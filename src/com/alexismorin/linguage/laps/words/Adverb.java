package com.alexismorin.linguage.laps.words;

import com.alexismorin.linguage.laps.Sentence;
import com.alexismorin.linguage.laps.grammar.Grammar;
import com.alexismorin.linguage.laps.grammar.GrammaticalNumber;
import com.alexismorin.linguage.laps.grammar.Pluralizable;
import com.alexismorin.linguage.laps.grammar.errors.NoArticleError;

public abstract class Adverb extends Word implements Grammar{

	public Adverb(String word) {
		super(word);
	}
}
