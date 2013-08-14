package com.alexismorin.linguage;


import com.alexismorin.linguage.laps.LAPs;
import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.se.sv.VideoActivity;
import com.alexismorin.linguage.se.sv.R.drawable;
import com.alexismorin.linguage.se.sv.R.id;
import com.alexismorin.linguage.se.sv.R.layout;
import com.alexismorin.linguage.se.sv.R.string;

import fragments.FeedFragment;
import fragments.MyFrenchFragment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * 
 * @author alexis
 * This activity is the main feed. 
 * It calls upon various fragments to populate it's right view.
 */
public class DrawerActivity extends Activity implements FeedFragment.OnChallengeCardSelectedListener{

	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private ListView mDrawerList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawer);
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close){
			public void onDrawerClosed(View view){
				//set the title,
				//getSupportActionBar().setTitle();
				//invalidate the menu
				//invalidateMenuOptions();
			}
			
			public void onDrawerOpen(View drawerView){
				//set the title,
				//getSupportActionBar().setTitle();
				//invalidate the menu
				//invalidateMenuOptions();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		// set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
		
        //set up the content of the drawer menu
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		DrawerMenuAdapter adapter = new DrawerMenuAdapter(this);		
		//set the adapter for the list view
		mDrawerList.setAdapter(adapter);
		//Set the list's click listener
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        
		//get the main feed in
		Fragment feedFragment = new FeedFragment();
		
		//insert the fragment
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, feedFragment).commit();
	}
	
	private class DrawerItemClickListener implements ListView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}
	
	private void selectItem(int position){
		Fragment frag;
		FragmentManager fragmentManager = getFragmentManager();
		switch (position) {
		case 0://Feed
			frag = new FeedFragment();
			fragmentManager.beginTransaction().replace(R.id.content_frame, frag).commit();
			break;

		case 1://My Swedish
			frag = new MyFrenchFragment();
			fragmentManager.beginTransaction().replace(R.id.content_frame, frag).commit();
		default:
			
			break;
		}
		
		mDrawerLayout.closeDrawers();
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
          return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }
	
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
	
	@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
	
	@Override
	public void onChallengeCardSelected(Bundle challengeCardBundle) {
		int challengeId = challengeCardBundle.getInt("challengeId");
		String chalType = challengeCardBundle.getString("chalType");
		
		if(chalType.equals("topic")){
			//start the vocabulary activity
			Intent vocabAct = new Intent(this, VocabularyActivity.class);
			vocabAct.putExtra("challengeId",challengeId);
			startActivity(vocabAct);
		}else{
			Log.i("No Challenge", "sorry, that kind of challenge hasn't been implemented yet.");
		}
	}
	
	private class DrawerMenuItem {
		public String tag;
		public int iconRes;
		public DrawerMenuItem(String tag, int iconRes) {
			this.tag = tag; 
			this.iconRes = iconRes;
		}
	}
	
	private class DrawerMenuAdapter extends ArrayAdapter<DrawerMenuItem> {

		public DrawerMenuAdapter(Context context) {
			super(context, 0);
			
			add(new DrawerMenuItem(getString(R.string.menu_challenges), R.drawable.menu_apostrophe));
			add(new DrawerMenuItem(getString(R.string.menu_my_french), R.drawable.menu_myfrench));
			add(new DrawerMenuItem(getString(R.string.menu_topics), R.drawable.menu_topics));
			
			add(new DrawerMenuItem(getString(R.string.menu_dictionary), R.drawable.menu_dictionary));
			add(new DrawerMenuItem(getString(R.string.menu_watch_read), R.drawable.menu_watchread));
			add(new DrawerMenuItem(getString(R.string.menu_settings), R.drawable.menu_settings));
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}

	}
}
