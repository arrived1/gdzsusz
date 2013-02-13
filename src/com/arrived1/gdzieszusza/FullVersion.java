package com.arrived1.gdzieszusza;

import android.view.LayoutInflater;
import android.widget.TextView;

public class FullVersion extends Tab {

	public FullVersion(LayoutInflater inflater_, int layout) {
		super(inflater_, layout);
	
		
		TextView title = (TextView)view.findViewById(R.id.tvTitle);
		TextView description = (TextView)view.findViewById(R.id.tvdesc);
	
		title.setText("Druga strona");
		description.setText("bdsjflk sfkljsdfl skdfj lsdfjlsdf j sidfhsdhj fzkdhjf'zkl xdfgzkjl'fzfgdfg DUPA");
	}
}
