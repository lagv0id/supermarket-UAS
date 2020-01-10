/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crude;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cynthia
 */
public class CKategori {
    // atribut barang
    public Integer idKategori;
    public String nama;
    
    // constructor
    public CKategori(){
    }
    

    public void insert(Connection m,String nama){
        // koneksi mysql
        Connection koneksi = m;
        
        // query mysql
        String sql = "INSERT INTO kategori_barang(nama_kategori) VALUES (?)";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(sql);
            // mapping nilai
            statement.setString(1, nama);
            
            // jalankan query
            int rowsInserted = statement.executeUpdate();
            // jika rows affected maka insert sukses
            if (rowsInserted > 0){
                System.out.println("Insert data kategori sukses");
            }
        } catch (SQLException ex) {
            // jika query gagal
            System.out.println("Insert data kategori gagal");
        }
    }
    
    // delete data barang berdasarkan idBarang
    public void delete(Connection m, Integer idKat){
        // koneksi mysql
        Connection koneksi = m;
        
        // query mysql
        String sql = "DELETE FROM kategori_barang WHERE id_kategori=?";
        
        try {
            PreparedStatement statement;
            statement = koneksi.prepareStatement(sql);
            
            // mapping nilai 
            statement.setString(1, idKat.toString());
            
            // jalankan query dan lihat row affected
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Kategori sudah berhasil dihapus");
            }
        } catch (SQLException ex) {
            System.out.println("Hapus data kategori gagal");
        }
    }
    
    // update data barang berdasarkan idBarang
    public void update(Connection m, Integer idKat, String nama){
        // koneksi mysql
        Connection koneksi = m;
        
        //query mysql
        String sql = "UPDATE kategori_barang SET nama_kategori=? WHERE id_kategori=?";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(sql);
            // mapping nilai 
            statement.setString(1, nama);
            statement.setInt(2, idKat);

            // jalankan query dan lihat row affected
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Update data kategori sukses");
            }
        } catch (SQLException ex) {
             System.out.println("Update data kategori gagal");
        }
    }
    
    // select semua data barang
    public void select(Connection m){
        // koneksi mysql
        Connection koneksi = m;
        
        // query sql
        String sql = "SELECT * FROM kategori_barang";

         try {
            Statement statement = koneksi.createStatement();
            // jalankan query
            ResultSet result = statement.executeQuery(sql);

            // membuat header table untuk output
            System.out.println("==============================================================================");
            String header = "%3s %20s";
            System.out.println(String.format(header, "ID", "NAMA"));
            System.out.println("------------------------------------------------------------------------------");
            
            // looping untuk baca data per record
            while (result.next()){
                // baca data barang per record
                String id = result.getString("id_kategori");
                String nama = result.getString("nama_kategori");
                // tampilkan data barang per record
                String output = "%3s %20s";
                System.out.println(String.format(output, id, nama));
            }
            
            System.out.println("==============================================================================");
            
        } catch (SQLException ex){
            System.out.println("Tampil data kategori gagal");
        }
    }
    public void select(Connection m, String where, int value){
        // koneksi mysql
        Connection koneksi = m;
        
        // query sql
        String sql = "SELECT * FROM kategori_barang WHERE " + where + "LIKE " + value;

         try {
            Statement statement = koneksi.createStatement();
            // jalankan query
            ResultSet result = statement.executeQuery(sql);

            // membuat header table untuk output
            System.out.println("==============================================================================");
            String header = "%3s %20s";
            System.out.println(String.format(header, "ID", "NAMA"));
            System.out.println("------------------------------------------------------------------------------");
            
            // looping untuk baca data per record
            while (result.next()){
                // baca data barang per record
                String id = result.getString("id_kategori");
                String nama = result.getString("nama_kategori");
                // tampilkan data barang per record
                String output = "%3s %20s";
                System.out.println(String.format(output, id, nama));
            }
            
            System.out.println("==============================================================================");
            
        } catch (SQLException ex){
            System.out.println("Tampil data barang gagal");
        }
    }
}