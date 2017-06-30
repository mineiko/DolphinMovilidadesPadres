package com.tyddolphin.apppadres.dto;

import com.tyddolphin.apppadres.rest.Ubicacion;

/**
 * @Author Alexis
 */

public class DtoGenerarRuta{
    private Ubicacion Inicio;
    private Ubicacion Fin;
    private Ubicacion[] Paradas;

    public Ubicacion getInicio() {
        return Inicio;
    }

    public void setInicio(Ubicacion inicio) {
        Inicio = inicio;
    }

    public Ubicacion getFin() {
        return Fin;
    }

    public void setFin(Ubicacion fin) {
        Fin = fin;
    }

    public Ubicacion[] getParadas() {
        return Paradas;
    }

    public void setParadas(Ubicacion[] paradas) {
        Paradas = paradas;
    }
}