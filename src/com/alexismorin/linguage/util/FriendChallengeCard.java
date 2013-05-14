package com.alexismorin.linguage.util;

import com.alexismorin.linguage.se.sv.R;
import com.fima.cardsui.objects.Card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class FriendChallengeCard extends Card {

	int friend_image;
	
	public FriendChallengeCard(String title, String desc, int friend_image, int image){
		super(title, desc, image);
		this.friend_image = friend_image;
	}

	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.challenge_friend, null);

		((TextView) view.findViewById(R.id.friend_name)).setText(title);
		((TextView) view.findViewById(R.id.friend_challenge_description)).setText(desc);
		((ImageView) view.findViewById(R.id.friend_challenge_icon)).setImageResource(image);
		((ImageView) view.findViewById(R.id.friend_face)).setImageResource(friend_image);
		
		
		return view;
	}
}
