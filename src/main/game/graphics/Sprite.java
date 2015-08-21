package graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	private int height, width;
	public int[] pixels;
	protected SpriteSheet sheet;

	 public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	 public static Sprite arvere = new Sprite(16, 3, 3, SpriteSheet.tiles2);
	 
	 public static Sprite areia = new Sprite(16, 14, 8, SpriteSheet.terrain);
	 public static Sprite agua = new Sprite(16, 13, 12, SpriteSheet.terrain);
	 
	 //Fogo
	 public static Sprite fogo = new Sprite(16, 15, 15, SpriteSheet.terrain);
	 public static Sprite tnt = new Sprite(16, 8, 0, SpriteSheet.terrain);
	 public static Sprite pedraFogo = new Sprite(16, 7, 6, SpriteSheet.terrain);
	 public static Sprite fireText = new Sprite(16, 15, 1, SpriteSheet.terrain);
	 public static Sprite fireChao = new Sprite(16, 0, 0, SpriteSheet.texturas);
	 
	//Gelo
		 public static Sprite geloMuro = new Sprite(16, 4, 3, SpriteSheet.terrain);
		 public static Sprite pedraComGelo = new Sprite(16, 7, 2, SpriteSheet.terrain);
		 public static Sprite geloChao = new Sprite(16, 2, 4, SpriteSheet.terrain);
		 public static Sprite chaoEscorrega = new Sprite(16, 3, 4, SpriteSheet.terrain);

		 public static Sprite pcdFogo = new Sprite(16, 3, 1, SpriteSheet.terrain);
		 
		 public static Sprite garraPe = new Sprite(16, 9, 8, SpriteSheet.terrain);



		 //Arvere
	 public static Sprite Tarvere = new Sprite(16, 0, 2, SpriteSheet.arveres);
	 public static Sprite Tarvere0= new Sprite(16, 1, 2, SpriteSheet.arveres);
	 public static Sprite Tarvere1= new Sprite(16, 0, 3, SpriteSheet.arveres);
	 public static Sprite Tarvere2= new Sprite(16, 1, 3, SpriteSheet.arveres);
	 public static Sprite Tarvere3= new Sprite(16, 0, 4, SpriteSheet.arveres);
	 public static Sprite Tarvere4= new Sprite(16, 1, 4, SpriteSheet.arveres);
	 



	 
	 public static Sprite pumpkin = new Sprite(16, 7, 7, SpriteSheet.terrain);
	 public static Sprite pumpkin2 = new Sprite(16, 8, 7, SpriteSheet.terrain);
	 public static Sprite madeira = new Sprite(16, 6, 12, SpriteSheet.terrain);
	 public static Sprite madeira2 = new Sprite(16, 7, 12, SpriteSheet.terrain);
	 public static Sprite chaocasa = new Sprite(16, 10, 3, SpriteSheet.terrain);

	 public static Sprite madeiratomb = new Sprite(16, 3, 6, SpriteSheet.terraintomb);
	 public static Sprite madeira2tomb = new Sprite(16, 3, 7, SpriteSheet.terraintomb);
	 
	 public static Sprite porta = new Sprite(48, 0, 0, SpriteSheet.porta);
	 
	 public static Sprite robotland = new Sprite(48, 0, 0, SpriteSheet.porta);

	 public static Sprite baba = new Sprite(32, 0, 0, SpriteSheet.baba);
	 
	 
	 public static Sprite tijaulaMuro = new Sprite(16, 2, 0, SpriteSheet.tijaula);
	 public static Sprite tijaulaTeto1 = new Sprite(16, 1, 0, SpriteSheet.tijaula);

	 
	 public static Sprite telhado = new Sprite(240, 0, 0, SpriteSheet.tijaulaTeto);
	 
	 public static Sprite tijoloteto = new Sprite(176, 0, 0, SpriteSheet.tijolocima);
	 
	 public static Sprite arvereCime = new Sprite(224, 0, 0, SpriteSheet.arvereCima);
	 public static Sprite arvereCimeMuro = new Sprite(32, 0, 0, SpriteSheet.arveres);


	 
	 public static Sprite aberta = new Sprite(48, 0, 0, SpriteSheet.aberta);


	 
	 //pedra
	 
	 
	 public static Sprite pedrateto = new Sprite(16, 2, 5, SpriteSheet.pedra);
	 public static Sprite pedrameio = new Sprite(16, 3, 5, SpriteSheet.pedra);
	 public static Sprite pedrachao = new Sprite(16, 3, 4, SpriteSheet.texturas);
	 
	 public static Sprite lava = new Sprite(16, 14, 15, SpriteSheet.terrain);

	 public static Sprite madeirachao = new Sprite(16, 4, 7, SpriteSheet.terrain);


	 public static Sprite pedratetor = new Sprite(16, 2, 2, SpriteSheet.pedrar);
	 public static Sprite pedrameior = new Sprite(16, 2, 3, SpriteSheet.pedrar);
	 
	 
	 public static Sprite orc = new Sprite(64, 0, 0, SpriteSheet.orc);

	 public static Sprite monamourParada = new Sprite(64, 0, 0, SpriteSheet.monamourparada);

	  
	 
	//T public static Sprite telhado = new Sprite(16, 0, 0, SpriteSheet.telhado);

	 public static Sprite kelzin = new Sprite(16, 0, 0, SpriteSheet.kelzin);

	// public static Sprite grass3 = new Sprite(16, 3, 0, SpriteSheet.tiles2);

	// public static Sprite grass4 = new Sprite(16, 0, 4, SpriteSheet.tiles3);

	public static Sprite voidSprite = new Sprite(16, 0x3D715A);
	 public static Sprite rock = new Sprite(16, 1, 0, SpriteSheet.tiles);
	// public static Sprite flower = new Sprite(16, 2, 0, SpriteSheet.tiles);

	// Coco Animation
	public static Sprite coco_parado = new Sprite(64, 0, 0, SpriteSheet.coco_an);
	public static Sprite coco_dedo = new Sprite(64, 1, 0, SpriteSheet.coco_an);
	public static Sprite coco_cannon = new Sprite(64, 2, 0, SpriteSheet.coco_an);
	public static Sprite coco_omg = new Sprite(64, 3, 0, SpriteSheet.coco_an);
	public static Sprite coco_soco = new Sprite(64, 4, 0, SpriteSheet.coco_an);
	public static Sprite coco_morto = new Sprite(64, 5, 0, SpriteSheet.coco_an);
	public static Sprite coco_congelado = new Sprite(64, 6, 0, SpriteSheet.coco_an);
	public static Sprite coco_outonincos = new Sprite(64, 7, 0, SpriteSheet.coco_an);
	public static Sprite coco_cannon_baixo = new Sprite(64, 8, 0, SpriteSheet.coco_an);
	public static Sprite coco_cannon_cima = new Sprite(64, 9, 0, SpriteSheet.coco_an);



	public static Sprite logo = new Sprite(500, 0, 0, SpriteSheet.logo);

	
	public static Sprite geladeira_parada = new Sprite(64, 0, 0, SpriteSheet.gelaparada);

	public static Sprite ammo0 = new Sprite(64, 0, 0, SpriteSheet.ammof);
	public static Sprite ammo1 = new Sprite(64, 1, 0, SpriteSheet.ammof);
	
	public static Sprite chave = new Sprite(32, 0, 0, SpriteSheet.chave);


	
	public static Sprite falamac = new Sprite(64, 0, 0, SpriteSheet.falamac);
	public static Sprite cocofala = new Sprite(64, 0, 0, SpriteSheet.cocofala);

	// public static Sprite somb0 = new Sprite(16, 3, 4, SpriteSheet.texturas);
	public static Sprite somb1 = new Sprite(16, 4, 4, SpriteSheet.texturas);
	public static Sprite somb2 = new Sprite(16, 4, 5, SpriteSheet.texturas);
	// public static Sprite somb3 = new Sprite(16, 2, 6, SpriteSheet.texturas);

	public static Sprite porcao = new Sprite(32, 0, 0, SpriteSheet.porcao);
	public static Sprite projectile = new Sprite(32, 0, 0, SpriteSheet.projectiles);
	public static Sprite gelo = new Sprite(32, 0, 0, SpriteSheet.gelos);

	// Landim

	public static Sprite lander = new Sprite(64, 0, 0, SpriteSheet.landerf);

	// Macacao
	// public static Sprite macacao = new Sprite(64, 2, 2, SpriteSheet.macacao);

	// Particles
	// deve-se declarar
	public static Sprite particle_coco = new Sprite(3, 0x502727); // cor de coco
	public static Sprite particle_porco = new Sprite(3, 0xFF0000); // cor de
																	// porco

	protected Sprite(SpriteSheet sheet, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.height = height;
		this.width = width;
		this.sheet = sheet;
	}

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int width, int height, int colour) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColour(colour);
	}

	public Sprite(int size, int colour) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}

	public Sprite(int[] pixels, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = colour;
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				// System.out.println("Sheet SIZE :  " + SIZE);
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y)
						* sheet.SIZE];
			}

		}
	}

}