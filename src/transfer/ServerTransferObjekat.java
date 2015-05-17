/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author student1
 */
public class ServerTransferObjekat implements Serializable{
    private Object podaci;
    private int uspesnostIzvrsenjaOperacije;
    //1 - uspesno; -1 - neuspesno
    private Exception exception;

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public int getUspesnostIzvrsenjaOperacije() {
        return uspesnostIzvrsenjaOperacije;
    }

    public void setUspesnostIzvrsenjaOperacije(int uspesnostIzvrsenjaOperacije) {
        this.uspesnostIzvrsenjaOperacije = uspesnostIzvrsenjaOperacije;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
