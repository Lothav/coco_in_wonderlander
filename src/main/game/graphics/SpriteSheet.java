package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {


	private String path;
	public final int SIZE;
	public final int HEIGHT, WIDTH;
	public int[] pixels;

	
	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);
	public static SpriteSheet tiles2 = new SpriteSheet("/textures/tiles2.png", 192);
	public static SpriteSheet tiles3 = new SpriteSheet("/textures/tiles3.png", 295);
	
	
	public static SpriteSheet kelzin = new SpriteSheet("/textures/Kelzin.png", 16);
	
	//Arvere
	public static SpriteSheet arveres = new SpriteSheet("/textures/Arveres.png", 80);

	
	public static SpriteSheet arvereCima = new SpriteSheet("/textures/ArvereCima.png", 224);
	public static SpriteSheet arvereCimaMuro = new SpriteSheet("/textures/ArvereCima.png", 224);


	//Tijaula
	
	public static SpriteSheet tijaula = new SpriteSheet("/textures/Tijaula.png", 128);

	public static SpriteSheet tijolocima = new SpriteSheet("/textures/tijolocima.png", 176);

	public static SpriteSheet aberta = new SpriteSheet("/textures/Arromba.png", 48);
	
	public static SpriteSheet tijaulaTeto = new SpriteSheet("/textures/tijaulateto.png", 240);

	public static SpriteSheet texturas = new SpriteSheet("/textures/texturas.png", 128);
	public static SpriteSheet spawn_level = new SpriteSheet("/textures/level.png", 54 );
	public static SpriteSheet projectiles = new SpriteSheet("/textures/projectile.png", 32);
	public static SpriteSheet porcao = new SpriteSheet("/textures/porcao.png", 32);
	public static SpriteSheet gelos = new SpriteSheet("/textures/gelo.png", 32);
	public static SpriteSheet terrain = new SpriteSheet("/textures/terrain.png", 256);
	public static SpriteSheet terraintomb = new SpriteSheet("/textures/terraintomb.png", 256);
	
	public static SpriteSheet porta = new SpriteSheet("/textures/porta.png", 48);
	

	public static SpriteSheet pedra = new SpriteSheet("/textures/pedra.png", 144);
	public static SpriteSheet pedrar = new SpriteSheet("/textures/pedrar.png", 144);


	public static SpriteSheet telhado = new SpriteSheet("/textures/telhado.png", 16);

	public static SpriteSheet falamac = new SpriteSheet("/textures/falamac.png", 64);
	public static SpriteSheet cocofala = new SpriteSheet("/textures/cocofala.png", 64);

	public static SpriteSheet porc0 = new SpriteSheet("/textures/porc0.png", 16, 48);
	public static SpriteSheet porc1 = new SpriteSheet("/textures/porc1.png", 16, 48);
	public static SpriteSheet porc2 = new SpriteSheet("/textures/porc2.png", 16, 48);
	public static SpriteSheet porc3 = new SpriteSheet("/textures/porc3.png", 16, 48);
	

	public static SpriteSheet cocomorto = new SpriteSheet("/textures/Morreu.png", 292, 235);

	public static SpriteSheet landerf = new SpriteSheet("/textures/Lander.png", 128);
	public static SpriteSheet landerAnim = new SpriteSheet(landerf, 0, 0, 2, 1, 64);
	
	public static SpriteSheet monamourstolenf = new SpriteSheet("/textures/MonamourStolen.png", 128);
	public static SpriteSheet monamourstolenAnim = new SpriteSheet(monamourstolenf, 0, 0, 2, 1, 64);
	
	public static SpriteSheet depressaof = new SpriteSheet("/textures/Depressao.png", 128);
	public static SpriteSheet depressaoAnim = new SpriteSheet(depressaof, 0, 0, 2, 1, 64);
	
	public static SpriteSheet pacmanf = new SpriteSheet("/textures/pacman.png", 128);
	public static SpriteSheet pacmanAnim = new SpriteSheet(pacmanf, 0, 0, 2, 1, 64);
	
	public static SpriteSheet ammof = new SpriteSheet("/textures/AmmoToinco.png", 128);
	public static SpriteSheet ammotoincoAnim = new SpriteSheet(ammof, 0, 0, 2, 1, 64);
	
	public static SpriteSheet baba = new SpriteSheet("/textures/Bab.png", 32);
	
	public static SpriteSheet chave = new SpriteSheet("/textures/Chave.png", 32);

	public static SpriteSheet ruivaf = new SpriteSheet("/textures/Ruiva.png", 128);
	public static SpriteSheet ruivaAnim = new SpriteSheet(ruivaf, 0, 0, 2, 1, 64);
	
	public static SpriteSheet RobotLanderf = new SpriteSheet("/textures/RobotLander.png", 280);
	public static SpriteSheet RobotLander = new SpriteSheet(RobotLanderf, 0, 0, 2, 1, 140);
	
	public static SpriteSheet crentef = new SpriteSheet("/textures/Crente.png", 128);
	public static SpriteSheet crenteAnim = new SpriteSheet(crentef, 0, 0, 2, 1, 64);
	
	public static SpriteSheet rochaf = new SpriteSheet("/textures/Rocha.png", 128);
	public static SpriteSheet rochaAnim = new SpriteSheet(rochaf, 0, 0, 2, 1, 64);
	
	public static SpriteSheet motocaf = new SpriteSheet("/textures/Motoca.png", 128);
	public static SpriteSheet motocaAnim = new SpriteSheet(motocaf, 0, 0, 2, 1, 64);
	
	public static SpriteSheet othavf = new SpriteSheet("/textures/Othav.png", 128);
	public static SpriteSheet othavAnim = new SpriteSheet(othavf, 0, 0, 2, 1, 64);
	
	public static SpriteSheet endriuf = new SpriteSheet("/textures/Endriu.png", 128);
	public static SpriteSheet endriuAnim = new SpriteSheet(endriuf, 0, 0, 2, 1, 64);
	
	public static SpriteSheet buracof = new SpriteSheet("/textures/buraco.png", 64);
	public static SpriteSheet buracoAnim = new SpriteSheet(buracof, 0, 0, 2, 1, 32);
	
	public static SpriteSheet horiuf = new SpriteSheet("/textures/Horiu.png", 128);
	public static SpriteSheet horiuAnim = new SpriteSheet(horiuf, 0, 0, 2, 1, 64);

	public static SpriteSheet ranierif = new SpriteSheet("/textures/Ranieri.png", 128);
	public static SpriteSheet ranieriAnim = new SpriteSheet(ranierif, 0, 0, 2, 1, 64);
	
	public static SpriteSheet macacao = new SpriteSheet("/textures/macacao.png", 128, 64);
	public static SpriteSheet macacaoAnim = new SpriteSheet(macacao, 0 , 0 , 2 , 1 , 64);
	
	public static SpriteSheet geladeira = new SpriteSheet("/textures/Geladeira.png", 192, 64);
	public static SpriteSheet geladeiraAnim = new SpriteSheet(geladeira, 0 , 0 , 3 , 1 , 64);
	
	public static SpriteSheet gameover = new SpriteSheet("/textures/GameOver.png", 450,150);
	public static SpriteSheet gameoverAnim = new SpriteSheet(gameover, 0 , 0 , 3 , 1 , 150);

	public static SpriteSheet coco_an = new SpriteSheet("/textures/coco_anim.png", 640);
	
	public static SpriteSheet logo = new SpriteSheet("/textures/LOGO.png", 500);
	
	public static SpriteSheet orc = new SpriteSheet("/textures/Orc.png", 64);
	
	public static SpriteSheet monamourparada = new SpriteSheet("/textures/monamourParada.png", 64);




	public static SpriteSheet gelaparada = new SpriteSheet("/textures/GeladeiraParada.png", 64);

	
	private Sprite[] sprites;
	

	public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height, int spriteSize){
		int xx = x * spriteSize;
		int yy = y * spriteSize;
		int w = width * spriteSize;
		int h = height * spriteSize;
		if( width == height) SIZE = width;
		else SIZE = -1;
		WIDTH = w;           
		HEIGHT = h;
		pixels = new int[w * h];
			for(int y0 = 0; y0 < h; y0++){
				int yp = yy + y0;
					for (int x0 = 0; x0 < w; x0++){
						int xp = xx + x0;	
						pixels[x0 + y0 *w] = sheet.pixels[xp + yp * sheet.WIDTH];
								
			}
		}
			int frame = 0;
			sprites = new Sprite[width * height];
			for(int ya =0; ya < height; ya ++){
				for(int xa = 0; xa < width; xa ++){
				int[] spritePixels = new int[spriteSize * spriteSize];	
			for(int y0 =0; y0 < spriteSize; y0 ++){
				for(int x0 =0; x0 < spriteSize; x0 ++){
					spritePixels[x0 + y0 * spriteSize] = pixels[(x0 + xa * spriteSize) + (y0 + ya * spriteSize)* WIDTH];		
					}
				}
			Sprite sprite = new Sprite(spritePixels, spriteSize, spriteSize);
			sprites[frame++] = sprite;
			}}} 
	
	
	public SpriteSheet(String path, int size){
			
			this.path = path;
			SIZE = size;
			WIDTH = size;
			HEIGHT = size;
			pixels = new int[SIZE * SIZE];
			load();
	}
	
	
	public SpriteSheet(String path, int width, int height){
		this.path = path;
		SIZE = -1;
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];
		load();	
	}
	
	public Sprite[] getSprites(){
		return sprites;
		
	}
	

	private void load(){
		try {
		BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
		int w = image.getWidth();
		int h = image.getHeight();
		image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch(IOException e){
			e.printStackTrace();
		}	
	}
}
