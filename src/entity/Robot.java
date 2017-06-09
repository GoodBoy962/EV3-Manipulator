package entity;

import java.util.ArrayList;
import java.util.List;

import lejos.hardware.Sound;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import engine.RobotDisplay;
import engine.RobotEngine;
import engine.StartTaskBListener;

public class Robot implements StartTaskBListener {
	
	public static final int DELAY_PERIOD = 2000;
	public static final double THETA_1 = 26;
	public static final double THETA_2 = 100;
	public static final double L1 = 18.5;
	public static final double L2 = 19.5;
	
	private List<Joint> joints;
	private ColorSensor sensor;
	private RobotEngine engine;
	private int[][] colorMatrix;
	private RobotDisplay display;
	private Field field;
	
	private Robot(List<Joint> links, ColorSensor sensor){
		this.joints = links;
		this.sensor = sensor;
		this.engine = new RobotEngine(this);
		this.display = new RobotDisplay();
	}
	
	public static Robot createRobot() {
		List<Joint> joints = new ArrayList<>();
		joints.add(new PrismaticJoint(0, 0, 0, Math.PI / 180 * THETA_1, MotorPort.D));
		joints.add(new RectangularJoint(L1, 0, 0, Math.PI / 180 * THETA_2, MotorPort.B));
		joints.add(new RectangularJoint(L2, Math.PI/2, 0, -Math.PI/2, MotorPort.A));
		ColorSensor sensor = new ColorSensor(SensorPort.S4);
		return new Robot(joints, sensor);
	}
	
	public void execute(Field field) {
		colorMatrix = new int[field.getPoints().length][field.getPoints()[0].length];
		Point[][] points = field.getPoints();
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
		move(points[0][0]);
		beep();
	}
	
	public void findAndHit(Field field, int colorId) {
		
		Point[][] points = field.getPoints();
		
		int foundColorId = -1;
		int j = 0;
		while (foundColorId != colorId) {
			move(points[0][j]);
			foundColorId = readColor();
			System.out.print(foundColorId + " ");
			j++;
		}
		
		hit();
		j = getJ(points, colorId, 0);
		
		for (int i = 1; i < points[0].length; i++) {
			move(points[i][j]);
			foundColorId = readColor();
			System.out.print(foundColorId + " ");
			if (foundColorId == colorId) {
				hit();
			}
			colorId = foundColorId;
			j = getJ(points, colorId, i);
		}
		
		moveBack();
		move(points[0][0]);
		beep();
	}
	
	private int getJ (Point[][] points, int colorId, int i) {
		if (colorId == 0) {
			colorId = 3;
		}
		int j = colorId;
		if (colorId > points[0].length) {
			j %= (i + 2);
		}
		if (j == 0) {
			return j;
		}
		return j - 1;
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
		
		Sound.twoBeeps();
		System.exit(-1);
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
	
	public void hit() {
		engine.hit();
	}
	
	public List<Joint> getAllJoints(){
		return joints;
	}
	
	public PrismaticJoint getPrismatic(){
		return (PrismaticJoint) joints.get(0);
	}
	
}
