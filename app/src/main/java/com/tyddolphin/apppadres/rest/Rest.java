package com.tyddolphin.apppadres.rest;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by Gianella Milon on 27/06/2017.
 */
public class Rest {
    Context Contexto;
    public Rest(Context c){
        this.Contexto=c;

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
