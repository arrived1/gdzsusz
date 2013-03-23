package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;

//System.out.println("DUPA ");


public class MainActivity extends Activity{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main); 

        String cityName = check();
        System.out.println("DUPA city name: " + cityName);
        
        if(cityName.equals("Nieznane misto")) {
        	 System.out.println("DUPA city: " + "Nieznane misto");
        }
        else { 
        	Intent myIntent = new Intent(this, RunnerActivity.class);
        	myIntent.putExtra("CITY_NAME", cityName);
        	startActivity(myIntent);
        }
        
        finish();
    }
    
    private String check() {
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
 		    	NetworkGeolocalizationCity networkGeolocalization = null;;
 		    	for(int i = 0; i < 10; i++) {
 		    		networkGeolocalization = new NetworkGeolocalizationCity(this, this);
 		    		System.out.println("DUPA geolokalizator zwrocil: " + networkGeolocalization.getCurrentCityName());
 		    		
 		    		if(!networkGeolocalization.getCurrentCityName().equals("Nieznane misto"))
 		    			return networkGeolocalization.getCurrentCityName();
 		    	}
 		    	return networkGeolocalization.getCurrentCityName();
 		    }
 		    else {
 		    	String title = "Błąd połaczcenia z internetem";
 		    	String msg = "Aplikacja wymaga połącznia z internetem w celu pobrania lub uaktualnienia danych. " +
 		    			     "Włącz internet i uruchom aplikację ponownie!";
 		    	
 		    	DialogBuilder dialog = new DialogBuilder(this);
 		    	dialog.buildRestartDialog(title, msg);
 		    }
     	}
     	return "Nieznane misto";
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