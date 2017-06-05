package entity;

import java.util.List;

import lejos.hardware.Sound;
import engine.RobotDisplay;
import engine.RobotEngine;
import engine.StartTaskBListener;
import enums.MyColor;

public class Robot implements StartTaskBListener{
	
	private List<Joint> joints;
	private ColorSensor sensor;
	private RobotEngine engine;
	private int[][] colorMatrix;
	private RobotDisplay display;
	private Field field;
	
	public Robot(List<Joint> links, ColorSensor sensor){
		this.joints = links;
		this.sensor = sensor;
		this.engine = new RobotEngine(this);
		this.display = new RobotDisplay();
	}
	
	public void execute(Field f){
		colorMatrix = new int[f.getPoints().length][f.getPoints()[0].length];
		Point[][] points = f.getPoints();
		for (int i = 0; i < points.length; i++){
			for(int j = 0; j < points[0].length; j++){
				move(points[i][j]);
				int colorId = readColor();
				colorMatrix[i][j] = colorId;
				System.out.print(colorId + " ");
			}
		}
		moveBack();
		display.printColorMatrix(colorMatrix);
	}
	
	private void moveBack() {
		engine.moveBack();
	}

	public void move(Point point){
		engine.ikine(point);
	}
	
	public void stop(){
		for(Joint j: joints){
			j.stop();
		}
		beep();
	}
	
	public void beep(){
		Sound.beep();
	}
	
	public int readColor(){
		return sensor.getMyColorId();
	}
	
	@Override
	public void startOnEnterClick(int colorId) {
		Point[][] points = field.getPoints();
		for (int i = 0; i < points.length; i++){
			for(int j = 0; j < points[i].length; j++){
				move(points[i][j]);
				if (colorId==readColor()){
					
				}
			}
		}
	}
	
	public RectangularJoint getRotational1(){
		return (RectangularJoint) joints.get(1);
	}
	
	public RectangularJoint getRotational2(){
		return (RectangularJoint) joints.get(2);
	}
	
	public void hit(){
		((RectangularJoint) joints.get(2)).move(180);
		((RectangularJoint) joints.get(2)).move(-180);
	}
	
	public List<Joint> getAllJoints(){
		return joints;
	}
	
	public PrismaticJoint getPrismatic(){
		return (PrismaticJoint) joints.get(0);
	}
	
}
