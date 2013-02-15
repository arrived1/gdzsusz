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
		
		
		 String[] countries = new String[] {
			        "India",
			        "Pakistan",
			        "Sri Lanka",
			        "China",
			        "Bangladesh",
			        "China"
			    };
			 
			    // Array of integers points to images stored in /res/drawable-ldpi/
			    int[] flags = new int[]{
			        R.drawable.ic,
			        R.drawable.ic,
			        R.drawable.ic,
			        R.drawable.ic,
			        R.drawable.ic,
			        R.drawable.ic
			    };
			 
			    // Array of strings to store currencies
			    String[] currency = new String[]{
			        "Indian Rupee",
			        "Pakistani Rupee",
			        "Sri Lankan Rupee",
			        "Renminbi",
			        "Bangladeshi Taka",
			        "Renminbi"
			    };
			    
			    
			    List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
			    
		        for(int i=0; i<6 ;i++) {
		            HashMap<String, String> hm = new HashMap<String,String>();
		            hm.put("txt", "Country : " + countries[i]);
		            hm.put("cur","Currency : " + currency[i]);
		            hm.put("flag", Integer.toString(flags[i]) );
		            aList.add(hm);
		        }
		 
		        // Keys used in Hashmap
		        String[] from = { "flag","txt","cur" };
		 
		        // Ids of views in listview_layout
		        int[] to = { R.id.flag, R.id.txt, R.id.cur};
		 
		        // Instantiating an adapter to store each items
		        // R.layout.listview_layout defines the layout of each item
		        SimpleAdapter adapter = new SimpleAdapter(view.getContext(), aList, R.layout.listview_layout, from, to);
		 
		        // Getting a reference to listview of main.xml layout file
		        ListView listView = ( ListView )view.findViewById(R.id.listView);
		 
		        // Setting the adapter to the listView
		        listView.setAdapter(adapter);

	}

}
