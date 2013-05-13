package fragments;

import java.util.ArrayList;
import java.util.List;

import words.WordsBus1;
import words.WordsRestaurant1;
import words.WordsRestaurant2;
import words.WordsRestaurant3;

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

	public VocabularySectionFragment(int i, String topic) {
		if(wordsList == null){
			wordsList = new ArrayList<VocabularyListItem>();//instantiate the thing
			
			if(topic.equals("restaurant")){
				switch (i) {
				case 1:
					wordsList = new WordsRestaurant1();
					break;

				case 2:
					wordsList = new WordsRestaurant2();
					break;
				case 3:
					
					
					wordsList = new WordsRestaurant3();
					
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
			if(topic.equals("bus")){
				wordsList = new WordsBus1();
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