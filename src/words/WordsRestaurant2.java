package words;

import java.util.ArrayList;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.util.VocabFlavorImage;
import com.alexismorin.linguage.util.VocabWord;
import com.alexismorin.linguage.util.VocabularyListItem;


public class WordsRestaurant2 extends ArrayList<VocabularyListItem> {

	public WordsRestaurant2(){
		this.add(new VocabFlavorImage(R.drawable.restaurant2));
		
		this.add(new VocabWord("Får vi beställa?"));
		this.add(new VocabWord("Ursäkta, skulle vi kunna få beställa?"));
		this.add(new VocabWord("Jag skulle vilja ha [en räkmacka]."));
		this.add(new VocabWord("Vad har ni för dagens lunch?"));
		this.add(new VocabWord("Har ni ett vegetariskt/glutenfritt alternativ?"));
		this.add(new VocabWord("Jag ska ta [en chokladboll]."));
		this.add(new VocabWord("Ingår kaffet?"));
		this.add(new VocabWord("Vi delar notan."));
		this.add(new VocabWord("Jag tar hela notan."));
		this.add(new VocabWord("Vad ska du ha?"));
	}
}