package entity;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.robotics.RegulatedMotor;
import main.TaskA;

public class RectangularJoint extends Joint {
	
	private RegulatedMotor motor;

	public RectangularJoint(double a, double alpha, double d, double theta, Port port) {
		super(a, alpha, d, theta);
		this.motor = new EV3LargeRegulatedMotor(port);
		motor.setSpeed(MOTOR_SPEED);
	}

	public void move(double angle){
		if (angle < 0) {
			theta = Math.PI / 180 * TaskA.THETA_2;
		} else {
 			theta += Math.toRadians(angle);
		}
		motor.rotate((int) angle);
	}
	
	public void moveEE(double angle) {
		motor.rotate((int) angle);
	}
	
	public double getTheta(){
		return theta;
	}
	
	@Override
	public void stop() {
		motor.stop();
	}
}
