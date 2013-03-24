package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ActivityCityManulaPicker extends Activity {
	
	private CityList cities = new CityList();
	  
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.city_manual_picker); 
	        
	    TextView txt = (TextView)findViewById(R.id.textView);
	    txt.setText("Niestety nie udało mi się rozpoznać miasta, w którym obecnie przebywasz.\n\n Wybierz miasto:");
	    
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, cities.getCityList());
		ListView listView = (ListView)findViewById(R.id.cityListView);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListenerCity(this));
	}

}