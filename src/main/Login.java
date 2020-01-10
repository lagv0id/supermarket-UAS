/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.*;
import utils.*;

/**
 *
 * @author Cynthia
 */


public class Login extends Supermarket {
    public int go(String username, String password){
        Connection c = getConnection();
        int res = 0;
        String q = "SELECT id_pegawai,nama_pegawai FROM pegawai WHERE username = ? AND password = ?";
        try {
            PreparedStatement p = c.prepareStatement(q);
            p.setString(1, username);
            p.setString(2, password);
            ResultSet result = p.executeQuery();
            while (result.next()){
                res = result.getInt("id_pegawai");
                System.out.println(res);
                break;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return res;
    }
    
}
