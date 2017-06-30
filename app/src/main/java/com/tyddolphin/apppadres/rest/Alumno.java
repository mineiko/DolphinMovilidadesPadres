package com.tyddolphin.apppadres.rest;

/**
 * Created by Gianella Milon on 27/06/2017.
 */

public class Alumno {
    public int Id;
    public String Nombre;
    public Ubicacion Casa;
    public String Foto;
    public String Estado;

    public Alumno(int i, String n, Ubicacion c, String e){
        Id=i;
        Nombre = n;
        Casa = c;
        Estado = e;


    }

}