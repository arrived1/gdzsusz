package com.arrived1.gdzieszusza;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class ListPickerOnItemClickListener implements OnItemClickListener {

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
		
		TextView textView1 = (TextView)view.findViewById(R.id.txt);
		
		String product = (String)textView1.getText();
		System.out.println("DUPA " + product);
	}

}
