package entity.mob;

import game.Dignidade;
import game.Game;
import  entity.mob.Mob.Direction;
import  entity.mob.coisas.Falas;
import  entity.mob.coisas.RenderDepoisDoPlayer;
import  entity.projectile.GeladeiraProjectile;
import  entity.projectile.Projectile;
import  entity.projectile.WizardProjectile;
import  graphics.Screen;
import  graphics.Sprite;
import  imput.Keyboard;
import  imput.Mouse;
import  level.EstadoAtual;
import  level.TileCoordinate;
import  level.tile.NoCollTile;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private int conta = 0;
	private boolean walking;
	private int fireRate = 0;
	private int contaAudio = 0;
	EstadoAtual ea ;
	Game game;
	public static boolean aberta = true;
	public static boolean aberta2 = false;
	private TileCoordinate playerSpawn2 = new TileCoordinate(3, 120);
	private NoCollTile nc;

	
	private int counta =0;
	private int destrava = 0;
	private int contador = 0;
	private int contador2 = 0;
	public static int contaSMacacoOnCoco = 0;
	
	public static boolean outoincos = false;
	
	public Player(Keyboard input){
		this.input = input;
		sprite = Sprite.coco_parado;
		
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x ;
		this.y = y;
		this.input = input;
		fireRate = WizardProjectile.FIRE_RATE;
	
		
	}
	
	public void update(){
	//	colliPorta ();
		if (fireRate > 0) fireRate--;
		int xa = 0, ya =0;
		if (anim < 7500) anim++; 
		else anim =0;
		
		if(y > 475  && Falas.liberaCoco){
			
			ya--;
			
			if ((xa != 0 || ya != 0) && !GeladeiraProjectile.congelado && !Geladeira.slow) {
				move( xa, ya );
				if(slow(xa,ya)) Geladeira.slow = true;
				walking = true;
			}else{
				walking = false;
			}
			
		} else	
			
				if(y <= 476 && contador == 0 && !aberta) {
					contador2++;
					if(contador2 > 30){
					Falas.falas++;
					fireRate = WizardProjectile.FIRE_RATE;
					ea.State = ea.State.CONVERSAINICIAL;	
					contador++;
					}
			}
		else 
				
				
				if(Dignidade.dign > 0 && LanderComeco.contador > 0)
		{
			
		if(input.up) {
			ya--;
			Macacao.sofre++;
		if( Macacao.sofre % 15 == 0)Game.audio.playClip( Game.audio.runs , 0);		
}
		if(input.down) {
			ya++;
			Macacao.sofre++;
			if( Macacao.sofre % 15 == 0)Game.audio.playClip( Game.audio.runs  , 0);		
}
		if(input.left){ 
			xa--;
			Macacao.sofre++;
			if( Macacao.sofre % 15 == 0)Game.audio.playClip( Game.audio.runs , 0);			
}
		if(input.right) {
			xa++;
			Macacao.sofre++;
			if( Macacao.sofre % 15 == 0)Game.audio.playClip( Game.audio.runs , 0);				
}

		if ((xa != 0 || ya != 0) && !GeladeiraProjectile.congelado && !Geladeira.slow) {
			move( xa, ya );
			if(slow(xa,ya)) Geladeira.slow = true;
			walking = true;
	}else{
			walking = false;
		}
		
		if( Geladeira.slow && (xa != 0 || ya != 0)
				&& !GeladeiraProjectile.congelado){
		
			if(conta % 4 == 0)
			move( xa, ya );
			if(slow(xa,ya)) Geladeira.slow = true;
			conta++;
			walking = true;
		}
		
		
		clear();

		if(!walking && !GeladeiraProjectile.congelado && LanderComeco.contador > 0) updateShooting();	
	
	}
	
	if( Dignidade.dign <= 0 && contaSMacacoOnCoco == 0){
		Game.audio.playClip(Game.audio.macacooncoco, 0);
		contaSMacacoOnCoco ++;
	}
		
		if(Dignidade.dign <= 0 && Mouse.getButton() == 1 && counta == 0){
			ea.State = ea.State.MENU;
			Player player = Game.player;
			player.remove();
			game = game.game;
			Chave.pisoChave = false;
			game.inicia();
			counta ++;
		}
		
		Player p = level.getClientPlayer();
		if( p.getX() > 231 && p.getX() < 248 && 
			p.getY() > 285 && p.getY() < 320 && counta == 0 && ea.fase == ea.fase.UM){
			Player player = Game.player;
			player.remove();
			ea.fase = ea.fase.DOIS;
			game = game.game;
			game.playerSpawn = playerSpawn2;
			game.inicia();
			counta ++;
		}
		
		
		
		
		
	}
	
	private boolean slow(int xa , int ya){
		boolean slow = false;
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
		
			if (level.getTile( xt , yt ).slow()) slow = true;
		}
		return slow;
	}

	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i++){
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) level.getProjectiles().remove(i);
	
		}
	}

	private void updateShooting() {
	
		if (( Mouse.getButton() == 1 || (Mouse.getButton() == 3 && WizardProjectile.countpor > 0 )) && fireRate <= 0){
			double dx = Mouse.getX() - Game.getWindowWidth()/2;
			double dy = Mouse.getY() - Game.getWindowHeight()/2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			if(Mouse.getButton() == 1) fireRate = WizardProjectile.FIRE_RATE;
			if(Mouse.getButton() == 3) {fireRate = WizardProjectile.FIRE_RATE + 50;
			WizardProjectile.countpor--;
			if(WizardProjectile.countpor < 0) WizardProjectile.countpor = 0;
			}		
		}
	}

	private boolean collision(){
		return false;
	}
	
	
	public int playerX(){
		return x;
	}
	
	//public boolean colliPorta (){
	//	solid  
	//	if(level.tileCollision(x, y, 288, 344, 48)) solid = true;
	//	return solid;
