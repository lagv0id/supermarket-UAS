/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Cynthia
 */
public class APegawai extends Admin {
    public APegawai(int idp){
        setAdmin(1);
    }
    public void banner(){
        System.out.println("=================================================");
        System.out.println("|              Supermarket  Panel               |");
        System.out.println("|                Admin - Pegawai                |");
        System.out.println("=================================================");
    }
    
}
