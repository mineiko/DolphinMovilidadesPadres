package com.tyddolphin.apppadres;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;

import org.w3c.dom.Text;

import java.util.Map;


public class FragmentMapa extends Fragment {

    LinearLayout mLinearLayout;
    MapView mMapView;
    GoogleMap googlemap;
    ListView mlistView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_mapa, container, false);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.btnHijos);

        final String [] Hijos = {
                "Maria",
                "José"
        };
        for(int i = 0; i<Hijos.length;i++ ) {
            Button btnA = new Button(super.getContext());
            btnA.setBackgroundColor(Color.CYAN);
            btnA.setText(Hijos[i]);
            btnA.setTextColor(Color.WHITE);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 20, 0);
            btnA.setLayoutParams(params);
            btnA.setTextSize(18);




            mLinearLayout.addView(btnA);
        }


        mMapView = (MapView) view.findViewById(R.id.mapview);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();
        MapsInitializer.initialize(getActivity().getApplicationContext());
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googlemap=googleMap;
            }
        });

        mlistView = (ListView) view.findViewById(R.id.ListViewNotificaciones);
        final Notificaciones[] items = {
                new Notificaciones(1, "Jose", "Trafico", Color.YELLOW),
                new Notificaciones(2, "Mauricio", "Accidente Leve", Color.RED),
                new Notificaciones(3, "Jose", "Trafico", Color.YELLOW),
                new Notificaciones(4, "Mauricio", "Accidente Leve", Color.RED),
                new Notificaciones(5, "Jose", "Trafico", Color.YELLOW),
                new Notificaciones(6, "Mauricio", "Accidente Leve", Color.RED),
        };
        ArrayAdapter<Notificaciones> adapter = new ArrayAdapter<Notificaciones>(super.getContext(),android.R.layout.simple_list_item_1, items){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView tv = (TextView) super.getView(position, convertView, parent);
                tv.setBackgroundColor(items[position].color);
                return tv;
            }
        };

        mlistView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //TextView tv = new TextView(getContext());
        //tv.setText("Jose");
        //tv.setText("Mauricio");
        //mlistView.addView(tv);
        String name = mlistView.getItemAtPosition(0).getClass().toString();
        Toast.makeText(getContext(), name, Toast.LENGTH_LONG).show();

        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {

                String item = ((TextView)view).getText().toString();

                Toast.makeText(getContext(), item, Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }

}
