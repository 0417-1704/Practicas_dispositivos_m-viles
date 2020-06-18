package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.example.practica3.ui.login.LoginActivity;

public class SegundaPantalla extends AppCompatActivity {
    private TextView tv1;
    Intent i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        i = getIntent();
        tv1 = (TextView)findViewById(R.id.txtp2);

        String cadena = i.getStringExtra(LoginActivity.r2);

        tv1.setText(cadena);




    }
    public void volver(View v2){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}