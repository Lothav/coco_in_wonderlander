package level.tile;

import  entity.mob.Geladeira;
import  graphics.Screen;
import  graphics.Sprite;
import  graphics.SpriteSheet;

public class Tile {

	public Sprite sprite;

	
	public static Tile grass = new NoCollTile(Sprite.grass);

	public static Tile areia = new NoCollTile(Sprite.areia);
	
	
	public static Tile agua = new CollTile(Sprite.agua);

	//Fogo
	public static Tile fogo = new SlowTile(Sprite.fogo);
	public static Tile tnt = new CollTile(Sprite.tnt);
	public static Tile pedraFogo = new CollTile(Sprite.pedraFogo);
	public static Tile fireText = new NoCollTile(Sprite.fireText);
	public static Tile fireChao = new NoCollTile(Sprite.fireText);

	//Gelo
		public static Tile geloMuro = new CollTile(Sprite.geloMuro);
		public static Tile pedraComGelo = new NoCollTile(Sprite.pedraComGelo);
		public static Tile geloChao = new NoCollTile(Sprite.geloChao);
		public static Tile chaoEscorrega = new EscorregaTile(Sprite.chaoEscorrega);
		
		public static Tile pcdFogo = new NoCollTile(Sprite.pcdFogo);
		public static Tile garraPe = new GarraPe(Sprite.garraPe);



	//Arveres
	public static Tile Tarvere = new CollTile(Sprite.Tarvere);
	public static Tile Tarvere0 = new CollTile(Sprite.Tarvere0);
	public static Tile Tarvere1 = new CollTile(Sprite.Tarvere1);
	public static Tile Tarvere2 = new CollTile(Sprite.Tarvere2);
	public static Tile Tarvere3 = new CollTile(Sprite.Tarvere3);
	public static Tile Tarvere4 = new CollTile(Sprite.Tarvere4);


//	public static Tile flower = new NoCollTile(Sprite.flower);
	public static Tile rock = new CollTile(Sprite.rock);
	public static Tile projectile = new NoCollTile(Sprite.projectile);
	public static Tile porcao = new NoCollTile(Sprite.porcao);
	public static Tile falamac = new NoCollTile(Sprite.falamac);
	public static Tile cocofala = new NoCollTile(Sprite.cocofala);
	
	public static Tile kelzin = new CollTile(Sprite.kelzin);
	//public static Tile telhado = new CollTile(Sprite.telhado);
	
	public static Tile madeira = new CollTile(Sprite.madeira);
	public static Tile lava = new NoCollTile(Sprite.lava);

	public static Tile madeira2 = new CollTile(Sprite.madeira2);
	public static Tile madeiratomb = new CollTile(Sprite.madeiratomb);
	public static Tile madeira2tomb = new CollTile(Sprite.madeira2tomb);

	public static Tile porta = new CollTile(Sprite.porta);
	
	public static Tile baba = new NoCollTile(Sprite.baba);

	
	
	public static Tile tijaulateto = new CollTile(Sprite.tijaulaTeto1);

	
	
	//public static Tile test = new CollTile(Sprite.test);

	
	
	//muros
	
	
	public static Tile pedrateto = new CollTileV(Sprite.pedrateto);
	public static Tile pedrameio = new CollTile(Sprite.pedrameio);
	public static Tile pedrachao = new NoCollTile(Sprite.pedrachao);
	public static Tile pedrachaoC = new CollTile(Sprite.pedrachao);

	public static Tile chaocasa = new NoCollTile(Sprite.chaocasa);

	public static Tile telhado = new NoCollTile(Sprite.telhado);
	public static Tile tijaula = new CollTile(Sprite.tijaulaMuro);
	public static Tile tijoloteto = new NoCollTile(Sprite.tijoloteto);
	public static Tile madeirachao = new NoCollTile(Sprite.madeirachao);
	
	public static Tile arvereCime = new NoCollTile(Sprite.arvereCime);
	public static Tile arvereCimeMuro = new CollTile(Sprite.arvereCimeMuro);




	public static Tile aberta = new NoCollTile(Sprite.aberta);

	
	
	public static Tile pedratetor = new CollTile(Sprite.pedratetor);
	public static Tile pedrameior = new CollTile(Sprite.pedrameior);
	
	public static Tile ammo0 = new NoCollTile(Sprite.ammo0);
	public static Tile ammo1 = new NoCollTile(Sprite.ammo1);

	public static Tile chave = new NoCollTile(Sprite.chave);

	
	public static Tile arver = new CollTile(Sprite.arvere);
	public static Tile pumpkin = new NoCollTile(Sprite.pumpkin);
	public static Tile pumpkin2 = new CollTile(Sprite.pumpkin2);


//	public static Tile gras3 = new NoCollTile(Sprite.grass3);

	public static Tile somb1 = new NoCollTile(Sprite.somb1);
	//public static Tile somb3 = new CollTile(Sprite.somb3);
	public static Tile somb2 = new CollTile(Sprite.somb2);
	//public static Tile gras4 = new NoCollTile(Sprite.grass4);

	
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;	
	}
	
	public void render(int x, int y, Screen screen){	
	}
	
	public boolean solid(){
		return false;
	}
	public boolean slow(){
		return false;
	}
	public boolean xia(){
		return false;
	}
	public boolean garrou(){
		return false;
	}
	
}
