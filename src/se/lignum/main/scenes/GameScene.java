package se.lignum.main.scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import se.lignum.main.Game;
import se.lignum.main.Scene;
import se.lignum.main.utils.ImageLoader;

public class GameScene extends Scene {
	
	int cx = 0;
	int cy = 0;
	
	
	
	public static boolean mb_left_hold = true;
	
	public void draw(Graphics g){
		//trying to make the selection thing in the game, just like in windows when you select files, there is an rectangle drawn to the mouse
		
		g.setColor(Color.WHITE);
		
		if(Game.mouse.mb_left){
			
			
			cx = Game.mouse.getX();
			cy = Game.mouse.getY();
			
			
			
			
			
			Game.mouse.mb_left = false;
		}
		
		
		
		if(mb_left_hold == true){
			Graphics2D g2d = (Graphics2D) g;
			Rectangle2D rect = new Rectangle2D.Double();
			rect.setFrameFromDiagonal(Game.mouse.clickedX, Game.mouse.clickedY, Game.mouse.getX(), Game.mouse.getY());
			g2d.draw(rect);
		}
		
		
		
	}
	
	

}
