package utils;

import entity.Field;
import entity.Point;
import enums.FieldType;

public class FieldBuilder {
	
	public static final double Z_MAX = 19.5;
	
	public static Field buildField(FieldType type){
		switch (type){
		case RED_FIELD: return buildRed();
		case YELLOW_FIELD: return buildYellow();
		default:
			return buildGreen();
		}
		
	}
	
	private static Field buildRed() {
		return new Field(new Point[][] {
			{ new Point(0, 18, 0), new Point(-1, 11, 0), new Point(-2, 5, 0), new Point(-1, -0.4, 0) },
			{ new Point(0, 18, 5), new Point(-1, 11, 5), new Point(-2, 5, 5), new Point(-1, -0.4, 5) },
			{ new Point(0, 18, 10), new Point(-1, 11, 10), new Point(-2, 5, 10), new Point(-1, -0.4, 10) },
			{ new Point(0, 18, 15), new Point(-1, 11, 15), new Point(-2, 5, 15), new Point(-1, -0.4, 15) },
			{ new Point(0, 18, Z_MAX), new Point(-1, 11, Z_MAX), new Point(-2, 5, Z_MAX), new Point(-1, -0.4, Z_MAX) },
		});
	}
	
	private static Field buildYellow() {
		return new Field(new Point[][] {
			{ new Point(0, 18, 0), new Point(-1, 11, 0), new Point(-2, 5, 0), new Point(-1, -0.4, 0) },
			{ new Point(0, 18, 7), new Point(-1, 11, 7), new Point(-2, 5, 7), new Point(-1, -0.4, 7) },
			{ new Point(0, 18, 14), new Point(-1, 11, 14), new Point(-2, 5, 14), new Point(-1, -0.4, 14) },
			{ new Point(0, 18, Z_MAX), new Point(-1, 11, Z_MAX), new Point(-2, 5, Z_MAX), new Point(-1, -0.4, Z_MAX) },
		});
	}
	
	private static Field buildGreen(){
		return new Field(new Point[][] {
			{ new Point(0, 18, 0), new Point(-2, 7.5, 0), new Point(-1, -0.4, 0) },
			{ new Point(0, 18, 14.5), new Point(-2, 7.5, 14.5), new Point(-1, -0.4, 14.5) },
			{ new Point(0, 18, Z_MAX), new Point(-2, 7.5, Z_MAX), new Point(-1, -0.4, Z_MAX) },
		});
	}

}
