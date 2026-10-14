package EjemploPG;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class EjemploPgPersona {
    public static void main(String[] args) {
        try {
            getConnection();
            createTablePersona();
            insertarPersona(new Persona("Juan Pérez", 
                                        Date.valueOf("2000-05-15"), 
                                        new BigDecimal("35000.00"), 
                                        "555-1234", 
                                        true, 
                                        1.80f));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://192.168.29.12:10203/AccesoDatos";
        String user = "dam78";
        String password = "postgresqldam78";

        return DriverManager.getConnection(url, user, password);
    }

    public static void createTablePersona() {
        String createTableSQL = "CREATE TABLE if NOT EXISTS persona ("
                + "id SERIAL PRIMARY KEY,"
                + "nombre VARCHAR(100) NOT NULL,"
                + "fecha_nacimiento DATE,"
                + "ingreso_anual DECIMAL(10, 2) not null,"
                + "telefono varchar(20) not null,"
                + "tiene_carnet boolean not null,"
                + "altura_metros REAL"
                + ");";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            int result = statement.executeUpdate(createTableSQL);
            System.out.println("Tabla creada con éxito. " + result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarPersona(Persona p) {
        String insertSQL = "INSERT INTO persona (nombre, fecha_nacimiento, ingreso_anual, telefono, tiene_carnet, altura_metros) "
                + "VALUES ( ?, ?, ?, ?, ?, ?);";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            
            if(p.getTelefono() == null) {
                statement.setNull(4, Types.VARCHAR);
            } else {
                statement.setString(4, p.getTelefono());
            }
            if(p.getAlturaMetros() == 0.0) {
                statement.setNull(6, Types.REAL);
            } else {
                statement.setDouble(6, p.getAlturaMetros());
            }
            statement.setString(1, p.getNombre());
            statement.setDate(2, p.getFechaNacimiento());
            statement.setBigDecimal(3, p.getIngresoAnual());
            statement.setString(4, p.getTelefono());
            statement.setBoolean(5, p.tieneCarnet());

            statement.executeUpdate();
            System.out.println("Persona insertada con éxito. " + p.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
