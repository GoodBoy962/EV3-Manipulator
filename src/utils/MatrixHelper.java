package utils;

import entity.Point;

public class MatrixHelper {
	public float[][] multiplyMatrix(float[][] firstarray, float[][] secondarray){
		float [][] result = new float[firstarray.length][secondarray[0].length];
		for (int i = 0; i < firstarray.length; i++) { 
		    for (int j = 0; j < secondarray[0].length; j++) { 
		        for (int k = 0; k < firstarray[0].length; k++) { 
		            result[i][j] += firstarray[i][k] * secondarray[k][j];
		        }
		    }
		}
		return result;
	}
	public Point getPoint(float[][] matrix){
		return new Point(matrix[3][0],matrix[3][1], matrix[3][2]); 
	}
	public float getRotationAngle(float[][] transMatrix){
		return 0;
	}
}
