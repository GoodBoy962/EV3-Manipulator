package entity;

import lejos.robotics.RegulatedMotor;

public class RectangularJoint extends Joint{
	private RegulatedMotor motor;
	private float currentAngle = 0;
	private final int MIN_LIMIT_ANGLE = 100;
	private final int MAX_LIMIT_ANGLE = 100;

	public RectangularJoint(float a, float alpha, float d, float theta, RegulatedMotor motor) {
		super(a, alpha, d, theta);
		this.motor = motor;
		motor.setSpeed(50);
		// TODO Auto-generated constructor stub
	}
	public void move(float angle){
		currentAngle+=angle;
		if (currentAngle>MAX_LIMIT_ANGLE){
			angle = -(currentAngle-MAX_LIMIT_ANGLE-angle); 
			currentAngle = MAX_LIMIT_ANGLE;
		}
		else if(currentAngle<MIN_LIMIT_ANGLE){
			angle = -(currentAngle-MIN_LIMIT_ANGLE-angle); 
			currentAngle = MAX_LIMIT_ANGLE;
		}
		motor.rotate((int)angle);
	}
	public float getAngle(){
		return currentAngle;
	}
	@Override
	public void stop() {
		motor.stop();
		
	}
}
