package main;

import entity.Field;
import entity.Point;
import entity.Robot;

public class TaskB {
	private Robot robot;
	private Field field;
	private int targetX = 0;
	private int targetY = 0;
	public TaskB(Robot r, Field f){
		robot = r;
		field = f;
	}
	public void start(int colorId){
		Point[][] points = field.getPoints();
		for (int i = 0; i < points.length; i++){
			for(int j = 0; j < points[i].length; j++){
				robot.move(points[i][j]);
				if (colorId==robot.readColor()){
					robot.hit();
					targetX = colorId;
				}
			}
		}
	}
}
