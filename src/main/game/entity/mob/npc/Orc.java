	package entity.mob.npc;

import game.Game;
import  entity.mob.Mob;
import  entity.mob.Player;
import  graphics.Screen;
import  graphics.Sprite;
import  level.tile.Tile;

	public class Orc extends Mob{
		
		private Sprite sprite;
		private int time = 0;
		private int contaAudio = 0;

		
		public Orc(int x, int y){
			this.x = x ;
			this.y = y ;	
		}
		public void update() {
				}
		public void render(Screen screen) {
			
			if(Player.aberta)  screen.renderCoisas(288, 384, Tile.aberta);
			else{ 
				screen.renderCoisas(288, 384, Tile.porta);
				if (contaAudio == 0){
					contaAudio++;
					Game.audio.playClip(Game.audio.pAbrindo, 0);}
				}
			sprite = Sprite.orc;
			screen.renderPlayerNovo(x-30, y-32, sprite, 0);
		}
		

								}

