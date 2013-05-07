package com.alexismorin.linguage.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.alexismorin.linguage.se.sv.R;
import com.fima.cardsui.objects.Card;

public class ChallengeCard extends Card {

	public ChallengeCard(String title, String desc){
		super(title, desc);
	}

	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.challenge_card, null);

		((TextView) view.findViewById(R.id.challenge_name)).setText(title);
		((TextView) view.findViewById(R.id.challenge_description)).setText(desc);
		
		return view;
	}
}
