package com.arrived1.gdzieszusza;

import android.view.LayoutInflater;
import android.widget.TextView;

public class Today extends Tab{
	private City city;

	public Today(LayoutInflater inflater_, int layout, City city_) {
		super(inflater_, layout);
		this.city = city_;

		City city = new City("Wroclaw", "http://www.apteka-zwycieska.pl/gdzieSusza/wroclaw.html");
		city.showVector();
		
		TextView title = (TextView)view.findViewById(R.id.tvTitle);
		TextView description = (TextView)view.findViewById(R.id.tvdesc);

		title.setText("Pierwsza strona");
		description.setText(city.getWebPage());
	}

}
