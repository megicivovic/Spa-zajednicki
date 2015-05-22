/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package protokol.objekti;

import java.io.Serializable;
import protokol.Protokol;


public class KlijentZahtev implements Serializable {
    
    private Object objekat;
    
    private Protokol protokol;

    public Object getObjekat() {
        return objekat;
    }

    public void setObjekat(Object objekat) {
        this.objekat = objekat;
    }

    public Protokol getProtokol() {
        return protokol;
    }

    public void setProtokol(Protokol protokol) {
        this.protokol = protokol;
    }

    @Override
    public String toString() {
        return "KlijentZahtev{" + "objekat=" + objekat + ", protokol=" + protokol + '}';
    }
    
    
    
}
