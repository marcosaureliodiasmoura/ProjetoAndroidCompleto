package com.projetodoertheia.a5cta.NoticiasFirebase.mFirebase;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.realtime.Connection;
import com.projetodoertheia.a5cta.NoticiasFirebase.mData.Noticias;
import com.projetodoertheia.a5cta.NoticiasFirebase.mRecycler.MyAdapter;

import java.util.ArrayList;

/**
 * Created by Marcos on 22/08/2016.
 */
public class FirebaseClient extends AsyncTask<Void,Void, Object> {

    Context c;
    String DB_URL;
    RecyclerView rv;

    ProgressDialog pd;

    Firebase fire;
    ArrayList<Noticias> noticias = new ArrayList<>();
    MyAdapter adapter;


    public FirebaseClient(Context c, String DB_URL, RecyclerView rv) {
        this.c = c;
        this.DB_URL = DB_URL;
        this.rv = rv;

        Firebase.setAndroidContext(c);


        fire = new Firebase(DB_URL);


    }



    public void refreshData()
    {

        fire.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }


    private void getUpdates(DataSnapshot dataSnapshot)
    {
        noticias.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            //Pra adicionar novos valores da Noticia
            Noticias n = new Noticias();
            n.setTitulo(ds.getValue(Noticias.class).getTitulo());
            n.setSubtitulo(ds.getValue(Noticias.class).getSubtitulo());
            n.setImagemurl(ds.getValue(Noticias.class).getImagemurl());

            noticias.add(n);

        }
        if (noticias.size()>0)
        {

            adapter = new MyAdapter(c, noticias);
            rv.setAdapter(adapter);


        }else {

            Toast.makeText(c, "NO DATABASE", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected Object doInBackground(Void... params) {
        return null;
    }
}