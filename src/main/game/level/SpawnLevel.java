package level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import  entity.mob.AmmoToinco;
import  entity.mob.BabaRanieri;
import  entity.mob.Buraco;
import  entity.mob.Chave;
import  entity.mob.Crente;
import  entity.mob.Depressao;
import  entity.mob.Endriu;
import  entity.mob.Geladeira;
import  entity.mob.Horiu;
import  entity.mob.LanderComeco;
import  entity.mob.Macacao;
import  entity.mob.MonamourStolen;
import  entity.mob.Motoca;
import  entity.mob.Othav;
import  entity.mob.PacMan;
import  entity.mob.Ranieri;
import  entity.mob.RobotLander;
import  entity.mob.Rocha;
import  entity.mob.Ruiva;
import  entity.mob.npc.Orc;

public class SpawnLevel extends Level{
	
	public static Object getLevel;
	private EstadoAtual ea;
	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path){

			
		if(ea.fase == ea.fase.UM){
		
		add(new Ranieri(40,740));
			
		add(new Orc(100,85));

		//Spawn Caixas de Toinços
		add(new Chave(85, 100));
		add(new Buraco(254, 336));

		add(new AmmoToinco(500, 30));
		add(new AmmoToinco(500, 600));
		add(new BabaRanieri(90, 780));
		

	//Spawn ADDs
		add(new Geladeira(200, 53));
	//	add(new Macacao(603, 150));
		add(new Motoca(22 , 6));
		add(new Othav(17 , 6));
		add(new Crente(12 *16 , 4*16));
		add(new Endriu(20 , 30));
		add(new MonamourStolen(20 , 4));
		add(new Rocha(25, 30));
		add(new Ruiva(35, 40));
		add(new PacMan(25, 30));
		add(new RobotLander(10, 10));

	
		add(new LanderComeco(580 , 640));
		
		
		}
		
		
		if(ea.fase == ea.fase.DOIS){
			
		add(new RobotLander(10, 10));
		add(new Geladeira(1350, 460));
		add(new Depressao(1300,1220));
		add(new Macacao(112, 120));
		add(new Horiu(200, 1900));



		}
		
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w , h, tiles, 0 , w);
			
		
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println("Exception! Could not load level file!");
		}	
	
	}
	
	
	protected void generateLevel(){	
		for (int y = 0; y < 64; y++){
			for ( int x = 0; x < 64; x++){
				getTile(x, y);
			}
			
		}
			tile_size = 16 ;
		}	
}
