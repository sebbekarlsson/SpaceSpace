package se.lignum.main.utils;

import java.awt.Image;
import java.awt.Toolkit;

public class ImageLoader {
	
	
	//loads and return an image based on the entered image location
	public static Image load(String imagePath){
		return Toolkit.getDefaultToolkit().getImage(imagePath);
	}

}
