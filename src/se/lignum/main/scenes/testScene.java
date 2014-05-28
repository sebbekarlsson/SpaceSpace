package se.lignum.main.scenes;

import se.lignum.main.Scene;
import se.lignum.main.instances.testObject;

public class testScene extends Scene {

	public testScene() {
		this.instantiate(new testObject(120, 120));
	}

}
