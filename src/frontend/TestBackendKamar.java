/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author TOSHIBA
 */

import backend.*;

public class TestBackendKamar {
    public static void main(String[] args) {
        Kamar ka1 = new Kamar("Deluxe Room Rp. 700.000", 700000);
        Kamar ka2 = new Kamar("Suite Room Rp. 810.000", 810000);
        Kamar ka3 = new Kamar("Royal Room Rp. 1.200.000", 1200000);
        Kamar ka4 = new Kamar("Executive Room Rp. 2.100.000", 2100000);
        
        ka1.save();
        ka2.save();
        ka3.save();
        ka4.save();
        
        //update
//        ka2.setAlamat("Sukun");
//        ka2.save();
//        
//        // test delete
//        ka3.delete();
//        
        //select all
        for(Kamar k : new Kamar().getAll()){
            System.out.println("Jenis Kamar: " + k.getNama() + "\nHarga: " + k.getHarga() + "\n");
        }
        
        //cari
//        for(Kamar k : new Kamar().search("Suite")){
//            System.out.println("\nJenis Kamar: " + k.getNama() + "\nHarga: " + k.getHarga());
//        }        
    }
}
