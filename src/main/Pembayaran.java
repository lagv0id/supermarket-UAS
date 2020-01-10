/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import crude.CBarang;
import crude.CPembayaran;
import crude.CPenjualan;
import java.sql.*;
import java.util.Scanner;
import utils.*;


/**
 *
 * @author Cynthia
 */
public class Pembayaran extends Penjualan {
    public Pembayaran(int idp, String kode){
        super(idp);
        setKodeTransaksi(kode);
    }
    
    public void banner(){
        System.out.println("=================================================");
        System.out.println("|               Supermarket Panel               |");
        System.out.println("|             Pegawai - Pembayaran              |");
        System.out.println("=================================================");
    }
    public void start(){
        CPenjualan cp = new CPenjualan();
        Scanner inp = new Scanner(System.in);
        cp.select(getConnection(), "kode_transaksi", getKodeTransaksi());
        Integer total = cp.checkout(getConnection(), "kode_transaksi", getKodeTransaksi());
        Integer bayar = 0;
        System.out.println("Total Pembayaran\t: " + total.toString());
        while (bayar < total){
            System.out.print("Masukkan Uang Bayar\t: ");
            bayar = inp.nextInt();
        }
        Integer kembali = bayar - total;
        System.out.println("Kembalian\t: " + kembali.toString());
        CPembayaran cpp = new CPembayaran();
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        cpp.insert(getConnection(), getPegawai(), getKodeTransaksi(), 1, sqlDate, total, kembali);
    }
    
}
