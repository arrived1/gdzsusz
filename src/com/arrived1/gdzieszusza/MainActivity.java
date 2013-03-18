package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
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
        GiloAdapter mAdapter =  new GiloAdapter(this);
        
        boolean hasLocalization = wirlessNetworkLocalization();
    	if(!hasLocalization) {
    		String title = "Błąd określenia lokalizacji";
        	String msg = "Aplikacja wymaga Uruchomionej usługi określania lokalizacji na podstawie sieci WiFi lub telefonii komórkowej.\n" +
        				 "Włącz usługi lokalizacji:\n \tUstawienia ->\n \tUsługi Lokalizacji ->\n \tUżyj Sieci Bezprzewodowych";
        	
        	DialogBuilder dialog = new DialogBuilder(this);
        	dialog.buildRestartDialog(title, msg);
    	}
    	else {
		    boolean hasInternet = networkAcces();
		    if(hasInternet) {
		    	NetworkGeolocalizationCity networkGeolocalization = new NetworkGeolocalizationCity(this, this);
		    	mAdapter = new GiloAdapter(this, this, networkGeolocalization.getCurrentCityName());
		    }
		    else {
		    	String title = "Błąd połaczcenia z internetem";
		    	String msg = "Aplikacja wymaga połącznia z internetem w celu pobrania lub uaktualnienia danych. " +
		    			     "Włącz internet i uruchom aplikację ponownie!";
		    	
		    	DialogBuilder dialog = new DialogBuilder(this);
		    	dialog.buildRestartDialog(title, msg);
		    }
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
	        	Intent myIntentCityList = new Intent(MainActivity.this, CityListActivity.class);
	            startActivity(myIntentCityList);
	            return true;
	        case R.id.about_program:
	        	Intent myIntentAboutPtogram = new Intent(MainActivity.this, AboutProgram.class);
	            startActivity(myIntentAboutPtogram);
	            return true;
	        case R.id.menu_item_share:
	        	Intent sendIntent = new Intent();
	        	sendIntent.setAction(Intent.ACTION_SEND);
	        	sendIntent.setType("text/plain");
	        	sendIntent.putExtra(Intent.EXTRA_TEXT, "Gdzie Suszą: unikaj fotoradarów i Straży Miejskiej! Sprawdź aplikację!"); //TODO: add Fecbook itp!!!
	        	sendIntent.putExtra("image_url", R.drawable.ic_launcher);
	        	startActivity(Intent.createChooser(sendIntent, "Podziel się aplikacją!"));
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
    
	private boolean wirlessNetworkLocalization() {
		ContentResolver cr = this.getContentResolver();
		return Settings.Secure.isLocationProviderEnabled(cr, LocationManager.NETWORK_PROVIDER);
	}
	
	private boolean networkAcces() {
		 InternetAcces internetAcces = new InternetAcces(this);
		 return internetAcces.isOnline();
	}
}