/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.*;

/**
 *
 * @author Cynthia
 */
public class connection {
    
    public String dbHost;
    public String dbName;
    public String dbUser;
    public String dbPass;
    public Connection conn;

    public connection(String dbHost, String dbUser, String dbPass, String dbName){
        this.dbHost = dbHost;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
        this.dbName = dbName;
        
        try {
            String dbURL = "jdbc:mysql://"+ this.dbHost +":3306/" + this.dbName;
            this.conn = DriverManager.getConnection(dbURL, this.dbUser, this.dbPass);
            if (this.conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void close(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.out.println("Penutupan koneksi gagal");
        }
    }
}
