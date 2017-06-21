package com.tyddolphin.apppadres;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



class SeccionesPagerAdapter extends FragmentPagerAdapter {

    SeccionesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)return new FragmentMapa();
        if(position==1)return new FragmentHijos();
        if(position==2)return new FragmentMovilidad();
        if(position==3)return new FragmentUsuario();
        if(position==4)return new FragmentConfiguracion();

        return new FragmentMapa();

    }

    @Override
    public int getCount() {
        return 5;
    }

}
