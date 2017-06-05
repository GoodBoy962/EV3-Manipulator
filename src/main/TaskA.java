package main;

import java.util.ArrayList;
import java.util.List;

import entity.Joint;
import entity.PrismaticJoint;
import entity.RectangularJoint;
import entity.Robot;
import enums.FieldType;
import entity.ColorSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;
import utils.FieldBuilder;

public class TaskA {
	
	public static final int DELAY_PERIOD = 2000;
	public static final double THETA_1 = 26;
	public static final double THETA_2 = 100;
	public static final double L1 = 18.5;
	public static final double L2 = 19.5;
	
	public static void main(String[] args) {
		Robot robot = createRobot();
		robot.execute(FieldBuilder.buildField(FieldType.GREEN_FIELD));	
	}

	private static Robot createRobot() {
		List<Joint> joints = new ArrayList<>();
		joints.add(new PrismaticJoint(0, 0, 0, Math.PI / 180 * THETA_1, MotorPort.D));
		joints.add(new RectangularJoint(L1, 0, 0, Math.PI / 180 * THETA_2, MotorPort.B));
		joints.add(new RectangularJoint(L2, Math.PI/2, 0, -Math.PI/2, MotorPort.A));
		ColorSensor sensor = new ColorSensor(SensorPort.S4);
		return new Robot(joints, sensor);
	}
	
}
