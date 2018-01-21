package com.projetodoertheia.a5cta.Notificacoes;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projetodoertheia.a5cta.Notificacoes.mFirebase.FireBaseClient;
import com.projetodoertheia.a5cta.R;

/**
 * Created by Ertheia on 03/11/2017.
 */

public class NotificacoesFragment extends android.support.v4.app.Fragment {

    final static String DB_URL = "https://cta-4f03b.firebaseio.com";


    RecyclerView rv;


    FireBaseClient firebaseClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {



        View rootview = inflater.inflate(R.layout.fragment_notificacao, container, false);
        RecyclerView  rv = (RecyclerView)rootview.findViewById(R.id.RecyclerNotificacao);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        if(container == null)
        {
            return null;
        }


        //        //Consultar dados do bancos
        firebaseClient = new FireBaseClient(NotificacoesFragment.this.getActivity(), DB_URL, rv);
//        firebaseClient = new FirebaseClient(this, DB_URL, rv);
        firebaseClient.refreshData();

        return rootview;



    }
}
