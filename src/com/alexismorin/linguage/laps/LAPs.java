package com.alexismorin.linguage.laps;

import com.alexismorin.linguage.laps.mouse.MouseEvent;

import android.view.MotionEvent;
import processing.core.PApplet;

public class LAPs extends PApplet {

	int sceneNo;
	LapsScene currentScene;//touch events will be sent to this guy
	Scene lapsScene;
	WinScene winScene;
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
			lapsScene.update();
			lapsScene.draw();
			if(lapsScene.points >= lapsScene.pointsToWin){
				sceneNo++;
			}
			break;
		case 2:
			if(winScene == null){
				winScene = new WinScene(this, lapsScene.numberOfSentences);
				currentScene = winScene;
			}
			break;
		}
	}

	public void setupVariables() {
		board = new Board(this);
		board.makeWords();

		lapsScene = new Scene(this, board);
		currentScene = lapsScene;
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
			currentScene.onMouseEvent(new MouseEvent(Config.MOUSE_PRESSED, mouseX, mouseY));
			break;
		case MotionEvent.ACTION_UP:
			touchEvent = "UP";
			currentScene.onMouseEvent(new MouseEvent(Config.MOUSE_RELEASED, mouseX, mouseY));
			break;
		case MotionEvent.ACTION_MOVE:
			touchEvent = "MOVE";
			currentScene.onMouseEvent(new MouseEvent(Config.MOUSE_DRAGGED, mouseX, mouseY));
			break;
		default:
			touchEvent = "OTHER (CODE " + action + ")";  // default text on other event
		}
		
		return super.dispatchTouchEvent(event);
	}
}