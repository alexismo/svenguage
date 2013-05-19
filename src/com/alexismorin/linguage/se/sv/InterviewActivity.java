package com.alexismorin.linguage.se.sv;

import com.alexismorin.linguage.util.LinguageActivity;

import fragments.FeedFragment;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class InterviewActivity extends LinguageActivity {

	Button continueBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().hide();
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_interview);
		
		Spinner inSwedenTo = (Spinner) findViewById(R.id.inSwedenToSpin);
		Spinner swedishLevel = (Spinner) findViewById(R.id.swedishLevelSpin);
		
		ArrayAdapter<CharSequence> inSweToAdapter = ArrayAdapter.createFromResource(
				this, R.array.in_sweden_to_array, android.R.layout.simple_spinner_item);
		
		ArrayAdapter<CharSequence> sweLevelAdapter = ArrayAdapter.createFromResource(
				this, R.array.swedish_level_array, android.R.layout.simple_spinner_item);
		
		//specify the layout to use when the list of choices appears
		inSweToAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sweLevelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//apply the adapter to the spinner
		inSwedenTo.setAdapter(inSweToAdapter);
		swedishLevel.setAdapter(sweLevelAdapter);
		
		continueBtn = (Button) findViewById(R.id.continueBtn);
		
		continueBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Intent frameIntent = new Intent(InterviewActivity.this, FrameActivity.class);
				//startActivity(frameIntent);
				Intent drawerIntent = new Intent(InterviewActivity.this, DrawerActivity.class);
				startActivity(drawerIntent);
				finish();
			}
		});
	}
}