package com.arrived1.gdzieszusza;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Today extends Tab{
	private City city;

	public Today(LayoutInflater inflater_, int layout, City city_) {
		super(inflater_, layout);
		this.city = city_;
		
		TextView cityText = (TextView)view.findViewById(R.id.cityString);
		TextView dateText = (TextView)view.findViewById(R.id.dateString);

		cityText.setText("Miasto: " + city.getName());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date(); ;
		dateText.setText("Data: " + dateFormat.format(date));
		
		 TodayListAdapter adapter = new TodayListAdapter(view.getContext(), city.getData());
		 ListView listView = ( ListView )view.findViewById(R.id.listView);
		 listView.setAdapter(adapter);

	}

}
