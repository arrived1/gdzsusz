package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;

public class WarningDialog extends Activity {
	private Activity activity;
	private String title;
	private String msg;
	
	public WarningDialog(Activity activity_, String title_, String msg_) {
		this.activity = activity_;
		this.title = title_;
		this.msg = msg_;
		
		buildWarnDialog();
	}

	private void buildWarnDialog() {
		Builder dialogBuilder = new AlertDialog.Builder(activity, AlertDialog.THEME_HOLO_DARK);
		dialogBuilder.setIconAttribute(android.R.attr.alertDialogIcon);
		dialogBuilder.setTitle(title);
		dialogBuilder.setMessage(msg);
		
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
