package se.lignum.main.scenes;

import java.awt.Color;
import java.awt.Graphics;

import se.lignum.main.Game;
import se.lignum.main.Scene;
import se.lignum.main.utils.ImageLoader;

public class GameScene extends Scene {
	
	int cx = 0;
	int cy = 0;
	
	int rx = 0;
	int ry = 0;
	
	public static boolean hold = false;
	
	public void draw(Graphics g){
		//trying to make the selection thing in the game, just like in windows when you select files, there is an rectangle drawn to the mouse
		
		g.setColor(Color.WHITE);
		
		if(Game.mouse.mb_left){
			
			
			cx = Game.mouse.getX();
			cy = Game.mouse.getY();
			
			
			
			hold = true;
			
			Game.mouse.mb_left = false;
		}
		
		if(hold){
			g.drawLine(cx, cy, Game.mouse.getX(), Game.mouse.getY());
			System.out.println("holding");
		}
		
		
		
		
		
	}

}
