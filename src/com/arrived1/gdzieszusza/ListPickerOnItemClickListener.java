package com.arrived1.gdzieszusza;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

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
		
//		TextView textView1 = (TextView)view.findViewById(R.id.txt);
//		
//		String product = (String)textView1.getText();
//		System.out.println("DUPA " + product);
		
		Police item = (Police)adapter.getItemAtPosition(position);
		String s = item.street;
		
		NetworkGeolocalizationStreet networkGeoLocalCity = new NetworkGeolocalizationStreet(context, s);
		latitude = networkGeoLocalCity.getLatitudeE6();
		longitude = networkGeoLocalCity.getLongitudeE6();
		
		Intent myIntentAboutPtogramMapka = new Intent(context, Map.class);
		System.out.println("DUPA Map LIST PICKER: " +  latitude + " " + longitude + " street: " + s);
		
		myIntentAboutPtogramMapka.putExtra("GEO_POINT_LATITUDE", latitude);
		myIntentAboutPtogramMapka.putExtra("GEO_POINT_LONGITUDE", longitude);
		context.startActivity(myIntentAboutPtogramMapka);
	}

}
