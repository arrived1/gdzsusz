package com.arrived1.gdzieszusza;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class OnItemClickListenerStreet implements OnItemClickListener {
	private String city = "";
	private Context context;
	private double latitude = 0;
	private double longitude = 0;
	
	public OnItemClickListenerStreet(Context context_, String city_) {
		this.context = context_;
		this.city = city_;
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long rowId) {

		Police item = (Police)adapter.getItemAtPosition(position);
		
		String streetAndCity = item.street + " " + city;
		NetworkGeolocalizationStreet networkGeoLocalCity = new NetworkGeolocalizationStreet(context, streetAndCity);
		latitude = networkGeoLocalCity.getLatitudeE6();
		longitude = networkGeoLocalCity.getLongitudeE6();
		
		Intent myIntentAboutPtogramMapka = new Intent(context, ActivityMap.class);
		
		myIntentAboutPtogramMapka.putExtra("GEO_POINT_LATITUDE", latitude);
		myIntentAboutPtogramMapka.putExtra("GEO_POINT_LONGITUDE", longitude);
		context.startActivity(myIntentAboutPtogramMapka);
	}

}
