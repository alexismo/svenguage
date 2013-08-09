package model;

import java.io.Serializable;
import java.util.ArrayList;

import com.alexismorin.linguage.util.VocabularyListItem;
import com.google.gson.annotations.SerializedName;

public class Word implements Serializable, VocabularyListItem{
	@SerializedName("id")
	int id;
	// times_seen;
	@SerializedName("word_source")
	String word_source;
	@SerializedName("word_target")
	String word_target;
	@SerializedName("language")
	Language language;
	@SerializedName("sounds")
	ArrayList<Sound> sounds;
	
	
	
	public String getWord_source() {
		return word_source;
	}

	public String getWord_target() {
		return word_target;
	}

	public Language getLanguage() {
		return language;
	}

	public ArrayList<Sound> getSounds() {
		return sounds;
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
		return false;
	}
}