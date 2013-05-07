package com.alexismorin.linguage.se.sv;

import com.slidingmenu.lib.SlidingMenu;

import fragments.FeedFragment;
import fragments.MenuListFragment;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.view.Menu;

public class FrameActivity extends Activity {

	private Fragment mFeedFragment;
	private Fragment mMenuFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_frame);
		
		//load the front view
		mFeedFragment = new FeedFragment();
		getFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, mFeedFragment)
		.commit();
		
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
    	FragmentTransaction t = this.getFragmentManager().beginTransaction();
		mMenuFragment = new MenuListFragment();
		t.replace(R.id.menu_frame, mMenuFragment);
		t.commit();
	}
}