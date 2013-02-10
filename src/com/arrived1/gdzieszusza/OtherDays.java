package com.arrived1.gdzieszusza;

import android.view.LayoutInflater;
import android.widget.TextView;

public class OtherDays extends Tab{

	public OtherDays(LayoutInflater inflater_, String name_, int layout) {
		super(inflater_, name_, layout);
	
		
		TextView title = (TextView)view.findViewById(R.id.tvTitle);
		TextView description = (TextView)view.findViewById(R.id.tvdesc);
	
		title.setText("Druga strona");
		description.setText("bdsjflk sfkljsdfl skdfj lsdfjlsdf j sidfhsdhj fzkdhjf'zkl xdfgzkjl'fzfgdfg DUPA");
	}
}
