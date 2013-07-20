package com.alexismorin.linguage;

import java.io.IOException;
import java.util.Locale;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.se.sv.R.id;
import com.alexismorin.linguage.se.sv.R.layout;
import com.alexismorin.linguage.se.sv.R.string;

import fragments.DefinitionFragment;
import fragments.VocabularySectionFragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;


public class VocabularyActivity extends FragmentActivity implements DefinitionFragment.OnSoundButtonClicked{

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;
	
	MediaPlayer mediaPlayer;
	boolean isPlaying = false;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	int topic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vocabulary);
		
		if(getIntent().hasExtra("activityTopic"))
			topic = getIntent().getExtras().getInt("activityTopic");

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
	}
	
	@Override 
	protected void onStop(){
		super.onStop();
		if(mediaPlayer != null)
			mediaPlayer.release();
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = VocabularySectionFragment.newInstance(position+1, topic);
			
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.vocab_words).toUpperCase(l);
			case 1:
				return getString(R.string.vocab_sentences).toUpperCase(l);
			case 2:
				return getString(R.string.vocab_context).toUpperCase(l);
			}
			return null;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onSoundButtonClicked(String accent) {
		//play a sound, yo
		Log.i("sound",accent);
		
		String soundUrl = "http://alexismorin.com/svenguage/restaurant.mp3";
		
		if(!isPlaying){
			//set up the media player
			mediaPlayer = new MediaPlayer();
			mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
				//preparing asynchronously seems like a better idea
				//this way it won't block the UI thread while data loads.
				@Override
				public void onPrepared(MediaPlayer mp) {
					mp.start();
				}
			});
			
			try {
				mediaPlayer.setDataSource(soundUrl);
				mediaPlayer.prepareAsync();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				Log.e("error", "prepare() failed");
				e.printStackTrace();
			}	
		}else{
			isPlaying = false;
			mediaPlayer.release();
			mediaPlayer = null;
		}
	}
}
