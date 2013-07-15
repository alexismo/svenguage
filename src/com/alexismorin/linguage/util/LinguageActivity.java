package com.alexismorin.linguage.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;

public class LinguageActivity extends Activity {

	public void showDemoDialog(String message){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		if(message.equals("")){
			builder.setMessage("This is only a short demo of sven'guage. You can't do that right now.");			
		}else{
			builder.setMessage(message);
		}
		
		builder.setTitle("sven'guage demo");
		
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				
			}
		});
		
		AlertDialog dialog = builder.create();
		dialog.show();
	}
}
