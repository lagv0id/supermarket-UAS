/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import crude.CBarang;
import crude.CKategori;
import crude.CPegawai;
import java.util.Scanner;

/**
 *
 * @author Cynthia
 */
public class APegawai extends Admin {
    public APegawai(int idp){
        super(idp);
    }
    public void banner(){
        System.out.println("=================================================");
        System.out.println("|              Supermarket  Panel               |");
        System.out.println("|                Admin - Pegawai                |");
        System.out.println("=================================================");
    }
     public void start(){
        banner();
        while (true){
            System.out.println("[1] Lihat Pegawai");
            System.out.println("[2] Tambah Pegawai");
            System.out.println("[3] Edit Pegawai");
            System.out.println("[4] Hapus Pegawai");
            System.out.print("[$] ");
            CPegawai pe = new CPegawai();
            Scanner inp = new Scanner(System.in);
            int p = inp.nextInt();
            if (p == 1){
                pe.select(getConnection());
            }
            else if (p == 2 || p == 3){
                int id = 0;
                if (p == 3){
                    pe.select(getConnection());
                    System.out.print("Masukkan ID : ");
                    id = inp.nextInt();
                }
                inp.nextLine();
                System.out.print("Nama Pegawai\t: ");
                String nama = inp.nextLine();
                System.out.print("Username\t: ");
                String username = inp.nextLine();
                System.out.print("Password\t: ");
                String password = inp.nextLine();
                if (p == 3){
                    pe.update(getConnection(), id, username, password, nama);
                }
                else {
                    pe.insert(getConnection(), username, password, nama);
                }
            }
            else if(p == 4){
                pe.select(getConnection());
                System.out.print("Masukkan ID : ");
                int id = inp.nextInt();
                inp.nextLine();
                pe.delete(getConnection(),id);
            }
        }
    }
}
