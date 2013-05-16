package com.alexismorin.linguage.laps.words.verbs;

import com.alexismorin.linguage.laps.Sentence;
import com.alexismorin.linguage.laps.grammar.Conjugable;
import com.alexismorin.linguage.laps.grammar.Grammar;
import com.alexismorin.linguage.laps.grammar.GrammaticalPerson;
import com.alexismorin.linguage.laps.grammar.Subjecting;
import com.alexismorin.linguage.laps.grammar.errors.NoPronounError;
import com.alexismorin.linguage.laps.words.Verb;
import com.alexismorin.linguage.laps.words.Word;

public class Äta_Word extends Verb implements Conjugable, Grammar{

	public Äta_Word() {
		super("att äta");
	}
	
	@Override
	public String conjugate(int person, String tense) {
		/**
		 * @returns conjugated form of the verb
		 */
		if (tense.equals("present")) {
			return "äter";
		}
		
		if (tense.equals("past")) {
			return "åt";
		}
		
		if(tense.equals("infinitive")){
			return "att äta";
		}

		return null;
	}
	
	@Override
	public boolean do_grammar(Sentence sentence, int i) {
		this.errors.clear();
		int gramPerson;
		Word prevWord = sentence.getPrevWord(i);
		String tense = sentence.findTimeIndicator();
		
		//previous word should be of a grammatical person and be a potential subject
		if (prevWord instanceof GrammaticalPerson && prevWord instanceof Subjecting){
			gramPerson = ((GrammaticalPerson) prevWord).person();
			
			this.setWord(this.conjugate(gramPerson, tense));
			return true;
		}
		else{
			this.setWord(this.conjugate(0, "infinitive"));
			this.errors.add(new NoPronounError());
			
			return false;
		}
	}

}
