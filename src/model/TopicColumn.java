package model;

import java.io.Serializable;
import java.util.ArrayList;

import android.support.v4.view.ViewPager;

import com.alexismorin.linguage.util.VocabFlavorImage;
import com.alexismorin.linguage.util.VocabularyListItem;
import com.google.gson.annotations.SerializedName;

public class TopicColumn implements Serializable{
	@SerializedName("id")
	int id;
	@SerializedName("type")
	String type;
	@SerializedName("title")
	String title;
	@SerializedName("header_url")
	String header_url;
	@SerializedName("header_author")
	String header_author;
	@SerializedName("source_lang")
	Language source_lang;
	@SerializedName("target_lang")
	Language target_lang;
	@SerializedName("words")
	ArrayList<Word> words;
	@SerializedName("column_order")
	int column_order;
	
	public ArrayList<VocabularyListItem> toVocabListItems(){
		ArrayList<VocabularyListItem> list = new ArrayList<VocabularyListItem>();
		/**
		 * make a list that can be digested by {@link VocabularySectionFragment};
		 */
		//flavor image first, then words
		list.add(new VocabFlavorImage(header_url, header_author));
		list.addAll(words);
		return list;
	}

	public String getTitle() {
		return title;
	}
}