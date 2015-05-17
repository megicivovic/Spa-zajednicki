/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Megi
 */
public class Zaposleni implements GenerickiDomenskiObjekat {

    private int zaposleniID;
    private String imePrezime;
    private String stepenSS;
    private Date datumRodjenja;

    public Zaposleni(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public Zaposleni() {
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getStepenSS() {
        return stepenSS;
    }

    public void setStepenSS(String stepenSS) {
        this.stepenSS = stepenSS;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public String toString() {
        return imePrezime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zaposleni other = (Zaposleni) obj;
        if (!Objects.equals(this.getZaposleniID(), other.getZaposleniID())) {
            return false;
        }
        return true;
    }

    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    @Override
    public String dajNazivTabele() {
        return "zaposleni";
    }

    @Override
    public List<GenerickiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<GenerickiDomenskiObjekat> zaposleni = new ArrayList<>();
        while (rs.next()) {
            Zaposleni z = new Zaposleni();
            z.setZaposleniID(rs.getInt("zaposleniID"));
            z.setImePrezime(rs.getString("imePrezime"));
            z.setStepenSS(rs.getString("stepenSS"));
            z.setDatumRodjenja(new java.util.Date(rs.getDate("datumRodjenja").getTime()));
            zaposleni.add(z);
        }
        return zaposleni;
    }

    @Override
    public String dajInsertVrednosti() {
        String drodj = new SimpleDateFormat("yyyy-MM-dd").format(datumRodjenja);
        return "'" + imePrezime + "', '" + stepenSS + "',  '" + drodj + "'";
    }

    @Override
    public String dajApdejtVrednosti() {
        return "";
    }

    @Override
    public String dajImenaSvihAtributa() {
        return " imePrezime, stepenSS, datumRodjenja";
    }

    @Override
    public String dajID() {
        return "zaposleniID";
    }

    @Override
    public int vratiBrojIzRS(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
