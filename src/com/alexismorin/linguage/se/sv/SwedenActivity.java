package com.alexismorin.linguage.se.sv;

import com.alexismorin.linguage.util.LinguageActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SwedenActivity extends LinguageActivity {
	
	Button btnJa, btnNo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sweden);
		
		btnJa = (Button) findViewById(R.id.buttonYes);
		btnNo = (Button) findViewById(R.id.buttonNo);
		registerForContextMenu(btnNo);
		
		btnJa.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent interviewIntent = new Intent(SwedenActivity.this, InterviewActivity.class);
				startActivity(interviewIntent);
				finish();
			}
		});
		
		btnNo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openContextMenu(v);
			}
		});
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo){
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Pick a language to learn");
		getMenuInflater().inflate(R.menu.languages, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item){
		//display the alert
		showDemoDialog("Sorry, you can only learn Swedish in this demo.");
		Log.i("context","show the alert");
		
		return super.onContextItemSelected(item);
	}
}
