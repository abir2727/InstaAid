/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaaid;

import java.sql.Connection;
import java.sql.DriverManager;

public class database1
{
    public static Connection getConnection(){
        Connection db=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            db=DriverManager.getConnection("jdbc:mysql://localhost/users_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
       
            //db=DriverManager.getConnection("jdbc:mysql://localhost/users_db","root","");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
            
        return db;
    }
}