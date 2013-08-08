package com.alexismorin.linguage.util.net;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import model.LinguageChallengeStub;

public class FeedResponse extends ServiceResponse implements Serializable{
	@SerializedName("feed")
	public List<LinguageChallengeStub> feed;	
}