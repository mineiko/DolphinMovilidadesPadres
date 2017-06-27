package com.tyddolphin.apppadres.rest;

/**
 * Created by Gianella Milon on 27/06/2017.
 */

public class Ubicacion {
    public double Latitud;
    public double Longitud;
    public Ubicacion(double lat, double lng){
        Latitud = lat;
        Longitud = lng;
    }

    @Override
    public String toString() {
        return "lat: " + Latitud + ", lng: " + Longitud;
    }
}
