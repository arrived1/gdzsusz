package com.arrived1.gdzieszusza;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.view.LayoutInflater;
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
		
		

	}

}
