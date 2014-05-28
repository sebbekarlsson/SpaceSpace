package se.lignum.main.utils;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import se.lignum.main.Game;
import se.lignum.main.Instance;
import se.lignum.main.scenes.GameScene;

public class Mouse extends MouseAdapter {

	private int x, y;
	public boolean mb_left = false;
	public boolean mb_right = false;

	public int clickedY = 0;
	public int clickedX = 0;

	public int releasedY = 0;
	public int releasedX = 0;


	public void tick(){
		PointerInfo a = MouseInfo.getPointerInfo();
		Point point = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(point, Game.getFrames()[0]);
		x=(int) point.getX() / 2;
		y=(int) point.getY() / 2;
	}

	@Override
	public void mouseMoved(MouseEvent e){


	}


	@Override
	public void mousePressed(MouseEvent e){
		clickedY = y;
		clickedX = x;
		if(e.getButton() == 1){
			mb_left = true;

			GameScene.mb_left_hold = true;

			for(int i = 0; i < Game.getCurrentScene().getInstances().size(); i++){
				Instance instance = Game.getCurrentScene().getInstances().get(i);
				if(!Game.vk_control){
					instance.marked = false;
				}
			}


		}
		if(e.getButton() == 3){
			mb_right = true;
		}


	}

	@Override
	public void mouseReleased(MouseEvent e){
		releasedY = y;
		releasedX = x;
		if(e.getButton() == 1){
			mb_left = false;


			GameScene.mb_left_hold = false;

		}
		if(e.getButton() == 3){
			mb_right = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e){
		if(e.getButton() == 1){GameScene.mb_left_hold = true;}

	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}



}
