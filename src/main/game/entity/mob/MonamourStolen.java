package entity.mob;
import  graphics.AnimatedSprite;
import  graphics.Screen;
import  graphics.Sprite;
import  graphics.SpriteSheet;

public class MonamourStolen extends Mob{
	
	
	private Sprite sprite;
	private int xa = 0;
	private int ya = 0;
	private int time = 0;
	
	private AnimatedSprite monamourstolen = new AnimatedSprite(SpriteSheet.monamourstolenAnim, 64, 64, 2);
	
	
	public MonamourStolen(int x, int y){
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
		
		if (walking) monamourstolen.update();
		else monamourstolen.setFrame(0);
		
		if(xa != 0 || ya !=0){
			move(xa, ya);
			walking = true;
			
		}
		
	}

	public void render(Screen screen) {
		sprite = monamourstolen.getSprite();
		screen.renderPlayer(x-30, y-32, sprite, 0);
	}
	
	
	

}