package entity;

import java.util.List;

public class Robot {
	private List<Joint> links;
	public Robot(List<Joint> links){
		this.links = links;
	}
	public Joint getLink(int position){
		return links.get(position);
	}
	public void move(Point point){
		//TODO
	}
	public void hit(){
		//TODO
	}
	
}
