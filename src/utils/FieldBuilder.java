package utils;

import entity.Field;
import entity.Point;
import enums.FieldType;

public class FieldBuilder {
	private final float Y_SIZE = 27.4f;
	private final float X_SIZE = 16;//21.5f;
	public Field buildField(FieldType type){
		switch (type){
		case RED_FIELD: return buildRed();
		case YELLOW_FIELD: return buildYellow();
		default:
			return buildGreen();
		}
		
	}
	private Field buildYellow(){
		return abstractBuilder(4,4);
	}
	private Field buildRed(){
		return abstractBuilder(4,5);
	}
	private Field buildGreen(){
		return abstractBuilder(3,3);
	}
	private Field abstractBuilder(int xSize, int ySize){
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
