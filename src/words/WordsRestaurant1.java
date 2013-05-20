package words;

import java.util.ArrayList;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.util.VocabFlavorImage;
import com.alexismorin.linguage.util.VocabWord;
import com.alexismorin.linguage.util.VocabularyListItem;

public class WordsRestaurant1 extends ArrayList<VocabularyListItem> {
	public WordsRestaurant1(){
		this.add(new VocabFlavorImage(R.drawable.restaurant));
		
		this.add(new VocabWord("en restaurang", "a restaurant"));
		this.add(new VocabWord("en stol", "a chair"));
		this.add(new VocabWord("ett bord", "a table"));
		this.add(new VocabWord("en bar", "a bar"));
		this.add(new VocabWord("en servitör", "a waiter"));
		this.add(new VocabWord("en meny", "a menu"));
		this.add(new VocabWord("en lunch", "a lunch"));
		this.add(new VocabWord("en middag", "a dinner"));
		this.add(new VocabWord("en fika", "a coffee, with something sweet"));
		this.add(new VocabWord("en servett", "a napkin"));
		this.add(new VocabWord("en nota","a bill"));
		this.add(new VocabWord("att beställa", "to pay"));
		this.add(new VocabWord("att äta", "to eat"));
		this.add(new VocabWord("att betala", "to order"));
		this.add(new VocabWord("att sitta", "to sit"));
	}
}
