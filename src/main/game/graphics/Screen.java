package graphics;

import java.util.Random;

import  entity.mob.Geladeira;
import  entity.projectile.GeladeiraProjectile;
import  entity.projectile.Projectile;
import  level.tile.Tile;
import  graphics.Sprite;
import  graphics.SpriteSheet;




public class Screen {
	
	public int width;
	public int height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	public int xOffset, yOffset; 
	private Random random = new Random();
	
		
	public Screen (int width , int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for (int i = 0; i < MAP_SIZE * MAP_SIZE ; i++){
			tiles[i] = random.nextInt(0xffffff);
			tiles[0] = 0;	
		}
	}
	
	public void clear(){
		for (int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
			
		
		}
	}
	
	public void renderSheet(int xp, int yp, SpriteSheet sheet, boolean fixed){
		if (fixed){
		xp -= xOffset;
		yp -= yOffset;
		}
			for (int y = 0; y < sheet.HEIGHT; y++){
				int ya = y + yp;
				for (int x = 0; x < sheet.WIDTH; x++){
					int xa = x + xp;
					if (xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
					
					int col = sheet.pixels[x + y * sheet.WIDTH];
					if (col != 0xffffffff && col != 0xffff00ff) pixels[xa + ya * width] = col;
					
					
				}
			}
		}
	
	
	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed){
		if (fixed){
		xp -= xOffset;
		yp -= yOffset;
		}
			for (int y = 0; y < sprite.getHeight(); y++){
				int ya = y + yp;
				for (int x = 0; x < sprite.getWidth(); x++){
					int xa = x + xp;
					if (xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
					int col = sprite.pixels[x + y * sprite.getWidth()];
					if (col != 0xffffffff && col != 0xffff00ff) pixels[xa + ya * width] = col;
					
					
					
					
					
				}
			}
		}

	
	
	public void renderTile(int xp, int yp, Tile tile, int flip){
	xp -= xOffset;
	yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++){
			int ya = y + yp;
			int ys = y;
			if(flip == 1 ) ys = (tile.sprite.SIZE - 1) - y;
			for (int x = 0; x < tile.sprite.SIZE; x++){
				int xa = x + xp;
				int xs = x;
				if(flip == 2) xs = (tile.sprite.SIZE - 1) - x;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height ) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[xs + ys * tile.sprite.SIZE];
			}
		}
	}
	
	public void renderCoisas(int xp, int yp, Tile tile){
	xp -= xOffset;
	yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++){
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++){
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height ) break;
				if (xa < 0) xa = 0;
				
				int col = tile.sprite.pixels[x + y * tile.sprite.SIZE];
				if (col != 0xffffffff && col != 0xffff00ff) pixels[xa + ya * width] = col;
		
			}
		}
	}
	
	
	public void randerProjectile(int xp, int yp, Projectile p){
		xp -= xOffset;
		yp -= yOffset;
			for (int y = 0; y < p.getSpriteSize(); y++){
				int ya = y + yp;
				for (int x = 0; x < p.getSpriteSize(); x++){
					int xa = x + xp;
					if (xa < -p.getSpriteSize() || xa >= width || ya < 0 || ya >= height ) break;
					if (xa < 0) xa = 0;
					int col = p.getSprite().pixels[x + y * p.getSpriteSize()];
					if (col != 0xffff00ff) pixels[xa + ya * width] = col;
				}
			}
		}
	
	public void randerProjectileG(int xp, int yp, GeladeiraProjectile g){
		xp -= xOffset;
		yp -= yOffset;
			for (int y = 0; y < g.getSpriteSize(); y++){
				int ya = y + yp;
				for (int x = 0; x < g.getSpriteSize(); x++){
					int xa = x + xp;
					if (xa < -g.getSpriteSize() || xa >= width || ya < 0 || ya >= height ) break;
					if (xa < 0) xa = 0;
					int col = g.getSprite().pixels[x + y * g.getSpriteSize()];
					if (col != 0xffff00ff) pixels[xa + ya * width] = col;
				}
			}
		}
	
	
	
	public void renderPlayer(int xp, int yp, Sprite sprite, int flip){
	xp -= xOffset;
		yp -= yOffset;
			for (int y = 0; y < 64; y++){
				int ya = y + yp;
				int ys = y;
					for (int x = 0; x < 64; x++){
					int xa = x + xp;
					int xs = x;
					if(flip == 1 || flip == 3) xs = 63 - x;
					if (xa < -64 || xa >= width || ya < 0 || ya >= height ) break;
					if (xa < 0) xa = 0;
					int col = sprite.pixels[xs + ys * 64];
					if(col != 0xffff00ff) pixels[xa + ya * width] = col;
					
					}
				}
			}
	
	public void renderPlayerNovo(int xp, int yp, Sprite sprite, int flip){
	xp -= xOffset;
		yp -= yOffset;
			for (int y = 0; y < 64; y++){
				int ya = y + yp;
				int ys = y;
					for (int x = 0; x < 64; x++){
					int xa = x + xp;
					int xs = x;
					if(flip == 1 || flip == 3) xs = 63 - x;
					if (xa < -64 || xa >= width || ya < 0 || ya >= height ) break;
					if (xa < 0) xa = 0;
					int col = sprite.pixels[xs + ys * 64];
					if(col != 0xffffffff) pixels[xa + ya * width] = col;
					
					}
				}
			}
	
	public void renderPlayer140(int xp, int yp, Sprite sprite, int flip){
		xp -= xOffset;
			yp -= yOffset;
				for (int y = 0; y < 140; y++){
					int ya = y + yp;
					int ys = y;
						for (int x = 0; x < 140; x++){
						int xa = x + xp;
						int xs = x;
						if(flip == 1 || flip == 3) xs = 139 - x;
						if (xa < -140 || xa >= width || ya < 0 || ya >= height ) break;
						if (xa < 0) xa = 0;
						int col = sprite.pixels[xs + ys * 140];
						if(col != 0xffff00ff) pixels[xa + ya * width] = col;
						
						}
					}
				}
	
	public void renderPlayerMenor(int xp, int yp, Sprite sprite, int flip){
		xp -= xOffset;
			yp -= yOffset;
				for (int y = 0; y < 32; y++){
					int ya = y + yp;
					int ys = y;
						for (int x = 0; x < 32; x++){
						int xa = x + xp;
						int xs = x;
						if(flip == 1 || flip == 3) xs = 31 - x;
						if (xa < -32 || xa >= width || ya < 0 || ya >= height ) break;
						if (xa < 0) xa = 0;
						int col = sprite.pixels[xs + ys * 32];
						if(col != 0xffff00ff && col != 0xffFFC3FF) pixels[xa + ya * width] = col;
						
						}
					}
				}


	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		
	}
	
	
	
	

	
}