package entity;

import enums.MyColor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;

public class ColorSensor extends EV3ColorSensor{

	public ColorSensor(Port port) {
		super(port);
	}
	
	public MyColor getColor(){
		int colorId = this.getColorID();
		switch (colorId){
			case(0): return MyColor.RED; 
			case(1): return MyColor.GREEN; 
			case(2): return MyColor.BLUE; 
			case(3): return MyColor.YELLOW;
			case(6): return MyColor.WHITE;
			case(7): return MyColor.BLACK;
			case(13): return MyColor.BROWN;																
		}																								
		return MyColor.NOCOLOR;																			
	}
	
	public int getMyColorId(){
		int colorId = this.getColorID();
		switch (colorId){
			case(0): return 5;
			case(1): return 3;
			case(2): return 2;
			case(3): return 4;
			case(6): return 6;
			case(7): return 1;
			case(13): return 7;													
		}																								
		return 0;																
	}
}
