package com.arrived1.gdzieszusza;

import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;

public class OtherDays extends Tab{
	private City city;
	
	public OtherDays(LayoutInflater inflater_, int layout, City city_) {
		super(inflater_, layout);
		this.city = city_;
	
		
		TextView cityText = (TextView)view.findViewById(R.id.cityString);
		cityText.setText(" " + city.getName());
		
		TodayListAdapter adapter = new TodayListAdapter(view.getContext(), city.getOtherDaysData());
		ListView listView = (ListView)view.findViewById(R.id.listViewOther);
		listView.setAdapter(adapter);
	}
}
