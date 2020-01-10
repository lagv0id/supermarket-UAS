/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author Cynthia
 */
public class Admin extends Supermarket {
    public Admin(int idp){
        super(idp);
    }
    public void banner(){
        System.out.println("=================================================");
        System.out.println("|               Supermarket Panel               |");
        System.out.println("|                     Admin                     |");
        System.out.println("=================================================");
    }
    public void start(){
        banner();
        while (true){
            System.out.println("[1] Pegawai");
            System.out.println("[2] Kategori Barang");
            System.out.println("[3] Barang");
            System.out.println("[4] History Penjualan");
            System.out.println("[5] Logout");
            System.out.print("[$] ");
            Scanner inp = new Scanner(System.in);
            int pilih = inp.nextInt();
            if (pilih == 1){
                //manggil bt pegawai
            }
            else if (pilih == 2){
                Kategori k = new Kategori(getAdmin());
                k.start();
            }
            else if (pilih == 3){
                
            }
        }
    }
}
