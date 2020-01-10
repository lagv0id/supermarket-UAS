/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.sql.*;
import java.util.Scanner;
import utils.*;

/**
 *
 * @author Cynthia
 */
interface sp {
    public void banner();
    public void start();
}
public abstract class Supermarket implements sp {
    private int login = 0;
    private int id_pegawai = 0;
    private int admin = 0;
    private connection c;
    
    public void setLogin(int l){
        login = l;
    }
    public int getLogin(){
        return login;
    }
    public void setPegawai(int p){
        id_pegawai = p;
    }
    public void setAdmin(int p){
        admin = 1;
    }
    public int getAdmin(){
        return admin;
    }
    public int getPegawai(){
        return id_pegawai;
    }
    public void banner(){
        System.out.println("=================================================");
        System.out.println("|               Supermarket Panel               |");
        System.out.println("=================================================");
    }
    public void start(){
        banner();
        System.out.println("[1] Login Sebagai Admin");
        System.out.println("[2] Login Sebagai Pegawai");
        System.out.print("[$] ");
        Scanner inp = new Scanner(System.in);
        int pilih = inp.nextInt();
        inp.nextLine();
        if (pilih == 1){
            System.out.print("Username : ");
            String user = inp.nextLine();
            System.out.print("Password : ");
            String pass = inp.nextLine();
            LoginA la = new LoginA();
            if (la.go(user, pass) > 0){
                setLogin(1);
                setPegawai(la.go(user, pass));
                System.out.println("Login Success");
            }
            else {
                System.out.println("Login Failed");
                System.exit(0);
            }
        }
        else {
            System.out.print("Username : ");
            String user = inp.nextLine();
            System.out.print("Password : ");
            String pass = inp.nextLine();
            Login lp = new Login();
            if (lp.go(user, pass) > 0){
                setLogin(1);
                setPegawai(lp.go(user, pass));
                System.out.println("Login Success");
            }
            else {
                System.out.println("Login Failed");
                System.exit(0);
            }
        }
    }
    public Connection getConnection(){
        c = new connection("localhost","root","","pbo_uas");
        return c.conn;
    }
    public Supermarket(){
        
    }
    public Supermarket(int idp){
        setPegawai(idp);
    }
}
