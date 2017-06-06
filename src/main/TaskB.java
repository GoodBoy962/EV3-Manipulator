package main;

import entity.Robot;
import enums.FieldType;
import utils.FieldBuilder;

public class TaskB {
	
	public static void main(String[] args) {
		Robot robot = Robot.createRobot();
		robot.findAndHit(FieldBuilder.buildField(FieldType.GREEN_FIELD), 5);
	}
	
}
