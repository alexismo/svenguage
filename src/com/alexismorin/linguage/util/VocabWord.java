package com.alexismorin.linguage.util;

public class VocabWord implements VocabularyListItem {

	String word;
	
	public String getWord() {
		return word;
	}

	public VocabWord(String word) {
		super();
		this.word = word;
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

}
