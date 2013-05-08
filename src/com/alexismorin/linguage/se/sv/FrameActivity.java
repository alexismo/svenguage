package com.alexismorin.linguage.se.sv;

import com.slidingmenu.lib.SlidingMenu;

import fragments.FeedFragment;
import fragments.MenuListFragment;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

public class FrameActivity extends FragmentActivity {

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
}