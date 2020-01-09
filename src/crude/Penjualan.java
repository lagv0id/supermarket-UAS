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
 * @author KAIROS
 */
public class Penjualan {
    
    // atribut Penjualan
    Integer idBarang, idPegawai, banyakBarang;
    String kodeTransaksi;
    
    // constructor
    public Penjualan(){
        
    }
    
    // insert data penjualan
    public void insert(connection m, String kode, Integer barang, Integer pegawai, Integer banyak){
        // koneksi mysql
        Connection koneksi = m.conn;
        
        // query mysql
        String sql = "INSERT INTO penjualan (kode_transaksi, id_barang, id_pegawai, banyak_barang)";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(sql);
            // mapping nilai
            statement.setString(1, kode);
            statement.setString(2, barang.toString());
            statement.setString(3, pegawai.toString());
            statement.setString(4, banyak.toString());
            
            // jalankan query
            int rowsInserted = statement.executeUpdate();
            // jika rows affected maka insert sukses
            if (rowsInserted > 0){
                System.out.println("Insert data penjualan sukses");
            } 
        } catch (SQLException ex) {
            // jika query gagal
            System.out.println("Insert data penjualan gagal");
        }
    }
    
    // delete data penjualan berdasarkan kodeTransaksi
    public void delete(connection m, String kode){
        // koneksi mysql
        Connection koneksi = m.conn;
        
        // query mysql
        String sql = "DELETE FROM penjualan WHERE kode_transaksi=?";
        
        try {
            PreparedStatement statement;
            statement = koneksi.prepareStatement(sql);
            
            // mapping nilai 
            statement.setString(1, kode);
            
            // jalankan query dan lihat row affected
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Penjualan sudah berhasil dihapus");
            }
        } catch (SQLException ex) {
            System.out.println("Hapus data penjualan gagal");
        }
    }
    
    // update data penjualan berdasarkan kodeTransaksi
    public void update(connection m, String kode, Integer barang, Integer pegawai, Integer banyak){
        // koneksi mysql
        Connection koneksi = m.conn;
        
        //query mysql
        String sql = "UPDATE penjualan SET kode_transaksi=?, id_barang=?, id_pegawai=?, banyak_barang=?";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(sql);
            // mapping nilai 
            statement.setString(1, kode);
            statement.setString(2, barang.toString());
            statement.setString(3, pegawai.toString());
            statement.setString(4, banyak.toString());

            // jalankan query dan lihat row affected
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Update data penjualan sukses");
            }
        } catch (SQLException ex) {
             System.out.println("Update data penjualan gagal");
        }
    }
    
    // select semua data penjualan
    public void select(connection m){
        // koneksi mysql
        Connection koneksi = m.conn;
        
        // query sql
        String sql = "SELECT * FROM penjualan";

         try {
            Statement statement = koneksi.createStatement();
            // jalankan query
            ResultSet result = statement.executeQuery(sql);

            // membuat header table untuk output
            System.out.println("==============================================================================");
            String header = "%3s %20s %20s %20s";
            System.out.println(String.format(header, "KODE", "ID BARANG", "ID PEGAWAI", "BANYAK BARANG"));
            System.out.println("------------------------------------------------------------------------------");
            
            // looping untuk baca data per record
            while (result.next()){
                // baca data barang per record
                String kode = result.getString("kode_transaksi");
                String barang = result.getString("id_barang");
                String pegawai = result.getString("id_pegawai");
                String banyak = result.getString("banyak_barang");
                // tampilkan data barang per record
                String output = "%3s %20s %20s %4s";
                System.out.println(String.format(output, kode, barang, pegawai, banyak));
            }
            
            System.out.println("==============================================================================");
            
        } catch (SQLException ex){
            System.out.println("Tampil data penjualan gagal");
        }
    }
    
}
