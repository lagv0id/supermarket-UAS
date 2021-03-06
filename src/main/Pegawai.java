/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.sql.*;
import java.util.Scanner;
import utils.*;

/**
 *
 * @author Cynthia
 */
public class Pegawai extends Supermarket {
    public Pegawai(int idp){
        super(idp);
    }
    public void banner(){
        System.out.println("=================================================");
        System.out.println("|               Supermarket Panel               |");
        System.out.println("|                     Pegawai                   |");
        System.out.println("=================================================");
    }
    public void start(){
        banner();
        while (true){
            System.out.println("[1] Penjualan");
            System.out.println("[2] Kategori Barang");
            System.out.println("[3] Barang");
            System.out.println("[4] History Penjualan");
            System.out.println("[5] Logout");
            System.out.print("[$] ");
            Scanner inp = new Scanner(System.in);
            int pilih = inp.nextInt();
            if (pilih == 1){
                Penjualan pen = new Penjualan(getPegawai());
                pen.start();
            }
            else if (pilih == 2){
                Kategori k = new Kategori(getPegawai());
                k.start();
            }
            else if (pilih == 3){
                Barang b = new Barang(getPegawai());
                b.start();
            }
            else if (pilih == 4){
                History h = new History(getPegawai());
                h.start();
            }
            else {
                System.out.println("Logout berhasil");
                System.exit(0);
            }
        }
    }
    
}