package model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class LinguageChallengeStub implements Serializable{
	@SerializedName("id")
	private
	int id;
	@SerializedName("type")
	String type;
	/*@SerializedName("source_lang")
	String source_lang;
	@SerializedName("target_lang")
	String target_lang;*/
	@SerializedName("title")
	private	String title;
	@SerializedName("subtitle")
	private	String subtitle;
	@SerializedName("icon_url")
	private String icon_url;
	/*@SerializedName("completed")
	boolean completed;*/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getIconUrl() {
		return icon_url;
	}
	public void setIconUrl(String icon) {
		this.icon_url = icon;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}