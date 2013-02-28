package com.arrived1.gdzieszusza;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.google.android.maps.GeoPoint;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

public class NetworkGeolocalizationStreet {
	private Context context;
	List<Address> addresses;;
	
	public NetworkGeolocalizationStreet(Context context_, String street_) {
		this.context = context_;
		
//		Geocoder geoCoder = new Geocoder(context, Locale.getDefault());
//		
//	    try {
//			addresses = geoCoder.getFromLocationName(street_, 5);
//			System.out.println("DUPA wyjatek");
//		} 
//	    catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	public GeoPoint getGeoPoint() {
		GeoPoint gp = null;
//		if(addresses.size() > 0) {
//			System.out.println("DUPA znalazlem koordy");
//			gp = new GeoPoint((int)(addresses.get(0).getLatitude() * 1E6), (int)(addresses.get(0).getLongitude() * 1E6));
//		}
//		else {
			System.out.println("DUPA nie znalazlem koordow daje polske");
			gp = new GeoPoint((int)(52 * 1E6), (int)(20 * 1E6));
//		}
		return gp;
	}
	
	
	
	
	
}
