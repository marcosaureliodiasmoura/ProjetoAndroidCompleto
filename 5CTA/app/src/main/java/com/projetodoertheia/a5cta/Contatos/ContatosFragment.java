package com.projetodoertheia.a5cta.Contatos;



import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;

import com.projetodoertheia.a5cta.Contatos.adapter.ListAdapter;
import com.projetodoertheia.a5cta.Contatos.model.ListData;
import com.projetodoertheia.a5cta.Contatos.model.ListItem;
import com.projetodoertheia.a5cta.Contatos.ui.Detail_Activity;
import com.projetodoertheia.a5cta.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ContatosFragment extends Fragment {

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";
    private static final String EXTRA_TELEFONE = "EXTRA_TELEFONE";

    private LayoutInflater inflater;

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;


    private RecyclerView rv;
    private ListAdapter adapter;
    private ArrayList listData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_contatos, container, false);

        listData = (ArrayList) ListData.getListData();

        RecyclerView rv = (RecyclerView) rootview.findViewById(R.id.Recycler_Lista);


        rv.setLayoutManager(new LinearLayoutManager(ContatosFragment.this.getActivity()));

        adapter = new ListAdapter(listData, this.getActivity());
        rv.setAdapter(adapter);
//        adapter.setItemClickCallback(this.getActivity());
        Toolbar toolbar = (Toolbar)rootview.findViewById(R.id.toolbarContatos);


        toolbar.setNavigationOnClickListener(new View.OnClickListener(){


                                                 @Override
                                                 public void onClick(View v) {
                                                     onBackPressed();
                                                 }

                                                 private void onBackPressed() {
                                                 }
                                             });


//        if (container == null) {
//            return null;
//        }
//
//
//        adapter = new ListAdapter(listData, ContatosFragment.this.getActivity());
//        rv.setAdapter(adapter);
//        adapter.setItemClickCallback((ListAdapter.ItemClickCallback) ContatosFragment.this.getActivity());


//        //        //Consultar dados do bancos
//        firebaseClient = new FirebaseClient(UltimasNoticiasFragment.this.getActivity(), DB_URL, rv);
////        firebaseClient = new FirebaseClient(this, DB_URL, rv);
//        firebaseClient.refreshData();

        return rootview;


    }




    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                // Se o usuário não deu permissão o array está vazio.
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permissão concedida, executo minha atividade


                } else {

                    // permissão negada, mostra uma mensagem pro usuário informando que tal funcionalidade não poderá ser executada
                }
                return;
            }
        }
    }


//    @Override
//    public void onItemClick(int p) {
//
//        ListItem item = (ListItem) listData.get(p);
//
//        Intent i = new Intent(this, Detail_Activity.class);
//
//        Bundle extras = new Bundle();
//        extras.putString(EXTRA_QUOTE, item.getTitulo());
//        extras.putString(EXTRA_ATTR, item.getSubtitulo());
//
//        i.putExtra(BUNDLE_EXTRAS, extras);
//        startActivity(i);
//
//    }

//    @Override
    public void onItemSecundaryClick(int p) {

        //realizar chamada através de uma list view
        //list view action dial

        if (Build.VERSION.SDK_INT == 23)

        {
            if (ActivityCompat.checkSelfPermission(ContatosFragment.this.getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(ContatosFragment.this.getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE);

            }

            ListItem item = (ListItem) listData.get(p);
            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + item.getTelefone()));
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(i);


        }

    }

}
