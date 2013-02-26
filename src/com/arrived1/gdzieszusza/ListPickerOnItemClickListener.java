package com.arrived1.gdzieszusza;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class ListPickerOnItemClickListener implements OnItemClickListener {
	private Context context;
	
	public ListPickerOnItemClickListener(Context context_) {
		this.context = context_;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
		
//		TextView textView1 = (TextView)view.findViewById(R.id.txt);
//		
//		String product = (String)textView1.getText();
//		System.out.println("DUPA " + product);
		
		Intent myIntentAboutPtogramMapka = new Intent(context, Map.class);
		context.startActivity(myIntentAboutPtogramMapka);
	}

}
