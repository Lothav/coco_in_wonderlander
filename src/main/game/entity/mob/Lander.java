package entity.mob;

import  graphics.AnimatedSprite;
import  graphics.Screen;
import  graphics.Sprite;
import  graphics.SpriteSheet;

public class Lander extends Mob{
	
	private Sprite sprite;
	private int xa = 0;
	private int ya = 0;
	private int time = 0;
	
	private AnimatedSprite lander = new AnimatedSprite(SpriteSheet.landerAnim, 64, 64, 2);
	
	
	public Lander(int x, int y){
		this.x = x ;
		this.y = y ;
		
	}

	public void update() {
		time++;
		if (time % (random.nextInt(50) + 30) == 0){
			xa = random.nextInt(3) - 1;
			ya = random.nextInt(3) - 1;
			if (random.nextInt(3) == 0){
				xa = 0;
				ya = 0;
			}
		}
		
		if (walking) lander.update();
		else lander.setFrame(0);
		
		if(xa != 0 || ya !=0){
			move(xa, ya);
			walking = true;
			
		}
		
	}
	public void render(Screen screen) {
		sprite = lander.getSprite();
		screen.renderPlayer(x-30, y-32, sprite, 0);
	}
	
	
	

}
