package fragments;

import java.util.ArrayList;

import com.alexismorin.linguage.laps.LAPs;
import com.alexismorin.linguage.se.sv.FirstLaunchActivity;
import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.se.sv.R.dimen;
import com.alexismorin.linguage.se.sv.R.drawable;
import com.alexismorin.linguage.se.sv.R.id;
import com.alexismorin.linguage.se.sv.R.layout;
import com.alexismorin.linguage.util.ChallengeCard;
import com.alexismorin.linguage.util.FriendChallengeCard;
import com.alexismorin.linguage.util.NowArrayAdapter;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.app.Fragment;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FeedFragment extends Fragment {

	protected ListFragment mFrag;
	protected CardUI mCardView;
	OnChallengeCardSelectedListener mListener;
	//new card listview things
	ArrayList<String> cardsList;
	NowArrayAdapter nowArrayAdapter;
	ListView list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_feed, container, false);
		list = (ListView) view.findViewById(R.id.challengeCards);
		list.setDivider(null);
		list.setDividerHeight(0);
		
		cardsList = new ArrayList<String>();
		cardsList.add("Taking the bus");
		cardsList.add("Build a sentence");
		cardsList.add("Ordering at the restaurant");
		cardsList.add("Tag a photograph");
		cardsList.add("Learn with friends");
		cardsList.add("Taking the bus");
		cardsList.add("Build a sentence");
		cardsList.add("Ordering at the restaurant");
		cardsList.add("Tag a photograph");
		cardsList.add("Learn with friends");
		cardsList.add("Taking the bus");
		cardsList.add("Build a sentence");
		cardsList.add("Ordering at the restaurant");
		cardsList.add("Tag a photograph");
		cardsList.add("Learn with friends");
		cardsList.add("Taking the bus");
		cardsList.add("Build a sentence");
		cardsList.add("Ordering at the restaurant");
		cardsList.add("Tag a photograph");
		cardsList.add("Learn with friends");
		cardsList.add("Taking the bus");
		cardsList.add("Build a sentence");
		cardsList.add("Ordering at the restaurant");
		cardsList.add("Tag a photograph");
		cardsList.add("Learn with friends");
		
		nowArrayAdapter = new NowArrayAdapter(getActivity(), R.id.challengeCards, cardsList);
		
		list.setAdapter(nowArrayAdapter);
		
		return view;
	}
	
	/*
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_feed, container, false);
		//TextView tv = (TextView) view.findViewById(R.id.todaysChallengesLabel);
		
		mCardView = (CardUI) view.findViewById(R.id.challengeCards);
		mCardView.setSwipeable(false);
		
		ChallengeCard busVocabCard = new ChallengeCard("Taking the bus", "(Ta bussen)", R.drawable.challenge_bus);
		busVocabCard.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle b = new Bundle();
				b.putString("startActivity", "com.alexismorin.linguage.se.sv.VocabularyActivity");
				b.putString("activityTopic", "bus");
				mListener.onChallengeCardSelected(b);
			}
		});
		mCardView.addCard(busVocabCard);
		
		ChallengeCard lapsCard = new ChallengeCard("Build a sentence", "(Bygg en mening)", R.drawable.challenge_order);
		lapsCard.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle b = new Bundle();
				b.putString("startActivity", "com.alexismorin.linguage.laps.LAPs");
				mListener.onChallengeCardSelected(b);
			}
		});
		mCardView.addCard(lapsCard);
		
		ChallengeCard restoCard = new ChallengeCard("Ordering at the restaurant", "(Beställa på restaurangen)", R.drawable.challenge_conversation); 	
		restoCard.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle b = new Bundle();
				b.putString("startActivity", "com.alexismorin.linguage.se.sv.VocabularyActivity");
				b.putString("activityTopic", "restaurant");
				mListener.onChallengeCardSelected(b);
			}
		});
		mCardView.addCard(restoCard);
		
		mCardView.addCard(new ChallengeCard("Tag a photograph", "(Tagga en bild)", R.drawable.challenge_photo));
		mCardView.addCard(new ChallengeCard("Learn with friends", "(Lär dig med kompisar)", R.drawable.challenge_google));
		
		FriendChallengeCard melodifestivalen = new FriendChallengeCard("Charles watched…", "Melodifestivalen 1979", R.drawable.friend, R.drawable.friend_challenge_icon);
		melodifestivalen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle b = new Bundle();
				b.putString("startActivity", "com.alexismorin.linguage.se.sv.VideoActivity");
				mListener.onChallengeCardSelected(b);
			}
		});
		mCardView.addCard(melodifestivalen);
		
		
		mCardView.refresh();
		
		return view;
	}
	*/
	
	//Container Activity must implement this interface
	public interface OnChallengeCardSelectedListener{
		public void onChallengeCardSelected(Bundle bundle);
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try {
			mListener = (OnChallengeCardSelectedListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement OnChallengeCardSelectedListener");
		}
	}
	
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);	
	}
}