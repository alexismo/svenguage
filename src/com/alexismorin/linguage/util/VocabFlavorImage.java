package com.alexismorin.linguage.util;

public class VocabFlavorImage implements VocabularyListItem{
	String imageURL;
	private String author;

	public String getImageResource() {
		return imageURL;
	}

	public VocabFlavorImage(String imageURL, String author) {
		super();
		this.imageURL = imageURL;
		this.setAuthor(author);
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
