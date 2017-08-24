package com.example.crianbra.webservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView)findViewById(R.id.textview);

        RequestQueue queue = Volley.newRequestQueue(this);
        String  url = "https://educaapp.000webhostapp.com/persona.php?usu=2&pas=124";
        //String  url = "http://educapp.rf.gd/persona.php?usu=1";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                text.setText("Resultado: "+response);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                text.setText("no se pudo realizar la solicitud");

            }

        });
        queue.add(stringRequest);
    }
}
