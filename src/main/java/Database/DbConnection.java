/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mike
 */
public class DbConnection {
    public static  Connection con; 
    
   static {
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/ChatApp?serverTimezone=UTC&useLegacyDateTimeCode=false";
            String user = "mike";
            String password = "RfireX_00";
            con=DriverManager.getConnection(url, user, password);
            
            if (con !=null && !con.isClosed()){
                System.out.println("Connection a la base de données etablie avec succes");
            }else{
                System.out.println("erreur lors de la connexion a la base de donnees");
        }
    }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Erreur lors de la connexion de la base de données "+e.getMessage());
            
        }   
    }
    public static  Connection getConnection() {
        return con;
    }
}
