package com.alexismorin.linguage.se.sv;

import java.util.Timer;
import java.util.TimerTask;

import com.actionbarsherlock.app.SherlockActivity;
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
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().hide();
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_launch);
		
		mTimer = new Timer();
		mTimer.schedule(new TimerTask(){
			public void run(){
				gotoNextView();
			}
		},2000, 99000);
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
