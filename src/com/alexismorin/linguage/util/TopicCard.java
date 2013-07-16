package com.alexismorin.linguage.util;

public class TopicCard {

	
	public String name, description;
	public int imageResId, topicId;
	
	public TopicCard(String title, String subTitle, int imageResId, int topicId) {
		super();
		this.name = title;
		this.description = subTitle;
		this.imageResId = imageResId;
		this.topicId = topicId;
	}
}
