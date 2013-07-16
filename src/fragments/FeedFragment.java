package fragments;

import java.util.ArrayList;

import com.alexismorin.linguage.FirstLaunchActivity;
import com.alexismorin.linguage.laps.LAPs;
import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.se.sv.R.dimen;
import com.alexismorin.linguage.se.sv.R.drawable;
import com.alexismorin.linguage.se.sv.R.id;
import com.alexismorin.linguage.se.sv.R.layout;
import com.alexismorin.linguage.util.TopicCardAdapter;
import com.alexismorin.linguage.util.TopicCard;

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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FeedFragment extends Fragment {

	protected ListFragment mFrag;
	OnChallengeCardSelectedListener mListener;
	//new card listview things
	ArrayList<TopicCard> cardsList;
	TopicCardAdapter nowArrayAdapter;
	ListView list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_feed, container, false);
		list = (ListView) view.findViewById(R.id.challengeCards);
		list.setDivider(null);
		list.setDividerHeight(0);
		list.setOnItemClickListener(new TopicItemClickListener());
		
		cardsList = new ArrayList<TopicCard>();
		cardsList.add(new TopicCard("Prendre l'autobus", "Taking the bus", R.drawable.challenge_bus, 1));
		cardsList.add(new TopicCard("Construis une phrase", "Build a sentence", R.drawable.challenge_order, 2));
		cardsList.add(new TopicCard("Commander au resto", "Ordering at the restuarant", R.drawable.challenge_conversation, 3));
		cardsList.add(new TopicCard("Taguer une photo", "Tag a photograph", R.drawable.challenge_photo, 4));
		cardsList.add(new TopicCard("Apprendre avec des amis", "Learn with friends", R.drawable.challenge_google, 5));
		cardsList.add(new TopicCard("Prendre l'autobus", "Taking the bus", R.drawable.challenge_bus, 6));
		cardsList.add(new TopicCard("Construis une phrase", "Build a sentence", R.drawable.challenge_order, 7));
		cardsList.add(new TopicCard("Commander au resto", "Ordering at the restuarant", R.drawable.challenge_conversation, 8));
		cardsList.add(new TopicCard("Taguer une photo", "Tag a photograph", R.drawable.challenge_photo, 9));
		cardsList.add(new TopicCard("Apprendre avec des amis", "Learn with friends", R.drawable.challenge_google, 10));
		
		nowArrayAdapter = new TopicCardAdapter(getActivity(), R.id.challengeCards, cardsList);
		
		list.setAdapter(nowArrayAdapter);
		
		return view;
	}
	
	//Container Activity must implement this interface
	public interface OnChallengeCardSelectedListener{
		public void onTopicCardSelected(Bundle bundle);
	}
	
	private class TopicItemClickListener implements ListView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			int topicId = cardsList.get(position).topicId;
			
			//make a bundle with the topic ID and notify the parent activity
			Bundle topicBundle = new Bundle();
			topicBundle.putInt("topicId", topicId);
			mListener.onTopicCardSelected(topicBundle);
		}
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