package com.tyddolphin.apppadres.rest;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.tyddolphin.apppadres.dto.DtoGenerarRuta;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Gianella Milon on 27/06/2017.
 */
public class Rest {

    public interface RestListener<T>{
        void onRespuesta(T respuesta);
    }

    public RestListener<Ubicacion[]> GenerarRutaCompleted;

    Context Contexto;
    public Rest(Context c){
        this.Contexto=c;

    }
    public void getCantidadAlumnosAsync(String idMovilidad){
        try{
            String url = "http://movilidadessignalr20170616114841.azurewebsites.net/ServicioMock.svc/alumnosPoMovilidad/" + idMovilidad;
            JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    //for(RestListener l : getCantidadAlumnosCompleted)
                    //l.onRespuesta(response.length());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void GenerarRuta(Ubicacion inicio, Ubicacion fin, Ubicacion[] paradas){
        try{
            String url = "http://movilidadessignalr20170616114841.azurewebsites.net/ServicioMock.svc/ruta";

            DtoGenerarRuta dto = new DtoGenerarRuta();
            dto.setInicio(inicio);
            dto.setFin(fin);
            dto.setParadas(paradas);

            Gson gson = new Gson();
            String json = gson.toJson(dto);

            JSONObject body = new JSONObject(json);

            JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, url, body, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Ubicacion[] ruta = new Gson().fromJson(response.toString(), Ubicacion[].class);
                    GenerarRutaCompleted.onRespuesta(ruta);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(Contexto);
            request.setTag("rest");
            requestQueue.add(request);
        }catch (Exception e){
            Log.e("Rest", e.getMessage());
            e.printStackTrace();
        }
    }


    public void Reponse(String url){

        try {
            //String url = "http://movilidadessignalr20170616114841.azurewebsites.net/ServicioMock.svc/movilidades/0";
            //HttpURLConnection conexion = (HttpURLConnection) Direccion.openConnection();

            JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.i("rest", response.toString());
                    Gson gson = new Gson();
                    Movilidad mov = gson.fromJson(response.toString(),Movilidad.class);
                    Log.i("","");
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("rest", error.getMessage());
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(Contexto);
            request.setTag("rest");
            requestQueue.add(request);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
