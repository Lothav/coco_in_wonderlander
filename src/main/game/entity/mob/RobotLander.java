package entity.mob;

import  graphics.AnimatedSprite;
import  graphics.Screen;
import  graphics.Sprite;
import  graphics.SpriteSheet;

public class RobotLander extends Mob{
	
	private Sprite sprite;
	private int xa = 0;
	private int ya = 0;
	private int time = 0;
	
	private AnimatedSprite RobotLander = new AnimatedSprite(SpriteSheet.RobotLander, 140, 140, 2);
	
	
	
	public RobotLander(int x, int y){
		this.x = x << 4;
		this.y = y << 4;
		
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
		
		if (walking) RobotLander.update();
		else RobotLander.setFrame(0);
		
		if(xa != 0 || ya !=0){
			move(xa, ya);
			walking = true;
			
		}
		
	}

	public void render(Screen screen) {
		sprite = RobotLander.getSprite();
		screen.renderPlayer140(x-30, y-32, sprite, 0);
	}
	

}