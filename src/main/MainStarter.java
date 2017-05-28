package main;

import java.util.ArrayList;
import java.util.List;

import utils.FieldBuilder;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;
import entity.Joint;
import entity.PrismaticJoint;
import entity.RectangularJoint;
import entity.Robot;
import entity.SuperColorSensor;
import enums.FieldType;

public class MainStarter {
	public static void main(String[] args){
		List<Joint> joints = new ArrayList();
		joints.add(new PrismaticJoint(0,(float)Math.PI/2,0,0,new EV3LargeRegulatedMotor(MotorPort.A)));
		joints.add(new RectangularJoint(0,-(float)Math.PI/2,0,0,new EV3LargeRegulatedMotor(MotorPort.D)));
		joints.add(new RectangularJoint(10,0,0,0,new EV3LargeRegulatedMotor(MotorPort.B)));
		SuperColorSensor sensor = new SuperColorSensor(SensorPort.S1);
		FieldBuilder builder = new FieldBuilder();
		Robot robot = new Robot(joints,sensor);
		robot.startExecution(builder.buildField(FieldType.GREEN_FIELD));	
		robot.stop();
	}
}
