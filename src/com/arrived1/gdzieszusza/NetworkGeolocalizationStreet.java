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
		
		Geocoder geoCoder = new Geocoder(context, Locale.getDefault());
		
	    try {
			addresses = geoCoder.getFromLocationName(street_, 5);
			System.out.println("DUPA GeolocalizatorStreet Street: " + street_ + " lat: " + addresses.get(0).getLatitude() + " long: " + addresses.get(0).getLongitude());
		} 
	    catch (IOException e) {
	    	System.out.println("DUPA wyjatek NetworkGeolocalizationStreet");
			e.printStackTrace();
		}
	}
	
	public double getLatitudeE6() {
		if(addresses.size() > 0) {
			return addresses.get(0).getLatitude();
		}
		System.out.println("DUPA nie znalazlem koordow daje polske");
		return 51;
	}
	
	public double getLongitudeE6() {
		if(addresses.size() > 0) {
			return addresses.get(0).getLongitude();
		}
		System.out.println("DUPA nie znalazlem koordow daje polske");
		return 17;
	}
	
	
	
	
	
}
