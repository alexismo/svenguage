package com.alexismorin.linguage.laps;

import java.util.ArrayList;

import org.apache.commons.lang3.text.WordUtils;

import com.alexismorin.linguage.laps.grammar.*;
import com.alexismorin.linguage.laps.grammar.errors.NoVerbInSentenceError;
import com.alexismorin.linguage.laps.grammar.errors.SentenceError;
import com.alexismorin.linguage.laps.grammar.errors.StartsWithError;
import com.alexismorin.linguage.laps.words.Pronoun;
import com.alexismorin.linguage.laps.words.Verb;
import com.alexismorin.linguage.laps.words.Word;

public class Sentence {
	WordList sentenceWords;
	boolean hasErrors = false;
	boolean hasChanged = true;
	ArrayList<SentenceError> errors;
	String tense;

	public Sentence() {
		errors = new ArrayList<SentenceError>();
		sentenceWords = new WordList();
		tense = "present";
	}

	public void setWords(ArrayList<Word> newWords) {
		sentenceWords.clear();
		sentenceWords = new WordList();

		sentenceWords.addAll(newWords);
	}
	
	public int size(){
		return sentenceWords.size();
	}

	@Override
	public String toString() {
		String sentence = "";

		for (int i = 0; i < sentenceWords.size(); i++) {
			Word w = sentenceWords.get(i);
			String s = w.getWord();

			if (i == 0) {// capitalize
				s = WordUtils.capitalize(s);
			}
			
			if(w instanceof IsSuffix && i > 0){//can't be the 1st word
				if(((IsSuffix)w).isSuffix()){
					//if it's a suffix, remove the previous space
					String charToDel = (String) sentence.substring(sentence.length()-1);
					if(charToDel.equals(" ")){
						sentence = (String) sentence.substring(0, sentence.length()-1);
					}
				}
			}
			
			if (i == sentenceWords.size() - 1) {
				sentence += s + ".";// add period
			} else {
				sentence += s + " ";// add a space
			}
		}

		return sentence;
	}

	public void checkSentenceGrammar() {
		hasErrors = false;
		errors.clear();
		boolean hasVerb = false;
		boolean wordsHaveErrors = false;

		for (int i = 0; i < sentenceWords.size(); i++) {
			Word w = sentenceWords.get(i);
			if (w instanceof Grammar && w.snapped) {
				Word prevW = getPrevWord(i);
				Word nextW = getNextWord(i);
				w.do_grammar(this, i);
				
				// start checking for sentence-wide errors
				if (i == 0) {// for starting word
					if (w instanceof Pronoun || w instanceof TimeIndicator ) {
					} else {
						errors.add(new StartsWithError());
					}
				}

				if (w instanceof Verb && !hasVerb) {
					hasVerb = true;
				}
				
				if(w instanceof TimeIndicator){
					tense = ((TimeIndicator) w).getTense();
				}
				
				if(w.hasErrors()){
					wordsHaveErrors = true;
				}
			}
		}
		
		if (!hasVerb) {
			NoVerbInSentenceError e = new NoVerbInSentenceError();
			if (!errors.contains(e))//we don't want duplicate errors
				errors.add(e);
		}

		//if either any of the words has an error or the sentence has an error
		if (errors.size() > 0 || wordsHaveErrors) {
			hasErrors = true;
		}
	}
	
	public boolean hasErrors(){
		return hasErrors;
	}

	public Word getNextWord(int i) {
		if (i < sentenceWords.size() - 1) {
			return sentenceWords.get(i + 1);
		} else {
			return null;
		}
	}

	public Word getPrevWord(int i) {
		if (i > 0) {
			return sentenceWords.get(i - 1);
		} else {
			return null;
		}
	}

	public String findTimeIndicator() {
		for (int i = 0; i < sentenceWords.size(); i++) {
			Word w = sentenceWords.get(i);
			if(w instanceof TimeIndicator){
				return ((TimeIndicator)w).getTense();
			}
		}
		return "present";//default value
	}
	
	public void /*Word*/ findByType(){
		//http://stackoverflow.com/questions/4516609/java-reflection-and-interface-as-parameter
		
	}
}
