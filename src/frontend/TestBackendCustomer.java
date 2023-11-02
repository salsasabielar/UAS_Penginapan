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

public class TestBackendCustomer {
    public static void main(String[] args) {
        Customer cus1 = new Customer("Salsa", "Malang", 20, "0821");
        Customer cus2 = new Customer("Sabiela", "Surabaya", 21, "0890");
        Customer cus3 = new Customer("Rosyada", "Jakarta", 22, "0878");
        
        
        cus1.save();
        cus2.save();
        cus3.save();
        
        //update
        cus2.setAlamat("Sukun");
        cus2.save();
        
        // test delete
        cus3.delete();
        
        //select all
        for(Customer c : new Customer().getAll()){
            System.out.println("Nama: " + c.getNama() + ", Alamat: " + c.getAlamat() + ", Usia: " + c.getUsia() + ", Telepon: " + c.getTelepon() );
        }
        
        //cari
        for(Customer c : new Customer().search("Malang")){
            System.out.println("Nama: " + c.getNama() + ", Alamat: " + c.getAlamat() + ", Usia: " + c.getUsia() + ", Telepon: " + c.getTelepon() );
        }        
    }
}
