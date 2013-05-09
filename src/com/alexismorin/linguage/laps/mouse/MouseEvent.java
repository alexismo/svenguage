package com.alexismorin.linguage.laps.mouse;

import processing.core.PVector;

public class MouseEvent{
	public PVector mousePos;
	public int type;

	public MouseEvent(int type, float posX, float posY) {
		this.type = type;
		mousePos = new PVector(posX, posY);
	}

}