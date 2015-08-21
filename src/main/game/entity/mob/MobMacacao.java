package entity.mob;


import game.Game;
import  entity.Entity;
import  entity.projectile.GeladeiraProjectile;
import  entity.projectile.Projectile;
import  entity.projectile.ProjectileG;
import  entity.projectile.WizardProjectile;
import  graphics.Screen;
import  graphics.Sprite;
import  level.tile.GarraPe;

public abstract class MobMacacao extends Entity{

	
	protected Sprite sprite;
	protected int dirA = 1;   
	protected boolean moving = false;
	protected boolean oler = false;

	protected boolean walking = false;
	protected enum Direction {
		UP, DOWN, LEFT, RIGHT	
	}
	
	private int direc = 0;
	
	
	protected Direction dir;


	public void move(int xa, int ya){
		if (xa != 0 && ya != 0 && !TaPreso(xa, ya)){
			move( xa , 0 );
			move( 0 , ya );

			return;
			
		}
		if (xa > 0) dir = Direction.RIGHT;  
		if (xa < 0) dir = Direction.LEFT;  
		if (ya > 0) dir = Direction.DOWN;
		if (ya < 0) dir = Direction.UP;

		if (xa > 0) dirA = 1;
		if (xa < 0) dirA = 3;
	
		
		if (!collision(xa, ya)){
		x += xa;
		y += ya;
		}
		
	//aberta
		
		
		if(Escorrega(xa,ya)){
			x += xa;
			y += ya * 14;
		}
		
		if (!collision(xa, ya)){
			x += xa;
			y += ya;
			}
		
	}
	
	public abstract void update();
	
	public abstract void render(Screen screen);

	
	protected void shoot(int x, int y, double dir){
		//dir *= (180 / Math.PI);
		Projectile p = new WizardProjectile(x, y, dir);
		level.add(p);
	}
	
	protected void shootG(int x, int y, double dir){
		//dir *= (180 / Math.PI);
		ProjectileG g = new GeladeiraProjectile(x, y, dir);
		level.add(g);
	}
	
	

	
	private boolean collision(double xa , double ya){
		boolean solid = false;
		for(int c = 0; c < 4 ; c++){
			double xt = ((x + xa) - c % 2 * 15) /16;
			double yt = ((y + ya) - c / 2 * 15) /16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if(c % 2 == 0) ix = (int) Math.floor(xt);
			if(c / 2 == 0) iy = (int) Math.floor(yt);
					if(level.getTile(ix, iy).solid()) solid = true;
		}
		return solid;
	}
	
	
	private boolean Escorrega(int xa , int ya){
		boolean xia = false;
		for(int c = 0; c < 4 ; c++){
			int xt = 0; 
			
			if( dir == Direction.DOWN || dir == Direction.UP ){
					
					xt = ( (x+xa) - c / 2 * 14 + 8) / 16;
					
					}
					else
				{
				if( dirA == 1 ) xt = ((x+xa) - c % 2 * 14 + 23) / 16;
				if( dirA == 3 ) xt = ((x+xa) + c % 2 * 14 - 23) / 16;
				}
																
			int yt = ((y+ya) + c / 2 * 12 + 18) / 16;
		
			if (level.getTile( xt , yt ).xia()) xia = true;
		}
		return xia;
	}

	private boolean TaPreso(int xa , int ya){
		boolean garrou = false;
		for(int c = 0; c < 4 ; c++){
			int xt = 0; 
			
			if( dir == Direction.DOWN || dir == Direction.UP ){
					
					xt = ( (x+xa) - c / 2 * 14 + 8) / 16;
					
					}
					else
				{
				if( dirA == 1 ) xt = ((x+xa) - c % 2 * 14 + 23) / 16;
				if( dirA == 3 ) xt = ((x+xa) + c % 2 * 14 - 23) / 16;
				}
																
			int yt = ((y+ya) + c / 2 * 12 + 18) / 16;
		
			if (level.getTile( xt , yt ).garrou()) garrou = true;
		}
		return garrou;
	}
}
