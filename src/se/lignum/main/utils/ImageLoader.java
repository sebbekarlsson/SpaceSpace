package se.lignum.main.utils;

import java.awt.Image;
import java.awt.Toolkit;

public class ImageLoader {
	
	public static Image load(String imagePath){
		return Toolkit.getDefaultToolkit().getImage(imagePath);
	}

}
