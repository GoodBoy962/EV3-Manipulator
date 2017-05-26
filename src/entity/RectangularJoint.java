package entity;

import lejos.robotics.RegulatedMotor;

public class RectangularJoint extends Joint{
	private RegulatedMotor motor;

	public RectangularJoint(float a, float alpha, float d, float theta, RegulatedMotor motor) {
		super(a, alpha, d, theta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(Point p) {
		// TODO Auto-generated method stub
		
	}

}
