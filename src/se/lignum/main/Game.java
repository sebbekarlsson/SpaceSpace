package se.lignum.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import se.lignum.main.scenes.GameScene;
import se.lignum.main.scenes.MenuScene;

public class Game extends JFrame implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 2;
	private String fps, ups;

	public static final Dimension SCREENSIZE = new Dimension(WIDTH*SCALE,HEIGHT*SCALE);
	public static final Dimension RENDERSIZE = new Dimension(SCREENSIZE.width/2,SCREENSIZE.height/2);
	public static BufferedImage offscreen = new BufferedImage(RENDERSIZE.width,RENDERSIZE.height,BufferedImage.TYPE_INT_RGB);

	Thread gameLoop = new Thread(this,"Game Loop");
	
	List<Scene> scenes = new ArrayList<Scene>();
	public static int sceneIndex = 0;
	
	public static boolean vk_down = false;
	public static boolean vk_up = false;
	public static boolean vk_enter = false;





	public Game() {
		
		
		//this is where the scenes should be added
		this.scenes.add(new MenuScene());
		this.scenes.add(new GameScene());
		
		//frame options
		this.setSize(SCREENSIZE);
		this.setTitle("Space Game");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addKeyListener(this);
	}

	//starts the gameloop thread
	public void start(){
		this.gameLoop.start();
	}

	public static void main(String[] args){
		Game game = new Game();
		game.start();
	}


	// Only print stuff!
	public void paint(Graphics g){
		Graphics gg = offscreen.getGraphics();

		gg.clearRect(0, 0, SCREENSIZE.width, SCREENSIZE.width);
		
		//draws the current scenes background if there is any
		if(getCurrentScene().background != null){
			gg.drawImage(getCurrentScene().background, 0, 0, this);
		}

		getCurrentScene().draw(gg);
		getCurrentScene().tick();
		//calls the tick and draw method for every instance in the current scene
		for(int i = 0; i < getCurrentScene().getInstances().size(); i++){
			
			Instance instance = getCurrentScene().getInstances().get(i);
			instance.tick();
			instance.draw(gg);
			
			
		}
		
		
		
		g.drawImage(offscreen.getScaledInstance(SCREENSIZE.width, SCREENSIZE.height, 1), 0, 0, this);
		
	}
	
	// Updates 60 times/sec
	private void tick(){
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		
		while(true){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			
			repaint();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " Ups " + frames + " Fps");
				updates = 0;
				frames = 0;
			}
			
		}

	}
	
	//returns the current scene
	public Scene getCurrentScene(){
		return this.scenes.get(sceneIndex);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			vk_up = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			vk_down = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			vk_enter = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			vk_up = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			vk_down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			vk_enter = false;
		}
		
	}



}
