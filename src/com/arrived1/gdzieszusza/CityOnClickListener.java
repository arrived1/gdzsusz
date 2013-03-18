package com.arrived1.gdzieszusza;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class CityOnClickListener implements OnClickListener {
	private int pos = -1;

	@Override
	public void onClick(DialogInterface dialog, int which) {
		pos = which;
	}
}