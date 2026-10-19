package ejemploProcedimientos;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class EjemploProcedurePersona {

  // Record para almacenar el resultado de la ejecución del procedimiento
  public record ResultadoIngresos(String nombre, BigDecimal ingresos) {
  }

  public static void main(String[] args) {
    try {
      // 1. Establecer conexión con BD
      Connection conexion = crearConexion("AccesoDatos", "dam78", "postgresqldam78");

      // 2. Crear procedimiento para aumentar el ingreso anual de una persona
      crearProcedimientoAumentarIngresos(conexion);
      // 3. Aumentar ingresos a las personas 1 y 2
      ResultadoIngresos persona1 = aumentarIngresos(conexion, 1, 500.00);
      ResultadoIngresos persona2 = aumentarIngresos(conexion, 2, 3000.00);

      System.out.println("Persona 1: " + persona1.nombre() + ", Ingresos nuevos: " + persona1.ingresos());
      System.out.println("Persona 2: " + persona2.nombre() + ", Ingresos nuevos: " + persona2.ingresos());
      // 4. Cerrar conexión
      conexion.close();
    } catch (SQLException e) {
      System.err.println("Error JDBC: " + e.getSQLState());
      System.err.println(e.getMessage());
    }
  }

  // Crea una conexión con la BD
  public static Connection crearConexion(String bd, String usuario, String clave) throws SQLException {
    Connection conexion = DriverManager.getConnection(
        "jdbc:postgresql://192.168.29.12:10203/" + bd,
        usuario,
        clave);

    System.out.println("Conexión con \"" + bd + "\" establecida");

    return conexion;
  }

  public static void crearProcedimientoAumentarIngresos(Connection conexion) throws SQLException {
    String procedimientoSql = """
            CREATE OR REPLACE PROCEDURE aumentar_ingresos(
                IN p_id INTEGER,
                IN p_incremento NUMERIC,
                OUT p_nombre VARCHAR,
                OUT p_ingresos_nuevo NUMERIC
            )
            LANGUAGE plpgsql
            AS $$
            BEGIN
                IF p_incremento IS NULL OR p_incremento <= 0 THEN
                    RAISE EXCEPTION 'El incremento debe ser mayor que cero';
                END IF;

                UPDATE persona
                SET ingreso_anual = ingreso_anual + p_incremento
                WHERE id = p_id
                RETURNING nombre, ingreso_anual INTO p_nombre, p_ingresos_nuevo;

                IF NOT FOUND THEN
                    RAISE EXCEPTION 'No existe la persona con id %', p_id;
                END IF;
            END;
            $$;
        """;

    // Crear sentencia de creación del procedimiento
    Statement statement = conexion.createStatement();

    // Ejecutar la sentencia
    statement.execute(procedimientoSql);

    // Cerrar el statement
    statement.close();
  }

  public static ResultadoIngresos aumentarIngresos(Connection conexion, int idPersona, double aumentoIngresos)
      throws SQLException {
    // Crear el CallableStatement para llamar al procedimiento
    CallableStatement callableStatement = conexion.prepareCall("CALL aumentar_ingresos(?, ?, ?, ?)");

    // Definir los parámetros de salida del procedimiento para poder recoger los
    // valores después
    callableStatement.registerOutParameter(3, Types.VARCHAR);
    callableStatement.registerOutParameter(4, Types.NUMERIC);

    // Definir los valores de los parámetros de entrada del procedimientos
    callableStatement.setInt(1, idPersona);
    callableStatement.setBigDecimal(2, new BigDecimal(aumentoIngresos));

    // Obtener los valores de los parámetros de salida registrados anteriormente
    callableStatement.execute();
    String nombre = callableStatement.getString(3);
    BigDecimal ingresos = callableStatement.getBigDecimal(4);

    // Cerrar el callablestatement
    callableStatement.close();

    return new ResultadoIngresos(nombre, ingresos);
  }
}