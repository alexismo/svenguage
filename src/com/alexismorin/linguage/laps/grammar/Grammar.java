package com.alexismorin.linguage.laps.grammar;

import com.alexismorin.linguage.laps.Sentence;



public interface Grammar {
/**
 * A series of grammatical requirements.
 */
	boolean do_grammar(Sentence sentence, int wordIndex);
}
