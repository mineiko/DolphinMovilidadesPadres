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



        return new FragmentMapa();

    }

    @Override
    public int getCount() {
        return 4;
    }

}
