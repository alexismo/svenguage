package com.alexismorin.linguage.laps.words;

import java.util.ArrayList;

import com.alexismorin.linguage.laps.Color;
import com.alexismorin.linguage.laps.Config;
import com.alexismorin.linguage.laps.Sentence;
import com.alexismorin.linguage.laps.grammar.errors.WordErrorList;


import processing.core.PVector;

public class Word extends Tile implements Comparable<Word>{

	private String word;
	//public ArrayList<WordError> errors;
	public WordErrorList errors;
	public Color wordColor;

	public Word(PVector pos, String word) {
		super(pos);
		this.word = word;
		this.errors = new WordErrorList();
	}

	public Word(String word) {
		this.word = word;
		this.errors = new WordErrorList();
		this.wordColor = new Color(Config.tileColor, Config.tileColor, Config.tileColor);
	}
	
	public String getWord(){
		return this.word;
	}
	
	public void setWord(String newWord){//use this to set words for conjugation
		this.word = newWord;
	}
	
	public boolean hasErrors(){
		if(this.errors.size() > 0)
			return true;
		else
			return false;
	}
	
	@Override
	public int compareTo(Word o) {
		int compareX = Math.round(((Word) o).pos.x);
		
		return compareX - Math.round(this.pos.x);
	}

	public boolean do_grammar(Word prevWord, Word nextWord) {
		/**
		 * @Deprecated
		 * Override this as soon as possible.
		 */
		return true;
	}
	
	public boolean is_first_word() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean is_last_word() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean do_grammar(Sentence sentence, int i) {
		// TODO Auto-generated method stub
		return false;
	}
}


