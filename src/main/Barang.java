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
        System.out.println("|                Admin - Barang                 |");
        System.out.println("=================================================");
    }
    public void start(){
        banner();
        while (true){
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
                int id = 0;
                if (p == 3){
                    b.select(getConnection());
                    System.out.print("Masukkan ID : ");
                    id = inp.nextInt();
                    inp.nextLine();
                }

                CKategori k = new CKategori();
                k.select(getConnection());
                System.out.print("Masukkan Kode Barang : ");
                int idk = inp.nextInt();
                System.out.print("Nama Barang\t: ");
                String nama = inp.nextLine();
                System.out.print("Harga Barang\t: ");
                int harga = inp.nextInt();
                System.out.print("Stok Barang\t: ");
                int stok = inp.nextInt();
                if (p == 3){
                    b.update(getConnection(), id, nama, harga, stok);
                }
                else {
                    b.insert(getConnection(), idk, nama, harga, stok);
                }
            }
            else if(p == 4){
                b.select(getConnection());
                System.out.print("Masukkan ID : ");
                int id = inp.nextInt();
                inp.nextLine();
                b.delete(getConnection(),id);
            }
        }
    }
}
