package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.practica3.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.StringTokenizer;

import static com.example.practica3.ui.login.LoginActivity.r2;

public class SegundaPantalla extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private TextView tv1;
    private ListView lv1;
    Intent i ;
    ArrayList<String> urls= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        lv1 = (ListView)findViewById(R.id.lv1);
        i = this.getIntent();
       // tv1 = (TextView)findViewById(R.id.txtp2);

        String cadena = i.getStringExtra(r2);
        StringTokenizer t = new StringTokenizer(cadena);

        t.nextToken();


        while(t.hasMoreTokens()){

            /**
             * String s = t.nextToken();
             * if(s.equals("true")){
             *     s = st.nextToken();
             *     urls.add(s);
             * }else{
             *     Toast.makeText(this,"ALGO SALIO MAL",Toast.LENGTH_SHORT).show();
             * }
             */
            urls.add(t.nextToken());
        }

        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,urls);

        lv1.setAdapter(a);
        lv1.setOnItemClickListener(this);
        //tv1.setText(cadena);




    }
    public void volver(View v2){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String s2 = parent.getItemAtPosition(position).toString();
        Uri u =  Uri.parse(s2);
        i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
        Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_SHORT).show();
    }
}