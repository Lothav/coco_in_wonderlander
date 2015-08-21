package entity.projectile;

import java.util.Random;

import game.Game;
import  entity.Entity;
import  entity.mob.Player;
import  graphics.Sprite;
import  imput.Mouse;

public abstract class ProjectileG extends Entity {

	
	protected final int xOrigin, yOrigin;
	protected double angle;
	public Sprite sprite;
	public static int type = 0;
	protected double x, y;
	protected double nx, ny;
	protected double distance;
	protected double speed, range, damage;
 	
	protected final Random random = new Random();
	
	public ProjectileG(int x, int y, double dir){
		xOrigin = x ;
		yOrigin = y;
		angle = dir;
		
		Player p = level.getClientPlayer();
		double px = p.getX();
		
		
			if(px > x){
				
		this.x = x + 20;
		this.y = y - 15;	
			
			}else{	
				
		this.x = x - 35;
		this.y = y - 15;
			
		}
	}	
	
	public Sprite getSprite(){
		return sprite;
	}
	
	public int getSpriteSize(){
		return sprite.SIZE;
		
		
	}
	protected void move(){
			
	}
}