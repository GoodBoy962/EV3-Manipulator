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
		for (int i = 0; i < robot.getAllJoints().size()-1; i++){
			transformMatrix = helper.multiplyMatrix(robot.getJoint(i).getTransformMatrix(),
					robot.getJoint(i+1).getTransformMatrix());
		}
		return transformMatrix;
	}
	public void ikine(Point p){
		float THETA = robot.getRotational1().getAngle();
		float[][] transMatrix = fkine();
		float someAngle = (float) (Math.acos((float)(p.getX()/robot.getLink1())));
		float sigma = someAngle-THETA;
		float d = (float) (p.getY()-robot.getLink1()*Math.sin(someAngle));
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
