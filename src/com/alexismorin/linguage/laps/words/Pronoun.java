package com.alexismorin.linguage.laps.words;

import com.alexismorin.linguage.laps.Color;
import com.alexismorin.linguage.laps.Sentence;
import com.alexismorin.linguage.laps.grammar.Grammar;
import com.alexismorin.linguage.laps.grammar.LinkTo;
import com.alexismorin.linguage.laps.grammar.Subjecting;
import com.alexismorin.linguage.laps.grammar.errors.NoVerbError;


public abstract class Pronoun extends Word implements Subjecting, Grammar, LinkTo {
	Word linkToThis;
	
	public Pronoun(String word) {
		super(word);
		this.wordColor = new Color(246, 142, 80);
	}

	@Override
	public boolean is_subject(Word followingWord) {
		return followingWord instanceof Verb;
	}

	@Override
	public boolean do_grammar(Sentence sentence, int i) {
		this.errors.clear();
		Word nextWord = sentence.getNextWord(i);
		
		if(is_subject(nextWord)){
			linkToThis = nextWord;
		}else{
			this.errors.add(new NoVerbError());
			linkToThis = null;
		}
		
		if(this.errors.size() == 0)	
			return true;
		else
			return false;
	}
	
	@Override
	public Word linkToWord(){
		return linkToThis;
	}
}