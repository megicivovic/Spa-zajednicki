/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Megi
 */
public class Korisnik implements GenerickiDomenskiObjekat {

    private int klijentID;
    private String imePrezime;
    private String korisnickoIme;
    private String korisnickaSifra;

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String imePrezime) {
        this.korisnickoIme = imePrezime;
    }

    @Override
    public String toString() {
        return korisnickoIme;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getKorisnickaSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (!other.getKorisnickoIme().equals(this.korisnickoIme)) {
            return false;
        }
        return true;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    @Override
    public String dajNazivTabele() {
        return "klijent";
    }

    @Override
    public List<GenerickiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<GenerickiDomenskiObjekat> listaKorisnika = new ArrayList<>();
        while (rs.next()) {
            Korisnik k = new Korisnik();
            k.setKlijentID(rs.getInt("klijentID"));
            k.setImePrezime(rs.getString("imePrezime"));
            k.setKorisnickoIme(rs.getString("korisnickoIme"));
            k.setKorisnickaSifra(rs.getString("korisnickaSifra"));

            listaKorisnika.add(k);
        }
        return listaKorisnika;
    }

    @Override
    public String dajInsertVrednosti() {
        return "'" + imePrezime + "', '" + korisnickoIme + "', '" + korisnickaSifra + "'";
    }

    @Override
    public String dajApdejtVrednosti() {
        return "";
    }

    @Override
    public String dajImenaSvihAtributa() {
        return "imePrezime, korisnickoIme, korisnickaSifra";
    }

    @Override
    public String dajID() {
        return "klijentID";
    }

    @Override
    public int vratiBrojIzRS(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
