package com.arrived1.gdzieszusza;

import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;

public class Today extends Tab {
	private City city;

	public Today(LayoutInflater inflater_, int layout, City city_) {
		super(inflater_, layout);
		this.city = city_;

		TextView cityText = (TextView)view.findViewById(R.id.cityString);
		cityText.setText(" " + city.getName());
		
		TodayListAdapter adapter = new TodayListAdapter(view.getContext(), city.getTodayData());
		ListView listView = (ListView)view.findViewById(R.id.listView);
		listView.setAdapter(adapter);
	}
}
