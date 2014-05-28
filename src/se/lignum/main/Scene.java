package se.lignum.main;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import se.lignum.main.utils.ImageLoader;

public class Scene {
	
	Image background;
	
	List<Instance> instances = new ArrayList<Instance>();
	
	public void tick(){}
	
	public List<Instance> getInstances(){
		return this.instances;
	}
	
	public void instantiate(Instance instance){
		this.instances.add(instance);
	}
	
	public void destroy(Instance instance){
		this.destroy(instance);
	}
	
	public void setBackground(String imagePath){
		this.background = ImageLoader.load(imagePath);
	}

}
