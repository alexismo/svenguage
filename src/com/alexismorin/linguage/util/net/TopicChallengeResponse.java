package com.alexismorin.linguage.util.net;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import model.TopicChallenge;

import com.google.gson.annotations.SerializedName;

public class TopicChallengeResponse extends ServiceResponse implements Serializable{
	@SerializedName("challenge")
	ArrayList<TopicChallenge> challenge;
}
