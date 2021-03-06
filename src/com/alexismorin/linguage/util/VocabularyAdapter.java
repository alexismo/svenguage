package com.alexismorin.linguage.util;

import java.util.List;

import model.Word;

import com.alexismorin.linguage.se.sv.R;
import com.squareup.picasso.Picasso;

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
	private static final int ITEM_VIEW_TYPE_REPLY = 4;
	
	private static final int ITEM_VIEW_TYPE_COUNT = 5;
	
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
		ImageView flavorImageView, convLeftTextView, convRightTextView;
	}
	
	@Override
	public int getItemViewType(int position) {
		if(vocabListItems.get(position).is_flavor_image())
			return ITEM_VIEW_TYPE_FLAVOR_IMAGE;
		if(vocabListItems.get(position).is_word())
			return ITEM_VIEW_TYPE_WORD;
		if(vocabListItems.get(position).is_reply())
			return ITEM_VIEW_TYPE_REPLY;
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
				
				vocabHolder.flavorImageView = (ImageView) convertView.findViewById(R.id.vocab_flavor_image);
			}
			if(getItemViewType(position) == ITEM_VIEW_TYPE_WORD){
				convertView = m_inflater.inflate(R.layout.vocab_word_list_item, parent, false);
				
				vocabHolder.word = (TextView) convertView.findViewById(R.id.vocab_word);
			}
			if(getItemViewType(position) == ITEM_VIEW_TYPE_REPLY){
				convertView = m_inflater.inflate(R.layout.vocab_reply_list_item, parent, false);
				
				vocabHolder.word = (TextView) convertView.findViewById(R.id.vocab_word);
				vocabHolder.convLeftTextView = (ImageView) convertView.findViewById(R.id.conv_head_left);
				vocabHolder.convRightTextView = (ImageView) convertView.findViewById(R.id.conv_head_right);
			}
			
			convertView.setTag(vocabHolder);
		}else{
			vocabHolder = (VocabHolder) convertView.getTag();
    	}
		
		if(getItemViewType(position) == ITEM_VIEW_TYPE_FLAVOR_IMAGE){
			VocabFlavorImage flvrImg = (VocabFlavorImage) getItem(position);
			
			Picasso.with(context).load(flvrImg.imageURL).into(vocabHolder.flavorImageView);
		}
		if(getItemViewType(position) == ITEM_VIEW_TYPE_WORD){
			Word word = (Word) getItem(position);
			//show the word in the target language to invite user to click on it
			vocabHolder.word.setText(word.getWord_target());
		}
		if(getItemViewType(position) == ITEM_VIEW_TYPE_REPLY){
			VocabReply reply = (VocabReply) getItem(position);
			vocabHolder.word.setText(reply.getWord_source());
			if(reply.getSpeakerSide() == 0){
				vocabHolder.convLeftTextView.setImageDrawable(context.getResources().getDrawable(reply.conversationalistDrawable));
				vocabHolder.convRightTextView.setImageResource(0);
			}
			if(reply.getSpeakerSide() == 1){
				vocabHolder.convRightTextView.setImageDrawable(context.getResources().getDrawable(reply.conversationalistDrawable));
				vocabHolder.convLeftTextView.setImageResource(0);
			}
		}
		
		
		return convertView;
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}
}
