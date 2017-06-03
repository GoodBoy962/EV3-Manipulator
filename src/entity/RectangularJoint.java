package entity;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.robotics.RegulatedMotor;

public class RectangularJoint extends Joint{
	
	private RegulatedMotor motor;
	private double currentAngle = 0;
	private final int MIN_LIMIT_ANGLE = 100;
	private final int MAX_LIMIT_ANGLE = 100;

	public RectangularJoint(double a, double alpha, double d, double theta, Port port) {
		super(a, alpha, d, theta);
		this.motor = new EV3LargeRegulatedMotor(port);
		motor.setSpeed(MOTOR_SPEED);
	}

	public void move(double angle){
//		currentAngle += angle;
//		if (currentAngle > MAX_LIMIT_ANGLE){
//			angle =- (currentAngle-MAX_LIMIT_ANGLE - angle); 
//			currentAngle = MAX_LIMIT_ANGLE;
//		}
//		else if(currentAngle < MIN_LIMIT_ANGLE){
//			angle =- (currentAngle-MIN_LIMIT_ANGLE - angle); 
//			currentAngle = MAX_LIMIT_ANGLE;
//		}
		motor.rotate((int)angle);
	}
	
	public double getAngle(){
		return currentAngle;
	}
	
	@Override
	public void stop() {
		motor.stop();
		
	}
}
