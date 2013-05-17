package com.alexismorin.linguage.laps;

import processing.core.PVector;

public class ScorePoint {
	PVector cPos;// current
	PVector tPos;// target
	float tick = 0.2f;
	boolean alive = true;

	public ScorePoint(PVector initialPosition, PVector target) {
		super();
		// this.iPos = initialPosition;
		this.cPos = initialPosition;
		this.tPos = target;
	}

	/**
	 * Update the position of the ScorePoint
	 */
	public void tick() {
		if (this.alive && cPos.x - tPos.x < 5) {
			this.alive = false;
		} else {
			this.cPos.x += (tPos.x - cPos.x) * tick;
			this.cPos.y += (tPos.y - cPos.y) * tick;// because increasing Y goes
													// down
		}
	}
}
