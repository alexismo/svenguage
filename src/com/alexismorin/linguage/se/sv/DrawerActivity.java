package com.alexismorin.linguage.se.sv;


import com.alexismorin.linguage.laps.LAPs;
import com.example.android.navigationdrawerexample.R;

import fragments.FeedFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.app.Fragment;
import android.app.FragmentManager;
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
		
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		SampleAdapter adapter = new SampleAdapter(this);
		
		adapter.add(new SampleItem("Challenges", R.drawable.menu_apostrophe));
		adapter.add(new SampleItem("My Swedish", R.drawable.menu_myswedish));
		adapter.add(new SampleItem("Topics", R.drawable.menu_topics));
		
		adapter.add(new SampleItem("Dictionary", R.drawable.menu_dictionary));
		adapter.add(new SampleItem("Watch & Read", R.drawable.menu_watchread));
		adapter.add(new SampleItem("Settings", R.drawable.menu_settings));
		
		//set the adapter for the list view
		mDrawerList.setAdapter(adapter);
		//Set the list's click listener
		//mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
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
		Log.i("challenge clicked", "gonna start some crazy b*shit");
		
		String startThis = challengeCardBundle.getString("startActivity");
		if(startThis.contains("LAPs")){
			Intent lapsAct = new Intent(this, LAPs.class);
			startActivity(lapsAct, challengeCardBundle);
		}
		
		if(startThis.contains("VocabularyActivity")){
			String topic = challengeCardBundle.getString("activityTopic");
			
			Intent vocabAct = new Intent(this, VocabularyActivity.class);
			vocabAct.putExtra("activityTopic", topic);
			/*
			Bundle vocabB = vocabAct.getExtras();
			vocabB.putString("activityTopic", topic);
			vocabAct.putExtras(vocabB);
			*/
			
			startActivity(vocabAct);
		}
		
		if(startThis.contains("VideoActivity")){
			Intent videoIntent = new Intent(this, VideoActivity.class);
			startActivity(videoIntent, challengeCardBundle);
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
	
	private class SampleItem {
		public String tag;
		public int iconRes;
		public SampleItem(String tag, int iconRes) {
			this.tag = tag; 
			this.iconRes = iconRes;
		}
	}
	
	private class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
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
