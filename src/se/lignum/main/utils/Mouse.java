package se.lignum.main.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.lignum.main.Game;

public class Mouse extends MouseAdapter {
	
	private int x, y;
	public boolean mb_left = false;
	public boolean mb_right = false;
	
	public int clickedY = 0;
	public int clickedX = 0;
	
	public int releasedY = 0;
	public int releasedX = 0;
	@Override
	public void mouseMoved(MouseEvent e){
		this.x = e.getX();
		this.y = e.getY();
		System.out.println("X:"+x+" Y:"+y);
	}
	
	
	@Override
	public void mousePressed(MouseEvent e){
		clickedY = y;
		clickedX = x;
		if(e.getButton() == 1){
			mb_left = true;
		}
		if(e.getButton() == 2){
			mb_right = true;
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e){
		releasedY = y;
		releasedX = x;
		if(e.getButton() == 1){
			mb_left = false;
		}
		if(e.getButton() == 2){
			mb_right = false;
		}
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	
	
}
