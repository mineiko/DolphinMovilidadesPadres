package com.tyddolphin.apppadres;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentHijos extends Fragment {

    class ButtonToast implements View.OnClickListener{
        int id;
        ButtonToast(int i){
            id=i;
        }
        @Override
        public void onClick(View view) {
            if (id == 1){
                Toast.makeText(getContext(), "Su hij@ no va a ir en la movilidad José", Toast.LENGTH_LONG).show();
            }

        }
    }
    LinearLayout mLinearLayout;
    public FragmentHijos() {
        // Required empty public constructor
    }

    public LinearLayout AgregarHijoLLO(String nombre, ImageView foto, Button b){
        LinearLayout temporal = new LinearLayout(getContext());
        temporal.setGravity(Gravity.CENTER);
        temporal.setOrientation(LinearLayout.HORIZONTAL);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        textView.setText(nombre);
        //textView.setTypeface(null, Typeface.BOLD);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(15);
        textView.setHeight(80);
        textView.setWidth(100);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(0,0,20,0);
        foto.setImageResource(R.drawable.b1);
        FrameLayout.LayoutParams ladderParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        foto.setLayoutParams(ladderParams);
        //foto.setGravity(Gravity.CENTER);
        foto.setPadding(20,20,20,0);
        //Button button = new Button(getContext());
        b.setText("No va a ir");
        b.setTextSize(15);
        b.setLayoutParams(ladderParams);
        b.setHeight(80);
        b.setWidth(160);
        b.setPadding(20,0,20,0);
        b.setGravity(Gravity.CENTER);

        b.setBackgroundColor(ContextCompat.getColor(this.getContext(),R.color.colorbotones2));
        temporal.addView(foto);
        temporal.addView(textView);
        temporal.addView(b);


        return temporal;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hijos, container, false);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.ListaHijos);
        //GridLayout mGridLayout = (GridLayout) view.findViewById(R.id.glo);
        LinearLayout LLODinamica = new LinearLayout(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //mLinearLayout.setOrientation(LinearLayout.VERTICAL);

        ImageView ladder = new ImageView(getContext());
        Button button = new Button(getContext());
        button.setOnClickListener(new ButtonToast(1));
        /*ladder.setImageResource(R.drawable.b1);
        FrameLayout.LayoutParams ladderParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        ladder.setLayoutParams(ladderParams);
        ladder.setPadding(20,20,20,0);*/


        /*TextView textView = new TextView(getContext());
        textView.setText("Maria Paredes");
        textView.setWidth(100);
        textView.setHeight(50);
        //int a = ladder.getTop()/2;
        //textView.setGravity();
        //textView.setPadding;
        textView.setLayoutParams(ladderParams);*/

        // added Button

        //button.setId(2);

        //added the textView and the Button to LinearLayout


        //mLinearLayout.addView(ladder);
        //mLinearLayout.addView(textView);
        //mLinearLayout.addView(button);

        LLODinamica.addView(AgregarHijoLLO("María Paredes",ladder, button));
        mLinearLayout.addView(LLODinamica);
        //LLODinamica.addView(textView);
        //LLODinamica.addView(button);


        return view;

    }

}
