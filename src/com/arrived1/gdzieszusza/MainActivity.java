package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.viewpagerindicator.TabPageIndicator;

//System.out.println("DUPA ");


public class MainActivity extends Activity{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        
        InternetAcces internetAcces = new InternetAcces(this);
        boolean hasInternet = internetAcces.isOnline();
        GiloAdapter mAdapter = null;

        if(hasInternet) {
        	NetworkGeolocalization networkGeolocalization = new NetworkGeolocalization(this);
        	mAdapter = new GiloAdapter(this, this, networkGeolocalization.getCurrentCityName());
        }
        else {
        	String title = "Błąd połaczcenia z internetem";
        	String msg = "Aplikacja wymaga połącznia z internetem w celu pobrania lub uaktualnienia danych. " +
        			     "Włącz internet i uruchom aplikację ponownie!";
        	
        	WarningDialog dialog = new WarningDialog(this);
        	dialog.buildRestartDialog(title, msg);
        	
        	mAdapter = new GiloAdapter(this);
        }

        //instantiate the Views
        ViewPager mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        TabPageIndicator mIndicator = (TabPageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.activity_main, menu);
	    return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.city_list:
	        	Intent myIntentCityList = new Intent(MainActivity.this, CityList.class);
	            startActivity(myIntentCityList);
	            return true;
	        case R.id.about_program:
	        	Intent myIntentAboutPtogram = new Intent(MainActivity.this, AboutProgram.class);
	            startActivity(myIntentAboutPtogram);
	            return true;
//	        case R.id.mapka:
//	        	Intent myIntentAboutPtogramMapka = new Intent(MainActivity.this, Map.class);
//	            startActivity(myIntentAboutPtogramMapka);
//	            return true;
	        case R.id.menu_item_share:
	        	Intent sendIntent = new Intent();
	        	sendIntent.setAction(Intent.ACTION_SEND);
	        	sendIntent.setType("text/plain");
	        	sendIntent.putExtra(Intent.EXTRA_TEXT, "Gdzie Suszą: unikaj fotoradarów i Straży Miejskiej! Sprawdź aplikację!"); //TODO: add Fecbook itp!!!
	        	startActivity(Intent.createChooser(sendIntent, "Podziel się aplikacją!"));
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}