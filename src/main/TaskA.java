package main;

import entity.Robot;
import enums.FieldType;
import utils.FieldBuilder;

public class TaskA {
	
	public static void main(String[] args) {
		Robot robot = Robot.createRobot();
		robot.execute(FieldBuilder.buildField(FieldType.GREEN_FIELD));	
	}
	
}
