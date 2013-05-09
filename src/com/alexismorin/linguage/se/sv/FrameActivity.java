package com.alexismorin.linguage.se.sv;

import processing.core.PApplet;

import com.alexismorin.linguage.laps.LAPs;
import com.slidingmenu.lib.SlidingMenu;

import fragments.FeedFragment;
import fragments.MenuListFragment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;

public class FrameActivity extends FragmentActivity implements FeedFragment.OnChallengeCardSelectedListener{

	private Fragment mFeedFragment;
	private Fragment mMenuFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_frame);
		
		FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
		
		//load the front view
		mFeedFragment = new FeedFragment();
		t.replace(R.id.content_frame, mFeedFragment);
		
		//customize the sliding menu
		SlidingMenu menu = new SlidingMenu(this);
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
		
		Intent challengeAct = new Intent(FrameActivity.this, LAPs.class);
		startActivity(challengeAct);
		
		
		/*String startThis = bundle.getString("startActivity");
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
}