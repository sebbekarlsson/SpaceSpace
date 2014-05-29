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

	private String[] informations = new String[]{
		"Play on your own. (Story Mode)",
		"Play online.",
		"Change the game settings.",
		"Go here if you are lost.",
		"Who are we?",
		"Shut down the game."
	};

	private int selectionIndex = 0;
	int xx;
	int yy;
	boolean rise = true;

	public void tick() {
		if (Game.vk_down) {
			if (selectionIndex < options.length - 1) {
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
				selectionIndex = options.length - 1;
			}
			xx = 16;
			Game.vk_up = false;
		}

		if (Game.vk_enter) {
			if (selectionIndex == options.length - 1) {
				System.exit(0);
			} else if (selectionIndex == 0) {
				Game.sceneIndex += 1;
			} else if (selectionIndex == options.length - 2) {
				Game.sceneIndex += 2;
			}

			Game.vk_enter = false;
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

	public void draw(Graphics g) {

		g.setColor(new Color(0, 149, 255));
		g.drawRect(0, 0, 186, Game.RENDERSIZE.height);

		for (int i = 0; i < options.length; i++) {
			if (i == selectionIndex) {
				g.setColor(Color.green);
				g.drawString(options[i], xx, 64 + 32 * i + yy);
			} else {
				g.setColor(new Color(0, 149, 255));
				g.drawString(options[i], 16, 64 + 32 * i);
			}

		}

		g.setColor(Color.WHITE);
		g.drawString(informations[selectionIndex], 200, 64);

	}
}
