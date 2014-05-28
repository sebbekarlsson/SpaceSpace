package se.lignum.main.instances;

import java.awt.event.KeyEvent;

import se.lignum.main.Game;
import se.lignum.main.Instance;

public class testObject extends Instance{

	int xx = 0;
	int yy = 0;

	public testObject(double x, double y) {
		super(x, y);
		this.setSprite("images/pc.png");

	}

	public void tick(){


		
		for(int i = 0; i < Game.getCurrentScene().getInstances().size(); i++){
			Instance instance = Game.getCurrentScene().getInstances().get(i);
			if(instance instanceof MovePoint){
				xx = (int) instance.x;
				yy = (int) instance.y;
				if(x >= instance.x && x <= instance.x+instance.getSprite().getWidth(null) && y >= instance.y && y <= instance.y+instance.getSprite().getHeight(null)){
					Game.getCurrentScene().destroy(instance);
					
				}
			}

		}
		

		if(this.isInSelection()){
			marked = true;
		}

		if(marked){

			if(Game.getCurrentScene().instanceExists(MovePoint.class)){

				if(x < xx){
					x++;
				}
				else if(x > xx){
					x--;
				}
				else if(y < yy){
					y++;
				}
				else if(y > yy){
					y--;
				}



			}

		}

		if(Game.vk_enter){
			xx = Game.mouse.getX();
			yy = Game.mouse.getY();
		}



	
	}
}





