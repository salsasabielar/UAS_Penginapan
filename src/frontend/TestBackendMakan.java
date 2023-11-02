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

public class TestBackendMakan {
    public static void main(String[] args) {
        Makan ma1 = new Makan("Paket 1 (Pagi + Siang + Malam)", 100000);
        Makan ma2 = new Makan("Paket 2 (Siang + Malam)", 70000);
        Makan ma3 = new Makan("Paket 3 (Siang)", 50000);
        
        ma1.save();
        ma2.save();
        ma3.save();
////        
//        //update
//        ka2.setAlamat("Sukun");
//        ka2.save();
//        
//        // test delete
//        ka3.delete();
//        
        //select all
        for(Makan m : new Makan().getAll()){
            System.out.println("Paket Makan: " + m.getPaket() + "\nHarga: " + m.getHarga());
        }
        
        //cari
//        for(Makan m : new Makan().search("1")){
//            System.out.println("\nPaket Makan: " + m.getPaket() + "\nHarga: " + m.getHarga());
//        }        
    }
}
