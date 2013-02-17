package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: implement city getter
		NetworkGeolocalization networkGeolocalization = new NetworkGeolocalization(this);
        
        //Instantiating the adapter
        GiloAdapter mAdapter = new GiloAdapter(this, networkGeolocalization.getCurrentCityName());

        //instantiate the Views
        ViewPager mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        TabPageIndicator mIndicator = (TabPageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }
}