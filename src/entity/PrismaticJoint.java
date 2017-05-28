package entity;

import lejos.robotics.RegulatedMotor;

public class PrismaticJoint extends Joint{
	private RegulatedMotor motor;
	private final float WHEELE_RADIUS=2.1f;
	private float currentDistance = -1;
	private final float MIN_DISTANCE = -2;
	private final float MAX_DISTANCE = 26;

	public PrismaticJoint(float a, float alpha, float d, float theta, RegulatedMotor motor) {
		super(a, alpha, d, theta);
		this.motor = motor;
		motor.setSpeed(50);
	}

	public void move(float distance) {
		
		currentDistance+=distance;
		if(currentDistance>MAX_DISTANCE){
			distance = -(currentDistance - MAX_DISTANCE - distance);
			currentDistance = MAX_DISTANCE; 
		}
		if(currentDistance<MIN_DISTANCE){
			distance = -(currentDistance-MIN_DISTANCE-distance);
			currentDistance = MIN_DISTANCE;
		}
		motor.rotate((int)(360*(distance)/(2*Math.PI*WHEELE_RADIUS)));
	}
	public float getCurrentDistance(){
		return currentDistance;
	}

	@Override
	public void stop() {
		motor.close();
		
	}

}