//	}
	
	public void render(Screen screen){
		
		
		int flip = 4;
		double dx = Mouse.getX();
		double ax = Game.getWindowWidth()/2;
		if(Dignidade.dign > 0){
			
			if(GeladeiraProjectile.congelado){
				
				sprite = Sprite.coco_congelado;
				//if (cong % 50 == 0)GeladeiraProjectile.congelado = false;
				
			}else if(WizardProjectile.countpor <=0 && Mouse.getButton() == 3 && !walking){
				
				sprite = Sprite.coco_outonincos;
				outoincos = true ;
			
				
		}else{
		outoincos = false ;
		if(walking && dirA == 1){
			
			if (anim % 20 > 9){
				sprite = Sprite.coco_dedo;
			}
			
			else {
				sprite = Sprite.coco_soco;	
			} 
		
		}	
			
			if(walking && dirA == 3){
				flip = 1;
				if (anim % 20 > 9){
						
					sprite = Sprite.coco_dedo;

				}
				
				else{
					sprite = Sprite.coco_soco;
				}	
				
			}
			
			
			//Atirando
			if(!walking && Mouse.getButton() == 1 && Projectile.atirandoBaixo ){
				
				sprite = Sprite.coco_cannon_baixo;
				
				}else
				
			if(!walking && Mouse.getButton() == 1 && Projectile.atirandoCima ){
				
				
				if(Projectile.atirandoCimaD)
					sprite = Sprite.coco_cannon_cima;
					
				else{ sprite = Sprite.coco_cannon_cima;
					flip = 1;
				    }
				
				}else
			
			 if(!walking && Mouse.getButton() == 1 && dx < ax ){
				 flip = 3;
					sprite = Sprite.coco_cannon;
			}else if(!walking && Mouse.getButton() == 1 && dx > ax ){
				sprite = Sprite.coco_cannon;
			}else if(!walking && Mouse.getButton() == 3 && dx < ax ){
					
				 flip = 3;
					sprite = Sprite.coco_omg;
			}else if(!walking && Mouse.getButton() == 3 && dx > ax ){
				sprite = Sprite.coco_omg;
			}	
			if(!walking && Mouse.getButton() != 1 && Mouse.getButton() != 3){

				if(dirA == 3){
					flip = 3;
					sprite = Sprite.coco_parado;
				}else{
				sprite = Sprite.coco_parado;
				}	
			}
		}
			}else{
			sprite = Sprite.coco_morto;
				}
		
		//Abre a porta quando o player já pegou a chave e se aproximou dela
		if(ea.fase == ea.fase.UM){
			if(Chave.pisoChave && y < 450 && y > 350 && x > 270 && x < 350) aberta = true;
			if(Falas.soltaRanieri && y > 600 && x > 35 && x < 120) aberta2 = true;
		}
		
		
		//Renderiza porta
		//Renderiza o player
		screen.renderPlayer(x-30, y- 32, sprite, flip);
	
		//Renderiza coisas que precisam ficar acima do player (pois o player é o último a ser renderizado)
		//Até eu descobrir um método que faça coisas ficarem acima de outras...
		RenderDepoisDoPlayer rc = new RenderDepoisDoPlayer();
		rc.render();


	}
}
