package entity.mob;

import game.Game;
import  entity.projectile.GeladeiraProjectile;
import  entity.projectile.WizardProjectile;
import  graphics.AnimatedSprite;
import  graphics.Screen;
import  graphics.Sprite;
import  graphics.SpriteSheet;
import  imput.Mouse;
import  level.EstadoAtual;
import  level.tile.Tile;

public class Geladeira extends Mob{

	public static int sofre = 0;
	private short count = 60;
	private Sprite sprite;
	private int time = 50;
	private int fireRate = 0;
	public static int dign = 300;
	public static boolean slow = false;
	private int slowcount = 0;
	private EstadoAtual ea;
	
	public static int tipo = 0;
	
	private AnimatedSprite Geladeira = new AnimatedSprite(SpriteSheet.geladeiraAnim, 64, 64, 3);

	public Geladeira(int x, int y){
		this.x = x ;
		this.y = y ;	
		fireRate = GeladeiraProjectile.FIRE_RATE;
	}

	public void move(){
		xa = 0;
		ya = 0;
		Player player = level.getClientPlayer();

		if(time % 3 == 0){
		if (x < player.getX() ) xa++;
		if (x > player.getX() ) xa--;
		if (y < player.getY() ) ya++;
		if (y > player.getY() ) ya--;
		
		
		time++;
		if(time > 1000) time = 50;
		}
		Player p = level.getClientPlayer();

		if((xa != 0 || ya !=0) && !(x > p.getX() - 100 && x < p.getX() + 100
				 && y > p.getY() - 100 && y < p.getY() + 100)){
			move(xa, ya);
			walking = true;
		}
	}

	public void update() {
		if (fireRate > 0) fireRate--;

		move();		
		time++;
		Player p = level.getClientPlayer();
		
		
		double dx = p.getX() - x;
		double dy = p.getY() - y;
		
		double dir = Math.atan2(dy, dx);
		
		if (x > p.getX() - 150 && x < p.getX() + 150
		 && y > p.getY() - 150 && y < p.getY() + 150 && fireRate <= 0){
		shootG(x, y, dir);
		fireRate = GeladeiraProjectile.FIRE_RATE;

		}
		
		if (GeladeiraProjectile.congelado) GeladeiraProjectile.cong++;
		
		if ( GeladeiraProjectile.cong > 60 ){ 
			GeladeiraProjectile.congelado = false;
			slow = true;
			GeladeiraProjectile.cong = 0;
			
		}
		
		if(slow == true) slowcount++;

		if( !(ea.State == ea.State.GAME)) slowcount = 101;
		
		if (slowcount > 100) {
		
		slow = false ;
		slowcount = 0;
		
		}
		count++;
		
		if (walking) Geladeira.update();
		else Geladeira.setFrame(0);
		Geladeira.setFrameRate(40);
	}

	public void render(Screen screen) {
		
		Player p = level.getClientPlayer();

		if (x > p.getX() - 150 && x < p.getX() + 150
		 && y > p.getY() - 150 && y < p.getY() + 150 ) sprite = Geladeira.getSprite();
		else sprite = Sprite.geladeira_parada;
		
		
		if( x <= p.getX() ) {screen.renderPlayer(x-30, y-32, sprite, 0);
		tipo = 0;
		}	
		else {
			screen.renderPlayer(x-30, y-32, sprite, 1);
		tipo = 1;
		}
		
		
	}
}