package words;

import java.util.ArrayList;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.util.VocabFlavorImage;
import com.alexismorin.linguage.util.VocabWord;
import com.alexismorin.linguage.util.VocabularyListItem;

public class WordsBus1 extends ArrayList<VocabularyListItem> {
	public WordsBus1(){
		this.add(new VocabFlavorImage(R.drawable.bus));
		
		this.add(new VocabWord("en buss"));
		this.add(new VocabWord("en biljett"));
		this.add(new VocabWord("en chaufför"));
		this.add(new VocabWord("en busshållplats"));
		this.add(new VocabWord("ungdomsbiljett"));
		this.add(new VocabWord("vuxenbiljett"));
		this.add(new VocabWord("att köpa en biljett"));
		this.add(new VocabWord("att åka buss"));
	}
}