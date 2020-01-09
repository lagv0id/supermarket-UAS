/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.sql.*;
import java.util.Scanner;
import utils.*;
import crude.*;
/**
 *
 * @author Cynthia
 */
public class Penjualan extends Supermarket {
    private String kode_transaksi;
    public void setKodeTransaksi(String kt){
        kode_transaksi = kt;
    }
    public String getKodeTransaksi(){
        return kode_transaksi;
    }
    public Penjualan(int idp) {
        super(idp);
    }
    public void banner(){
        System.out.println("=================================================");
        System.out.println("|               Supermarket Panel               |");
        System.out.println("|              Pegawai - Penjualan              |");
        System.out.println("=================================================");
    }
    public void start(){
        banner();
        System.out.println("[1] Transaksi Yang Sudah Ada");
        System.out.println("[1] Transaksi Baru");
        Scanner inp = new Scanner(System.in);
        if (inp.nextInt() == 1){
            inp.nextLine();
            System.out.print("[$] Kode : ");
            setKodeTransaksi(inp.nextLine());
        }
        else {
            Generator generate = new Generator();
            setKodeTransaksi(generate.kode_transaksi());   
        }
        while (true){
            System.out.println("[1] Lihat Barang");
            System.out.println("[2] Tambah Barang");
            System.out.println("[3] Hapus Barang");
            System.out.println("[4] Pembayaran");
            System.out.print("[$] ");
            int pilih = inp.nextInt();
            CPenjualan pen = new CPenjualan();
            if (pilih == 1){
                pen.select(getConnection(), "kode_transaksi", getKodeTransaksi());
            }
            else if (pilih == 2){
                CKategori kat = new CKategori();
                kat.select(getConnection());
                System.out.print("[$] Pilih Kategori (ID) : ");
                int id_kategori = inp.nextInt();
                CBarang b = new CBarang();
                b.select(getConnection(), "id_kategori", id_kategori);
                System.out.print("[$] Pilih Barang (ID) : ");
                int id_barang = inp.nextInt();
                System.out.print("[$] Jumlah Barang : ");
                int jumlah = inp.nextInt();
                pen.insert(getConnection(), kode_transaksi, id_barang, getPegawai(), jumlah);
            }
            else if (pilih == 3){
                pen.select(getConnection(), "kode_transaksi", getKodeTransaksi());
                System.out.print("[$] Masukkan ID : ");
                pen.delete(getConnection(), inp.nextInt());
                
            }
        }
    }
}