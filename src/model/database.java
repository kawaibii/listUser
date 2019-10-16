/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kinn007
 */
public class database {
     private static final String DB_URL = "jdbc:mysql://localhost/service";
     private static final String USER_NAME = "root";
     private static final String PASSWORD = "";
     private Connection conn;
     public database() throws SQLException{
         conn=connect();
      }
     public static Connection connect() throws SQLException{
         Connection conn=null;
         conn=DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
         if(conn==null){
             System.out.println("that bai");
             return null;
         }
         return conn;
     }
     // kiem tra tai khoan mat khau
     public static boolean checklogin(users user) throws SQLException{
         Connection conn=database.connect();
         return true;
     }
     public static boolean  checksignup(users user){
         
        return true;
     }
     /*cap nhat tran thang*/
     public static void updatewin(users user){
     
     }
     // cap nhat tran thua
     public static void updatelose(users user){
     
     }
}
