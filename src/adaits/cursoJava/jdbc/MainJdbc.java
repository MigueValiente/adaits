package adaits.cursoJava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class MainJdbc{
    public static void main(String[] args) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
                    "databaseName=NOMBRE DE LA BASE DE DATOS ;user=sa;password=tuclave;";
            Connection conexion = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            System.out.println("SQL Exception: "+ ex.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: "+ cE.toString());
        }
    }
}
