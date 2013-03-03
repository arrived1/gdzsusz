package com.arrived1.gdzieszusza;

import com.google.android.maps.GeoPoint;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class ListPickerOnItemClickListener implements OnItemClickListener {
	private Context context;
	private GeoPoint geoPoint;
	
	public ListPickerOnItemClickListener(Context context_, GeoPoint gp_) {
		this.context = context_;
		this.geoPoint = gp_;
	}
	
	public ListPickerOnItemClickListener(Context context_) {
		this.context = context_;
		this.geoPoint = null;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
		
//		TextView textView1 = (TextView)view.findViewById(R.id.txt);
//		
//		String product = (String)textView1.getText();
//		System.out.println("DUPA " + product);
		
		Intent myIntentAboutPtogramMapka = new Intent(context, Map.class);
		System.out.println("DUPA Map LIST PICKER: " +  geoPoint.getLatitudeE6() + " " + geoPoint.getLongitudeE6());
		
		double latitude = geoPoint.getLatitudeE6();
		double longtitude = geoPoint.getLongitudeE6();
		
		myIntentAboutPtogramMapka.putExtra("GEO_POINT_LATITUDE", latitude);
		myIntentAboutPtogramMapka.putExtra("GEO_POINT_LONGITUDE", longtitude);
		myIntentAboutPtogramMapka.putExtra("D", -1);
		context.startActivity(myIntentAboutPtogramMapka);
	}

}
