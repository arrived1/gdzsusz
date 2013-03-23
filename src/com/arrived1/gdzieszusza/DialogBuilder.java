package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;

public class DialogBuilder extends Activity {
	private Activity activity;
	
	public DialogBuilder(Activity activity_) {
		this.activity = activity_;
	}

	public void buildRestartDialog(String title, String msg) {
		checkAndroidVersion();
		
		Builder dialogBuilder;
		if(checkAndroidVersion() < 11) {
			dialogBuilder = new AlertDialog.Builder(activity);
		}
		else {
			dialogBuilder = new AlertDialog.Builder(activity, AlertDialog.THEME_HOLO_DARK);
			dialogBuilder.setIconAttribute(android.R.attr.alertDialogIcon);	
		}

		dialogBuilder.setTitle(title);
		dialogBuilder.setMessage(msg);
		
		dialogBuilder.setNeutralButton("Wyłącz aplikacje", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            	activity.finish();
            }
        });
		dialogBuilder.show();
	}
	
	public void buildeChooseCityDialog(String title) {
		Builder dialogBuilder;
		if(checkAndroidVersion() < 11) {
			dialogBuilder = new AlertDialog.Builder(activity);
		}
		else {
			dialogBuilder = new AlertDialog.Builder(activity, AlertDialog.THEME_HOLO_DARK);
			dialogBuilder.setIconAttribute(android.R.attr.alertDialogIcon);	
		}

		dialogBuilder.setTitle(title);
		
		CityList cities = new CityList();
		dialogBuilder.setItems(cities.getCityList(), new CityOnClickListener());
		dialogBuilder.show();
		
	}

	private int checkAndroidVersion() {
		return android.os.Build.VERSION.SDK_INT;
	}
}
