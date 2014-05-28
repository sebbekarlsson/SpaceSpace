package se.lignum.main.scenes;

import java.awt.Color;
import java.awt.Graphics;

import se.lignum.main.Game;
import se.lignum.main.Scene;

public class MenuScene extends Scene {

	private String[] options = new String[]{
		"Single Player",
		"Multi Player",
		"Options",
		"Help",
		"Quit"
	};
	
	private int selectionIndex = 0;
	
	public void tick(){
		if(Game.vk_down && selectionIndex < options.length-1){
			selectionIndex += 1;
			Game.vk_down = false;
		}
		else if(Game.vk_up && selectionIndex > 0){
			selectionIndex -= 1;
			Game.vk_up = false;
		}
		
		if(Game.vk_enter){
			if(selectionIndex == options.length-1){
				System.exit(0);
			}
		}
		
		
	}
	
	public void draw(Graphics g){
		
		g.setColor(Color.blue);
		
		for(int i = 0; i < options.length; i++){
			if(i == selectionIndex){
				g.setColor(Color.green);
			}else{
				g.setColor(Color.blue);
			}
			g.drawString(options[i], 16, 64+32*i);
		}
		
		
	}
}
