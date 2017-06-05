package engine;

import lejos.hardware.Button;
import lejos.hardware.Key;
import lejos.utility.Delay;
import utils.Utils;
import entity.Point;
import entity.Robot;

import static main.TaskA.THETA_1;
import static main.TaskA.L2;
import static main.TaskA.DELAY_PERIOD;
import static utils.FieldBuilder.*;

public class RobotEngine {
	
	private Robot robot;
	private double angle = 0;
	
	public RobotEngine(Robot robot){
		this.robot = robot;
		setPANICButton();
	}
	
	public double[][] fkine(){
		return Utils.multiply(
				Utils.multiply(
						robot.getPrismatic().getTransformMatrix(),
						robot.getRotational1().getTransformMatrix()
				), 
				robot.getRotational2().getTransformMatrix());
	}
	
	public void ikine(Point p) {
		double d = robot.getPrismatic().getCurrentDistance();
		if (- d < p.getZ()) {
			changeRow(d, p);
		}
		double theta = Math.toDegrees(robot.getRotational1().getTheta());
		double sigma = - (theta - (180 - Math.toDegrees(Math.asin(
						(Math.cos(Math.PI / 180 * THETA_1) * p.getY() - Math.sin(Math.PI / 180 * THETA_1) * p.getX()) / L2))));
		angle += sigma;
		robot.getRotational1().move(sigma);
		delay();
	}
	
	private void setPANICButton() {
		Key escape = Button.ESCAPE;
		escape.addKeyListener(new MyClickListener() {
			@Override
			public void keyPressed(Key k) {
				robot.stop();
			}	
		});
	}
	
	private void delay() {
		Delay.msDelay(DELAY_PERIOD);
	}

	public void moveBack() {
		robot.getRotational1().move(-angle - 12);
		delay();
		angle = 0;
		robot.getRotational2().move(-180);
		delay();
		robot.getPrismatic().move(-robot.getPrismatic().getCurrentDistance());
		delay();
	}
	
	private void changeRow(double d, Point p) {
		d = - p.getZ() - d;
		robot.getRotational1().move(- angle);
		angle = 0;
		delay();
		robot.getPrismatic().move(d);
		delay();
		if (p.getZ() == Z_MAX) {
			moveEE();
		}
	}
	
	private void moveEE() {
		robot.getRotational2().move(180);
		delay();
		robot.getRotational1().moveEE(12);
		delay();
	}
	
}
