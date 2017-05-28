package entity;

import java.util.List;

import lejos.hardware.Sound;
import engine.RobotDisplay;
import engine.RobotEngine;
import engine.StartTaskBListener;
import enums.MyColor;

public class Robot implements StartTaskBListener{
	private List<Joint> joints;
	private SuperColorSensor sensor;
	private final float LINK1 = 16;
	private RobotEngine engine;
	private int[][] colorMatrix;
	private RobotDisplay display;
	private Field field;
	public Robot(List<Joint> links, SuperColorSensor sensor){
		this.joints = links;
		this.sensor = sensor;
		this.engine = new RobotEngine(this);
		this.display = new RobotDisplay();
	}
	public Joint getJoint(int position){
		return joints.get(position);
	}
	public RectangularJoint getRotational1(){
		for(Joint j: joints){
			if (j instanceof RectangularJoint){
				return  (RectangularJoint) j;
			}
		}
		return null;
	}
	public void move(Point point){
		engine.ikine(point);
	}
	public void hit(){
		((RectangularJoint) getJoint(2)).move(180);
		((RectangularJoint) getJoint(2)).move(-180);
	}
	public List<Joint> getAllJoints(){
		return joints;
	}
	public PrismaticJoint getPrismatic(){
		for(Joint j: joints){
			if (j instanceof PrismaticJoint){
				return (PrismaticJoint) j;
			}
		}
		return null;
	}
	public float getLink1(){
		return LINK1;
	}
	public void startExecution(Field f){
		colorMatrix = new int[f.getPoints().length][f.getPoints()[0].length];
		Point[][] points = f.getPoints();
		for (int i = 0; i < points.length; i++){
			for(int j = points[i].length-1; j >= 0; j--){
				move(points[i][j]);
				colorMatrix[i][j] = readColor();
			}
		}
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
	public void executeTaskB(Field f){
		this.field = f;
		display.bindEnter(this);
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
}
