package entity;

public abstract class Joint {
	private float a;
	private float alpha;
	private float d;
	private float theta;
	public Joint(float a, float alpha, float d, float theta){
		this.a = a;
		this.alpha = alpha;
		this.d = d;
		this.theta = theta;
	}
	public abstract void move();

}
