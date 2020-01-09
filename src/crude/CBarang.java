/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crude;
import java.sql.*;
import utils.*;
/**
 *
 * @author asus
 */
public class CBarang {
    // atribut barang
    public Integer idBarang, hargaBarang, stokBarang;
    public String namaBarang;
    
    // constructor
    public CBarang(){
    }
    
    // insert data barang
    public void insert(Connection m, Integer idBarang, Integer idKategori, String namaBarang, Integer hargaBarang, Integer stokBarang){
        // koneksi mysql
        Connection koneksi = m;
        
        // query mysql
        String sql = "INSERT INTO barang (id_barang, id_kategori, nama_barang, harga_barang, stok_barang) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(sql);
            // mapping nilai
            statement.setString(1, idBarang.toString());
            statement.setString(2, namaBarang);
            statement.setString(3, hargaBarang.toString());
            statement.setString(4, stokBarang.toString());
            
            // jalankan query
            int rowsInserted = statement.executeUpdate();
            // jika rows affected maka insert sukses
            if (rowsInserted > 0){
                System.out.println("Insert data barang sukses");
            }
        } catch (SQLException ex) {
            // jika query gagal
            System.out.println("Insert data barang gagal");
        }
    }
    
    // delete data barang berdasarkan idBarang
    public void delete(Connection m, Integer idBarang){
        // koneksi mysql
        Connection koneksi = m;
        
        // query mysql
        String sql = "DELETE FROM barang WHERE id_barang=?";
        
        try {
            PreparedStatement statement;
            statement = koneksi.prepareStatement(sql);
            
            // mapping nilai 
            statement.setString(1, idBarang.toString());
            
            // jalankan query dan lihat row affected
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Barang sudah berhasil dihapus");
            }
        } catch (SQLException ex) {
            System.out.println("Hapus data barang gagal");
        }
    }
    
    // update data barang berdasarkan idBarang
    public void update(Connection m, Integer idBarang, String namaBarang, Integer hargaBarang, Integer stokBarang){
        // koneksi mysql
        Connection koneksi = m;
        
        //query mysql
        String sql = "UPDATE barang SET nama_barang=?, harga_barang=?, stok_barang=? WHERE id_barang=?";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(sql);
            // mapping nilai 
            statement.setString(1, idBarang.toString());
            statement.setString(2, namaBarang);
            statement.setString(3, hargaBarang.toString());
            statement.setString(4, stokBarang.toString());

            // jalankan query dan lihat row affected
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Update data barang sukses");
            }
        } catch (SQLException ex) {
             System.out.println("Update data barang gagal");
        }
    }
    
    // select semua data barang
    public void select(Connection m){
        // koneksi mysql
        Connection koneksi = m;
        
        // query sql
        String sql = "SELECT * FROM barang";

         try {
            Statement statement = koneksi.createStatement();
            // jalankan query
            ResultSet result = statement.executeQuery(sql);

            // membuat header table untuk output
            System.out.println("==============================================================================");
            String header = "%3s %20s %20s %20s";
            System.out.println(String.format(header, "ID", "NAMA", "HARGA", "STOK"));
            System.out.println("------------------------------------------------------------------------------");
            
            // looping untuk baca data per record
            while (result.next()){
                // baca data barang per record
                String id = result.getString("id_barang");
                String nama = result.getString("nama_barang");
                String harga = result.getString("harga_barang");
                String stok = result.getString("stok_barang");
                // tampilkan data barang per record
                String output = "%3s %20s %20s %20s";
                System.out.println(String.format(output, id, nama, harga, stok));
            }
            
            System.out.println("==============================================================================");
            
        } catch (SQLException ex){
            System.out.println("Tampil data barang gagal");
        }
    }
    public void select(Connection m, String where, int value){
        // koneksi mysql
        Connection koneksi = m;
        
        // query sql
        String sql = "SELECT * FROM barang WHERE " + where + "=" + value;

         try {
            Statement statement = koneksi.createStatement();
            // jalankan query
            ResultSet result = statement.executeQuery(sql);

            // membuat header table untuk output
            System.out.println("==============================================================================");
            String header = "%3s %20s %20s %20s";
            System.out.println(String.format(header, "ID", "NAMA", "HARGA", "STOK"));
            System.out.println("------------------------------------------------------------------------------");
            
            // looping untuk baca data per record
            while (result.next()){
                // baca data barang per record
                String id = result.getString("id_barang");
                String nama = result.getString("nama_barang");
                String harga = result.getString("harga_barang");
                String stok = result.getString("stok_barang");
                // tampilkan data barang per record
                String output = "%3s %20s %20s %20s";
                System.out.println(String.format(output, id, nama, harga, stok));
            }
            
            System.out.println("==============================================================================");
            
        } catch (SQLException ex){
            System.out.println("Tampil data barang gagal");
        }
    }
}
