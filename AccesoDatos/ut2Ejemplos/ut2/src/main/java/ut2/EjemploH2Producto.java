package ut2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EjemploH2Producto {
    public static void main(String[] args) {
        try {
            Connection conexion = DriverManager.getConnection(
                "jdbc:h2:./datos/tienda",
                "sa", 
                "");
                
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}