package com.arrived1.gdzieszusza;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;

public class OtherDays extends Tab{
	private City city;
	
	public OtherDays(LayoutInflater inflater_, int layout, City city_, Context context_) {
		super(inflater_, layout);
		this.city = city_;
		
		addAdView();
		
		TextView cityText = (TextView)view.findViewById(R.id.cityString);
		cityText.setText(" " + city.getName());
		
		TodayListAdapter adapter = new TodayListAdapter(view.getContext(), city.getOtherDaysData());
		ListView listView = (ListView)view.findViewById(R.id.listViewOther);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListenerStreet(context_, city.getName()));
	}
	
    private void addAdView() {
		AdView ad = (AdView)view.findViewById(R.id.adView2);
		ad.loadAd(new AdRequest());
	}
}
