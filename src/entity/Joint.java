package entity;

public abstract class Joint {
	
	protected static final int MOTOR_SPEED = 40;
	
	protected double a;
	protected double alpha;
	protected double d;
	protected double theta;
	double[][] transMatrix = new double[4][4];
	
	public Joint(double a, double alpha, double d, double theta){
		this.a = a;
		this.alpha = alpha;
		this.d = d;
		this.theta = theta;
		executeTransformMatrix();
	}
	
	public double[][] getTransformMatrix(){
		return transMatrix;
	}
	
	private void executeTransformMatrix(){
		transMatrix[0][0] = (float) Math.cos(theta);
		transMatrix[0][1] = (float) -Math.sin(theta);
		transMatrix[0][2] = 0;
		transMatrix[0][3] = a;
		transMatrix[1][0] = (float)Math.sin(theta)*(float)Math.cos(alpha);
		transMatrix[1][1] = (float)Math.cos(theta)*(float)Math.cos(alpha);
		transMatrix[1][2] = - (float) Math.sin(alpha);
		transMatrix[1][3] = - (float) Math.sin(alpha)*d;
		transMatrix[2][0] = (float) Math.sin(theta)*(float) Math.sin(alpha);
		transMatrix[2][1] = (float) Math.cos(theta)*(float) Math.sin(alpha);
		transMatrix[2][2] = (float) Math.cos(alpha);
		transMatrix[2][3] = (float) Math.cos(alpha) * d;
		transMatrix[3][0] = 0;
		transMatrix[3][1] = 0;
		transMatrix[3][2] = 0;
		transMatrix[3][3] = 1;
	}
	
	public abstract void stop();
	
	protected boolean changed = false;
	
	public boolean isChanged() {
		return changed;
	}

}
