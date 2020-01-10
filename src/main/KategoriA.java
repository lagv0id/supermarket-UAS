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
public class KategoriA extends Kategori {

    public KategoriA(int idp) {
        super(idp);
    }
    public void banner(){
        System.out.println("=================================================");
        System.out.println("|              Supermarket  Panel               |");
        System.out.println("|              Pegawai - Kategori               |");
        System.out.println("=================================================");
    }
}
