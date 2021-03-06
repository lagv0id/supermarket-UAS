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
public class CPembayaran {
    
    // atribut CPembayaran
    Integer idPembayaran, statusPembayaran, jumlahBayar, kembalian;
    String kodeTransaksi, tanggalPembayaran;
    
    // constructor
    public CPembayaran(){
        
    }
    
    // insert data pembayaran
    public void insert(Connection m, Integer id, String kode, Integer status, Date date, Integer jumlah, Integer kembali){
        // koneksi mysql
        Connection koneksi = m;
        
        // query mysql
        String sql = "INSERT INTO pembayaran (id_pegawai, kode_transaksi, status_pembayaran, tanggal_pembayaran, jumlah_bayar, kembalian) VALUES (?,?,?,?,?,?)";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(sql);
            // mapping nilai
            statement.setString(1, id.toString());
            statement.setString(2, kode);
            statement.setString(3, status.toString());
            statement.setDate(4, date);
            statement.setString(5, jumlah.toString());
            statement.setString(6, kembali.toString());
            
            // jalankan query
            int rowsInserted = statement.executeUpdate();
            // jika rows affected maka insert sukses
            if (rowsInserted > 0){
                System.out.println("Pembayaran sukses");
            } 
        } catch (SQLException ex) {
            // jika query gagal
            System.out.println("Pembayaran gagal");
        }
    }
    
    // delete data pembayaran berdasarkan idPembayaran
    public void delete(Connection m, Integer id){
        // koneksi mysql
        Connection koneksi = m;
        
        // query mysql
        String sql = "DELETE FROM pembayaran WHERE id_pembayaran=?";
        
        try {
            PreparedStatement statement;
            statement = koneksi.prepareStatement(sql);
            
            // mapping nilai 
            statement.setString(1, id.toString());
            
            // jalankan query dan lihat row affected
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Pembayaran sudah berhasil dihapus");
            }
        } catch (SQLException ex) {
            System.out.println("Hapus data pembayaran gagal");
        }
    }
    
    // update data pembayaran berdasarkan idPembayaran
    public void update(Connection m, Integer id, String kode, int status, java.sql.Date tanggal, Integer jumlah, Integer kembali){
        // koneksi mysql
        Connection koneksi = m;
        
        //query mysql
        String sql = "UPDATE pembayaran SET kode_transaksi=?, status_pembayaran=?, tanggal_pembayaran=?, jumlah_bayar=?, kembalian=? WHERE id_pembayaran=?";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(sql);
            // mapping nilai 
            
            statement.setString(1, kode);
            statement.setInt(2, status);
            statement.setDate(3, tanggal);
            statement.setInt(4, jumlah);
            statement.setInt(5, kembali);
            statement.setInt(6, id);

            // jalankan query dan lihat row affected
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Update data pembayaran sukses");
            }
        } catch (SQLException ex) {
             System.out.println("Update data pembayaran gagal");
        }
    }
    
    // select semua data pembayaran
    public void select(Connection m){
        // koneksi mysql
        Connection koneksi = m;
        
        // query sql
        String sql = "SELECT * FROM pembayaran";

         try {
            Statement statement = koneksi.createStatement();
            // jalankan query
            ResultSet result = statement.executeQuery(sql);

            // membuat header table untuk output
            System.out.println("==============================================================================");
            String header = "%3s %20s %20s %20s %20s %20s";
            System.out.println(String.format(header, "ID", "KODE", "STATUS", "TANGGAL", "JUMLAH", "KEMBALIAN"));
            System.out.println("------------------------------------------------------------------------------");
            
            // looping untuk baca data per record
            while (result.next()){
                // baca data buku per record
                String id = result.getString("id_pembayaran");
                String kode = result.getString("kode_transaksi");
                String status = result.getString("status_pembayaran");
                String tanggal = result.getString("tanggal_pembayaran");
                String jumlah = result.getString("jumlah_bayar");
                String kembali = result.getString("kembalian");
                // tampilkan data buku per record
                String output = "%3s %20s %20s %20s %20s %4s";
                System.out.println(String.format(output, id, kode, status, tanggal, jumlah, kembali));
            }
            
            System.out.println("==============================================================================");
            
        } catch (SQLException ex){
            System.out.println("Tampil data pembayaran gagal");
        }
    }
    public void select(Connection m, int idp){
        // koneksi mysql
        Connection koneksi = m;
        // query sql
        String pgw = String.valueOf(idp);
        String sql = "SELECT * FROM pembayaran WHERE id_pegawai=" + pgw;

         try {
            Statement statement = koneksi.createStatement();
            // jalankan query
            ResultSet result = statement.executeQuery(sql);

            // membuat header table untuk output
            System.out.println("==============================================================================");
            String header = "%3s %20s %6s %20s %20s %4s";
            System.out.println(String.format(header, "ID", "KODE", "STATUS", "TANGGAL", "JUMLAH", "KEMBALIAN"));
            System.out.println("------------------------------------------------------------------------------");
            
            // looping untuk baca data per record
            while (result.next()){
                // baca data buku per record
                String id = result.getString("id_pembayaran");
                String kode = result.getString("kode_transaksi");
                String status = result.getString("status_pembayaran");
                String tanggal = result.getString("tanggal_pembayaran");
                String jumlah = result.getString("jumlah_bayar");
                String kembali = result.getString("kembalian");
                // tampilkan data buku per record
                String output = "%3s %20s %6s %20s %20s %4s";
                System.out.println(String.format(output, id, kode, status, tanggal, jumlah, kembali));
            }
            
            System.out.println("==============================================================================");
            
        } catch (SQLException ex){
            System.out.println("Tampil history pembayaran gagal");
        }
    }
}