package com.alexismorin.linguage.laps;

import java.util.Comparator;

import com.alexismorin.linguage.laps.words.Word;

public class WordPositionComparator implements Comparator<Word> {

	@Override
	public int compare(Word o1, Word o2) {
			
		return (int) o1.pos.x - (int)o2.pos.x;
	}
}
