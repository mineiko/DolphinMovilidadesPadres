package com.tyddolphin.apppadres;

import android.support.annotation.DrawableRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SeccionesPagerAdapter mSeccionesPagerAdapter;
    private ViewPager mViewPager;
    TabLayout Tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tabs = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mSeccionesPagerAdapter = new SeccionesPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSeccionesPagerAdapter);
        Tabs.setupWithViewPager(mViewPager);


        setIconoOnTab(0,R.drawable.ic_place_white_24dp);
    }

    private void setIconoOnTab(int tabID, @DrawableRes int drawable){
        TabLayout.Tab tab = Tabs.getTabAt(tabID);
        if (tab != null){
            tab.setIcon(drawable);
        }
    }

}
