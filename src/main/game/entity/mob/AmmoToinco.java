package entity.mob;

import game.Game;
import  entity.projectile.WizardProjectile;
import  graphics.Screen;
import  level.EstadoAtual;
import  level.tile.NoCollTile;
import  level.tile.Tile;

public class AmmoToinco extends Mob{

private boolean pisoCaixa = false;	
private int count = 0;
private int counte = 0;
private int x, y;


public AmmoToinco(int x, int y){
	this.x = x;
	this.y = y;
	//
}


public void update() {

		}


public void render(Screen screen) {
	
	
	
	
	
	
	int PlayerX = screen.xOffset + 170;
	int PlayerY = screen.yOffset + 120;
		
	
	if( x - PlayerX < 20 && x - PlayerX > -20
     && y - PlayerY < 20 && y - PlayerY > -20) pisoCaixa = true;	
			
			
	if (count < 35 && counte == 0){		
			
		if( pisoCaixa ) {
			
			Game.audio.playClip(Game.audio.toincoammo , 0);
			if(count == 0) WizardProjectile.countpor++;
			screen.renderCoisas(x, y, NoCollTile.ammo1);
			count++;
		}
	
		else screen.renderCoisas(x, y, NoCollTile.ammo0);
	 		
	}else{
		count = 0;
		counte = 1;
	}
		}
			}