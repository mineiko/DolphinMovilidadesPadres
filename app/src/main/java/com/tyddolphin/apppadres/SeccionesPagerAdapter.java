package com.tyddolphin.apppadres;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



class SeccionesPagerAdapter extends FragmentPagerAdapter {

    SeccionesPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    private Fragment fragments[] = {
        new FragmentMapa(),
        new FragmentHijos(),
        new FragmentMovilidad(),
        new FragmentUsuario(),
        new FragmentConfiguracion(),
    };

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return 5;
    }

}
