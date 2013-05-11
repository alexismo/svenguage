package com.alexismorin.linguage.util;

public class VocabFlavorImage implements VocabularyListItem{
	int imageResource;

	public VocabFlavorImage(int imageResource) {
		super();
		this.imageResource = imageResource;
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
}
