package com.arrived1.gdzieszusza;

import android.view.LayoutInflater;
import android.widget.TextView;

public class Today extends Tab{

	public Today(LayoutInflater inflater_, String name_, int layout) {
		super(inflater_, name_, layout);

		City city = new City("Wroclaw");
		
		TextView title = (TextView)view.findViewById(R.id.tvTitle);
		TextView description = (TextView)view.findViewById(R.id.tvdesc);

		title.setText("PIerwsza strona");
		description.setText(city.getWebPage());
	}

}
