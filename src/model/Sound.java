package model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Sound implements Serializable{
	@SerializedName("id")
	int id;
	//times_listened;
	@SerializedName("url")
	String url;
	@SerializedName("accent")
	String accent;
}