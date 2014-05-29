package se.lignum.main.scenes;

import java.awt.Color;
import java.awt.Graphics;
import se.lignum.main.Game;
import se.lignum.main.Scene;

public class DevelopersScene extends Scene {

	public DevelopersScene(int sizeX, int sizeY) {
		super(sizeX, sizeY);
		// TODO Auto-generated constructor stub
	}

	private String[] people = new String[]{
		"Marcus Persson",
		"Philip Johansson",
		"Sebastian Karlsson",
		"Filip Rotkirk",
		"Robin Kangas",
		"Back"
	};

	private String[] informations = new String[]{
		"Graphics Designer",
		"Programmer",
		"Programmer",
		"3D artist",
		"Poster designer, Graphics Designer & Web developer",
		"Go back to the main menu"
	};

	private int selectionIndex = 0;
	int xx = 16;
	int yy;
	boolean rise = true;

	@Override
	public void tick() {
		if (Game.vk_down) {
			if (selectionIndex < people.length - 1) {
				selectionIndex += 1;
			} else {
				selectionIndex = 0;
			}
			xx = 16;
			Game.vk_down = false;
		} else if (Game.vk_up) {
			if (selectionIndex > 0) {
				selectionIndex -= 1;
			} else {
				selectionIndex = people.length - 1;
			}
			xx = 16;
			Game.vk_up = false;
		}
		
		
		if(Game.vk_enter){
			if(selectionIndex == people.length-1){
				Game.sceneIndex = 0;
				Game.vk_enter = false;
			}
		}

		if (xx < 16 + 8) {
			xx += 3;
		}

		if (rise == true && yy <= 6) {
			yy += 1;

			if (yy == 6) {
				rise = false;
			}
		} else {
			rise = false;
			yy -= 1;

			if (yy == 0) {
				rise = true;
			}
		}

	}

	@Override
	public void draw(Graphics g) {

		g.setColor(new Color(0, 149, 255));
		g.drawRect(0, 0, 186, Game.RENDERSIZE.height);

		for (int i = 0; i < people.length; i++) {
			if (i == selectionIndex) {
				g.setColor(Color.green);
				g.drawString(people[i], xx, 64 + 32 * i + yy);

			} else {

				g.setColor(new Color(0, 149, 255));
				g.drawString(people[i], 16, 64 + 32 * i);
			}

		}

		g.setColor(Color.WHITE);
		g.drawString(informations[selectionIndex], 200, 64);
	}

}
