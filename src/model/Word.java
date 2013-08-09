package model;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Word implements Serializable{
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
}