/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author TOSHIBA
 */

import java.util.ArrayList;
import java.sql.*;

public class Customer {
    private int kode_register;
    private String nama;
    private String alamat;
    private int usia;
    private String telepon;

    public Customer() {
    }

    public Customer(String nama, String alamat, int usia, String telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.usia = usia;
        this.telepon = telepon;
    }

    public int getKode_register() {
        return kode_register;
    }

    public void setKode_register(int kode_register) {
        this.kode_register = kode_register;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
    
    public String toString(){
        return nama;
    }
    
    public Customer getById(int kode){
        Customer cus = new Customer();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM customer " 
                + " WHERE kode_register = '" + kode + "'");
        
        try{
            while(rs.next()){
                cus = new Customer();
                cus.setKode_register(rs.getInt("kode_register"));
                cus.setNama(rs.getString("nama"));
                cus.setAlamat(rs.getString("alamat"));
                cus.setUsia(rs.getInt("usia"));
                cus.setTelepon(rs.getString("telepon"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return cus;
    }
    
    public ArrayList<Customer> getAll(){
        ArrayList<Customer> ListCustomer = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM customer");
        
        try{
            while(rs.next()){
                Customer cus = new Customer();
                cus.setKode_register(rs.getInt("kode_register"));
                cus.setNama(rs.getString("nama"));
                cus.setAlamat(rs.getString("alamat"));
                cus.setUsia(rs.getInt("usia"));
                cus.setTelepon(rs.getString("telepon"));
                
                ListCustomer.add(cus);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ListCustomer;
    }
    
    public ArrayList<Customer> search(String keyword){
        ArrayList<Customer> ListCustomer = new ArrayList();
        
        String sql = "SELECT * FROM customer WHERE "
                +"          nama Like '%" + keyword + "%' "
                +"          OR alamat LIKE '%" + keyword + "%' ";
        
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Customer cus = new Customer();
                cus.setKode_register(rs.getInt("kode_register"));
                cus.setNama(rs.getString("nama"));
                cus.setAlamat(rs.getString("alamat"));
                cus.setUsia(rs.getInt("usia"));
                cus.setTelepon(rs.getString("telepon"));
                
                ListCustomer.add(cus);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ListCustomer;
    }
    
    public void save(){
        if(getById(kode_register).getKode_register()==0){
            String SQL = "INSERT INTO customer (nama, alamat, usia, telepon) VALUES ("
                    + "     '" + this.nama + "', "
                    + "     '" + this.alamat + "', "
                    + "     '" + this.usia + "', "
                    + "     '" + this.telepon + "' "
                    + "     )";
            this.kode_register = DBHelper.insertQueryGetId(SQL);
        }
        else{
            String SQL = "UPDATE customer SET"
                    + "     nama = '" + this.nama + "', "
                    + "     alamat = '" + this.alamat + "', "
                    + "     usia = '" + this.usia + "', "
                    + "     telepon = '" + this.telepon + "' "
                    + "     WHERE kode_register = '" + this.kode_register + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete(){
        String SQL = "DELETE FROM customer WHERE kode_register = '" + this.kode_register + "'";
        DBHelper.executeQuery(SQL);
    }
}
