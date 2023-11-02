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

public class TestBackendTransaksi {
    public static void main(String[] args) {
        Customer cus1 = new Customer().getById(1);
        Customer cus2 = new Customer().getById(2);
        
        Kamar ka1 = new Kamar().getById(12);
        Kamar ka2 = new Kamar().getById(13);
        
        
        Makan ma1 = new Makan().getById(17);
        Makan ma2 = new Makan().getById(18);
                
        Transaksi tr1 = new Transaksi(cus2, ka2, ma2, "11-12-2020", 6, 4, 12);
        Transaksi tr2 = new Transaksi(cus1, ka1, ma1, "10-12-2020", 3, 7, 7);
//        tr1.save();
//        tr2.save();
//        ka3.save();
        
        //update
//        ka2.setAlamat("Sukun");
//        ka2.save();
        
        // test delete
//        ka3.delete();
        
        //select all
        for(Transaksi t : new Transaksi().getAll()){
            System.out.println("Nama            : " + t.getCustomer().getById(t.getCustomer().getKode_register()).getNama());
            System.out.println("Jenis Kamar     : " + t.getKamar().getById(t.getKamar().getKode_kamar()).getNama());
            System.out.println("Paket Makan     : " + t.getMakan().getById(t.getMakan().getKode_makan()).getPaket());
            System.out.println("Tanggal Sewa    : " + t.getTgl_sewa());
            System.out.println("Durasi Menginap : " + t.getLama());
            System.out.println("Jumlah Kamar    : " + t.getjmlKamar());
            System.out.println("Jumlah Makan    : " + t.getjmlMakan());
            System.out.println("Total Bayar     : " + t.getTotal_transaksi());
            System.out.println();

        }
        
        //cari
//        for(Customer c : new Customer().search("Malang")){
//            System.out.println("Nama: " + c.getNama() + ", Alamat: " + c.getAlamat() + ", Usia: " + c.getUsia() + ", Telepon: " + c.getTelepon() );
//        }        
    }
}
