package entity;

import lejos.robotics.RegulatedMotor;

public class RectangularJoint extends Joint{
	private RegulatedMotor motor;
	private float currentAngle = 0;
	private final float LINK_SIZE=10;

	public RectangularJoint(float a, float alpha, float d, float theta, RegulatedMotor motor) {
		super(a, alpha, d, theta);
		this.motor = motor;
		// TODO Auto-generated constructor stub
	}
	public void move(float angle){
		currentAngle+=angle;
		motor.rotate((int)angle);
	}
}
