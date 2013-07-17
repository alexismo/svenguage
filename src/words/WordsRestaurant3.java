package words;

import java.util.ArrayList;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.util.VocabFlavorImage;
import com.alexismorin.linguage.util.VocabReply;
import com.alexismorin.linguage.util.VocabWord;
import com.alexismorin.linguage.util.VocabularyListItem;


public class WordsRestaurant3 extends ArrayList<VocabularyListItem> {

	public WordsRestaurant3(){
		
		int l = R.drawable.user_face;
		int f = R.drawable.friend;
		int w = R.drawable.waiter;
		
		this.add(new VocabFlavorImage("http://alexismorin.com/svenguage/restaurant3.jpg"));
		
		this.add(new VocabReply("Tja!", 0, l));
		this.add(new VocabReply("Hej. \n Ska ni äta här?", 1, w));
		this.add(new VocabReply("Ja, det ska vi. \n Vart sitter vi?", 0, l));
		this.add(new VocabReply("Följ mig, så visar jag er till era platser.", 1, w));
		this.add(new VocabReply("Tack.", 0, l));
		this.add(new VocabReply("Här är menyerna. Varsågoda.", 1, w));
		this.add(new VocabReply("Vill ni beställa?", 1, w));
		this.add(new VocabReply("Ja tack. \n Jag skulle vilja ha den här fiskgratängen.", 0, l));
		//this.add(new VocabReply("Och jag...får se nu. \n Jag skulle vilja ha pastan med köttfärssås.", 0, f)); //a new drawable doesn't work, somehow
		this.add(new VocabReply("Någonting att dricka?", 1, w));
		this.add(new VocabReply("Ett glas vatten, tack.", 0, l));
	}
}