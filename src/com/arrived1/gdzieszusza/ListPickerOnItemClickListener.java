package com.arrived1.gdzieszusza;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class ListPickerOnItemClickListener implements OnItemClickListener {
	private Context context;
	private double latitude = 0;
	private double longitude = 0;

	
	public ListPickerOnItemClickListener(Context context_, double latitude_, double longitude_) {
		this.context = context_;
		this.latitude = latitude_;
		this.longitude = longitude_;
	}
	
	public ListPickerOnItemClickListener(Context context_) {
		this.context = context_;	
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long rowId) {

		Police item = (Police)adapter.getItemAtPosition(position);
		
		NetworkGeolocalizationStreet networkGeoLocalCity = new NetworkGeolocalizationStreet(context, item.street);
		latitude = networkGeoLocalCity.getLatitudeE6();
		longitude = networkGeoLocalCity.getLongitudeE6();
		
		Intent myIntentAboutPtogramMapka = new Intent(context, Map.class);
		
		myIntentAboutPtogramMapka.putExtra("GEO_POINT_LATITUDE", latitude);
		myIntentAboutPtogramMapka.putExtra("GEO_POINT_LONGITUDE", longitude);
		context.startActivity(myIntentAboutPtogramMapka);
	}

}
