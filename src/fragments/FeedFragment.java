package fragments;

import java.util.ArrayList;
import java.util.Collection;

import model.LinguageChallengeStub;

import com.alexismorin.linguage.FirstLaunchActivity;
import com.alexismorin.linguage.laps.LAPs;
import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.se.sv.R.dimen;
import com.alexismorin.linguage.se.sv.R.drawable;
import com.alexismorin.linguage.se.sv.R.id;
import com.alexismorin.linguage.se.sv.R.layout;
import com.alexismorin.linguage.util.TopicCardAdapter;
import com.alexismorin.linguage.util.TopicCard;
import com.alexismorin.linguage.util.net.ChallengeFeedTask;
import com.alexismorin.linguage.util.net.FeedResponse;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.app.Fragment;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.util.Log;
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
	TopicCardAdapter nowArrayAdapter;
	ListView list;
	ProgressDialog progressD;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_feed, container, false);
		list = (ListView) view.findViewById(R.id.challengeCards);
		list.setDivider(null);
		list.setDividerHeight(0);
		list.setOnItemClickListener(new TopicItemClickListener());
		
		nowArrayAdapter = new TopicCardAdapter(getActivity().getApplicationContext(), R.id.challengeCards, new ArrayList<LinguageChallengeStub>());
		list.setAdapter(nowArrayAdapter);
		
		progressD = new ProgressDialog(getActivity());
		progressD.setCancelable(false);
		
		Log.i("Progress","initialized");
		if(nowArrayAdapter.isEmpty()){
			getFeed();
		}
		
		return view;
	}
	
	private void getFeed() {
		nowArrayAdapter.notifyDataSetInvalidated();
		
		ChallengeFeedTask cft = new ChallengeFeedTask(this, progressD);
		cft.execute();
	}
	
	public void setCardsList(ArrayList<LinguageChallengeStub> newCards){
		nowArrayAdapter.clear();
		nowArrayAdapter.addAll(newCards);
		nowArrayAdapter.notifyDataSetChanged();
	}

	//Container Activity must implement this interface
	public interface OnChallengeCardSelectedListener{
		public void onChallengeCardSelected(Bundle bundle);
	}
	
	private class TopicItemClickListener implements ListView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			LinguageChallengeStub stub = nowArrayAdapter.getItem(position);
			int challengeId = stub.getId();
			String chalType = stub.getType();
			
			//make a bundle with the topic ID and notify the parent activity
			Bundle topicBundle = new Bundle();
			topicBundle.putInt("challengeId", challengeId);
			topicBundle.putString("chalType", chalType);
			mListener.onChallengeCardSelected(topicBundle);
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