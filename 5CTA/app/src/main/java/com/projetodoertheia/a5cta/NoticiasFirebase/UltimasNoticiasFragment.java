package com.projetodoertheia.a5cta.NoticiasFirebase;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projetodoertheia.a5cta.NoticiasFirebase.mFirebase.FirebaseClient;
import com.projetodoertheia.a5cta.R;


public class UltimasNoticiasFragment extends android.support.v4.app.Fragment {


    final static String DB_URL = "https://cta-4f03b.firebaseio.com/";

    RecyclerView rv;


    FirebaseClient firebaseClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {



        View rootview = inflater.inflate(R.layout.fragment_ultimas_noticias, container, false);
            RecyclerView  rv = (RecyclerView)rootview.findViewById(R.id.RecyclerNoticias);
                rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        if(container == null)
        {
            return null;
        }


        //        //Consultar dados do bancos
        firebaseClient = new FirebaseClient(UltimasNoticiasFragment.this.getActivity(), DB_URL, rv);
//        firebaseClient = new FirebaseClient(this, DB_URL, rv);
        firebaseClient.refreshData();

        return rootview;



    }

}
