package com.tyddolphin.apppadres;

/**
 * Created by Gianella Milon on 02/06/2017.
 */

public class Notificaciones {
    private int id;
    private String name;
    private String alert;
    public int color;

    public Notificaciones(){
        super();
    }
    public Notificaciones(int id, String name, String alert, int color) {
        super();
        this.id = id;
        this.name = name;
        this.alert = alert;
        this.color= color;
    }
    @Override
    public String toString() {
        return "Movilidad " + this.id + " : " + this.name + " |" + " Alerta : " + this.alert;
    }
}
