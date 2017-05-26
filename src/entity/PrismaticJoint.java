package entity;

import lejos.robotics.RegulatedMotor;

public class PrismaticJoint extends Joint{
	RegulatedMotor motor;

	public PrismaticJoint(float a, float alpha, float d, float theta, RegulatedMotor motor) {
		super(a, alpha, d, theta);
		this.motor = motor;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(Point p) {
		// TODO Auto-generated method stub
		
	}

}
