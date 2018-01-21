package com.projetodoertheia.a5cta.NoticiasFirebase;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.projetodoertheia.a5cta.Outros.AbrirChamadoFragment;
import com.projetodoertheia.a5cta.ViewPagerAdapters.MyFragmentPagerAdapter;
import com.projetodoertheia.a5cta.R;

public class NoticiasActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    ActionBarDrawerToggle toggle;

    DrawerLayout mdrawerLayout;

    private static final long DRAWER_CLOSE_DELAY_MS = 350;
    private static final String NAV_ITEM_ID = "navItemId";

    private final Handler mDrawerActionHandler = new Handler();
    private int mNavItemid;


    private final UltimasNoticiasFragmentNav ultimasNoticiasFragment = new UltimasNoticiasFragmentNav();
    private final AbrirChamadoFragment abrirChamadoFragment = new AbrirChamadoFragment();



//    private final UniformesFragment uniformesFragment = new UniformesFragment();
//    private final ContatosFragment contatosFragment = new ContatosFragment();
//    private final CursosFragment cursosfragment = new CursosFragment();
//    private final Hinos_CancoesFragment hinos_cancoesFragment = new Hinos_CancoesFragment();


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);


//        FirebaseMessaging.getInstance().subscribeToTopic("news");


        //Carrega e salva o estado selecionado para navigationview, abrindo a primeia tela escrita aqui
        if(null == savedInstanceState)
        {
            mNavItemid = R.id.nav_menu1;
        }else {
            mNavItemid = savedInstanceState.getInt(NAV_ITEM_ID);
        }


        mTabLayout = (TabLayout)findViewById(R.id.tab_layout);
        mViewPager = (ViewPager)findViewById(R.id.view_pager);

        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),getResources().getStringArray(R.array.title_tabs)));

        mTabLayout.setupWithViewPager(mViewPager);

        Toolbar toolbarNoticias = (Toolbar) findViewById(R.id.toolbarNoticias);
        setSupportActionBar(toolbarNoticias);

        getSupportActionBar().setTitle("Centro de Informação");
        getSupportActionBar().setSubtitle("5° CTA");



        //Lista de eventos do navigation view
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigationViewNoticias);
        navigationView.setNavigationItemSelectedListener(this);

        //Seleciona o item do menu
        navigationView.getMenu().findItem(mNavItemid).setCheckable(true);



         mdrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        toggle = new ActionBarDrawerToggle(this, mdrawerLayout, R.string.open, R.string.close);
        mdrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigate(mNavItemid);


    }

//Ao clicar no item do Navigation  View, irá abrir um fragment
    private void navigate(final int itemId) {
        switch (itemId) {
            case R.id.nav_menu1:
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, ultimasNoticiasFragment)
                    .commit();

//                Intent it0 = new Intent(this, com.projetodoertheia.a5cta.Contatos.ui.ListActivity.class );
//                startActivity(it0);

//                getSupportActionBar().setTitle(R.string.tituloNoticias);
//                getSupportActionBar().setSubtitle(R.string.subtituloNoticias);
            break;
//
            case R.id.nav_menu2:
//                Intent it1 = new Intent(this, com.projetodoertheia.a5cta.Cursos.CursosActivity.class );
//                startActivity(it1);
//                break;


                Intent it1 = new Intent(this, com.projetodoertheia.a5cta.Cursos.CursosActivity.class );
                startActivity(it1);

//                fragment usado
//                getFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.view_pager, cursosfragment)
//                        .commit();


//                getSupportActionBar().setTitle(R.string.titulocursos);
//                getSupportActionBar().setSubtitle(R.string.cursos);
                break;

            case R.id.nav_menu3:
//                getFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.content, contatosFragment)
//                        .commit();
//                break;
                Intent it3 = new Intent(this, com.projetodoertheia.a5cta.Contatos.ui.ListActivity.class );
                startActivity(it3);
                break;

            case R.id.nav_menu4:

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, abrirChamadoFragment)
                        .commit();
//                getSupportActionBar().setTitle("Uniformes");
//                getSupportActionBar().setSubtitle("Atualização 2016");
                break;


//            case R.id.nav_menu5:
//
//                getFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.content, hinos_cancoesFragment)
//                        .commit();
//                getSupportActionBar().setTitle("Hinos e Canções");
//                getSupportActionBar().setSubtitle("Conhecimento é Poder (Thomas Hobbes) ");
//                break;

            case R.id.nav_menu6:

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, abrirChamadoFragment)
                        .commit();
//                getSupportActionBar().setTitle(R.string.tituloChamada);
//                getSupportActionBar().setSubtitle(R.string.abrirChamado);
                break;

//            case R.id.nav_menu8:
////                getFragmentManager()
////                        .beginTransaction()
////                        .replace(R.id.content, contatosFragment)
////                        .commit();
////                break;
//                Intent it8 = new Intent(this, AplicativosActivity.class );
//                startActivity(it8);
//                break;



            default:
                // ignore
                break;
        }
    }


    //Menu do toolbar direito
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    //Menu do toolbar direito (SELECIONANDO ITEM)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (toggle.onOptionsItemSelected(item))

            return true;
            return super.onOptionsItemSelected(item);


//        switch (item.getItemId()) {
//            case R.id.menu_1:
//                Toast.makeText(NoticiasActivity.this, "Abre uma lista de Mensagens de Notificações", Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.menu_2:
//                Intent it2 = new Intent(this, NoticiasActivity.class);
//                startActivity(it2);
//                break;
//
//        }
//        return super.onOptionsItemSelected(item);


    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem menuitem) {

        menuitem.setCheckable(true);
        mNavItemid = menuitem.getItemId();

        mdrawerLayout.closeDrawer(GravityCompat.START);
        mDrawerActionHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigate(menuitem.getItemId());
            }
            }, DRAWER_CLOSE_DELAY_MS);
               return true;
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }


    @Override
    public void onBackPressed() {
        if (mdrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mdrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NAV_ITEM_ID, mNavItemid);
    }



}


