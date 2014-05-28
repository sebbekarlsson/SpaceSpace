package se.lignum.main;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import se.lignum.main.utils.ImageLoader;

public class Scene {
	
	Image background;
	
	List<Instance> instances = new ArrayList<Instance>();
	
	public void tick(){}
	
	
	//returns all the instances in the current scene
	public List<Instance> getInstances(){
		return this.instances;
	}
	
	//creates a new object in the scene
	public void instantiate(Instance instance){
		this.instances.add(instance);
	}
	
	//destroys a specific object
	public void destroy(Instance instance){
		this.destroy(instance);
	}
	
	//sets the scenes background
	public void setBackground(String imagePath){
		this.background = ImageLoader.load(imagePath);
	}

}
