package entity.projectile;

import game.Game;
import  entity.mob.Geladeira;
import  entity.mob.Player;
import  graphics.Screen;
import  graphics.Sprite;

public class GeladeiraProjectile extends ProjectileG{
	
	public static int countpor = 3;
	public static final int FIRE_RATE = 100 ;
	public static boolean congelado = false;
	public static int cong = 0;
	
	public GeladeiraProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = random.nextInt(1000)+150;
		speed = 4;
		damage = 20;
		
		sprite = Sprite.gelo;
		
		
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
		
	}
	
	public void update(){
		if(level.tileCollision(x, y, nx, ny, 64)) remove();
	
		move();
	}
	
	protected void move(){
		x += nx;
		y += ny;
		
		Player p = level.getClientPlayer();
		
		
		if (x > p.getX() - 30 && x < p.getX() + 10
		 && y > p.getY() - 45 && y < p.getY() + 10 && cong <= 30){
			
			congelado = true;
			Game.audio.playClip( Game.audio.freeze  , 0);		

			remove();	
		}
		
		if (distance() > range) remove();
	}
	
	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x)*(xOrigin - x) + (yOrigin - y)*(yOrigin - y)));
		return dist;
	}

	public void render(Screen screen){
		
	screen.randerProjectileG((int)x, (int)y, this);

	}
}
