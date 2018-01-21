package com.projetodoertheia.a5cta.Firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.projetodoertheia.a5cta.Firebase.m_FireBase.Fire;
import com.projetodoertheia.a5cta.R;

public class FirebaseNoticias extends AppCompatActivity {

    final static String DB_URL ="https://cta-4f03b.firebaseio.com/";
    Fire fire;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_noticias);

        lv = (ListView)findViewById(R.id.lvFIREBASE);

        fire = new Fire(this,lv,DB_URL);

        fire.refreshData();

    }
}
