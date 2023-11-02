
package backend;

import java.util.ArrayList;
import java.sql.*;

public class Kamar implements IPenginapan{
    private int kode_kamar;
    private String nama;
    private int harga;
    private int total;

    public Kamar() {
    }

    public Kamar(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public int getKode_kamar() {
        return kode_kamar;
    }

    public void setKode_kamar(int kode_kamar) {
        this.kode_kamar = kode_kamar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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
        return nama;
    }
        
    public Kamar getById(int kode){
        Kamar ka = new Kamar();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM kamar " 
                + " WHERE kode_kamar = '" + kode + "'");
        
        try{
            while(rs.next()){
                ka = new Kamar();
                ka.setKode_kamar(rs.getInt("kode_kamar"));
                ka.setNama(rs.getString("nama"));
                ka.setHarga(rs.getInt("harga"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ka;
    }
    
    public ArrayList<Kamar> getAll(){
        ArrayList<Kamar> ListKamar = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM kamar");
        
        try{
            while(rs.next()){
                Kamar ka = new Kamar();
                ka.setKode_kamar(rs.getInt("kode_kamar"));
                ka.setNama(rs.getString("nama"));
                ka.setHarga(rs.getInt("harga"));
                
                ListKamar.add(ka);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ListKamar;
    }
    
    public ArrayList<Kamar> search(String keyword){
        ArrayList<Kamar> ListKamar = new ArrayList();
        
        String sql = "SELECT * FROM kamar WHERE "
                +"          kode_kamar Like '%" + keyword + "%' "
                +"          OR nama LIKE '%" + keyword + "%' "
                +"          OR harga LIKE '%" + keyword + "%' ";
        
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Kamar ka = new Kamar();
                ka.setKode_kamar(rs.getInt("kode_kamar"));
                ka.setNama(rs.getString("nama"));
                ka.setHarga(rs.getInt("harga"));
                
                ListKamar.add(ka);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ListKamar;
    }
    
    public void save(){
        if(getById(kode_kamar).getKode_kamar() == 0){
            String SQL = "INSERT INTO kamar (nama, harga) VALUES ("
                    + "     '" + this.nama + "', "
                    + "     '" + this.harga + "' "
                    + "     )";
            this.kode_kamar = DBHelper.insertQueryGetId(SQL);
        }
        else{
            String SQL = "UPDATE kamar SET"
                    + "     nama = '" + this.nama + "', "
                    + "     harga = '" + this.harga + "' "
                    + "     WHERE kode_kamar = '" + this.kode_kamar + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete(){
        String SQL = "DELETE FROM kamar WHERE kode_kamar = '" + this.kode_kamar + "'";
        DBHelper.executeQuery(SQL);
    }

}

