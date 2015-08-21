package entity.mob;

import  graphics.AnimatedSprite;
import  graphics.Screen;
import  graphics.Sprite;
import  graphics.SpriteSheet;

public class Buraco extends Mob{
	
	private Sprite sprite;
	private int xa = 0;
	private int ya = 0;
	private int time = 0;
	
	private AnimatedSprite Buraco = new AnimatedSprite(SpriteSheet.buracoAnim, 32, 32, 2);
	
	
	
	public Buraco(int x, int y){
		this.x = x ;
		this.y = y ;
		
	}

	public void update() {
		time++;
		Buraco.setFrameRate(4);

		if (time % (random.nextInt(50) + 30) == 0){
			xa = random.nextInt(3) - 1;
			ya = random.nextInt(3) - 1;
			if (random.nextInt(3) == 0){
				xa = 0;
				ya = 0;
			}
		}
		
	 Buraco.update();
		
		
		
			
		
		
	}

	public void render(Screen screen) {
		sprite = Buraco.getSprite();
		screen.renderPlayerMenor(x-30, y-32, sprite, 0);
	}
	

}