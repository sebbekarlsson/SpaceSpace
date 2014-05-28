package se.lignum.main.scenes;

import java.awt.Color;
import java.awt.Graphics;

import se.lignum.main.Game;
import se.lignum.main.Scene;

public class DevelopersScene extends Scene {

	
	private String[] people = new String[]{
			"Marcus Persson",
			"Philip Johansson",
			"Sebastian Karlsson",
			"Filip Rotkirk",
			"Robin Kangas"
	};
	
	private String[] informations = new String[]{
			"Graphics Designer",
			"Programmer",
			"Programmer",
			"3D artist",
			"Poster & Graphics Designer"
	};
	
	private int selectionIndex = 0;
	
	public void tick(){
		if(Game.vk_down){
			if(selectionIndex < people.length-1){
				selectionIndex += 1;
			}else{
				selectionIndex = 0;
			}
			
			Game.vk_down = false;
		}
		else if(Game.vk_up){
			if(selectionIndex > 0){
				selectionIndex -= 1;
			}else{
				selectionIndex = people.length-1;
			}
			
			Game.vk_up = false;
		}

	


	}
	
	public void draw(Graphics g){
		
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, 186, Game.RENDERSIZE.height);
		
		for(int i = 0; i < people.length; i++){
			if(i == selectionIndex){
				g.setColor(Color.green);
			}else{
				g.setColor(Color.blue);
			}
			
			g.drawString(people[i], 16, 64+32*i);
			
		}
		
		g.setColor(Color.WHITE);
		g.drawString(informations[selectionIndex], 200, 64);
	}
	
}
