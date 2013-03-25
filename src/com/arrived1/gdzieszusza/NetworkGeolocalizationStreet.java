package com.arrived1.gdzieszusza;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

public class NetworkGeolocalizationStreet {
	private Context context;
	List<Address> addresses;
	
	public NetworkGeolocalizationStreet(Context context_, String street_) {
		this.context = context_;
		Geocoder geoCoder = new Geocoder(context, Locale.getDefault());
		
	    try {
			addresses = geoCoder.getFromLocationName(street_, 5);
		} 
	    catch (IOException e) {
	    	addresses.add(new Address(new Locale("en")));
			e.printStackTrace();
		}
	}
	
	//WARNING: magic value 51, 17 Wrolcaw coords?
	public double getLatitudeE6() {
		if(addresses.size() > 0) {
			return addresses.get(0).getLatitude();
		}
		return 51;
	}
	
	public double getLongitudeE6() {
		if(addresses.size() > 0) {
			return addresses.get(0).getLongitude();
		}
		return 17;
	}
}
