package com.arrived1.gdzieszusza;

import android.view.LayoutInflater;
import android.view.View;

public class Tab {
	protected LayoutInflater inflater;
	protected View view;
	
	public Tab(LayoutInflater inflater_, int layout) {
		this.inflater = inflater_;
		view = inflater.inflate(layout, null, false);
	}
	
	protected View getView() {
		return view;
	}

}
