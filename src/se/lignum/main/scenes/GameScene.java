package se.lignum.main.scenes;

import java.awt.Color;
import java.awt.Graphics;

import se.lignum.main.Game;
import se.lignum.main.Scene;
import se.lignum.main.utils.ImageLoader;

public class GameScene extends Scene {
	
	public void draw(Graphics g){
		//trying to make the selection thing in the game, just like in windows when you select files, there is an rectangle drawn to the mouse
		
		if(Game.mouse.mb_left){
			g.setColor(Color.white);
			g.drawLine(Game.mouse.clickedX, Game.mouse.clickedY, Game.mouse.getX(), Game.mouse.getY());
			
		}
		
	}

}
