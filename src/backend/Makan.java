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

public class Makan implements IPenginapan{
    private int kode_makan;
    private String paket;
    private int harga;
    private int total;
    
    public Makan() {
    }

    public Makan(String paket, int harga) {
        this.paket = paket;
        this.harga = harga;
    }

    public void setKode_makan(int kode_makan) {
        this.kode_makan = kode_makan;
    }

    public int getKode_makan() {
        return kode_makan;
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    @Override
    public int hitungTotal(int jumlah) {
        total = harga * jumlah;
        return total;
    }
    
    public String toString(){
        return paket;
    }
            
    public Makan getById(int kode){
        Makan ma = new Makan();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM makan " 
                + " WHERE kode_makan = '" + kode + "'");
        
        try{
            while(rs.next()){
                ma = new Makan();
                ma.setKode_makan(rs.getInt("kode_makan"));
                ma.setPaket(rs.getString("paket"));
                ma.setHarga(rs.getInt("harga"));
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ma;
    }
    
    public ArrayList<Makan> getAll(){
        ArrayList<Makan> ListMakan = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM makan");
        
        try{
            while(rs.next()){
                Makan ma = new Makan();
                ma.setKode_makan(rs.getInt("kode_makan"));
                ma.setPaket(rs.getString("paket"));
                ma.setHarga(rs.getInt("harga"));
                
                ListMakan.add(ma);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ListMakan;
    }
    
    public ArrayList<Makan> search(String keyword){
        ArrayList<Makan> ListMakan = new ArrayList();
        
        String sql = "SELECT * FROM makan WHERE "
                +"          paket LIKE '%" + keyword + "%' "
                +"          OR harga Like '%" + keyword + "%' ";
        
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Makan ma = new Makan();
                ma.setKode_makan(rs.getInt("kode_makan"));
                ma.setPaket(rs.getString("paket"));
                ma.setHarga(rs.getInt("harga"));
                               
                ListMakan.add(ma);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ListMakan;
    }
    
    public void save(){
        if(getById(kode_makan).getKode_makan() == 0){
            String SQL = "INSERT INTO makan (paket, harga) VALUES ("
                    + "     '" + this.paket + "', "
                    + "     '" + this.harga + "' "
                    + "     )";
            this.kode_makan = DBHelper.insertQueryGetId(SQL);
        }
        else{
            String SQL = "UPDATE makan SET"
                    + "     paket = '" + this.paket + "', "
                    + "     harga = '" + this.harga + "' "
                    + "     WHERE kode_makan = '" + this.kode_makan + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete(){
        String SQL = "DELETE FROM makan WHERE kode_makan = '" + this.kode_makan + "'";
        DBHelper.executeQuery(SQL);
    }
    
}
