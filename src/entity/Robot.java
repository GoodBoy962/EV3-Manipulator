package entity;

import java.util.List;

import engine.RobotEngine;

public class Robot {
	private List<Joint> joints;
	private SuperColorSensor sensor;
	private final float LINK1 = 10;
	private RobotEngine engine;
	public Robot(List<Joint> links, SuperColorSensor sensor){
		this.joints = links;
		this.sensor = sensor;
		this.engine = new RobotEngine(this);
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
		Point[][] points = f.getPoints();
		for (int i = 0; i < points.length; i++){
			for(int j = 0; j < points[i].length; j++){
				move(points[i][j]);
			}
		}
	}
	public void stop(){
		for(Joint j: joints){
			j.stop();
		}
	}
}
