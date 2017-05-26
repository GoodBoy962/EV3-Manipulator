package entity;

import enums.MyColor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;

public class SuperColorSensor extends EV3ColorSensor{

	public SuperColorSensor(Port port) {
		super(port);
		// TODO Auto-generated constructor stub
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

}
