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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Megi
 */
public class Rezervacija implements GenerickiDomenskiObjekat {

    private int rezervacijaID;
    private Korisnik klijent;
    private Tretman tretman;
    private Zaposleni zaposleni;
    private Date vreme;

    public Rezervacija() {
    }

    public Rezervacija(Korisnik klijent, Tretman tretman, Zaposleni zaposleni, Date vreme) {
        this.klijent = klijent;
        this.tretman = tretman;
        this.zaposleni = zaposleni;
        this.vreme = vreme;
    }
    
    

    public int getRezervacijaID() {
        return rezervacijaID;
    }

    public void setRezervacijaID(int rezervacijaID) {
        this.rezervacijaID = rezervacijaID;
    }

    public Korisnik getKlijent() {
        return klijent;
    }

    public void setKlijent(Korisnik klijent) {
        this.klijent = klijent;
    }

    public Tretman getTretman() {
        return tretman;
    }

    public void setTretman(Tretman tretman) {
        this.tretman = tretman;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
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

            Korisnik k = new Korisnik();
            k.setKlijentID(rs.getInt("klijentID"));
            k.setImePrezime(rs.getString("imePrezime"));
            k.setKorisnickoIme(rs.getString("korisnickoIme"));
            k.setKorisnickaSifra(rs.getString("korisnickaSifra"));

            Tretman t = new Tretman();

            t.setTretmanID(rs.getInt("tretmanID"));
            t.setOpis(rs.getString("opis"));
            t.setCena(rs.getDouble("cena"));
            t.setTrajanjeUMin(rs.getInt("trajanjeUMin"));

            Zaposleni z = new Zaposleni();
            z.setZaposleniID(rs.getInt("zaposleniID"));
            z.setImePrezime(rs.getString("imePrezime"));
            z.setStepenSS(rs.getString("stepenSS"));
            z.setDatumRodjenja(new java.util.Date(rs.getDate("datumRodjenja").getTime()));

            Rezervacija r = new Rezervacija();

            r.setRezervacijaID(rs.getInt("rezervacijaID"));
            r.setKlijent(k);
            r.setTretman(t);
            r.setZaposleni(z);
            r.setVreme(new java.util.Date(rs.getDate("vreme").getTime()));

            listaRezervacija.add(r);
        }
        return listaRezervacija;
    }

    @Override
    public String dajInsertVrednosti() {
        String vr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(vreme);
        return klijent.getKlijentID() + ", " + tretman.getTretmanID() + ", " + zaposleni.getZaposleniID() + ", '" + vr + "'";
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

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rezervacija other = (Rezervacija) obj;
        if (this.rezervacijaID != other.rezervacijaID) {
            return false;
        }
        if (!Objects.equals(this.klijent, other.klijent)) {
            return false;
        }
        if (!Objects.equals(this.tretman, other.tretman)) {
            return false;
        }
        if (!Objects.equals(this.zaposleni, other.zaposleni)) {
            return false;
        }
        if (!Objects.equals(this.vreme, other.vreme)) {
            return false;
        }
        return true;
    }
    
    

}
