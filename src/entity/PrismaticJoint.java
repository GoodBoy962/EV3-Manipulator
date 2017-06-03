package entity;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.robotics.RegulatedMotor;

public class PrismaticJoint extends Joint{
	
	private static final double WHEELE_RADIUS = 1.5;
	private static final double MIN_DISTANCE = -2;
	private static final double MAX_DISTANCE = 26;
	
	private RegulatedMotor motor;
	private double currentDistance = -1;

	public PrismaticJoint(double a, double alpha, double d, double theta, Port port) {
		super(a, alpha, d, theta);
		this.motor = new EV3LargeRegulatedMotor(port);
		motor.setSpeed(MOTOR_SPEED);
	}

	public void move(double distance) {
		
		currentDistance += distance;
		
//		if(currentDistance > MAX_DISTANCE){
//			distance =- (currentDistance - MAX_DISTANCE - distance);
//			currentDistance = MAX_DISTANCE; 
//		}
//		
//		if(currentDistance < MIN_DISTANCE){
//			distance = -(currentDistance - MIN_DISTANCE - distance);
//			currentDistance = MIN_DISTANCE;
//		}
		
		motor.rotate((int)(360 * distance / (2 * Math.PI * WHEELE_RADIUS)));
	}
	
	public double getCurrentDistance(){
		return currentDistance;
	}

	@Override
	public void stop() {
		motor.close();
	}

}
