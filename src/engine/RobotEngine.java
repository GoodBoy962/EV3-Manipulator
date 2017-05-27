package engine;

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
	}
	public float[][] fkine(){
		float [][] transformMatrix = new float[4][4];
		for (int i = 0; i < robot.getAllJoints().size()-1; i++){
			transformMatrix = helper.multiplyMatrix(robot.getJoint(i).getTransformMatrix(),
					robot.getJoint(i+1).getTransformMatrix());
		}
		return transformMatrix;
	}
	private final float THETA = 0.1f;
	public void ikine(Point p){
		float[][] transMatrix = fkine();
		float sigma = (float) Math.acos(p.getX()/robot.getLink1()-THETA);
		float d = (float) (p.getY()-robot.getLink1()*Math.sin(THETA+sigma));
		robot.getPrismatic().move(d);
		robot.getRotational1().move(sigma);
	}
}
