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
public class CPenjualan {
    
    // atribut CPenjualan
    Integer idBarang, idPegawai, banyakBarang;
    String kodeTransaksi;
    
    // constructor
    public CPenjualan(){
        
    }
    
    // insert data penjualan
    public void insert(Connection m, String kode, Integer barang, Integer pegawai, Integer banyak){
        // koneksi mysql
        Connection koneksi = m;
        
        // query mysql
        String sql = "INSERT INTO penjualan (kode_transaksi, id_barang, id_pegawai, banyak_barang) VALUES (?,?,?,?)";
        
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
    public void delete(Connection m, int id){
        // koneksi mysql
        Connection koneksi = m;
        
        // query mysql
        String sql = "DELETE FROM penjualan WHERE id_transaksi=?";
        
        try {
            PreparedStatement statement;
            statement = koneksi.prepareStatement(sql);
            
            // mapping nilai 
            statement.setInt(1, id);
            
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
    public void update(Connection m, String kode, Integer barang, Integer pegawai, Integer banyak){
        // koneksi mysql
        Connection koneksi = m;
        
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
    public void select(Connection m){
        // koneksi mysql
        Connection koneksi = m;
        
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
    public void select(Connection m, String where, String value){
        // koneksi mysql
        Connection koneksi = m;
        
        // query sql
        String sql = "SELECT a.id_transaksi, b.nama_barang, c.nama_pegawai, a.banyak_barang FROM penjualan a JOIN barang b ON a.id_barang = b.id_barang JOIN pegawai c ON a.id_pegawai = c.id_pegawai WHERE " + where + " LIKE '%" + value + "%'";

         try {
            Statement statement = koneksi.createStatement();
            // jalankan query
            ResultSet result = statement.executeQuery(sql);

            // membuat header table untuk output
            System.out.println("==============================================================================");
            String header = "%4s %4s %20s %20s %16s";
            System.out.println(String.format(header,"NO", "ID", "NAMA BARANG", "NAMA PEGAWAI", "BANYAK BARANG"));
            System.out.println("------------------------------------------------------------------------------");
            int no = 1;
            // looping untuk baca data per record
            while (result.next()){
                // baca data barang per record
                String nomor = String.valueOf(no);
                String id = result.getString("id_transaksi");
                String barang = result.getString("nama_barang");
                String pegawai = result.getString("nama_pegawai");
                String banyak = result.getString("banyak_barang");
                // tampilkan data barang per record
                String output = "%4s %4s %20s %20s %16s";
                System.out.println(String.format(output, nomor, id, barang, pegawai, banyak));
            }
            
            System.out.println("==============================================================================");
            
        } catch (SQLException ex){
            System.out.println("Belum ada barang");
        }
    }
    
}
