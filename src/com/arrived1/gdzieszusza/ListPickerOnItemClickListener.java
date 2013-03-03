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

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
		
//		TextView textView1 = (TextView)view.findViewById(R.id.txt);
//		
//		String product = (String)textView1.getText();
//		System.out.println("DUPA " + product);
		
		Intent myIntentAboutPtogramMapka = new Intent(context, Map.class);
		System.out.println("DUPA Map LIST PICKER: " +  latitude + " " + longitude);
		
		myIntentAboutPtogramMapka.putExtra("GEO_POINT_LATITUDE", latitude);
		myIntentAboutPtogramMapka.putExtra("GEO_POINT_LONGITUDE", longitude);
		context.startActivity(myIntentAboutPtogramMapka);
	}

}
