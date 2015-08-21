package entity.mob;

import  graphics.Screen;
import  level.tile.NoCollTile;

public class BabaRanieri extends Mob{

public static boolean pisoBaba = false;	
private int count = 0;
private int counte = 0;
private int x, y;


public BabaRanieri(int x, int y){
	this.x = x;
	this.y = y;
	//
}

public void update() {

		}

public void render(Screen screen) {
	
	int PlayerX = screen.xOffset + 170;
	int PlayerY = screen.yOffset + 120;
	
	screen.renderCoisas(x, y, NoCollTile.baba);

	if( x - PlayerX < 20 && x - PlayerX > -20
     && y - PlayerY < 20 && y - PlayerY > -20) pisoBaba = true;	
					
	if (count < 35 && counte == 0){		
			
		if( pisoBaba ) {
			remove();
			counte++;
			}
		}
	}
}