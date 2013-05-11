package com.alexismorin.linguage.se.sv;

import processing.core.PApplet;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.*;
import com.alexismorin.linguage.laps.LAPs;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingActivityBase;

import fragments.FeedFragment;
import fragments.MenuListFragment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class FrameActivity extends SherlockFragmentActivity implements FeedFragment.OnChallengeCardSelectedListener, SlidingActivityBase{

	private Fragment mFeedFragment;
	private Fragment mMenuFragment;
	private SlidingMenu menu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_SvActionBar);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		//getSupportActionBar().
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_frame);
		
		FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
		
		//load the front view
		mFeedFragment = new FeedFragment();
		t.replace(R.id.content_frame, mFeedFragment);
		
		//customize the sliding menu
		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.menu_frame);
        
        //load the back view
		mMenuFragment = new MenuListFragment();
		t.replace(R.id.menu_frame, mMenuFragment);
		
		//commit the fragment changes to all the frames
		t.commit();
	}
	
	@Override
	public void onChallengeCardSelected(Bundle bundle) {
		Log.i("challenge clicked", "gonna start some crazy b*shit");
		
		String startThis = bundle.getString("startActivity");
		if(startThis.contains("LAPs")){
			Intent lapsAct = new Intent(FrameActivity.this, LAPs.class);
			startActivity(lapsAct);
		}
		
		if(startThis.contains("VocabularyActivity")){
			Intent vocabAct = new Intent(FrameActivity.this, VocabularyActivity.class);
			startActivity(vocabAct);
		}
		
		
		/*
		 * ==CAN ONLY START LAPs FOR NOW
		 * String startThis = bundle.getString("startActivity");
		Class cls;
		try {
			cls = Class.forName(startThis);
			if(cls.isInstance(Activity.class) || cls.isInstance(PApplet.class)){
				//Activity a = (Activity) cls.newInstance();
				Intent challengeAct = new Intent(FrameActivity.this, cls.getClass());
				startActivity(challengeAct);
			}else{
				Log.e("class cast exception", "cls is a "+cls.getName());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getSupportMenuInflater();
	    inflater.inflate(R.menu.user_face, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Log.i("Home","clicked home");
			toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void setBehindContentView(View view, LayoutParams layoutParams) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBehindContentView(View view) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setBehindContentView(int layoutResID) {
		// TODO Auto-generated method stub
	}

	@Override
	public SlidingMenu getSlidingMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void toggle() {
		if(menu.isMenuShowing())
			showContent();
		else
			showMenu();
	}

	@Override
	public void showContent() {
		menu.showContent();
	}

	@Override
	public void showMenu() {
		menu.showMenu();
	}

	@Override
	public void showSecondaryMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSlidingActionBarEnabled(boolean slidingActionBarEnabled) {
		// TODO Auto-generated method stub
		
	}
}