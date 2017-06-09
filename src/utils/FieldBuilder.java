package utils;

import entity.Field;
import entity.Point;
import enums.FieldType;

public class FieldBuilder {
	
	public static final double Z_MAX = 19.505;
	
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
			{ new Point(0, 18, 0), new Point(-1, 12, 0), new Point(-2, 5, 0), new Point(-1, -0.4, 0) },
			{ new Point(0, 18, 8), new Point(-1, 12, 8), new Point(-2, 5, 8), new Point(-1, -0.4, 8) },
			{ new Point(0, 18, 14), new Point(-1, 12, 14), new Point(-2, 5, 14), new Point(-1, -0.4, 14) },
			{ new Point(0, 18, 22), new Point(-1, 12, 22), new Point(-2, 5, 22), new Point(-1, -0.4, 22) },
			{ new Point(0, 18, Z_MAX), new Point(-1, 12, Z_MAX), new Point(-2, 5, Z_MAX), new Point(-1, -0.4, Z_MAX) },
		});
	}
	
	private static Field buildYellow() {
		return new Field(new Point[][] {
			{ new Point(0, 18, 0), new Point(-1, 12, 0), new Point(-2, 5, 0), new Point(-1, -0.4, 0) },
			{ new Point(0, 18, 10), new Point(-1, 12, 10), new Point(-2, 5, 10), new Point(-1, -0.4, 10) },
			{ new Point(0, 18, 19.4), new Point(-1, 12, 19.4), new Point(-2, 5, 19.4), new Point(-1, -0.4, 19.4) },
			{ new Point(0, 18, Z_MAX), new Point(-1, 12, Z_MAX), new Point(-2, 5, Z_MAX), new Point(-1, -0.4, Z_MAX) },
		});
	}
	
	private static Field buildGreen() {
		return new Field(new Point[][] {
			{ new Point(0, 18, 0), new Point(-2, 7.5, 0), new Point(-1, -0.4, 0) },
			{ new Point(0, 18, 14.5), new Point(-2, 7.5, 14.5), new Point(-1, -0.4, 14.5) },
			{ new Point(0, 18, Z_MAX), new Point(-2, 7.5, Z_MAX), new Point(-1, -0.4, Z_MAX) },
		});
	}

}
