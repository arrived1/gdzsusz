package com.arrived1.gdzieszusza;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;

public class NetworkGeolocalizationCity {
	private String cityName = "Nieznane misto";
	
	public NetworkGeolocalizationCity(Context context, Activity activity) {
		LocationManager locMgr = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
		Location loc = locMgr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		
		Geocoder gcd = new Geocoder(context, Locale.getDefault());
		List<Address> addresses = null;
		
		try {
			addresses = gcd.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
			cityName = addresses.get(0).getLocality();
		} 
		catch (IOException e) {
			cityName = "Nieznane misto";
			e.printStackTrace();
		}
	}
	
	public String getCurrentCityName() {
			return cityName;
	}

}