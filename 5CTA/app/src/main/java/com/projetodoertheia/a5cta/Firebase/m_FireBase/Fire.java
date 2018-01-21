package com.projetodoertheia.a5cta.Firebase.m_FireBase;

import android.content.Context;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.projetodoertheia.a5cta.Firebase.m_Data.Noticias;
import com.projetodoertheia.a5cta.Firebase.m_ListView.Adapter;

import java.util.ArrayList;

/**
 * Created by Marcos on 20/08/2016.
 */
public class Fire {

    Context c;
    ArrayList<Noticias> noticias = new ArrayList<>();
    Adapter adapter;
    ListView lv;
    Firebase firebase;
    String DB_URL;

    public Fire(Context c, ListView lv, String DB_URL) {
        this.c = c;
        this.lv = lv;
        this.DB_URL = DB_URL;

        Firebase.setAndroidContext(c);
        firebase = new Firebase(DB_URL);

    }

    public void saveOnline (String titulo, String subtitulo, String imagemurl)
    {
        Noticias  n = new Noticias();
        n.setTitulo(titulo);
        n.setSubtitulo(subtitulo);
        n.setImagemurl(imagemurl);

        firebase.child("noticias").setValue(n);

    }

    public void refreshData()
    {
        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchupdates(dataSnapshot);


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchupdates(dataSnapshot);

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



    public void fetchupdates(DataSnapshot dataSnapshot)
    {

        noticias.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Noticias n = new Noticias();
            n.setTitulo(ds.getValue(Noticias.class).getTitulo());
            n.setImagemurl(ds.getValue(Noticias.class).getImagemurl());
            n.setSubtitulo(ds.getValue(Noticias.class).getSubtitulo());

            noticias.add(n);
        }

        if (noticias.size()>0);
        {
            adapter = new Adapter(c,noticias);
            lv.setAdapter(adapter);
        }


    }


}
