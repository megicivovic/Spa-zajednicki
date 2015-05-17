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
public class TretmanPreparati implements GenerickiDomenskiObjekat {

    private int tretmanID;
    private int preparatID;

    public TretmanPreparati() {
    }

    public TretmanPreparati(int tretmanID, int preparatID) {
        this.tretmanID = tretmanID;
        this.preparatID = preparatID;
    }

    public int getTretmanID() {
        return tretmanID;
    }

    public void setTretmanID(int tretmanID) {
        this.tretmanID = tretmanID;
    }

    public int getPreparatID() {
        return preparatID;
    }

    public void setPreparatID(int preparatID) {
        this.preparatID = preparatID;
    }

    @Override
    public String dajNazivTabele() {
        return "tretmanpreparati";
    }

    @Override
    public List<GenerickiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<GenerickiDomenskiObjekat> preparatiTretmana = new ArrayList<>();
        while (rs.next()) {
            TretmanPreparati tp = new TretmanPreparati();
            tp.setPreparatID(rs.getInt("preparatID"));
            tp.setTretmanID(rs.getInt("tretmanID"));

            preparatiTretmana.add(tp);
        }
        return preparatiTretmana;
    }

    @Override
    public String dajInsertVrednosti() {
        return tretmanID + ", " + preparatID;
    }

    @Override
    public String dajApdejtVrednosti() {
        return "";
    }

    @Override
    public String dajImenaSvihAtributa() {
        return " tretmanID, preparatID";
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
