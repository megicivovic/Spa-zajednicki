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
 * @author student1
 */
public class Preparat implements GenerickiDomenskiObjekat {

    private double cena;
    private int preparatID;
    private String naziv;
    private Kompanija proizvodjac;

    public Preparat() {
        this.cena = 0;
        this.naziv = "N/A";
    }

    public Preparat(long cena, String naziv) {
        this.cena = cena;
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double ptt) {
        this.cena = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object obj) {
        Preparat m = (Preparat) obj;
        if (this.getPreparatID() == m.getPreparatID()) {
            return true;
        }
        return false;
    }

    public Kompanija getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Kompanija proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public int getPreparatID() {
        return preparatID;
    }

    public void setPreparatID(int preparatID) {
        this.preparatID = preparatID;
    }

    @Override
    public String dajNazivTabele() {
        return "preparat";
    }

    @Override
    public List<GenerickiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<GenerickiDomenskiObjekat> listaPreparata = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("preparatID");
            String nazivP = rs.getString("naziv");
            double cena = rs.getDouble("cena");
            int proizvodjacID = rs.getInt("proizvodjac");

            Preparat p = new Preparat();

            p.setPreparatID(id);
            p.setNaziv(nazivP);
            p.setCena(cena);
            p.setProizvodjac(new Kompanija(proizvodjacID));
            listaPreparata.add(p);
        }
        return listaPreparata;
    }

    @Override
    public String dajInsertVrednosti() {
        return "'" + naziv + "', " + cena + ", " + getProizvodjac().getKompanijaID();
    }

    @Override
    public String dajApdejtVrednosti() {
        return " tretmanID= ";
    }

    @Override
    public String dajImenaSvihAtributa() {
        return "naziv, cena, proizvodjac";
    }

    @Override
    public String dajID() {
        return "preparatID ";
    }

    @Override
    public int vratiBrojIzRS(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
