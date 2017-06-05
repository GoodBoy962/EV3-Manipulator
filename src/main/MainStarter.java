package main;

import java.util.ArrayList;
import java.util.List;

import utils.FieldBuilder;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import entity.Joint;
import entity.PrismaticJoint;
import entity.RectangularJoint;
import entity.Robot;
import entity.ColorSensor;
import enums.FieldType;

public class MainStarter {
	
	public static void main(String[] args){
		List<Joint> joints = new ArrayList<>();
		joints.add(new PrismaticJoint(0, Math.PI/2 , 0, 0, MotorPort.D));
		joints.add(new RectangularJoint(0, -Math.PI/2, 0, 0, MotorPort.A));
		joints.add(new RectangularJoint(10, 0, 0, 0, MotorPort.B));
		ColorSensor sensor = new ColorSensor(SensorPort.S1);
		Robot robot = new Robot(joints,sensor);
		robot.execute(FieldBuilder.buildField(FieldType.GREEN_FIELD));	
		robot.stop();
	}
}
