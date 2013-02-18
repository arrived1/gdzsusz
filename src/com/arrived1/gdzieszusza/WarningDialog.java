package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;

public class WarningDialog extends Activity {
	private Activity activity;
	
	public WarningDialog(Activity activity_) {
		this.activity = activity_;

		
		buildWarnDialog();
	}
	
	
	private void buildWarnDialog() {
		Builder dialogBuilder = new AlertDialog.Builder(activity, AlertDialog.THEME_HOLO_DARK);
		dialogBuilder.setIconAttribute(android.R.attr.alertDialogIcon);
		dialogBuilder.setTitle("Argh");
		dialogBuilder.setMessage("Watch out!");
		
		dialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                
                /* User clicked OK so do some stuff */
            }
        });
		
		dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                /* User clicked Something so do some stuff */
            }
        });

		dialogBuilder.show();
	}
}
