package engine;

import lejos.hardware.Button;
import lejos.hardware.Key;
import lejos.hardware.KeyListener;
import lejos.hardware.lcd.LCD;

public class RobotDisplay {
	
	private int colorCount;
	
	public RobotDisplay(){
		colorCount = 0;
		initLeft();
		initRight();
	}
	
	public void printColorMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				LCD.drawInt(matrix[i][j], i, j);
			}
		}
	}
	
	public void bindEnter(final StartTaskBListener listener){
		Button.ENTER.addKeyListener(new MyClickListener(){
			@Override
			public void keyPressed(Key k) {
				listener.startOnEnterClick(colorCount);
			}
		});
	}
	
	private void initLeft(){
		Button.LEFT.addKeyListener(
			new MyClickListener(){
				@Override
				public void keyPressed(Key k) {
					LCD.clearDisplay();
					colorCount--;
					LCD.drawInt(colorCount,0,0);
				}
			});
	}
	
	private void initRight(){
		Button.RIGHT.addKeyListener(
				new MyClickListener() {
					@Override
					public void keyPressed(Key k) {
						LCD.clearDisplay();
						colorCount++;
						LCD.drawInt(colorCount,0,0);	
					}
				});
	}
}
