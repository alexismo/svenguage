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
import android.widget.TextView;

public class NowArrayAdapter extends ArrayAdapter<String> {

	private Context context;
	private ArrayList<String> values;
	private Typeface typeface;
    private static Hashtable fontCache = new Hashtable();
	private LayoutInflater inflater;
	
	public class CustomListItem {
		TextView descText;
	}
	
	public NowArrayAdapter(Context context, int resource, ArrayList<String> commandsList) {
		// TODO Auto-generated constructor stub
		super(context, R.layout.list_item, commandsList);
		this.context = context;
		values = new ArrayList<String>();
		values.addAll(commandsList);
		//typeface = getTypeface(this.context, "fonts/Roboto-Light.ttf");
		inflater = LayoutInflater.from(this.context);
	}

    static Typeface getTypeface(Context context, String font) {
        Typeface typeface = (Typeface) fontCache.get(font);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(context.getAssets(), font);
            fontCache.put(font, typeface);
        }
        return typeface;
    }

	public View getView(int position, View convertView, ViewGroup parent) {
		
		CustomListItem myListItem;
		
		String myText = getItem(position);
		
		if(convertView == null) {
			convertView = inflater.inflate(R.layout.list_item, parent, false);
			myListItem = new CustomListItem();
			
			myListItem.descText = (TextView) convertView.findViewById(R.id.commandText);
			//myListItem.descText.setTypeface(typeface);
			
			convertView.setTag(myListItem);
		} else {
			myListItem = (CustomListItem) convertView.getTag();
		}
		
		myListItem.descText.setText(myText);
		//myListItem.descText.setTextSize(14);
		
		return convertView;
	}


}
