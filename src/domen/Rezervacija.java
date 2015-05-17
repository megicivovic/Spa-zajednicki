/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Megi
 */
public class Rezervacija implements GenerickiDomenskiObjekat {
    
    private int rezervacijaID;
    private int klijentID;
    private int tretmanID;
    private int zaposleniID;
    private Date vreme;

    public Rezervacija(int klijentID, int tretmanID, int zaposleniID, Date vreme) {
        this.klijentID = klijentID;
        this.tretmanID = tretmanID;
        this.zaposleniID = zaposleniID;
        this.vreme = vreme;
    }
    
  
    
    public Rezervacija() {
    }
    
    public Date getVreme() {
        return vreme;
    }
    
    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }
    
    @Override
    public String dajNazivTabele() {
        return "rezervacija";
    }
    
    @Override
    public List<GenerickiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<GenerickiDomenskiObjekat> listaRezervacija = new ArrayList<>();
        while (rs.next()) {
            Rezervacija r = new Rezervacija();
            r.setRezervacijaID(rs.getInt("rezervacijaID"));
            r.setKlijentID(rs.getInt("klijentID"));
            r.setTretmanID(rs.getInt("tretmanID"));
            r.setZaposleniID(rs.getInt("zaposleniID"));            
            r.setVreme(new java.util.Date(rs.getDate("vreme").getTime()));
            
            listaRezervacija.add(r);
        }
        return listaRezervacija;
    }
    
    @Override
    public String dajInsertVrednosti() {
        String vr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(vreme);
        return klijentID+", "+tretmanID  + ", " + zaposleniID+ ", '" + vr + "'";
    }
    
    @Override
    public String dajApdejtVrednosti() {
        return "";
    }
    
    @Override
    public String dajImenaSvihAtributa() {
        return "klijentID, tretmanID, zaposleniID, vreme";
    }
    
    @Override
    public String dajID() {
        return "rezervacijaID";
    }
    
    @Override
    public int vratiBrojIzRS(ResultSet rs) {
        int broj = 0;
        try {
            broj = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Rezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return broj;
    }
    
    public int getRezervacijaID() {
        return rezervacijaID;
    }
    
    public void setRezervacijaID(int rezervacijaID) {
        this.rezervacijaID = rezervacijaID;
    }
    
    public int getTretmanID() {
        return tretmanID;
    }
    
    public void setTretmanID(int tretmanID) {
        this.tretmanID = tretmanID;
    }
    
    public int getZaposleniID() {
        return zaposleniID;
    }
    
    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }
    
}
