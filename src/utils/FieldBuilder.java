package utils;

import entity.Field;
import entity.Point;
import enums.FieldType;

public class FieldBuilder {
	
	private static final float Y_SIZE = 27.4f;
	private static final float X_SIZE = 16;
	public static final double Z_MAX = 19.5;
	
	public static Field buildField(FieldType type){
		switch (type){
		case RED_FIELD: return buildRed();
		case YELLOW_FIELD: return buildYellow();
		default:
			return buildGreen();
		}
		
	}
	
	private static Field buildYellow(){
		return abstractBuilder(4,4);
	}
	
	private static Field buildRed(){
		return abstractBuilder(4,5);
	}
	
	private static Field buildGreen(){
		return new Field(new Point[][] {
			{ new Point(0, 18, 0), new Point(-2, 8, 0), new Point(-1, -0.4, 0) },
			{ new Point(0, 18, 14.5), new Point(-2, 8, 14.5), new Point(-1, -0.4, 14.5) },
			{ new Point(0, 18, Z_MAX), new Point(-2, 8, Z_MAX), new Point(-1, -0.4, Z_MAX) },
		});
	}
	
	private static Field abstractBuilder(int xSize, int ySize){
		Point[][] coordinates = new Point[xSize][ySize];
		float stepX = X_SIZE/(xSize-1);
		float stepY = Y_SIZE/(ySize-1);
		float xCounter = 0;
		float yCounter = 0;
		for(int i = 0; i < xSize; i++){
			for(int j = 0; j < ySize; j++){
				coordinates[i][j] = new Point(xCounter, yCounter, 0);
				xCounter+=stepX;
			}
			xCounter=0;
			yCounter+=stepY;
		}
		return new Field(coordinates);
	}

}
