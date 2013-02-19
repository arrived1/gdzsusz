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
        
        checkoInternetConnection();
        
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
    
    private void checkoInternetConnection() {
    	InternetAcces internetAcces = new InternetAcces(this);
        boolean hasInternet = internetAcces.isOnline();
        
        if(!hasInternet) {
        	WarningDialog dialog = new WarningDialog(this);
        	dialog.buildRestartDialog("Błąd połaczcenia z internetem", 
        			"Aplikacja wymaga połącznia z internetem w celu pobrania lub uaktualnienia danych. Właćż internet i uruchom aplikację ponownie!");
        }
        
    }
}