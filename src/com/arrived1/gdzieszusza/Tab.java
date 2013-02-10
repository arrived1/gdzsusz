package com.arrived1.gdzieszusza;

import android.view.LayoutInflater;
import android.view.View;

public class Tab {
	protected LayoutInflater inflater;
	protected View view;
	protected String name;
	
	public Tab(LayoutInflater inflater_, String name_, int layout) {
		this.inflater = inflater_;
		this.name = name_;
		view = inflater.inflate(layout, null, false);
	}
	
	protected View getView() {
		return view;
	}

}
