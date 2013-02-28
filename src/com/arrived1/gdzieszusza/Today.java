package com.arrived1.gdzieszusza;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.google.android.maps.GeoPoint;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;

public class Today extends Tab {
	private City city;

	public Today(LayoutInflater inflater_, int layout, City city_, Context context_) {
		super(inflater_, layout);
		this.city = city_;
		
		addAdView();

		TextView cityText = (TextView)view.findViewById(R.id.cityString);
		cityText.setText(" " + city.getName());
		
		NetworkGeolocalizationStreet networkGeoLocalCity = new NetworkGeolocalizationStreet(context_, city.getName());
		GeoPoint gp = networkGeoLocalCity.getGeoPoint();
		
		TodayListAdapter adapter = new TodayListAdapter(view.getContext(), city.getTodayData());
		ListView listView = (ListView)view.findViewById(R.id.listView);
		listView.setAdapter(adapter);
//		listView.setOnItemClickListener(new ListPickerOnItemClickListener(context_, gp));
		listView.setOnItemClickListener(new ListPickerOnItemClickListener(context_));
	}
	
    private void addAdView() {
		AdView ad = (AdView)view.findViewById(R.id.adView1);
		ad.loadAd(new AdRequest());
	}
    
}
