package engine;

import lejos.hardware.Key;
import lejos.hardware.KeyListener;

public abstract class MyClickListener implements KeyListener{

	public abstract void keyPressed(Key k);

	@Override
	public void keyReleased(Key k) {
		// TODO Auto-generated method stub
	}

}
