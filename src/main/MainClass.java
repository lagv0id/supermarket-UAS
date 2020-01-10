/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import utils.*;

/**
 *
 * @author Cynthia
 */
public class MainClass {
    public static void main(String args[]){
        Login m = new Login();
        m.start();
        if (m.getPegawai() == 31337){
            m.setAdmin(1);
            m.setPegawai(0);
            Admin am = new Admin(m.getAdmin());
            am.start();
        }
        else {
            Pegawai p = new Pegawai(m.getPegawai());
            p.start();
        }
        
//        Generator g = new Generator();
//        System.out.println(g.kode_transaksi());
//        m.go("cycyn", "1");
    }
}
