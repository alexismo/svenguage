package com.alexismorin.linguage.util;

public class TopicCard {

	public String name, description;
	public int imageResId;
	public TopicCard(String title, String subTitle, int imageResId) {
		super();
		this.name = title;
		this.description = subTitle;
		this.imageResId = imageResId;
	}
}
