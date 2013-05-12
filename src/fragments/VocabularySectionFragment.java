package fragments;

import java.util.ArrayList;
import java.util.List;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.se.sv.VocabularyActivity;
import com.alexismorin.linguage.util.VocabFlavorImage;
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
				
				wordsList.add(new VocabWord("Får vi beställa?"));
				wordsList.add(new VocabWord("Jag skulle vilja..."));
				wordsList.add(new VocabWord("Vad har ni för dagens lunch?"));
				wordsList.add(new VocabWord("Har ni ett vegetariskt/glutenfri alternativ?"));
				wordsList.add(new VocabWord("Jag ska ta..."));
				wordsList.add(new VocabWord("Är kaffet ingår?"));
				wordsList.add(new VocabWord("Vi betalar ihop/separat."));
				break;

			case 2:
				wordsList.add(new VocabFlavorImage(R.drawable.baby));
				
				wordsList.add(new VocabWord("Hej"));
				wordsList.add(new VocabWord("Hallå"));
				wordsList.add(new VocabWord("Tjenare"));
				wordsList.add(new VocabWord("Tjena"));
				wordsList.add(new VocabWord("Tja (slang)"));
				wordsList.add(new VocabWord("God morgon"));
				wordsList.add(new VocabWord("God kväll"));
				break;
			case 3:
				wordsList.add(new VocabFlavorImage(R.drawable.restaurant));
				
				wordsList.add(new VocabWord("Får vi beställa?"));
				wordsList.add(new VocabWord("Jag skulle vilja..."));
				wordsList.add(new VocabWord("Vad har ni för dagens lunch?"));
				wordsList.add(new VocabWord("Har ni ett vegetariskt/glutenfri alternativ?"));
				wordsList.add(new VocabWord("Jag ska ta..."));
				wordsList.add(new VocabWord("Är kaffet ingår?"));
				wordsList.add(new VocabWord("Vi betalar ihop/separat."));
				break;
				
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
