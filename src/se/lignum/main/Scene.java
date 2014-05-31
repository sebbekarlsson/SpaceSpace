package se.lignum.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import se.lignum.main.utils.Camera;
import se.lignum.main.utils.ImageLoader;

public class Scene {

	Image background;

	List<Instance> instances = new ArrayList<Instance>();
	
	protected int ROOM_SIZE_X;
	protected int ROOM_SIZE_Y;
	public Camera camera = new Camera();
	private boolean useCamera = false;
	
	public Scene(int sizeX,int sizeY,boolean useCamera){
		this.ROOM_SIZE_X = sizeX;
		this.ROOM_SIZE_Y = sizeY;
		this.useCamera = useCamera;
	}

	public void tick() {}

	public void draw(Graphics g) {}

	//returns all the instances in the current scene
	public List<Instance> getInstances() {
		return this.instances;
	}

	//creates a new object in the scene
	public void instantiate(Instance instance) {
		this.instances.add(instance);
	}

	//destroys a specific object
	public void destroy(Instance instance) {
		instances.remove(instance);
	}

	public void destroyAll(Object o) {
		for (int i = 0; i < instances.size(); i++) {
			Instance instance = instances.get(i);
			if (instance.getClass().equals(o)) {
				instances.remove(instance);
			}
		}
	}

	public boolean instanceExists(Object o) {
		for (int i = 0; i < instances.size(); i++) {
			Instance instance = instances.get(i);
			if (instance.getClass().equals(o)) {
				return true;
			}
		}

		return false;
	}
	
	public Dimension getRoomSize(){
		return new Dimension(this.ROOM_SIZE_X,this.ROOM_SIZE_Y);
	}

	//sets the scenes background
	public void setBackground(String imagePath) {
		this.background = ImageLoader.load(imagePath);
	}
	
	public boolean hasCamera(){
		return this.useCamera;
	}
	
	public Camera getCamera(){
		return this.camera;
	}
	
	protected void setRoomSize(Dimension d){
		
		this.ROOM_SIZE_X = d.width;
		this.ROOM_SIZE_Y = d.height;
		
	}
	
	
}
