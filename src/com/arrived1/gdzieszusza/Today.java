package com.arrived1.gdzieszusza;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;

public class Today extends Tab{
	private City city;

	public Today(LayoutInflater inflater_, int layout, City city_) {
		super(inflater_, layout);
		this.city = city_;
		
		TextView cityText = (TextView)view.findViewById(R.id.cityString);

		LocationManager locMgr = (LocationManager)view.getContext().getSystemService(Context.LOCATION_SERVICE);
		Location loc = locMgr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		
		Geocoder gcd = new Geocoder(view.getContext(), Locale.getDefault());
		List<Address> addresses = null;
		
		try {
			addresses = gcd.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (addresses.size() > 0) 
		    System.out.println(addresses.get(0).getLocality());
		
		cityText.setText(" " + addresses.get(0).getLocality());
//		cityText.setText(" " + city.getName());
		
		TodayListAdapter adapter = new TodayListAdapter(view.getContext(), city.getTodayData());
		ListView listView = (ListView)view.findViewById(R.id.listView);
		listView.setAdapter(adapter);
	}

}
