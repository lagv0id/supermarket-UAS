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
public class CPegawai {
    // atribut CPegawai
    Integer idPegawai;
    String username, password, namaPegawai;
    
    // constructor
    public CPegawai(){
        
    }
    
    // insert data pegawai
    public void insert(Connection m, Integer idPegawai, String username, String password, String namaPegawai){
        // koneksi mysql
        Connection koneksi = m;
        
        // query mysql
        String sql = "INSERT INTO pegawai (id_pegawai, username, password, nama_pegawai)";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(sql);
            // mapping nilai
            statement.setString(1, idPegawai.toString());
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, namaPegawai);
            
            // jalankan query
            int rowsInserted = statement.executeUpdate();
            // jika rows affected maka insert sukses
            if (rowsInserted > 0){
                System.out.println("Insert data pegawai sukses");
            } 
        } catch (SQLException ex) {
            // jika query gagal
            System.out.println("Insert data pegawai gagal");
        }
    }
    
    // delete data pegawai berdasarkan idPegawai
    public void delete(Connection m, Integer idPegawai){
        // koneksi mysql
        Connection koneksi = m;
        
        // query mysql
        String sql = "DELETE FROM pegawai WHERE id_pegawai=?";
        
        try {
            PreparedStatement statement;
            statement = koneksi.prepareStatement(sql);
            
            // mapping nilai 
            statement.setString(1, idPegawai.toString());
            
            // jalankan query dan lihat row affected
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Pegawai sudah berhasil dihapus");
            }
        } catch (SQLException ex) {
            System.out.println("Hapus data pegawai gagal");
        }
    }
    
    // update data pegawai berdasarkan idPegawai
    public void update(Connection m, Integer idPegawai, String username, String password, String namaPegawai){
        // koneksi mysql
        Connection koneksi = m;
        
        //query mysql
        String sql = "UPDATE pegawai SET username=?, password=?, nama_pegawai=? WHERE id_pegawai=?";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(sql);
            // mapping nilai 
            statement.setString(1, idPegawai.toString());
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, namaPegawai);

            // jalankan query dan lihat row affected
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Update data buku sukses");
            }
        } catch (SQLException ex) {
             System.out.println("Update data buku gagal");
        }
    }
    
    // select semua data pegawai
    public void select(Connection m){
        // koneksi mysql
        Connection koneksi = m;
        
        // query sql
        String sql = "SELECT * FROM pegawai";

         try {
            Statement statement = koneksi.createStatement();
            // jalankan query
            ResultSet result = statement.executeQuery(sql);

            // membuat header table untuk output
            System.out.println("==============================================================================");
            String header = "%3s %20s %20s %20s";
            System.out.println(String.format(header, "ID", "USERNAME", "PASSWORD", "NAMA"));
            System.out.println("------------------------------------------------------------------------------");
            
            // looping untuk baca data per record
            while (result.next()){
                // baca data buku per record
                String id = result.getString("id_pegawai");
                String user = result.getString("username");
                String passwd = result.getString("password");
                String nama = result.getString("nama_pegawai");
                // tampilkan data buku per record
                String output = "%3s %20s %20s %20s";
                System.out.println(String.format(output, id, user, passwd, nama));
            }
            
            System.out.println("==============================================================================");
            
        } catch (SQLException ex){
            System.out.println("Tampil data pegawai gagal");
        }
    }
}