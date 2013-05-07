package fragments;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.se.sv.R.dimen;
import com.alexismorin.linguage.se.sv.R.drawable;
import com.alexismorin.linguage.se.sv.R.id;
import com.alexismorin.linguage.se.sv.R.layout;
import com.alexismorin.linguage.util.ChallengeCard;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.slidingmenu.lib.SlidingMenu;


import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;

public class FeedFragment extends Fragment {

	protected ListFragment mFrag;
	protected CardUI mCardView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mCardView = (CardUI) container.findViewById(R.id.cardContent);
		
		CardStack stackPlay = new CardStack();
		mCardView.addStack(stackPlay);
		
		mCardView.addCard(new ChallengeCard("Title for card", "Card Desc"));
		
		return inflater.inflate(R.layout.activity_feed, null);
	}
	
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);	
	}
}