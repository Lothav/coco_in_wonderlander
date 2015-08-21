package entity.mob;

import java.util.List;
import java.util.Vector;

import game.Dignidade;
import game.Game;
import  entity.Entity;
import  entity.projectile.WizardProjectile;
import  graphics.AnimatedSprite;
import  graphics.Screen;
import  graphics.Sprite;
import  graphics.SpriteSheet;
import  imput.Keyboard;
import  level.Level;
import  level.TileCoordinate;
import  level.tile.Node;
import  level.tile.Tile;
import  util.Vector2i;

public class Macacao extends MobMacacao{

	public static int sofre = 0;
	private int count = 0;
	private Sprite sprite;
	private int time = 50;
	private AnimatedSprite macacao = new AnimatedSprite(SpriteSheet.macacaoAnim, 64, 64, 2);
	public static int coont = 0;
	private List<Node> path = null;
	private int timeS = 0;

	
	public Macacao(int x, int y){
		this.x = x << 4 ;
		this.y = y << 4;			
	}
	


	public void move(){
		xa = 0;
		ya = 0;
		macacao.setFrameRate(15);
		Player player = level.getClientPlayer();
		
		if (x - player.getX() < 20 && x - player.getX() > -20
				 && y - player.getY() < 20 && y - player.getY() > -20){ 
			sofre++;
			if(Dignidade.dign > 0 && sofre % 20 == 0) Game.audio.playClip( Game.audio.cocosofres , 0 );		

			Dignidade.dign--;
			}

		
		
		int px = level.getPlayerAt(0).getX();
		int py = level.getPlayerAt(0).getY();
		Vector2i start = new Vector2i(getX() >> 4, getY() >> 4);
		Vector2i destination = new Vector2i(px >> 4, py >> 4);
		if(time % 10 == 0)	path = level.findPath(start, destination);
		if(path != null){
			if(path.size() > 0){
				Vector2i vec = path.get(path.size() - 1).tile;
				if ( x < vec.getX() << 4) xa++;
				if ( x > vec.getX() << 4) xa--;
				if ( y < vec.getY() << 4) ya++;
				if ( y > vec.getY() << 4) ya--;
				
			}
			
		}
		if(xa != 0 || ya !=0 ){
			move(xa, ya);
			walking = true;
		}else{
			walking = false;
		}
		//porta
	/*	
		if( time % 5 == 1 || time % 5 == 0 || time % 5 == 3 || time % 5 == 4){
		if (x < player.getX() ) xa++;
		if (x > player.getX() ) xa--;
		if (y < player.getY() ) ya++;
		if (y > player.getY() ) ya--;
		time++;
		if(time > 1000) time = 50;
		}
		
		
		*/
	}

	public void update() {
		move();		
		time++;
		timeS++;

		if (time % (random.nextInt(50) + 30) == 0){
			xa = random.nextInt(3) - 1;
			ya = random.nextInt(3) - 1;
			if (random.nextInt(3) == 0){
				xa = 0;
				ya = 0;
			}
		}
		
		if (walking) macacao.update();
		else macacao.setFrame(0);
	}
	

	public void render(Screen screen) {
		
		Player player = level.getClientPlayer();		
		
		sprite = macacao.getSprite();
		screen.renderPlayer(x-30, y-32, sprite, 0);		
		
		// Fala de coco co macacao

		if(count > 10000) count = 0;
	
		if(player.getX() - x  < 150 && count < 1000) {
			screen.renderCoisas(x, y-100, Tile.falamac);
			screen.renderCoisas(player.getX(), player.getY() - 100, Tile.cocofala);		
			}
		
		if(player.getX() - x  < 150) count++;

		
		
					}
	
	
	
	
}