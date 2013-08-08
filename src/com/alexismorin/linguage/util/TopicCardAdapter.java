package com.alexismorin.linguage.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import model.LinguageChallengeStub;

import com.alexismorin.linguage.se.sv.R;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TopicCardAdapter extends ArrayAdapter<LinguageChallengeStub> {

	private Context context;
	private ArrayList<LinguageChallengeStub> values;
	private LayoutInflater inflater;
	
	public class TopicListItem {
		TextView nameText, descText;
		ImageView topicIcon;
	}
	
	public TopicCardAdapter(Context context, int resource, Collection<LinguageChallengeStub> commandsList) {
		super(context, R.layout.card_list_item);
		this.context = context;
		values = new ArrayList<LinguageChallengeStub>();
		values.addAll(commandsList);
		inflater = LayoutInflater.from(this.context);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		TopicListItem myListItem;
		
		String topicName = getItem(position).getTitle();
		String topicDesc = getItem(position).getSubtitle();
		String topicIcon = getItem(position).getIconUrl();
		
		if(convertView == null) {
			convertView = inflater.inflate(R.layout.card_list_item, parent, false);
			myListItem = new TopicListItem();
			
			myListItem.nameText = (TextView) convertView.findViewById(R.id.topic_name);
			myListItem.descText = (TextView) convertView.findViewById(R.id.topic_description);
			myListItem.topicIcon = (ImageView) convertView.findViewById(R.id.topic_icon);
			
			convertView.setTag(myListItem);
		} else {
			myListItem = (TopicListItem) convertView.getTag();
		}
		
		myListItem.nameText.setText(topicName);
		myListItem.descText.setText(topicDesc);
		Picasso.with(context).load(topicIcon).into(myListItem.topicIcon);
		
		return convertView;
	}
}
