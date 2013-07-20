package com.alexismorin.linguage.util;

public class VocabWord implements VocabularyListItem {

	String word;
	String translation;

	public VocabWord(String word, String translation) {
		super();
		this.word = word;
		this.translation = translation;
	}
	
	public String getWord() {
		return word;
	}
	
	public String getTranslation(){
		return translation;
	}

	@Override
	public boolean is_flavor_image() {
		return false;
	}

	@Override
	public boolean is_word() {
		return true;
	}

	@Override
	public boolean is_sentence() {
		return false;
	}

	@Override
	public boolean is_reply() {
		// TODO Auto-generated method stub
		return false;
	}
}
