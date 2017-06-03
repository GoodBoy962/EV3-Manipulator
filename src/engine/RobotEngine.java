package engine;

import lejos.hardware.Button;
import lejos.hardware.Key;
import lejos.utility.Delay;
import utils.Utils;
import entity.Joint;
import entity.Point;
import entity.Robot;

public class RobotEngine {
	
	private Robot robot;
	
	public RobotEngine(Robot robot){
		this.robot = robot;
		setPANICButton();
	}
	
	public double[][] fkine(){
		double [][] transformMatrix = new double[4][4];
		for (int i = 0; i < robot.getAllJoints().size()-2; i++){
			transformMatrix = Utils.multiply(robot.getJoint(i).getTransformMatrix(),
					robot.getJoint(i+1).getTransformMatrix());
		}
		return transformMatrix;
	}
	
	public void ikine(Point p){
		double THETA = robot.getRotational1().getAngle();
		double[][] transMatrix = fkine();
		
		double someAngle = (float) (Math.acos((float)(Math.abs(p.getX())/robot.getLink1())));
		double d = 0;
		double sigma = 0;
		if(p.getY()>0){
			someAngle *=-1;
			sigma = Math.toDegrees(someAngle)-THETA;
			d = (p.getY()-robot.getLink1()*Math.sin(someAngle))+robot.getPrismatic().getCurrentDistance();
		}
		else{
			sigma = (float) (Math.toDegrees(someAngle)-THETA);
			d = (float) (p.getY()-robot.getLink1()*Math.sin(someAngle))-robot.getPrismatic().getCurrentDistance();
		}
		robot.getPrismatic().move(d);
		Delay.msDelay(3000);
		robot.getRotational1().move(sigma);
		Delay.msDelay(3000);
	}
	
	private void setPANICButton(){
		Key escape = Button.ESCAPE;
		escape.addKeyListener(new MyClickListener(){

			@Override
			public void keyPressed(Key k) {
				robot.stop();
			}
			
		});
	}
}
