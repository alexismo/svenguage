package com.alexismorin.linguage.util;

public class VocabReply extends VocabWord {

	int side, conversationalistDrawable;
	
	public int getSpeakerSide() {
		return side;
	}

	public int getConversationalistDrawable() {
		return conversationalistDrawable;
	}

	public VocabReply(String word, int side, int conversationalistDrawable) {
		super(word, "");
		this.side = side;
		this.conversationalistDrawable = conversationalistDrawable;
	}
	
	@Override
	public boolean is_word() {
		return false;
	}
	
	@Override
	public boolean is_reply() {
		return true;
	}
}