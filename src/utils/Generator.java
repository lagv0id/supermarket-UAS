/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.*;
import java.time.LocalDateTime;
/**
 *
 * @author Cynthia
 */
public class Generator {
    public String padding(String s, Integer len){
        return String.format("%0"+len.toString()+"d", Integer.parseInt(s));
    }
    public String kode_transaksi(){
        connection dbms = new connection("localhost","root","","pbo_uas");
        Connection conn = dbms.conn;
        String prefix = "TSV";
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear() % 2000;
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int last = 0;
        String kode = prefix + String.valueOf(year) + String.valueOf(month) + String.valueOf(day);
        try {
            Statement stt = conn.createStatement();
            String q = "SELECT substring(kode_transaksi,10) as kode from penjualan where kode_transaksi like '" + kode + "%' ORDER BY kode_transaksi DESC";
            ResultSet res = stt.executeQuery(q);
            while (res.next()){
             last = Integer.parseInt(res.getString("kode"));
             break;
            }
        }
        catch (Exception e){
            System.out.println("Error");
        }
        return kode + padding(String.valueOf(last + 1), 4);
    }
}