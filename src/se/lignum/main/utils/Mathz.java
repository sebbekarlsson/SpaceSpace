package se.lignum.main.utils;

import java.util.Random;

public class Mathz {

	public static Random random = new Random();

	public static String chooseString(String... args) {
		return args[random.nextInt(args.length)];
	}
	
	public static double chooseDouble(double... args) {
		return args[random.nextInt(args.length)];
	}
}
