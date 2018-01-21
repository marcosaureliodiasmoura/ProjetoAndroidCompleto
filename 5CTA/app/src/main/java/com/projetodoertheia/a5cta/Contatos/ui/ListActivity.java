package com.projetodoertheia.a5cta.Contatos.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.projetodoertheia.a5cta.R;
import com.projetodoertheia.a5cta.Contatos.adapter.ListAdapter;
import com.projetodoertheia.a5cta.Contatos.model.ListData;
import com.projetodoertheia.a5cta.Contatos.model.ListItem;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements ListAdapter.ItemClickCallback, ActivityCompat.OnRequestPermissionsResultCallback {

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";
    private static final String EXTRA_TELEFONE = "EXTRA_TELEFONE";

    private LayoutInflater inflater;

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 2;

    ActionBarDrawerToggle toggle;

    private RecyclerView recyclerView;
    private ListAdapter adapter;
    private ArrayList listData;
    private ImageView img;
    CardView cardView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);





        Toolbar toolbarContatos = (Toolbar) findViewById(R.id.toolbarContatos);
        setSupportActionBar(toolbarContatos);
        toolbarContatos.setTitle("Contatos do 5° CTA");
        toolbarContatos.setSubtitle("Suporte Telemático");
        toolbarContatos.setNavigationOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {

                                                     finish();
                                                 }
                                             });



//        getSupportActionBar().setTitle(R.string.ContatosCTA);
//        getSupportActionBar().setSubtitle(R.string.ligacoes);


        listData = (ArrayList) ListData.getListData();

//        img = (ImageView)findViewById(R.id.imageView3);

        recyclerView = (RecyclerView) findViewById(R.id.Recycler_Lista);
//        YoYo.with(Techniques.FadeInDown).duration(700).playOn(findViewById(R.id.imageView3));


        //Layoyt Manager: GridLayoutManager or StaggeredGridLayoutManager

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ListAdapter(listData, this);
//        adapter = new ListAdapter(ListData.getListData(),this);
        recyclerView.setAdapter(adapter);
        adapter.setItemClickCallback(this);





    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                // Se o usuário não deu permissão o array está vazio.
                if (grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED){

                    // permissão concedida, executo minha atividade


                }else{

                    // permissão negada, mostra uma mensagem pro usuário informando que tal funcionalidade não poderá ser executada
                }
                return;
            }
        }
    }


    @Override
    public void onItemClick(int p) {

        ListItem item = (ListItem) listData.get(p);

        Intent i = new Intent(this, Detail_Activity.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_QUOTE, item.getTitulo());
        extras.putString(EXTRA_ATTR, item.getSubtitulo());

        i.putExtra(BUNDLE_EXTRAS, extras);
        startActivity(i);

    }

//    @SuppressWarnings({"MissingPermission"})
//    private boolean checkCallPermission() {
//        String permission = "android.permission.READ_EXTERNAL_STORAGE";
//        int res = getApplicationContext().checkCallingOrSelfPermission(permission);
//        return (res == PackageManager.PERMISSION_GRANTED);
//    }


    @Override
    public void onItemSecundaryClick(int p) {

        //realizar chamada através de uma list view
        //list view action dial

        if(VERSION.SDK_INT == 23)

        {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(ListActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE);

            }

            ListItem item = (ListItem) listData.get(p);
            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + item.getTelefone()));
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(i);



        }




//        }
        }

    //Menu do toolbar direito
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    }
//}
