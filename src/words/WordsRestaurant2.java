package words;

import java.util.ArrayList;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.util.VocabFlavorImage;
import com.alexismorin.linguage.util.VocabWord;
import com.alexismorin.linguage.util.VocabularyListItem;


public class WordsRestaurant2 extends ArrayList<VocabularyListItem> {

	public WordsRestaurant2(){
		this.add(new VocabFlavorImage("http://alexismorin.com/svenguage/restaurant2.jpg"));
		
		this.add(new VocabWord("Får vi beställa?", "May we order?"));
		this.add(new VocabWord("Ursäkta, skulle vi kunna få beställa?", "Excuse me, may we please order?"));
		this.add(new VocabWord("Jag skulle vilja ha [en räkmacka].", "I would like to have a [shrimp sandwich]"));
		this.add(new VocabWord("Vad har ni för dagens lunch?", "What's the lunch of the day?"));
		this.add(new VocabWord("Har ni ett vegetariskt/glutenfritt alternativ?", "Do you have a vegetarian/gluten-free alternative?"));
		this.add(new VocabWord("Jag ska ta [en chokladboll].", "I'll have a [chocolate ball]."));
		this.add(new VocabWord("Ingår kaffet?", "Is coffee included?"));
		this.add(new VocabWord("Vi delar notan.", "We'll split the bill."));
		this.add(new VocabWord("Jag tar hela notan.", "I'll take the bill."));
		this.add(new VocabWord("Vad ska du ha?", "What will you be having?"));
	}
}