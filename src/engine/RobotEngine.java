package engine;

import lejos.hardware.Button;
import lejos.hardware.Key;
import lejos.utility.Delay;
import utils.MatrixHelper;
import entity.Joint;
import entity.Point;
import entity.Robot;

public class RobotEngine {
	private Robot robot;
	private MatrixHelper helper;
	public RobotEngine(Robot r){
		robot = r;
		helper = new MatrixHelper();
		setPANICButton();
	}
	public float[][] fkine(){
		float [][] transformMatrix = new float[4][4];
		for (int i = 0; i < robot.getAllJoints().size()-2; i++){
			transformMatrix = helper.multiplyMatrix(robot.getJoint(i).getTransformMatrix(),
					robot.getJoint(i+1).getTransformMatrix());
		}
		return transformMatrix;
	}
	public void ikine(Point p){
		float THETA = robot.getRotational1().getAngle();
		float[][] transMatrix = fkine();
		
		float someAngle = (float) (Math.acos((float)(Math.abs(p.getX())/robot.getLink1())));
		float d = 0;
		float sigma = 0;
		if(p.getY()>0){
			someAngle *=-1;
			sigma = (float) (Math.toDegrees(someAngle)-THETA);
			d = (float) (p.getY()-robot.getLink1()*Math.sin(someAngle))+robot.getPrismatic().getCurrentDistance();
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
