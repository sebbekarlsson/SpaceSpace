package se.lignum.main.instances;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import se.lignum.main.Game;
import se.lignum.main.Instance;

public class Ship extends Instance {

	int xx = 0;
	int yy = 0;

	private double health = 100;
	private double attackPower = 1;
	private double attackDamage = 16 * attackPower;

	public Ship(double x, double y) {
		super(x, y);

	}

	@Override
	public void draw(Graphics g) {

		drawDefaultSprite(g);

		if (marked) {
			g.setColor(Color.BLUE);
			g.drawRect((int) x +  - sprite.getWidth(null) / 2,
					(int) y +  - sprite.getHeight(null) / 2,
					(int) sprite.getWidth(null) * 2,
					(int) sprite.getHeight(null) * 2);
			g.setColor(Color.WHITE);
			g.setFont(new Font(Font.SERIF, 13, 13));
			g.drawString("HP: " + (int) this.health, (int) x  , (int) y  - 16);
		}
	}

	@Override
	public void tick() {
		if (health < 1) {
			Game.getCurrentScene().destroy(this);
		}

		for (int i = 0; i < Game.getCurrentScene().getInstances().size(); i++) {
			Instance instance = Game.getCurrentScene().getInstances().get(i);
			if (instance instanceof MovePoint) {
				xx = (int) instance.x;
				yy = (int) instance.y;
				if (x >= instance.x && x <= instance.x + instance.getSprite().getWidth(null) && y >= instance.y && y <= instance.y + instance.getSprite().getHeight(null)) {
					Game.getCurrentScene().destroy(instance);

				}
			}
		}

		if (this.isInSelection()) {
			marked = true;
		}

		if (marked) {

			if (Game.getCurrentScene().instanceExists(MovePoint.class)) {

				if (x < xx) {
					x+=6;
				} else if (x > xx) {
					x-=6;
				} else if (y < yy) {
					y+=6;
				} else if (y > yy) {
					y-=6;
				}
			}
		}
	}

	public void damage(double damage) {
		this.health -= damage;
	}

	public void attack(Ship ship) {
		ship.damage(attackDamage);
	}

}
