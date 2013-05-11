package com.alexismorin.linguage.util;

import java.util.List;

import com.alexismorin.linguage.se.sv.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VocabularyAdapter extends BaseAdapter {

	private Context context;
	private List<VocabularyListItem> vocabListItems;
	
	private static final int ITEM_VIEW_TYPE_SEPARATOR = 0;
	private static final int ITEM_VIEW_TYPE_FLAVOR_IMAGE = 1;
	private static final int ITEM_VIEW_TYPE_WORD = 2;
	private static final int ITEM_VIEW_TYPE_SENTENCE = 3;
	
	private static final int ITEM_VIEW_TYPE_COUNT = 4;
	
	public VocabularyAdapter(Context context,
			List<VocabularyListItem> vocabListItems) {
		super();
		this.context = context;
		this.vocabListItems = vocabListItems;
	}
	
	@Override
	public int getCount() {
		return vocabListItems.size();
	}

	@Override
	public int getViewTypeCount(){
		return ITEM_VIEW_TYPE_COUNT;
	}
	
	@Override
	public Object getItem(int position) {
		return vocabListItems.get(position);
	}

	static class VocabHolder{
		TextView word;
		ImageView flavor_image;
	}
	
	@Override
	public int getItemViewType(int position) {
		if(vocabListItems.get(position).is_flavor_image())
			return ITEM_VIEW_TYPE_FLAVOR_IMAGE;
		if(vocabListItems.get(position).is_word())
			return ITEM_VIEW_TYPE_WORD;
		else
			return ITEM_VIEW_TYPE_SEPARATOR;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		VocabHolder vocabHolder;
		LayoutInflater m_inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(convertView == null){
			vocabHolder = new VocabHolder();
			if(getItemViewType(position) == ITEM_VIEW_TYPE_FLAVOR_IMAGE){
				convertView = m_inflater.inflate(R.layout.vocab_flavor_image, parent, false);
				
				vocabHolder.flavor_image = (ImageView) convertView.findViewById(R.id.vocab_flavor_image);
			}
			if(getItemViewType(position) == ITEM_VIEW_TYPE_WORD){
				convertView = m_inflater.inflate(R.layout.vocab_word_list_item, parent, false);
				
				vocabHolder.word = (TextView) convertView.findViewById(R.id.vocab_word);
			}
		}else{
			vocabHolder = (VocabHolder) convertView.getTag();
    	}
		
		if(getItemViewType(position) == ITEM_VIEW_TYPE_FLAVOR_IMAGE){
			vocabHolder.flavor_image.setImageDrawable(context.getResources().getDrawable(R.drawable.baby));
		}
		if(getItemViewType(position) == ITEM_VIEW_TYPE_WORD){
			Log.i("Word","It's a word");
			VocabWord word = (VocabWord) getItem(position);
			vocabHolder.word.setText(word.getWord());
		}
		
		return convertView;
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}
}
