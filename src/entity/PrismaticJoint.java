package entity;

import lejos.robotics.RegulatedMotor;

public class PrismaticJoint extends Joint{
	private RegulatedMotor motor;
	private final float WHEELE_RADIUS=2.1f;
	private float currentDistance = 0;

	public PrismaticJoint(float a, float alpha, float d, float theta, RegulatedMotor motor) {
		super(a, alpha, d, theta);
		this.motor = motor;
	}

	public void move(float distance) {
		currentDistance+=distance;
		motor.rotate((int)(360*distance/(2*Math.PI*WHEELE_RADIUS)));
	}
	public float getCurrentDistance(){
		return currentDistance;
	}

	@Override
	public void stop() {
		motor.close();
		
	}

}
