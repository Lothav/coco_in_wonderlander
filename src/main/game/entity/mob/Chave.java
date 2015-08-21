package entity.mob;

import game.Game;
import  entity.mob.coisas.Falas;
import  entity.projectile.WizardProjectile;
import  graphics.Screen;
import  level.tile.NoCollTile;
import  level.tile.Tile;

public class Chave extends Mob{

public static boolean pisoChave = false;	
private int count = 0;
private int counte = 0;
private int x, y;
private int contaAudio = 0;



public Chave(int x, int y){
	this.x = x;
	this.y = y;
	//
}


public void update() {

		}


public void render(Screen screen) {
	
	int PlayerX = screen.xOffset + 170;
	int PlayerY = screen.yOffset + 120;
if(Falas.chaveSpawn){		
	
	if( x - PlayerX < 20 && x - PlayerX > -20
     && y - PlayerY < 20 && y - PlayerY > -20) pisoChave = true;	
			
			
	if (count < 35 && counte == 0){		
			
		if( pisoChave ) {
			
			if(contaAudio  == 0) {contaAudio++;
			Game.audio.playClip(Game.audio.chave , 0);
			}
			count++;
		}
	
		else screen.renderCoisas(x, y, NoCollTile.chave);
	 		
	}else{
		count = 0;
		counte = 1;
	}
		}
			}}