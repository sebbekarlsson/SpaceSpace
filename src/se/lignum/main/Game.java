package se.lignum.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 2;

	public static final Dimension SCREENSIZE = new Dimension(WIDTH*SCALE,HEIGHT*SCALE);
	public static final Dimension RENDERSIZE = new Dimension(SCREENSIZE.width/2,SCREENSIZE.height/2);
	public static BufferedImage offscreen = new BufferedImage(RENDERSIZE.height,RENDERSIZE.width,BufferedImage.TYPE_INT_RGB);

	Thread gameLoop = new Thread(this,"Game Loop");





	public Game() {
		this.setSize(SCREENSIZE);
		this.setTitle("Space Game");
		this.setResizable(false);
		this.setVisible(true);
	}

	public void start(){
		this.gameLoop.start();
	}

	public static void main(String[] args){
		Game game = new Game();
		game.start();
	}


	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		g2d.clearRect(0, 0, SCREENSIZE.width, SCREENSIZE.width);


		g2d.drawImage(offscreen.getScaledInstance(SCREENSIZE.width, SCREENSIZE.height, 1), 0, 0, this);
	}

	@Override
	public void run() {
		while(true){

			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}



}
