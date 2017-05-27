package entity;

import java.util.List;

public class Robot {
	private List<Joint> joints;
	private SuperColorSensor sensor;
	private final float LINK1 = 10;
	public Robot(List<Joint> links, SuperColorSensor sensor){
		this.joints = links;
		this.sensor = sensor;
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
		//TODO
	}
	public void hit(){
		//TODO
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
}
