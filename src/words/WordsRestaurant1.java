package words;

import java.util.ArrayList;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.util.VocabFlavorImage;
import com.alexismorin.linguage.util.VocabWord;
import com.alexismorin.linguage.util.VocabularyListItem;

public class WordsRestaurant1 extends ArrayList<VocabularyListItem> {
	public WordsRestaurant1(){
		this.add(new VocabFlavorImage(R.drawable.restaurant));
		
		this.add(new VocabWord("en restaurang"));
		this.add(new VocabWord("en stol"));
		this.add(new VocabWord("ett bord"));
		this.add(new VocabWord("en bar"));
		this.add(new VocabWord("en servitör"));
		this.add(new VocabWord("en meny"));
		this.add(new VocabWord("en lunch"));
		this.add(new VocabWord("en middag"));
		this.add(new VocabWord("en fika"));
		this.add(new VocabWord("en servett"));
		this.add(new VocabWord("en nota"));
		this.add(new VocabWord("att beställa"));
		this.add(new VocabWord("att äta"));
		this.add(new VocabWord("att betala"));
		this.add(new VocabWord("att sitta"));
	}
}
