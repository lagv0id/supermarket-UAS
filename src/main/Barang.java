/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import crude.*;
import java.util.Scanner;

/**
 *
 * @author Cynthia
 */
public class Barang extends Admin {
    
    public Barang(int idp) {
        super(idp);
    }
    public void banner(){
        System.out.println("=================================================");
        System.out.println("|              Supermarket  Panel               |");
        System.out.println("|               Pegawai - Barang                |");
        System.out.println("=================================================");
    }
    public void start(){
        banner();
        System.out.println("[1] Lihat Barang");
        System.out.println("[2] Tambah Barang");
        System.out.println("[3] Edit Barang");
        System.out.println("[4] Hapus Barang");
        System.out.print("[$] ");
        CBarang b = new CBarang();
        Scanner inp = new Scanner(System.in);
        int p = inp.nextInt();
        if (p == 1){
            b.select(getConnection());
        }
        else if (p == 2 || p == 3){
            
        }
    }
}
