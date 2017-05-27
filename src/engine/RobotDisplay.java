package engine;

import lejos.hardware.lcd.LCD;

public class RobotDisplay {
	public void printColorMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				LCD.drawInt(matrix[i][j], i, j);
			}
		}
	}
}
