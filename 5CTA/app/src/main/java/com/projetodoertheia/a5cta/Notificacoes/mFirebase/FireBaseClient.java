package com.projetodoertheia.a5cta.Notificacoes.mFirebase;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.projetodoertheia.a5cta.NoticiasFirebase.mRecycler.MyAdapter;
import com.projetodoertheia.a5cta.Notificacoes.mData.Notificacao;
import com.projetodoertheia.a5cta.Notificacoes.mRecycler.NotificacaoAdapter;

import java.util.ArrayList;

/**
 * Created by Ertheia on 03/11/2017.
 */

public class FireBaseClient extends AsyncTask<Void, Void, Object>{

    Context c;
    String DB_URL;
    RecyclerView rv;

    ProgressDialog pd;

    Firebase fire;
    ArrayList<Notificacao> notificacoes = new ArrayList<>();
   NotificacaoAdapter notificacaodapter;


    public FireBaseClient(Context c, String DB_URL, RecyclerView rv) {
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
        notificacoes.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            //Pra adicionar novos valores da Noticia
            Notificacao n = new Notificacao();
            n.setTitulo(ds.getValue(Notificacao.class).getTitulo());
            n.setSubtitulo(ds.getValue(Notificacao.class).getSubtitulo());
            n.setImagemurl(ds.getValue(Notificacao.class).getImagemurl());

            notificacoes.add(n);

        }
        if (notificacoes.size()>0)
        {

            notificacaodapter = new NotificacaoAdapter(c, notificacoes);
            rv.setAdapter(notificacaodapter);


        }else {

            Toast.makeText(c, "NO DATABASE", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected Object doInBackground(Void... params) {
        return null;
    }


}
