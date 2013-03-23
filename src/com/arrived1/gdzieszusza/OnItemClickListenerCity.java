package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class OnItemClickListenerCity implements OnItemClickListener {
	private Context context;

	public OnItemClickListenerCity(Context context_) {
		this.context = context_;
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long rowId) {

		String city = (String)adapter.getItemAtPosition(position);
		
		Intent myIntent = new Intent(context, ActivityRunner.class);
    	myIntent.putExtra("CITY_NAME", city);
    	context.startActivity(myIntent);
    	
    	//Hack? Not sure about it, but it works^^
    	((Activity) context).finish();
	}
}
