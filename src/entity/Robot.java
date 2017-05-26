package entity;

import java.util.List;

public class Robot {
	private List<Joint> joints;
	private SuperColorSensor sensor;
	public Robot(List<Joint> links, SuperColorSensor sensor){
		this.joints = links;
		this.sensor = sensor;
	}
	public Joint getJoint(int position){
		return joints.get(position);
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
	
}
