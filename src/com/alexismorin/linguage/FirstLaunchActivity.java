package com.alexismorin.linguage;

import java.util.Timer;
import java.util.TimerTask;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.se.sv.SwedenActivity;
import com.alexismorin.linguage.se.sv.R.layout;
import com.alexismorin.linguage.util.LinguageActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class FirstLaunchActivity extends LinguageActivity {

	private Timer mTimer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setDisplayShowTitleEnabled(false);
		getActionBar().hide();
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_launch);
		
		mTimer = new Timer();
		mTimer.schedule(new TimerTask(){
			public void run(){
				gotoNextView();
			}
		},4000, 99000);
	}
	
	private void gotoNextView(){
		this.runOnUiThread(Timer_Tick);
	}
	
	private Runnable Timer_Tick = new Runnable(){
		public void run(){
			//destroy timer
			mTimer.cancel();
			mTimer.purge();
			
			//go to next activity
			Intent i = new Intent(FirstLaunchActivity.this, SwedenActivity.class);
			startActivity(i);
			finish();
		}
	};
}
