package se.lignum.main.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {
	
	private int x, y;
	
	@Override
	public void mouseMoved(MouseEvent e){
		this.x = e.getX();
		this.y = e.getY();
	}
	
	
	@Override
	public void mousePressed(MouseEvent e){
		
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	
	
}
