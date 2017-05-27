package utils;

import entity.Field;
import entity.Point;
import enums.FieldType;

public class FieldBuilder {
	private final float X_SIZE = 22.4f;
	private final float Y_SIZE = 16.5f;
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
		Point[][] coordinates = new Point[4][4];
		float stepX = X_SIZE/xSize;
		float stepY = Y_SIZE/ySize;
		float xCounter = 0;
		float yCounter = 0;
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				coordinates[i][j] = new Point(xCounter, yCounter, 0);
				xCounter+=stepX;
			}
			yCounter+=stepY;
		}
		return new Field(coordinates);
	}

}
