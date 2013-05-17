package com.alexismorin.linguage.laps;


import com.alexismorin.linguage.laps.mouse.MouseEvent;

import processing.core.PApplet;
import processing.core.PFont;

public class WinScene extends LapsScene{
	PApplet parent;
	PFont fontMega;
	int numberOfSentences;
	int fontSize = 60;
	
	public WinScene(PApplet p, int numSentences) {
		super();
		this.parent = p;
		this.numberOfSentences = numSentences;
		fontMega = parent.createFont("SansSerif", fontSize);
		parent.strokeWeight(0);
		
		//grey overlay
		parent.fill(0, 100);
		parent.rect(0,0,parent.width, parent.height);
		
		//white rectangle
		parent.fill(255);
		parent.rect(parent.width/5, parent.height/5, (parent.width/5)*3, (parent.height/5)*3);
		
		//write in that shit
		parent.fill(0);//black text
		parent.textFont(fontMega);
		parent.text("Congratulations,\nYou built "+numberOfSentences+" sentences!", parent.width/5+fontSize, parent.height/4 + fontSize);
		//instructions to go back
		parent.text("Touch to go back.", parent.width/5+fontSize, (parent.height/4)*2 + 2*(fontSize));
	}
	
	public void onMouseEvent(MouseEvent e) {
		if(e.type == Config.MOUSE_RELEASED){
			parent.exit();
		}
	}
}
