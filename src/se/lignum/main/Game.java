package se.lignum.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import se.lignum.main.scenes.testScene;

public class Game extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 2;

	public static final Dimension SCREENSIZE = new Dimension(WIDTH*SCALE,HEIGHT*SCALE);
	public static final Dimension RENDERSIZE = new Dimension(SCREENSIZE.width/2,SCREENSIZE.height/2);
	public static BufferedImage offscreen = new BufferedImage(RENDERSIZE.width,RENDERSIZE.height,BufferedImage.TYPE_INT_RGB);

	Thread gameLoop = new Thread(this,"Game Loop");
	
	List<Scene> scenes = new ArrayList<Scene>();
	public int sceneIndex = 0;





	public Game() {
		this.scenes.add(new testScene());
		
		this.setSize(SCREENSIZE);
		this.setTitle("Space Game");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void start(){
		this.gameLoop.start();
	}

	public static void main(String[] args){
		Game game = new Game();
		game.start();
	}


	public void paint(Graphics g){
		Graphics gg = offscreen.getGraphics();

		gg.clearRect(0, 0, SCREENSIZE.width, SCREENSIZE.width);
		
		if(getCurrentScene().background != null){
			gg.drawImage(getCurrentScene().background, 0, 0, this);
		}

		for(int i = 0; i < getCurrentScene().getInstances().size(); i++){
			Instance instance = getCurrentScene().getInstances().get(i);
			instance.tick();
			instance.draw(gg);
			
		}
		
		
		
		g.drawImage(offscreen.getScaledInstance(SCREENSIZE.width, SCREENSIZE.height, 1), 0, 0, this);
		
		repaint();
		
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
	
	public Scene getCurrentScene(){
		return this.scenes.get(sceneIndex);
	}



}
