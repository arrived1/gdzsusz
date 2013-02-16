package com.arrived1.gdzieszusza;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;

public class NetworkGeolocalization {
	private String cityName = "";
	
	public NetworkGeolocalization(Context context) {
		LocationManager locMgr = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
		Location loc = locMgr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		
		Geocoder gcd = new Geocoder(context, Locale.getDefault());
		List<Address> addresses = null;
		
		try {
			addresses = gcd.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		cityName = addresses.get(0).getLocality();
	}
	
	public String getCurrentCityName() {
		return cityName;
	}
	
}
