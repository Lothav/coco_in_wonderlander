package entity.projectile;

import game.Game;
import  entity.Entity;
import  entity.spawner.Spawner;
import  entity.mob.Ranieri;
import  entity.particle.Particle;
import  entity.spawner.ParticleSpawner;
import  graphics.Screen;
import  graphics.Sprite;
import  graphics.SpriteSheet;
import  imput.Mouse;
import  level.SpawnLevel;

public class WizardProjectile extends Projectile{
	
	public static int countpor = 3;
	public static final int FIRE_RATE = 15 ;
	private Entity wp;
	private Ranieri ranieri;

	private int conta = 0;



	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = random.nextInt(100)+150;
		speed = 2;
		damage = 20;
		if( Mouse.getButton() == 1 )	{
			type = 1;
			sprite = Sprite.projectile;
			Game.audio.playClip( Game.audio.cocoatiras , 0 );		
		}
		
		if( Mouse.getButton() == 3 ){	
			sprite = Sprite.porcao;
			type = 3;
			Game.audio.playClip( Game.audio.porcos , 0);	
		
		}
		
		
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
		
	}
	
	public void update(){
		if(level.tileCollision((int)(x+nx),(int)(y+ny), 1, 12, 32)) {
			level.add(new ParticleSpawner((int)x , (int)y , 40, 50, level));
			
			if ( sprite == Sprite.porcao) Game.audio.playClip( Game.audio.porcoexpls , 0);		
			if ( sprite == Sprite.projectile) Game.audio.playClip( Game.audio.cocoexpls , 0);		

			remove();
	}
		move();
	}
	
	protected void move(){
		x += nx;
		y += ny;
		if (distance() > range) remove();
		

	/*	
			wp = level.getClientEntity();

		if ( x > wp.getX() - 30 && x < wp.getX() + 10
				 && y > wp.getY() - 45 && y < wp.getY() + 10 ){
					
					
					Game.audio.playClip( Game.audio.freeze  , 0);		
					ranieriRemove  = true;			
				
		}
		conta++;
	
		*/
		
	}
	
	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x)*(xOrigin - x) + (yOrigin - y)*(yOrigin - y)));
		return dist;
	}
	
	public int getX(){
		return (int) x;
	}
	
	public int getY(){
		return (int) y;
	}

	public void render(Screen screen){
		screen.randerProjectile((int)x, (int)y, this);
	

	}
}
