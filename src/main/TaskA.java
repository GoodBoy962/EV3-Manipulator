package main;

import java.util.ArrayList;
import java.util.List;

import entity.Joint;
import entity.PrismaticJoint;
import entity.RectangularJoint;
import entity.Robot;
import entity.ColorSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class TaskA {
	
	private static final int DELAY_PERIOD = 2000;

	public static void main(String[] args) {
		Robot robot = createRobot();
		
//		1
		System.out.println(robot.readColor());
		Delay.msDelay(DELAY_PERIOD);
		
//		2
		robot.getPrismatic().move(-11.5);
		Delay.msDelay(DELAY_PERIOD);
		System.out.println(robot.readColor());
		Delay.msDelay(DELAY_PERIOD);
		
//		3
		robot.getPrismatic().move(-6.5);
		Delay.msDelay(DELAY_PERIOD);
		robot.getRotational1().move(-8);
		Delay.msDelay(DELAY_PERIOD);
		System.out.println(robot.readColor());
		Delay.msDelay(DELAY_PERIOD);
		
//		4
		robot.getRotational1().move(8);
		Delay.msDelay(DELAY_PERIOD);
		robot.getPrismatic().move(4.5);
		Delay.msDelay(DELAY_PERIOD);
		robot.getRotational1().move(72);
		Delay.msDelay(DELAY_PERIOD);
		System.out.println(robot.readColor());
		Delay.msDelay(DELAY_PERIOD);
		
//		5
		robot.getPrismatic().move(-1.5);
		Delay.msDelay(DELAY_PERIOD);
		robot.getRotational1().move(30);
		Delay.msDelay(DELAY_PERIOD);
		System.out.println(robot.readColor());
		Delay.msDelay(DELAY_PERIOD);
		
//		6
		robot.getPrismatic().move(1.5);
		Delay.msDelay(DELAY_PERIOD);
		robot.getRotational1().move(-35);
		Delay.msDelay(DELAY_PERIOD);
		robot.getRotational1().move(-72);
		Delay.msDelay(DELAY_PERIOD);
		robot.getPrismatic().move(2.5);
		Delay.msDelay(DELAY_PERIOD);
		System.out.println(robot.readColor());
		Delay.msDelay(DELAY_PERIOD);
		
//		7
		robot.getPrismatic().move(1.5);
		Delay.msDelay(DELAY_PERIOD);
		robot.getRotational1().move(-30);
		Delay.msDelay(DELAY_PERIOD);
		System.out.println(robot.readColor());
		Delay.msDelay(DELAY_PERIOD);
		
//		end
		robot.getPrismatic().move(-1.5);
		Delay.msDelay(DELAY_PERIOD);
		robot.getRotational1().move(35);
		Delay.msDelay(DELAY_PERIOD);
		robot.getRotational1().move(72);
		Delay.msDelay(DELAY_PERIOD);
		robot.getPrismatic().move(9.5);
		Delay.msDelay(DELAY_PERIOD);
		
	}

	private static Robot createRobot() {
		List<Joint> joints = new ArrayList<>();
		joints.add(new PrismaticJoint(0, Math.PI/2, 0, 0, MotorPort.D));
		joints.add(new RectangularJoint(0, -Math.PI/2, 0, 0, MotorPort.A));
		joints.add(new RectangularJoint(10, 0, 0, 0, MotorPort.B));
		ColorSensor sensor = new ColorSensor(SensorPort.S1);
		return new Robot(joints, sensor);
	}
}
