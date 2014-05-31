package se.lignum.main.scenes;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import se.lignum.main.Game;
import se.lignum.main.Scene;
import se.lignum.main.instances.MovePoint;
import se.lignum.main.instances.Star;
import se.lignum.main.instances.testObject;
import se.lignum.main.instances.planets.Earth;
import se.lignum.main.utils.Mathz;

public class GameScene extends Scene {

	

	int cx = 0;
	int cy = 0;

	public static boolean mb_left_hold = false;
	
	
	
	
	public GameScene(int sizeX, int sizeY,boolean useCamera) {
		super(sizeX, sizeY,useCamera);
		
		this.camera.x = -this.ROOM_SIZE_X / 2;
		this.camera.y = -this.ROOM_SIZE_Y / 2;
		
		for(int i = 0; i < 10000; i++){
			this.instantiate(new Star(Mathz.random.nextInt(this.ROOM_SIZE_X),Mathz.random.nextInt(this.ROOM_SIZE_Y)));
		}
		
		
		
		this.instantiate(new Earth(this.ROOM_SIZE_X/2,this.ROOM_SIZE_Y/2));
		this.instantiate(new testObject(this.ROOM_SIZE_X/2+300,this.ROOM_SIZE_Y/2+100));
		this.instantiate(new testObject(this.ROOM_SIZE_X/2-300,this.ROOM_SIZE_Y/2-100));
		this.instantiate(new testObject(this.ROOM_SIZE_X/2+150,this.ROOM_SIZE_Y/2-500));
		this.instantiate(new testObject(this.ROOM_SIZE_X/2-150,this.ROOM_SIZE_Y/2));
		
		this.instantiate(new testObject(this.ROOM_SIZE_X/2+500,this.ROOM_SIZE_Y/2-100));
		this.instantiate(new testObject(this.ROOM_SIZE_X/2-500,this.ROOM_SIZE_Y/2+500));
		this.instantiate(new testObject(this.ROOM_SIZE_X/2,this.ROOM_SIZE_Y/2-20));
		this.instantiate(new testObject(this.ROOM_SIZE_X/2,this.ROOM_SIZE_Y/2+1000));
		
		
		
	}

	@Override
	public void tick() {
		if (Game.mouse.mb_right) {
			if (!instanceExists(MovePoint.class)) {
				Game.getCurrentScene().instantiate(new MovePoint(Game.mouse.getX(), Game.mouse.getY()));
				Game.mouse.mb_right = false;
			} else {
				Game.getCurrentScene().destroyAll(MovePoint.class);
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		//trying to make the selection thing in the game, just like in windows when you select files, there is an rectangle drawn to the mouse

		g.setColor(Color.WHITE);

		if (Game.mouse.mb_left) {

			cx = Game.mouse.getX();
			cy = Game.mouse.getY();

			Game.mouse.mb_left = false;
		}

		if (mb_left_hold == true && Game.vk_control == true) {
			Graphics2D g2d = (Graphics2D) g;

			g2d.setColor(Color.blue);
			Rectangle2D rect = new Rectangle2D.Double();
			rect.setFrameFromDiagonal(Game.mouse.clickedX, Game.mouse.clickedY, Game.mouse.getX(), Game.mouse.getY());

			g2d.draw(rect);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
			g2d.setColor(Color.BLUE);
			g2d.fill(rect);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		}
	}
}
