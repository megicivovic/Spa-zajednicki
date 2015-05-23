/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Megi
 */
public class Raspored implements GenerickiDomenskiObjekat {

    private int brojTermina;
    private Zaposleni zaposleni;
    private Tretman tretman;

    public Raspored() {
    }

    public Raspored(int brojTermina, Zaposleni z, Tretman t) {
        this.brojTermina = brojTermina;
        this.zaposleni = z;
        this.tretman = t;
    }

    public int getBrojTermina() {
        return brojTermina;
    }

    public void setBrojTermina(int brojTermina) {
        this.brojTermina = brojTermina;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni z) {
        this.zaposleni = z;
    }

    public Tretman getTretman() {
        return tretman;
    }

    public void setTretman(Tretman t) {
        this.tretman = t;
    }

    @Override
    public String dajNazivTabele() {
        return "raspored";
    }

    @Override
    public List<GenerickiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<GenerickiDomenskiObjekat> rasporedi = new ArrayList<>();
        while (rs.next()) {
            Zaposleni z = new Zaposleni();
            z.setZaposleniID(rs.getInt("zaposleniID"));
            z.setImePrezime(rs.getString("imePrezime"));
            z.setStepenSS(rs.getString("stepenSS"));
            z.setDatumRodjenja(new java.util.Date(rs.getDate("datumRodjenja").getTime()));

            Tretman t = new Tretman();
            t.setTretmanID(rs.getInt("tretmanID"));
            t.setOpis(rs.getString("opis"));
            t.setCena(rs.getDouble("cena"));
            t.setTrajanjeUMin(rs.getInt("trajanjeUMin"));
         
            int brTermina = rs.getInt("brojTermina");
            Raspored r = new Raspored(brTermina, z, t);
            rasporedi.add(r);
        }
        return rasporedi;
    }

    @Override
    public String dajInsertVrednosti() {
        return zaposleni.getZaposleniID() + ", " + tretman.getTretmanID() + ", " + brojTermina;
    }

    @Override
    public String dajApdejtVrednosti() {
        return "";
    }

    @Override
    public String dajImenaSvihAtributa() {
        return " zaposleniID, tretmanID, brojTermina";
    }

    @Override
    public String dajID() {
        return "";
    }

    @Override
    public int vratiBrojIzRS(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
