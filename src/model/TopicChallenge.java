package model;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class TopicChallenge extends LinguageChallenge implements Serializable {
	@SerializedName("columns")
	public ArrayList<TopicColumn> columns;
}