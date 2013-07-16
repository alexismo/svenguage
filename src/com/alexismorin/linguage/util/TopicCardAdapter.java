package com.alexismorin.linguage.util;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.alexismorin.linguage.se.sv.R;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TopicCardAdapter extends ArrayAdapter<TopicCard> {

	private Context context;
	private ArrayList<TopicCard> values;
	private LayoutInflater inflater;
	
	public class TopicListItem {
		TextView nameText, descText;
		ImageView topicIcon;
	}
	
	public TopicCardAdapter(Context context, int resource, ArrayList<TopicCard> commandsList) {
		super(context, R.layout.card_list_item, commandsList);
		this.context = context;
		values = new ArrayList<TopicCard>();
		values.addAll(commandsList);
		inflater = LayoutInflater.from(this.context);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		TopicListItem myListItem;
		
		String topicName = getItem(position).name;
		String topicDesc = getItem(position).description;
		int topicIcon	 = getItem(position).imageResId;
		
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
		myListItem.topicIcon.setImageResource(topicIcon);
		
		return convertView;
	}


}
