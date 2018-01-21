package com.projetodoertheia.a5cta.ViewPagerAdapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.projetodoertheia.a5cta.Cursos.EadFragment;
import com.projetodoertheia.a5cta.NoticiasFirebase.UltimasNoticiasFragment;
import com.projetodoertheia.a5cta.Notificacoes.NotificacoesFragment;

/**
 * Created by Ertheia on 22/09/2017.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabTitles;

    //Construtor Obrigatorio
    public MyFragmentPagerAdapter(FragmentManager fm, String[] mTabTitles) {
        super(fm);
        this.mTabTitles = mTabTitles;
    }

    @Override
    public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return new UltimasNoticiasFragment();

                case 1:
                    return new EadFragment();

                case 2:
                    return new NotificacoesFragment();

                default:
                    return null;
            }

    }

    @Override
    public int getCount() {
        return this.mTabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       return this.mTabTitles[position];
    }



}
