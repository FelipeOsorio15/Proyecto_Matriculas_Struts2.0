/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pc
 */
public class Conexion {
   public static Connection getConnection() throws Exception {
        Connection con = null;
        try {
            //url de BD
            String url = "jdbc:mysql://localhost:3306/seguidordb";
            //usuario BD
            String user = "root";
            //Clave BD
            String clave = "";
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url, user, clave);
            System.out.println("Exito Conexion BD");
        } catch (Exception e) {
            System.out.println("Error conexion BD "+e.getMessage());
            e.printStackTrace();
        }
        return con;
    }  
}

