package entity.mob;

import  entity.mob.Mob;
import  entity.mob.coisas.Falas;
import  graphics.AnimatedSprite;
import  graphics.Screen;
import  graphics.Sprite;
import  graphics.SpriteSheet;
import  level.EstadoAtual;

public class LanderComeco extends Mob{
	
	private Sprite sprite;
	private int xa = 0;
	private int ya = 0;
	private int time = 0;
	private int time2 = 0;

	
	private AnimatedSprite LanderComeco = new AnimatedSprite(SpriteSheet.landerAnim, 64, 64, 2);
	private AnimatedSprite monamour = new AnimatedSprite(SpriteSheet.monamourstolenAnim, 64, 64, 2);
	private EstadoAtual ea;
	private int landersome = 0;
	public static int contador = 0;
	
	public LanderComeco(int x, int y){
		this.x = x ;
		this.y = y ;
		
	}

	public void update() {
		
		time++;
		time2++;
		
		if( x > 570  && x < 579){
			//Apenas para chamar a conversa no começo
			ea.State = ea.State.CONVERSAINICIAL;
		}
		
		
		
		if( x > 340 ){			
			if(time % 44 == 0){
					xa--;
					ya = 0;	
					}
			} else {
				
				if(contador == 0){
				//Chama a conversa quando pega monamour
				//contador++ evita que se repita
				ea.State = ea.State.CONVERSAINICIAL;
				Falas.falas++;
				contador++;
				}
			
			if( y > 425 ){
				if( time % 44 == 0){ 
					ya--;
					xa = 0;
					
				}
			}
		}
		
		if(y < 360 && y > 330) Player.aberta = false;
		
		
		if (walking) LanderComeco.update();
		else LanderComeco.setFrame(0);
		
		if (walking) monamour.update();
		else monamour.setFrame(0);
		
		if(xa != 0 || ya !=0){
			move(xa, ya);
			walking = true;
			
		}
		
	}
	public void render(Screen screen) {
		if(!(Player.aberta)) landersome ++;
		if(landersome==0){
			
			if(x > 341){
			
			sprite = LanderComeco.getSprite();
			screen.renderPlayer(x-30, y-32, sprite, 0);
			screen.renderPlayerNovo(305, 605, Sprite.monamourParada, 0);

				}else {
			sprite = monamour.getSprite();
			screen.renderPlayer(x-30, y-32, sprite, 0);
				}
		
	}
	}
	
	

}
