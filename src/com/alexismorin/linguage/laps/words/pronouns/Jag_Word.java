package com.alexismorin.linguage.laps.words.pronouns;

import com.alexismorin.linguage.laps.grammar.GrammaticalNumber;
import com.alexismorin.linguage.laps.grammar.GrammaticalPerson;
import com.alexismorin.linguage.laps.grammar.Subjecting;
import com.alexismorin.linguage.laps.words.Pronoun;
import com.alexismorin.linguage.laps.words.Verb;
import com.alexismorin.linguage.laps.words.Word;

public class Jag_Word extends Pronoun implements GrammaticalNumber, GrammaticalPerson, Subjecting{

	public Jag_Word() {
		super("jag");
	}

	@Override
	public int number() {
		return 1;
	}

	@Override
	public int person() {
		return 1;
	}
	
	@Override
	public boolean is_subject(Word followingWord){
		if(followingWord instanceof Verb)
			return true;
		else
			return false;
	}
}