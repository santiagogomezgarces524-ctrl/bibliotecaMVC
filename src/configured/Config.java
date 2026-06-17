/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configured;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class Config {
      public  Connection conn;
       public PreparedStatement ps;
       public  ResultSet rs;

    public Config() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
            System.out.print("conexion segura");
        } catch(ClassNotFoundException | SQLException e){
            System.out.print("error de conexion");
        }
        
    }
        
        
}
