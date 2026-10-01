package ut2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploH2Producto {
    public static void main(String[] args) {
        try {
            Connection conexion = DriverManager.getConnection(
                "jdbc:h2:./datos/tienda",
                "sa",
                "");

            String createTable = "CREATE TABLE productos ("
                    + "id UUID PRIMARY KEY,"
                    + "nombre VARCHAR(100) NOT NULL,"
                    + "precio decimal(8,2) not null,"
                    + "stock integer not null,"
                    + "garantia_meses integer,"
                    + "disponible boolean not null,"
                    + "fecha_alta date not null"
                    + ");";

                    Statement createTableStatement = conexion.createStatement();
                    int respuesta = createTableStatement.executeUpdate(createTable);
                    System.out.println(respuesta);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}