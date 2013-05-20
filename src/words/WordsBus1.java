package words;

import java.util.ArrayList;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.util.VocabFlavorImage;
import com.alexismorin.linguage.util.VocabWord;
import com.alexismorin.linguage.util.VocabularyListItem;

public class WordsBus1 extends ArrayList<VocabularyListItem> {
	public WordsBus1(){
		this.add(new VocabFlavorImage(R.drawable.bus));
		
		this.add(new VocabWord("en buss", "a bus"));
		this.add(new VocabWord("en biljett", "a ticket"));
		this.add(new VocabWord("en ungdomsbiljett", "a youth ticket"));
		this.add(new VocabWord("en chaufför", "a driver"));
		this.add(new VocabWord("en busshållplats", "a bus stop"));
		this.add(new VocabWord("att köpa en biljett", "to buy a ticket"));
		this.add(new VocabWord("att åka buss", "to ride the bus"));
	}
}