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
public class Pembayaran extends Penjualan {
    public Pembayaran(int idp){
        super(idp);
    }
    
    public void start(){
        System.out.println("=================================================");
        System.out.println("|               Supermarket Panel               |");
        System.out.println("|             Pegawai - Pembayaran              |");
        System.out.println("=================================================");
    }
    
}
