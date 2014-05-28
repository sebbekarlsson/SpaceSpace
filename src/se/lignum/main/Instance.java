package se.lignum.main;

import java.awt.Graphics;
import java.awt.Image;

import se.lignum.main.utils.ImageLoader;


public class Instance {

	
	public double x,y;
	Image sprite;

	public Instance(double x, double y){
		this.x = x;
		this.y = y;
	}

	public void tick(){}

	public void draw(Graphics g){
		drawDefaultSprite(g);
	}

	public void drawDefaultSprite(Graphics g){
		if(this.sprite != null){
			g.drawImage(this.sprite,(int)x,(int)y,null);
		}else{
			System.out.println("Trying to draw a null sprite");
		}
	}

	public Image getSprite(){
		return this.sprite;
	}

	public void setSprite(String imagePath){
		this.sprite = ImageLoader.load(imagePath);
	}

}
