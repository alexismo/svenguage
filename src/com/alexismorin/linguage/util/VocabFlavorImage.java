package com.alexismorin.linguage.util;

public class VocabFlavorImage implements VocabularyListItem{
	String imageURL;

	public String getImageResource() {
		return imageURL;
	}

	public VocabFlavorImage(String imageURL) {
		super();
		this.imageURL = imageURL;
	}

	@Override
	public boolean is_flavor_image() {
		return true;
	}

	@Override
	public boolean is_word() {
		return false;
	}

	@Override
	public boolean is_sentence() {
		return false;
	}

	@Override
	public boolean is_reply() {
		return false;
	}
}
