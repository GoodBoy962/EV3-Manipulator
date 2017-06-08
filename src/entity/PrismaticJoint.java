package entity;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.robotics.RegulatedMotor;

import static utils.FieldBuilder.Z_MAX;

public class PrismaticJoint extends Joint{
	
	private static final double WHEELE_RADIUS = 2.3;
	
	private RegulatedMotor motor;
	private double currentDistance = 0;

	public PrismaticJoint(double a, double alpha, double d, double theta, Port port) {
		super(a, alpha, d, theta);
		this.motor = new EV3LargeRegulatedMotor(port);
		motor.setSpeed(MOTOR_SPEED);
	}

	public void move(double distance) {
		currentDistance += distance;
		if (currentDistance >= Z_MAX) {
			currentDistance = Z_MAX;
		}
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
