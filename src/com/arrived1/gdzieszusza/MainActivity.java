package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.viewpagerindicator.TabPageIndicator;

//System.out.println("DUPA ");


public class MainActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        
        checkoInternetConnection();

		NetworkGeolocalization networkGeolocalization = new NetworkGeolocalization(this);
        
        //Instantiating the adapter
        GiloAdapter mAdapter = new GiloAdapter(this, this, networkGeolocalization.getCurrentCityName());

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
        	String title = "Błąd połaczcenia z internetem";
        	String msg = "Aplikacja wymaga połącznia z internetem w celu pobrania lub uaktualnienia danych. " +
        			     "Włącz internet i uruchom aplikację ponownie!";
        	
        	WarningDialog dialog = new WarningDialog(this);
        	dialog.buildRestartDialog(title, msg);
        }
    }
}