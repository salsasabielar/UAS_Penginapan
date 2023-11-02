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

public class Transaksi {
    private int kode_transaksi;
    private Customer customer = new Customer();
    private Kamar kamar = new Kamar();
    private Makan makan = new Makan();
    private String tgl_sewa;
    private int lama;
    private int jmlKamar;
    private int jmlMakan;
    private int total_transaksi;

    public Transaksi() {
    }

    public Transaksi(Customer customer, Kamar kamar, Makan makan, String tgl_sewa, int lama, int jmlKamar, int jmlMakan) {
        this.customer = customer;
        this.kamar = kamar;
        this.makan = makan;
        this.tgl_sewa = tgl_sewa;
        this.lama = lama;
        this.jmlKamar = jmlKamar;
        this.jmlMakan = jmlMakan;
    }

    public int getKode_transaksi() {
        return kode_transaksi;
    }

    public int getjmlKamar() {
        return jmlKamar;
    }

    public void setjmlKamar(int jmlKamar) {
        this.jmlKamar = jmlKamar;
    }

    public int getjmlMakan() {
        return jmlMakan;
    }

    public void setjmlMakan(int jmlMakan) {
        this.jmlMakan = jmlMakan;
    }

    public void setKode_transaksi(int kode_transaksi) {
        this.kode_transaksi = kode_transaksi;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public void setKamar(Kamar kamar) {
        this.kamar = kamar;
    }

    public Makan getMakan() {
        return makan;
    }

    public void setMakan(Makan makan) {
        this.makan = makan;
    }

    public String getTgl_sewa() {
        return tgl_sewa;
    }

    public void setTgl_sewa(String tgl_sewa) {
        this.tgl_sewa = tgl_sewa;
    }

    public int getLama() {
        return lama;
    }

    public void setLama(int lama) {
        this.lama = lama;
    }

    public int getTotal_transaksi() {
        return total_transaksi;
    }

    public void setTotal_transaksi() {
        hitungTotal();
    }
    
    public void hitungTotal() {
        total_transaksi = lama * (makan.getById(makan.getKode_makan()).hitungTotal(jmlMakan) + kamar.getById(kamar.getKode_kamar()).hitungTotal(jmlKamar));
    }
        
    public Transaksi getById(int kode)
    {
        Transaksi tr = new Transaksi();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                                        + "     t.kode_transaksi AS kode_transaksi, "
                                        + "     c.kode_register AS kode_register, "
                                        + "     k.kode_kamar AS kode_kamar, "
                                        + "     m.kode_makan AS kode_makan, "
                                        + "     t.tgl_sewa AS tgl_sewa, "
                                        + "     t.lama AS lama, "
                                        + "     t.jmlKamar AS jmlKamar, "
                                        + "     t.jmlMakan AS jmlMakan, "
                                        + "     t.total_transaksi AS total_transaksi "
                                        + "     FROM transaksi t "
                                        + "     LEFT JOIN customer c ON t.kode_register = c.kode_register "
                                        + "     LEFT JOIN kamar k ON t.kode_kamar = k.kode_kamar "
                                        + "     LEFT JOIN makan m ON t.kode_makan = m.kode_makan "
                                        + "     WHERE t.kode_transaksi = '" + kode + "'");
        
        try
        {
            while(rs.next())
            {
                tr = new Transaksi();
                tr.setKode_transaksi(rs.getInt("kode_transaksi"));
                tr.getCustomer().setKode_register(rs.getInt("kode_register"));
                tr.getKamar().setKode_kamar(rs.getInt("kode_kamar"));
                tr.getMakan().setKode_makan(rs.getInt("kode_makan"));
                tr.setTgl_sewa(rs.getString("tgl_sewa"));
                tr.setLama(rs.getInt("lama"));
                tr.setjmlKamar(rs.getInt("jmlKamar"));
                tr.setjmlMakan(rs.getInt("jmlMakan"));
                tr.setTotal_transaksi();
                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return tr;
    }
    
    public ArrayList<Transaksi> getAll()
    {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT "
                                        + "     t.kode_transaksi AS kode_transaksi, "
                                        + "     c.kode_register AS kode_register, "
                                        + "     k.kode_kamar AS kode_kamar, "
                                        + "     m.kode_makan AS kode_makan, "
                                        + "     t.tgl_sewa AS tgl_sewa, "
                                        + "     t.lama AS lama, "
                                        + "     t.jmlKamar AS jmlKamar, "
                                        + "     t.jmlMakan AS jmlMakan, "
                                        + "     t.total_transaksi AS total_transaksi "
                                        + "     FROM transaksi t "
                                        + "     LEFT JOIN customer c ON t.kode_register = c.kode_register "
                                        + "     LEFT JOIN kamar k ON t.kode_kamar = k.kode_kamar "
                                        + "     LEFT JOIN makan m ON t.kode_makan = m.kode_makan ");
                                       
        
        try
        {
            while(rs.next())
            {
                Transaksi tr = new Transaksi();
                tr.setKode_transaksi(rs.getInt("kode_transaksi"));
                tr.getCustomer().setKode_register(rs.getInt("kode_register"));
                tr.getKamar().setKode_kamar(rs.getInt("kode_kamar"));
                tr.getMakan().setKode_makan(rs.getInt("kode_makan"));
                tr.setTgl_sewa(rs.getString("tgl_sewa"));
                tr.setLama(rs.getInt("lama"));
                tr.setjmlKamar(rs.getInt("jmlKamar"));
                tr.setjmlMakan(rs.getInt("jmlMakan"));
                tr.setTotal_transaksi();
                
                ListTransaksi.add(tr);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return ListTransaksi;
    }
    
    public ArrayList<Transaksi> search(String keyword)
    {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT "
                                        + "     t.kode_transaksi AS kode_transaksi, "
                                        + "     c.kode_register AS kode_register, "
                                        + "     k.kode_kamar AS kode_kamar, "
                                        + "     m.kode_makan AS kode_makan, "
                                        + "     t.tgl_sewa AS tgl_sewa, "
                                        + "     t.lama AS lama, "
                                        + "     t.jmlKamar AS jmlKamar, "
                                        + "     t.jmlMakan AS jmlMakan, "
                                        + "     t.total_transaksi AS total_transaksi, "
                                        + "     FROM transaksi t "
                                        + "     LEFT JOIN customer c ON t.kode_register = c.kode_register "
                                        + "     LEFT JOIN kamar k ON t.kode_kamar = k.kode_kamar "
                                        + "     LEFT JOIN makan m ON t.kode_makan = m.kode_makan "
                                        + "     WHERE t.kode_transaksi LIKE '%" + keyword + "%' "
                                        + "         OR c.kode_register LIKE '%" +keyword + "%' "
                                        + "         OR k.kode_kamar LIKE '%" +keyword + "%' "
                                        + "         OR t.tgl_sewa LIKE '%" +keyword + "%' "
                                        + "         OR t.total_transaksi LIKE '%" +keyword + "%' ");
        
        try
        {
            while(rs.next())
            {
                Transaksi tr = new Transaksi();
                tr.setKode_transaksi(rs.getInt("kode_transaksi"));
                tr.getCustomer().setKode_register(rs.getInt("kode_register"));
                tr.getKamar().setKode_kamar(rs.getInt("kode_kamar"));
                tr.getMakan().setKode_makan(rs.getInt("kode_makan"));
                tr.setTgl_sewa(rs.getString("tgl_sewa"));
                tr.setLama(rs.getInt("lama"));
                tr.setjmlKamar(rs.getInt("jmlKamar"));
                tr.setjmlMakan(rs.getInt("jmlMakan"));
                tr.setTotal_transaksi();
                
                ListTransaksi.add(tr);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return ListTransaksi;
    }
    
    public void save()
    {
        if (getById(kode_transaksi).getKode_transaksi() == 0)
        {
            String SQL = "INSERT INTO transaksi (kode_register, kode_kamar, kode_makan, tgl_sewa, lama, jmlKamar, jmlMakan, total_transaksi) VALUES("
                    + "     '" + this.getCustomer().getKode_register() + "', "
                    + "     '" + this.getKamar().getKode_kamar() + "', "
                    + "     '" + this.getMakan().getKode_makan() + "', "
                    + "     '" + this.tgl_sewa+ "', "
                    + "     '" + this.lama + "', "
                    + "     '" + this.jmlKamar + "', "
                    + "     '" + this.jmlMakan + "', "
                    + "     '" + this.total_transaksi + "' "
                    + "     )";
            this.kode_transaksi = DBHelper.insertQueryGetId(SQL);
        }
        else
        {
            String SQL = "UPDATE transaksi SET "
                    + "     kode_register = '" + this.getCustomer().getKode_register() + "', "
                    + "     kode_kamar = '" + this.getKamar().getKode_kamar() + "', "
                    + "     kode_makan = '" + this.getMakan().getKode_makan() + "', "
                    + "     tgl_sewa = '" + this.tgl_sewa + "', "
                    + "     lama = '" + this.lama + "', "
                    + "     jmlKamar = '" + this.jmlKamar + "', "
                    + "     jmlMakan = '" + this.jmlMakan + "', "
                    + "     total_transaksi = '" + this.total_transaksi + "' "
                    + "     WHERE kode_transaksi = '" + this.kode_transaksi + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete()
    {
        String SQL = "DELETE FROM transaksi WHERE kode_transaksi = '" + this.kode_transaksi + "'";
        DBHelper.executeQuery(SQL);
    }

    
}
