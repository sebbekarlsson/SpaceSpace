package se.lignum.main.instances;




import se.lignum.main.Instance;
import se.lignum.main.utils.Mathz;

public class Star extends Instance {
	
	int dir = Mathz.random.nextInt(4);
	int speed = (int) Mathz.chooseDouble(1,2);

	public Star(double x, double y) {
		super(x, y);
		this.setSprite("images/star.png");
		int scale = Mathz.random.nextInt(16)+1;
		this.sprite = sprite.getScaledInstance((int)scale, (int)scale, 1);
		
	}
	
	public void tick(){
		
		switch(dir){
		case 0: x+=speed; break;
		case 1: x-=speed; break;
		case 2: y+=speed; break;
		case 3: y-=speed; break;
		}
		
		if(Mathz.random.nextInt(2000) >= 1900){
			dir = Mathz.random.nextInt(4);
		}
		
	}

}
