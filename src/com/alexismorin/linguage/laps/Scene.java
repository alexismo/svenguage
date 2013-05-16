package com.alexismorin.linguage.laps;

import com.alexismorin.linguage.laps.words.Word;
import com.alexismorin.linguage.laps.grammar.Conjugable;
import com.alexismorin.linguage.laps.grammar.Pluralizable;
import com.alexismorin.linguage.laps.grammar.LinkTo;
import com.alexismorin.linguage.laps.grammar.IsSuffix;
import com.alexismorin.linguage.laps.grammar.errors.SentenceError;
import com.alexismorin.linguage.laps.grammar.errors.WordError;
import com.alexismorin.linguage.laps.mouse.MouseEvent;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

public class Scene {
	PApplet parent;
	PFont font;
	PFont fontLarge;
	PFont fontMega;
	Board board;
	Sentence sentence;
	boolean firstTouched = false;//for the intro message

	public Scene(PApplet p, Board board) {
		super();
		this.parent = p;
		this.board = board;
		font = parent.createFont("SansSerif", 28);
		fontLarge = parent.createFont("Sans Serif", 48);
		fontMega = parent.createFont("SansSerif", 80);
	}

	void update() {
		for (int i = 0; i < board.words.size(); i++) {
			Word w = board.words.get(i);
			if (w.pos == null) {// create a default position for the words.
								// simplifies instanciation
				w.pos = new PVector(Config.wordSize * (i + 1) + 20/*margin*/, Config.wordSize/2);//rectMode is CORNER
			}

			if (!w.snapped) {// change the words back to singular / infinitive
								// forms

				if (w instanceof Conjugable) {
					w.setWord(((Conjugable) w).conjugate(0, "infinitive"));
				}

				if (w instanceof Pluralizable) {
					w.setWord(((Pluralizable) w).pluralize(1));
				}
			}

		}
	}

	void draw() {
		parent.background(255);
		parent.strokeWeight(4);
		parent.noFill();
		parent.ellipseMode(parent.CENTER);

		//draw the words atop zone
		parent.fill(200);
		parent.noStroke();
		parent.rect(0,  0, parent.width, 2*Config.wordSize);
		parent.noFill();
		
		// draw the word line
		parent.stroke(38, 133, 36);
		parent.line(0, parent.height / 2, parent.width, parent.height / 2);
		
		// draw tiles
		drawTiles();
		drawSentence();
		
		//if not touched yet
		if(!firstTouched){
			parent.fill(0, 200);
			parent.rect(0, 0, parent.width, parent.height);
			
			parent.textFont(fontMega);
			//parent.stroke(0);
			parent.fill(240);
			parent.text("Drag words from the gutter \nonto the green sentence line \nto score points.",
					parent.width/40, parent.height/4);
			
			parent.textFont(fontLarge);
			parent.text("Touch anywhere to start.",
					parent.width/40, (parent.height/3)*2);
		}
	}

	void drawTiles() {
		parent.rectMode(parent.CORNER);
		parent.textFont(font);

		sentence = board.makeSentence();
		sentence.checkSentenceGrammar();

		int indexInSentence = -1;
		for (int i = 0; i < board.words.size(); i++) {
			Word w = board.words.get(i);

			parent.stroke(0);// paint word outline the default color: black

			if (w.snapped) {
				indexInSentence++;
				if (w.do_grammar(sentence, indexInSentence)) {
					parent.stroke(38, 133, 36);// paint it green for correct
												// grammar
					// draw a bezier, like a bawss
					if (w instanceof LinkTo) {
						if(((LinkTo) w).linkToWord() != null){
							Word linkTo =((LinkTo) w).linkToWord(); 
							drawBezier(w, linkTo);
							
							if(w instanceof IsSuffix){
								if(((IsSuffix)w).isSuffix() && board.dragger.getTargetWord() != w){
									w.pos.x = linkTo.pos.x+Config.wordSize;
									w.pos.y = linkTo.pos.y;
								}
							}
							
						}
					}
				} else {
					parent.stroke(205, 24, 24);// paint it red for bad grammar
				}
			}else{
				if(w.errors.size() > 0){
					w.errors.clear();
				}
			}

			// finish drawing the tile
			parent.fill(Config.tileColor);
			parent.rect(w.pos.x, w.pos.y, Config.wordSize, Config.wordSize);

			//draw word-specific errors
			if (w.errors.size() > 0) {
				parent.fill(205, 24, 24);
				for (int j = 0; j < w.errors.size(); j++) {
					WordError e = w.errors.get(j);
					
					parent.text(e.getErrorMsg(), w.pos.x, w.pos.y + Config.wordSize + (j+1)*20);
				}
			}

			// draw the words from the tiles
			parent.fill(0);
			parent.text(w.getWord(), w.pos.x + 10, w.pos.y + Config.wordSize
					/ 2);

			parent.text(sentence.sentenceWords.size(), 10, parent.height - 50);
		}

		// draw the errors (global sentence validation)
		if (sentence.hasErrors) {
			parent.fill(205, 24, 24);//red
			parent.textAlign(parent.CENTER);
			// draw the error
			for (int i = 0; i < sentence.errors.size(); i++) {
				SentenceError e = sentence.errors.get(i);
				parent.text(e.getMessage(), parent.width / 2,
						(float) (parent.height * 0.65 + ((i + 1) * 30)));
			}
		}
	}

	void drawSentence(){
		// draw the Sentence
		if(sentence.hasErrors())
			parent.fill(205, 24, 24);
		
		parent.textAlign(parent.CENTER);
		parent.textFont(fontLarge);
		parent.text(board.getSentenceString(), parent.width / 2,
				parent.height - 100);
		
		//reset to what it was
		parent.textFont(font);
		parent.textAlign(parent.LEFT);
	}
	
	void drawBezier(Word w1, Word w2) {
		// center of the 1st word
		parent.noFill();
		parent.bezier(w1.pos.x + Config.wordSize / 2, w1.pos.y
				+ Config.wordSize / 2, w1.pos.x + Config.wordSize / 2, w1.pos.y
				- Config.wordSize, w2.pos.x + Config.wordSize / 2, w2.pos.y
				- Config.wordSize, w2.pos.x + Config.wordSize / 2, w2.pos.y
				+ Config.wordSize / 2);
	}

	void onMouseEvent(MouseEvent e) {
		if(!firstTouched){
			firstTouched = true;
		}
		board.onMouseEvent(e);
	}
}
