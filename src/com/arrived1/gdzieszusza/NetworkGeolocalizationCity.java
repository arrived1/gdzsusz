package com.arrived1.gdzieszusza;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

public class NetworkGeolocalizationCity {
	private final String unknownCity = "Nieznane misto";
	private String cityName = unknownCity;
	
	public NetworkGeolocalizationCity(Context context, Activity activity) {
		
		List<Address> addresses = null;
		
		try {
			LocationListener listeneer = new LocationListenerMy();
			LocationManager locMgr = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
			locMgr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 20000, 1, listeneer);
			
			Location loc = locMgr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			Geocoder gcd = new Geocoder(context, Locale.getDefault());
			
			if(gcd == null) {
				cityName = unknownCity;
				return;
			}

			addresses = gcd.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
			cityName = addresses.get(0).getLocality();
		} 
		catch (IOException e) {
			cityName = unknownCity;
			e.printStackTrace();
		}
	}
	
	public String getCurrentCityName() {
		if(cityName == null)
			return unknownCity;
		return cityName;
	}
}
