/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import crude.CPembayaran;
import crude.CPenjualan;

/**
 *
 * @author Cynthia
 */
public class History extends Pegawai {
    
    public History(int idp) {
        super(idp);
    }
    
    public void banner(){
        System.out.println("=================================================");
        System.out.println("|               Supermarket Panel               |");
        System.out.println("|         Pegawai - History Penjualan           |");
        System.out.println("=================================================");
    }
    public void start(){
        banner();
        CPembayaran pem = new CPembayaran();
        pem.select(getConnection(), getPegawai());
    }
    
}
