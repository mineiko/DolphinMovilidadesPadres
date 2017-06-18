package com.tyddolphin.apppadres;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;




import org.w3c.dom.Text;

import java.util.Map;


public class FragmentMapa extends Fragment {
    private static final LatLng BRISBANE = new LatLng(-16.449487, -71.534222);

    private static final LatLng MELBOURNE = new LatLng(-16.449909, -71.536766);

    private Marker Movilidad;
    private Marker MovilidadA;
    private Marker mHijo1;
    private Marker mHijo2;
    private Marker mCasa;

    //private Button infoButton;
    //private ViewGroup infoWindow;
    /*
    class A implements View.OnClickListener{
        Hijo n ;
        A(Hijo _n){
            n=_n;
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(getContext(), n.Nombre , Toast.LENGTH_LONG).show();
            googlemap.moveCamera(CameraUpdateFactory.newLatLngZoom(n.Ubicacion, 18));
            MarkerOptions marker_options = new MarkerOptions()
                    .position(n.Ubicacion)
                    .title(n.Nombre).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp));
            n.marcador = googlemap.addMarker(marker_options);
        }
    }*/
    Polyline a;
    class Notificaciones implements View.OnClickListener{
        int id;
        Notificaciones(int i){
            id = i;
        }
        @Override
        public void onClick(View view) {
            //Construccion de la accion del intent implicito
            Intent intent= new Intent(getContext(),FragmentMapa.class);
            PendingIntent pendingIntent=PendingIntent.getActivity(getContext(),0,intent,0);
            //Construccion de la notificacion;
            NotificationCompat.Builder builder= new NotificationCompat.Builder(getContext());
            builder.setSmallIcon(R.drawable.ic_directions_bus_black_24dp);
            builder.setContentIntent(pendingIntent);
            builder.setAutoCancel(true);
            builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icono));
            //Polyline a = new Polyline();
            if (id==0){
                builder.setContentTitle("Movilidad : José");
                builder.setContentText("Inicio su Recorrido");
                //builder.setSubText("Toca para ver la documentacion acerca de Anndroid.");
                //googlemap.moveCamera(CameraUpdateFactory.newLatLngZoom(n.Ubicacion, 18));
                a =  googlemap.addPolyline(new PolylineOptions()
                        .add(new LatLng(-16.449496, -71.534201))
                        .add(new LatLng(-16.450648, -71.535639))
                        .add(new LatLng(-16.449661, -71.536486))
                        .add(new LatLng(-16.449918, -71.536840)));

                /*googlemap.addPolyline(new PolylineOptions()
                        .add(new LatLng(-16.449496, -71.534201))
                        .add(new LatLng(-16.450648, -71.535639))
                        .add(new LatLng(-16.449661, -71.536486))
                        .add(new LatLng(-16.449918, -71.536840)));*/
                MarkerOptions moMovilidades = new MarkerOptions()
                        .position(BRISBANE)
                        .title("Movilidad : José ").snippet("Llega en 5 min")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp));
                Movilidad = googlemap.addMarker(moMovilidades);

            }
            if (id==1){
                builder.setContentTitle("Movilidad : José");
                builder.setContentText("Acaba de recoger a su Hij@ : María");
                a.remove();
                Movilidad.remove();
                MarkerOptions moHijo = new MarkerOptions()
                        .position(MELBOURNE)
                        .title("María").snippet("Yendo al colegio")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
                mHijo1 = googlemap.addMarker(moHijo);

                googlemap.setInfoWindowAdapter(new B());
                //builder.setSubText("Toca para ver la documentacion acerca de Anndroid.");
            }
            if (id==2){
                builder.setContentTitle("Movilidad : José");
                builder.setContentText("Alerta : Accidente");
                mHijo1.remove();
                MarkerOptions Movilidad01 = new MarkerOptions()
                        .position(new LatLng(-16.449661, -71.536486))
                        .title("María").snippet("Yendo al colegio")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                MovilidadA = googlemap.addMarker(Movilidad01);
                googlemap.setInfoWindowAdapter(new B());
                //builder.setSubText("Toca para ver la documentacion acerca de Anndroid.");
            }
            //Enviar la notificacion
            NotificationManager notificationManager= (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(id,builder.build());
        }
    }
    class B implements InfoWindowAdapter{
        private final View mWindow;

        private final View mContents;

        B() {
            mWindow = getActivity().getLayoutInflater().inflate(R.layout.custom_info_window, null);
            mContents =getActivity(). getLayoutInflater().inflate(R.layout.custom_info_contents, null);
        }

        @Override
        public View getInfoWindow(Marker marker) {

            render(marker, mWindow);
            return mWindow;
        }

        @Override
        public View getInfoContents(Marker marker) {
            render(marker, mContents);
            return mContents;
        }
    }

    private void render(Marker marker, View view) {
        int badge;
        // Use the equals() method on a Marker to check for equals.  Do not use ==.
        if (marker.equals(mHijo1)) {
            badge = R.drawable.b1;
        }else if (marker.equals(mHijo2)) {
            badge = R.drawable.a1;
        }else if (marker.equals(MovilidadA)) {
            badge = R.drawable.b1;
        }else{
            badge = 0;
        }
        ((ImageView) view.findViewById(R.id.badge)).setImageResource(badge);

        String title = marker.getTitle();
        TextView titleUi = ((TextView) view.findViewById(R.id.title));
        if (title != null) {
            // Spannable string allows us to edit the formatting of the text.
            SpannableString titleText = new SpannableString(title);
            titleText.setSpan(new ForegroundColorSpan(Color.BLACK), 0, titleText.length(), 0);
            titleUi.setText(titleText);
        } else {
            titleUi.setText("");
        }

        String snippet = marker.getSnippet();
        TextView snippetUi = ((TextView) view.findViewById(R.id.snippet));
        if (snippet != null && snippet.length() > 12) {
            SpannableString snippetText = new SpannableString(snippet);
            snippetText.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 10, 0);
            snippetText.setSpan(new ForegroundColorSpan(Color.BLACK), 12, snippet.length(), 0);
            snippetUi.setText(snippetText);
        } else {
            snippetUi.setText("");
        }

        //this.infoButton = (Button)infoWindow.findViewById(R.id.buttonHijo);


    }

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
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.btn);

        Button btnA = new Button(super.getContext());
        Button btnB = new Button(super.getContext());
        Button btnC = new Button(super.getContext());
        Button btnD = new Button(super.getContext());
        btnA.setText("Inicio Recorrido");
        btnA.setOnClickListener(new Notificaciones(0));
        btnB.setText("Recogio Alumno");
        btnB.setOnClickListener(new Notificaciones(1));
        btnC.setText("Alerta Accidente");
        btnC.setOnClickListener(new Notificaciones(2));
        //btnD.setText("Inicio Recorrido");

        mLinearLayout.addView(btnA);
        mLinearLayout.addView(btnB);
        mLinearLayout.addView(btnC);
        //mLinearLayout.addView(btnD);
        /*final Hijo[] Hijos  = new Hijo[2];
        Hijos[0] = new Hijo("Maria",-16.450452, -71.537035);
        Hijos[1] = new Hijo("Jose",-16.450, -71.537);
        for (int i = 0; i < Hijos.length; i++) {
            Button btnA = new Button(super.getContext());
            btnA.setBackgroundColor(ContextCompat.getColor(this.getContext(),R.color.colorbotones));
            btnA.setText(Hijos[i].Nombre);
            btnA.setTextColor(Color.WHITE);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 20, 0);
            btnA.setLayoutParams(params);
            btnA.setTextSize(18);
            btnA.setOnClickListener(new A(Hijos[i]));

            mLinearLayout.addView(btnA);
        }*/


        mMapView = (MapView) view.findViewById(R.id.mapview);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();
        MapsInitializer.initialize(getActivity().getApplicationContext());
        mMapView.getMapAsync(new OnMapReadyCallback() {
            public void onMapReady(GoogleMap _googleMap) {
                googlemap = _googleMap;

                /*LatLng mll = new LatLng(-16.450452, -71.537035);//latitud y longitud
                googlemap.moveCamera(CameraUpdSateFactory.newLatLngZoom(mll, 18));
                MarkerOptions marker_options = new MarkerOptions()
                        .position(mll)
                        .title("Holi").snippet("Population: 4,137,400").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp));
                //googlemap.addPolyline(new PolylineOptions().add(new LatLng(-16.450452, -71.537035)).add(new LatLng(-16.4504, -71.5370)));
                Marker m = googlemap.addMarker(marker_options);*/
                googlemap.moveCamera(CameraUpdateFactory.newLatLngZoom(BRISBANE, 18));

                /*googlemap.addPolyline(new PolylineOptions()
                        .add(new LatLng(-16.449496, -71.534201))
                        .add(new LatLng(-16.450648, -71.535639))
                        .add(new LatLng(-16.449661, -71.536486))
                        .add(new LatLng(-16.449918, -71.536840)));
                googlemap.addPolyline(new PolylineOptions()
                        .add(new LatLng(-16.453807, -71.533557))
                        .add(new LatLng(-16.451518, -71.534276))
                        .add(new LatLng(-16.451394, -71.534314))
                        .add(new LatLng(-16.450360, -71.535215))
                        .add(new LatLng(-16.450659, -71.535633))
                        .add(new LatLng(-16.449661, -71.536475))
                        .add(new LatLng(-16.449918, -71.536840)));*/



                MarkerOptions casa = new MarkerOptions()
                        .position(new LatLng(-16.449918, -71.536840))
                        .title("Casa")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_home_black_36dp));
                mCasa = googlemap.addMarker(casa);
                //googlemap.setInfoWindowAdapter(new B());
                //mHijo1 = googlemap.addMarker(marker_options1);
                //mHijo2 = googlemap.addMarker(marker_options2);

                //mHijo1.showInfoWindow();
                //mHijo2.showInfoWindow();

            }
        });
        /*MarkerOptions marker_options1 = new MarkerOptions()
                .position(BRISBANE)
                .title("Maria").snippet("Llega en 5 min")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));*/


        MarkerOptions marker_options2 = new MarkerOptions()
                .position(MELBOURNE)
                .title("Jose").snippet("Llega en 7 min")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        /*mlistView = (ListView) view.findViewById(R.id.ListViewNotificaciones);
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
        };*/

       /* mlistView.setAdapter(adapter);
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
        });*/

        return view;
    }

}
