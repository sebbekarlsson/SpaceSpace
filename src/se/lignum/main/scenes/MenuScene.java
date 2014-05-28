package se.lignum.main.scenes;

import java.awt.Color;
import java.awt.Graphics;

import se.lignum.main.Game;
import se.lignum.main.Scene;

public class MenuScene extends Scene {

	private String[] options = new String[]{
			"SinglePlayer",
			"MultiPlayer",
			"Options",
			"Help",
			"Developers",
			"Quit"
	};

	private int selectionIndex = 0;

	public void tick(){
		if(Game.vk_down){
			if(selectionIndex < options.length-1){
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
				selectionIndex = options.length-1;
			}
			
			Game.vk_up = false;
		}

		if(Game.vk_enter){
			if(selectionIndex == options.length-1){
				System.exit(0);
			}
			else if(selectionIndex == 0){
				Game.sceneIndex += 1;
			}
			else if(selectionIndex == options.length-2){
				Game.sceneIndex += 2;
			}

			Game.vk_enter = false;
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
