package com.arrived1.gdzieszusza;

import android.view.LayoutInflater;
import android.view.View;

public class Tab {
	protected LayoutInflater inflater;
	protected View view;
	
	public Tab(LayoutInflater inflater_, int layout) {
		this.inflater = inflater_;
		view = inflater.inflate(layout, null, false);
		
		//TODO: add facebook button
//		addListenerOnButtonFacebook();
	}
	
	protected View getView() {
		return view;
	}
	
	//TODO: add facebook button
//	public void addListenerOnButtonFacebook() {
//		final Button button = (Button)view.findViewById(R.id.buttonFacebook);
//		button.setOnClickListener(new ButtonFacebook());
//	}

}
