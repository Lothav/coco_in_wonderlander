package entity.mob;

import game.Dignidade;
import game.Game;
import  entity.particle.Particle;
import  entity.projectile.Projectile;
import  entity.projectile.WizardProjectile;
import  graphics.AnimatedSprite;
import  graphics.Screen;
import  graphics.Sprite;
import  graphics.SpriteSheet;
import  level.Level;

public class Ranieri extends Mob{
	
	
	private AnimatedSprite ranieri = new AnimatedSprite(SpriteSheet.ranieriAnim, 64, 64, 2);
	
	private Sprite sprite;
	private int xa = 0;
	private int ya = 0;
	private int time = 0;
	private Projectile p;
	private int time2 = 50;


	private int vida = 6;

	private int contaAudio = 0;
	
	
	public Ranieri(int x, int y){
		this.x = x;
		this.y = y;
		
	}

	public void update() {
		
		if(Player.aberta2)move();		
		time++;

		if (time % (random.nextInt(50) + 30) == 0){
			xa = random.nextInt(3) - 1;
			ya = random.nextInt(3) - 1;
			if (random.nextInt(3) == 0){
				xa = 0;
				ya = 0;
			}
		}
		
		if (walking) ranieri.update();
		else ranieri.setFrame(0);
		
		if(xa != 0 || ya !=0){
			move(xa, ya);
			walking = true;
			
		}

		
		// Dano ne Ranieri
		if(!(Level.projectiles.isEmpty())){
			p = level.getClientProjectile();
				if ( p.getX() > x - 30 && p.getX() < x + 10
						 && p.getY() > y - 45 && p.getY() < y + 10){
					vida --;
					if(vida > 0) Game.audio.playClip( Game.audio.Ranieri  , 0);		
					else Game.audio.playClip( Game.audio.Ranieri2  , 0);	
					if(vida == 0)remove();
					p.remove();
					}
				}

	}
	
	
	public void move(){
		xa = 0;
		ya = 0;
		
		Player player = level.getClientPlayer();
		
		if(contaAudio == 50){
			Game.audio.playClip( Game.audio.RanieriScream  , 0);	
			
			 
		}
		contaAudio++;
		
		if (x - player.getX() < 20 && x - player.getX() > -20
				 && y - player.getY() < 20 && y - player.getY() > -20){ 
			Macacao.sofre++;
			if(Dignidade.dign > 0 && Macacao.sofre % 20 == 0) Game.audio.playClip( Game.audio.cocosofres , 0 );		

			Dignidade.dign--;
			}

		if(time % 3 == 0){
		if (x < player.getX() ) xa++;
		if (x > player.getX() ) xa--;
		if (y < player.getY() ) ya++;
		if (y > player.getY() ) ya--;
		time++;
		if(time > 1000) time = 50;
		}
		
		if(xa != 0 || ya !=0){
			move(xa, ya);
			walking = true;
		}
	}

	public void render(Screen screen) {
		sprite = ranieri.getSprite();
		screen.renderPlayer(x-30, y-32, sprite, 0);
	}
	
	
	

}