package model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Language implements Serializable{
	@SerializedName("id")
	int id;
	@SerializedName("locale")
	String locale;
	@SerializedName("iso_639_1")
	String iso_639_1;
	@SerializedName("iso_3166_1")
	String iso_3166_1;
	@SerializedName("native_name")
	String native_name;
	@SerializedName("english_name")
	String english_name;
}
