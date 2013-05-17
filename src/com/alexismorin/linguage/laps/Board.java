package com.alexismorin.linguage.laps;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.lang3.text.WordUtils;

import com.alexismorin.linguage.laps.mouse.MouseEvent;
import com.alexismorin.linguage.laps.words.Word;
import com.alexismorin.linguage.laps.words.articles.En_Word;
import com.alexismorin.linguage.laps.words.articles.Ett_Word;
import com.alexismorin.linguage.laps.words.nouns.Tomat_Word;
import com.alexismorin.linguage.laps.words.pronouns.Du_Word;
import com.alexismorin.linguage.laps.words.pronouns.Jag_Word;
import com.alexismorin.linguage.laps.words.verbs.Äta_Word;

import processing.core.PApplet;
import processing.core.PVector;

public class Board {

	PApplet parent;
	WordList words;
	Dragger dragger;
	Sentence sentence;

	public Board(PApplet p) {
		super();
		this.parent = p;
		this.words = new WordList();
		dragger = new Dragger(this, p);
		this.sentence = new Sentence();
	}

	public void makeWords() {
		// English things
		
		/*
		addWord( new Eat_Word() ); 
		addWord( new I_Word() );
		addWord( new You_Word() );
		addWord( new The_Word() ); 
		addWord( new Apple_Word() );
		addWord( new Yesterday_Word() );
		addWord( new She_Word());
		*/
		
		//Swedish things
		
		addWord( new Äta_Word());
		addWord( new Jag_Word());
		addWord( new Ett_Word());
		addWord( new Tomat_Word());
		addWord( new Du_Word());
		addWord( new En_Word());
		
		// French things
		/*
		addWord(new Manger_Word());
		addWord(new Je_Word());
		addWord(new Tu_Word());
		addWord(new Nous_Word());
		addWord(new La_Word());
		addWord(new Le_Word());
		addWord(new Les_Word());
		addWord(new Pomme_Word());
		addWord(new Demain_Word());
		addWord(new Elles_Word());
		*/
	}

	public void addWord(Word w) {
		words.add(w);
	}

	public void sortSentence() {
		words.sort();
	}

	public Sentence makeSentence() {
		/**
		 * @returns a sentence object comprised of all the words on the main line, in order
		 */
		ArrayList<Word> newSentence = new ArrayList<Word>();
		
		for (int i = 0; i < words.size(); i++) {
			Word w = words.get(i);

			if (w.snapped) {
				newSentence.add(w);
			}
		}
		
		this.sentence.setWords(newSentence);

		return this.sentence;
	}
	
	public String toString(){
		return this.sentence.toString();
	}

	public void onMouseEvent(MouseEvent e) {
		dragger.onMouseEvent(e);
	}
}
