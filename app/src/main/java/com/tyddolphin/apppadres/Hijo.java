package com.tyddolphin.apppadres;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by Gianella Milon on 08/06/2017.
 */

public class Hijo {
    String Nombre;
    Movilidad movilidad;
    LatLng Ubicacion;
    Marker marcador;





    public Hijo(String n, double lat, double lng){
        this.Nombre = n;
        this.Ubicacion = new LatLng(lat,lng);
    }

}
