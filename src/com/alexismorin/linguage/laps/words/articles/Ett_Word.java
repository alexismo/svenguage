package com.alexismorin.linguage.laps.words.articles;

import com.alexismorin.linguage.laps.Sentence;
import com.alexismorin.linguage.laps.grammar.Actionnable;
import com.alexismorin.linguage.laps.grammar.Definiteness;
import com.alexismorin.linguage.laps.grammar.GrammaticalGender;
import com.alexismorin.linguage.laps.grammar.GrammaticalNumber;
import com.alexismorin.linguage.laps.grammar.IsArticle;
import com.alexismorin.linguage.laps.grammar.IsSuffix;
import com.alexismorin.linguage.laps.grammar.errors.NoNounError;
import com.alexismorin.linguage.laps.words.Article;
import com.alexismorin.linguage.laps.words.Word;

public class Ett_Word extends Article implements GrammaticalGender, GrammaticalNumber, IsSuffix {
	Word linkToThis;
	boolean isSuffix;
	
	public Ett_Word() {
		super("ett");
		linkToThis = null;
		isSuffix = false;
	}
	
	@Override 
	public boolean do_grammar(Sentence s, int i){
		this.errors.clear();
		Word nWord = s.getNextWord(i);
		Word pWord = s.getPrevWord(i);
		
		if(nWord instanceof Definiteness || pWord instanceof Definiteness){
			
			if(nWord instanceof Definiteness){
				isSuffix = false;
				linkToThis = nWord;
			}
			
			if(pWord instanceof Definiteness){
				isSuffix = true;
				linkToThis = pWord;
			}
			
			return true;
		}else{
			this.errors.add(new NoNounError());
			return false;
		}
	}
	
	@Override
	public String gender() {
		return "neuter";
	}

	@Override
	public int number() {
		return 1;
	}
	
	@Override
	public Word linkToWord() {
		return linkToThis;
	}

	@Override
	public boolean isSuffix() {
		return isSuffix;
	}
}