package com.alexismorin.linguage.laps;

import com.alexismorin.linguage.laps.mouse.MouseEvent;

import android.view.MotionEvent;
import processing.core.PApplet;

public class LAPs extends PApplet {

	int sceneNo;
	Scene scene;
	Board board;
	
	//for touch events;
	String touchEvent = "";    // string for touch event type
	float pressure = 0.0f;      // pressure and size variables
	float pointerSize = 0.0f;

	public void setup() {
		orientation(LANDSCAPE);  // the hot dog way
		size(displayWidth, displayHeight);
		smooth();
		setupVariables();
	}

	public void draw() {
		switch (sceneNo) {
		case 1:
			scene.update();
			scene.draw();
		}
	}

	public void setupVariables() {
		board = new Board(this);
		board.makeWords();

		scene = new Scene(this, board);
		sceneNo = 1;
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent event){
		float mouseX = event.getX(); //get the position of touch event 
		float mouseY = event.getY();
		
		int action = event.getActionMasked();
		pressure = event.getPressure();
		pointerSize = event.getSize();
		
		
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			touchEvent = "DOWN";
			scene.onMouseEvent(new MouseEvent(Config.MOUSE_PRESSED, mouseX, mouseY));
			break;
		case MotionEvent.ACTION_UP:
			touchEvent = "UP";
			scene.onMouseEvent(new MouseEvent(Config.MOUSE_RELEASED, mouseX, mouseY));
			break;
		case MotionEvent.ACTION_MOVE:
			touchEvent = "MOVE";
			scene.onMouseEvent(new MouseEvent(Config.MOUSE_DRAGGED, mouseX, mouseY));
			break;
		default:
			touchEvent = "OTHER (CODE " + action + ")";  // default text on other event
		}
		
		return super.dispatchTouchEvent(event);
	}
}