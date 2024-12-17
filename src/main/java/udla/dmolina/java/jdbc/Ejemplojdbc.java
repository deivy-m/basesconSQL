package udla.dmolina.java.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class Ejemplojdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_jdbc"; //el 3306 era el puerto y le sigue el nombre de la base de datos en el sql
        String us = "root"; //user del sql
        String pw = "L@borator10"; //password del sql

        //hacer la conexion
        //connection es una clase propia de java
        //Se hace dentro de un try porque la conexión puede fallar
        //el try se encarga de abrir y cerrar la conexion
        try {
            Connection conn = DriverManager.getConnection(url, us, pw);
            //generar la sentencia
            Statement st = conn.createStatement();
            ResultSet resultado = st.executeQuery("select * from productos"); //se usa el select de sql que muestra el listado de productos
            while(resultado.next()){
                //Pone el resultado en una lista
                System.out.print(resultado.getInt("id")); //es getString porque es el tipo de columna en el SQL
                System.out.print("    ");
                System.out.print(resultado.getString("marca"));
                System.out.print("    ");
                System.out.print(resultado.getString("modelo"));
                System.out.print("    ");
                System.out.print(resultado.getString("precio"));
                System.out.print("    ");
                System.out.println(resultado.getString("color"));


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
