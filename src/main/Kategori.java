/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import crude.CBarang;
import crude.CKategori;
import java.util.Scanner;

/**
 *
 * @author Cynthia
 */
public class Kategori extends Admin{
    
    public Kategori(int idp) {
        super(idp);
    }
    
    public void banner(){
        System.out.println("=================================================");
        System.out.println("|              Supermarket  Panel               |");
        System.out.println("|               Admin - Kategori                |");
        System.out.println("=================================================");
    }
    public void start(){
        banner();
        while (true){
            System.out.println("[1] Lihat Kategori");
            System.out.println("[2] Tambah Kategori");
            System.out.println("[3] Edit Kategori");
            System.out.println("[4] Hapus Kategori");
            System.out.print("[$] ");
            CKategori k = new CKategori();
            Scanner inp = new Scanner(System.in);
            int p = inp.nextInt();
            inp.nextLine();
            if (p == 1){
                k.select(getConnection());
            }
            else if (p == 2 || p == 3){
                int id = 0;
                if (p == 3){
                    k.select(getConnection());
                    System.out.print("Masukkan ID : ");
                    id = inp.nextInt();
                    inp.nextLine();
                }
                
                System.out.print("Nama Kategori : ");
                String nama = inp.nextLine();
                if (p == 3){
                    k.update(getConnection(), id, nama);
                }
                else {
                    k.insert(getConnection(), nama);
                }
            }
            else if (p == 4){
                k.select(getConnection());
                System.out.print("Masukkan ID : ");
                int id = inp.nextInt();
                k.delete(getConnection(), id);
            }
        }
    }
    
}
