package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CityListActivity extends Activity {
	private CityList cities = new CityList();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.city_list);

		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, cities.getCityList());
		 ListView listView = (ListView)findViewById(R.id.cityListView);
		 listView.setAdapter(adapter); 
	}
}
