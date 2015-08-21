package entity;

import java.util.Random;

import  entity.mob.Macacao;
import  entity.mob.Player;
import  graphics.Screen;
import  graphics.Sprite;
import  level.Level;
import  level.SpawnLevel;

public class Entity {
	private int counte = 0;

	public int x, y, xa , ya;
	protected Sprite sprite;
	private boolean removed = false;
	protected static Level level;
	protected final Random random = new Random();

	
	public Entity(){
		
	}
	
	public Entity(int x, int y, Sprite sprite){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		
		//collision
	}

	
	public void update(){
		
	}
	
	
	
	public void render(Screen screen){
		if (sprite !=null) screen.renderSprite(x, y, sprite, true);
		
	}
	
	public void remove(){
		// Remove do level
		//System.out.println("Macaco X : " + getX());
		//System.out.println("Player X : " + player.getX());
		removed = true;
	}
	
	public int getX(){
		return x;	
	}
	
	public int getXa(){
		return xa;
		
	}
	
	public int getY(){
		return y;

	}
	
	public Sprite getSprite(){
		return sprite;
	}
	
	public boolean isRemoved(){
		return removed;
		
	}
	
	public void init(Level level){
		this.level = level;
		
	}
	
	
}
