package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author student1
 */
public class Tretman implements GenerickiDomenskiObjekat {

    private int tretmanID;
    private String opis;
    private double cena;
    private int trajanjeUMin;
    private List<Preparat> listaPreparata;

    public Tretman() {

    }

    public Tretman(int tretmanID) {
        this.tretmanID = tretmanID;
    }

    @Override
    public boolean equals(Object obj) {
        Tretman t = (Tretman) obj;
        if (getOpis().equals(t.getOpis())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return opis;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getTrajanjeUMin() {
        return trajanjeUMin;
    }

    public void setTrajanjeUMin(int trajanjeUMin) {
        this.trajanjeUMin = trajanjeUMin;
    }

    public List<Preparat> getListaPreparata() {
        return listaPreparata;
    }

    public void setListaPreparata(List<Preparat> listaPreparata) {
        this.listaPreparata = listaPreparata;
    }

    public int getTretmanID() {
        return tretmanID;
    }

    public void setTretmanID(int tretmanID) {
        this.tretmanID = tretmanID;
    }

    @Override
    public String dajNazivTabele() {
        return "tretman";
    }

    @Override
    public List<GenerickiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<GenerickiDomenskiObjekat> listaTretmana = new ArrayList<>();
        while (rs.next()) {
            Tretman t = new Tretman();

            t.setTretmanID(rs.getInt("tretmanID"));
            t.setOpis(rs.getString("opis"));
            t.setCena(rs.getDouble("cena"));
            t.setTrajanjeUMin(rs.getInt("trajanjeUMin"));

            listaTretmana.add(t);
        }
        return listaTretmana;
    }

    @Override
    public String dajInsertVrednosti() {
        return "'" + opis + "', " + cena + ", " + trajanjeUMin;
    }

    @Override
    public String dajApdejtVrednosti() {
        return "opis= '" + getOpis() + "', cena= " + getCena() + ", trajanjeUMin=" + getTrajanjeUMin() + " WHERE tretmanID= " + getTretmanID();
    }

    @Override
    public String dajImenaSvihAtributa() {
        return "opis, cena, trajanjeUMin";
    }

    @Override
    public String dajID() {
        return "tretmanID";
    }

    @Override
    public int vratiBrojIzRS(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
