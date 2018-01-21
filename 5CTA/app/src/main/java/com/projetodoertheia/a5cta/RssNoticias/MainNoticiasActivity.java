package com.projetodoertheia.a5cta.RssNoticias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.projetodoertheia.a5cta.R;

public class MainNoticiasActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_noticias);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar01);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.toolbar_titulo);
        getSupportActionBar().setSubtitle(R.string.toolbar_subtitulo);
        getSupportActionBar().setIcon(R.drawable.ic_cast_dark);


//        recyclerView = (RecyclerView) findViewById(R.id.Recycler_Noticias);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ReadRss readRss=new ReadRss(this, recyclerView);
        readRss.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_1:
                Toast.makeText(MainNoticiasActivity.this, "Opcao de testes clicada", Toast.LENGTH_SHORT).show();
                break;



            case R.id.menu_2:
                Toast.makeText(MainNoticiasActivity.this, "Opcao de testes clicada atualizar view", Toast.LENGTH_SHORT).show();
                break;
        }





        return super.onOptionsItemSelected(item);
    }
}
