
package Formularios;

import java.sql.*;
import javax.swing.JOptionPane;

public class conectar_db {
    private static Connection conn; 
    private static String driver = "org.postgresql.Driver";
    private static String user = "postgres";
    private static String password = "root";
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    
    public static Connection conectar_a_baseded(){
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error"+ e);
        }
        return conn;
    }  
}
