package com.alexismorin.linguage;

import java.io.IOException;
import java.util.Locale;

import model.TopicChallenge;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.se.sv.R.id;
import com.alexismorin.linguage.se.sv.R.layout;
import com.alexismorin.linguage.se.sv.R.string;
import com.alexismorin.linguage.util.net.ChallengeFeedTask;
import com.alexismorin.linguage.util.net.TopicChallengeResponse;
import com.alexismorin.linguage.util.net.TopicChallengeTask;

import fragments.DefinitionFragment;
import fragments.VocabularySectionFragment;
import android.app.ProgressDialog;
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
	ProgressDialog progressD;
	
	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	int challengeId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vocabulary);
		progressD = new ProgressDialog(this);
		progressD.setCancelable(false);
		
		if(getIntent().hasExtra("challengeId")){
			challengeId = getIntent().getExtras().getInt("challengeId");
			//fetch the thing
			TopicChallengeTask tct = new TopicChallengeTask(this, challengeId, progressD);
			tct.execute();
		}
	}
	
	public void attachAdapter(TopicChallenge tc){
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		//send the challenge and its columns down to it
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), tc);
	
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

		TopicChallenge challenge;
		
		public SectionsPagerAdapter(FragmentManager fm, TopicChallenge challenge) {
			super(fm);
			this.challenge = challenge;
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = VocabularySectionFragment.newInstance(position+1, challenge.columns.get(position));
			return fragment;
		}

		@Override
		public int getCount() {
			return challenge.columns.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return challenge.columns.get(position).getTitle().toUpperCase(Locale.getDefault());
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
