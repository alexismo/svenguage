package fragments;

import java.util.ArrayList;
import java.util.List;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.se.sv.VocabularyActivity;
import com.alexismorin.linguage.util.VocabFlavorImage;
import com.alexismorin.linguage.util.VocabReply;
import com.alexismorin.linguage.util.VocabWord;
import com.alexismorin.linguage.util.VocabularyAdapter;
import com.alexismorin.linguage.util.VocabularyListItem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class VocabularySectionFragment extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	public ListView vocabListView;
	private List<VocabularyListItem> wordsList;
	private VocabularyAdapter vocabAdapter;

	public VocabularySectionFragment(int i) {
		if(wordsList == null){
			wordsList = new ArrayList<VocabularyListItem>();//instantiate the thing
			
			//position is 1 2 or 3
			switch (i) {
			case 1:
				wordsList.add(new VocabFlavorImage(R.drawable.restaurant));
				
				wordsList.add(new VocabWord("en restaurang"));
				wordsList.add(new VocabWord("en stol"));
				wordsList.add(new VocabWord("ett bord"));
				wordsList.add(new VocabWord("en bar"));
				wordsList.add(new VocabWord("en servitör"));
				wordsList.add(new VocabWord("en vaktmästare"));
				wordsList.add(new VocabWord("en meny"));
				wordsList.add(new VocabWord("en lunch"));
				wordsList.add(new VocabWord("en middag"));
				wordsList.add(new VocabWord("en fika"));
				wordsList.add(new VocabWord("en servett"));
				wordsList.add(new VocabWord("en nota"));
				wordsList.add(new VocabWord("att beställa"));
				wordsList.add(new VocabWord("att äta"));
				wordsList.add(new VocabWord("att betala"));
				wordsList.add(new VocabWord("att sitta"));
				break;

			case 2:
				wordsList.add(new VocabFlavorImage(R.drawable.restaurant2));
				
				wordsList.add(new VocabWord("Får vi beställa?"));
				wordsList.add(new VocabWord("Jag skulle vilja..."));
				wordsList.add(new VocabWord("Vad har ni för dagens lunch?"));
				wordsList.add(new VocabWord("Har ni ett vegetariskt/glutenfri alternativ?"));
				wordsList.add(new VocabWord("Jag ska ta..."));
				wordsList.add(new VocabWord("Är kaffet ingår?"));
				wordsList.add(new VocabWord("Vi betalar ihop/separat."));
				break;
			case 3:
				wordsList.add(new VocabFlavorImage(R.drawable.restaurant3));
				
				int l = R.drawable.user_face;
				int f = R.drawable.friend;
				int w = R.drawable.waiter;
				
				wordsList.add(new VocabReply("Tjena!", 0, l));
				wordsList.add(new VocabReply("Hejsan. \n Ska ni äta här?", 1, w));
				wordsList.add(new VocabReply("Ja, det ska vi. \n Vars sittar vi?", 0, l));
				wordsList.add(new VocabReply("Följ mig, jag visar er platser.", 1, w));
				wordsList.add(new VocabReply("Tack", 0, l));
				wordsList.add(new VocabReply("Här är menyer. Varsågoda.", 1, w));
				wordsList.add(new VocabReply("Vill ni beställa?", 1, w));
				wordsList.add(new VocabReply("Ja Tack. \n Jag ska ta den fiskgratäng.", 0, l));
				//wordsList.add(new VocabReply("Och jag...får se nu. \n Jag skulle vilja ha pastan med köttfärssås.", 0, f)); //a new drawable doesn't work, somehow
				wordsList.add(new VocabReply("Någonting att dricka?", 1, w));
				wordsList.add(new VocabReply("Ett glass vatten, tack.", 0, l));
				
				break;
				/*
				wordsList.add(new VocabFlavorImage(R.drawable.baby));
				
				wordsList.add(new VocabWord("Hej"));
				wordsList.add(new VocabWord("Hejsan (slang)"));
				wordsList.add(new VocabWord("Hallå"));
				wordsList.add(new VocabWord("Tjenare"));
				wordsList.add(new VocabWord("Tjena"));
				wordsList.add(new VocabWord("Tja (slang)"));
				wordsList.add(new VocabWord("God morgon"));
				wordsList.add(new VocabWord("God kväll"));
				
				break;*/
				
			default:
				break;
			}
			
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(
				R.layout.fragment_vocabulary, container, false);
		
		vocabListView = (ListView) rootView.findViewById(R.id.vocab_list_view);
		
		vocabAdapter = new VocabularyAdapter(getActivity().getApplicationContext(), wordsList);
		vocabListView.setAdapter(vocabAdapter);
		
		return rootView;
	}
}