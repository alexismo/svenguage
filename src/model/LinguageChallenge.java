package model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class LinguageChallenge implements Serializable{
	@SerializedName("id")
	int id;
	@SerializedName("type")
	String type;
	@SerializedName("source_lang")
	Language source_lang;
	@SerializedName("target_lang")
	Language target_lang;
	@SerializedName("title")
	String title;
	@SerializedName("subtitle")
	String subtitle;
	@SerializedName("icon")
	String icon;
	
	/*@SerializedName("completed")
	boolean completed;
	*/
}