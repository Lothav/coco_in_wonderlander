package game;

import entity.Audio;
import entity.mob.Player;
import entity.mob.coisas.Falas;
import entity.projectile.Projectile;
import entity.projectile.WizardProjectile;
import graphics.Fundo;
import graphics.Screen;
import imput.Keyboard;
import imput.Mouse;
import level.EstadoAtual;
import level.Level;
import level.SpawnLevel;
import level.TileCoordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	private static int width = 400;
	private static int height = 250 ;
	private static int scale = 3 ;
	public static String title = "Coco in WonderLander";
	private Thread thread ;
	public JFrame frame;
	public static Keyboard key;
	public static Level level;
	public static EstadoAtual ea;
	public static Object getLevel;
	public static Player player;
	public static boolean running = false ;
	public static Screen screen;
	public static Audio audio;
	public static Falas falas;
	public static Dignidade digni; 
	public static Game game;
	private Menu menuu;
	private Fundo fundo ;
	private Projectile projectile;
	public static TileCoordinate playerSpawn = new TileCoordinate(17, 40);

	
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

	
	
	public Game() {

		///  Inicia ou Reinicia o jogo  ///

		inicia();
			
	}
	
	public void inicia(){
	
		Level spawn = new SpawnLevel("/textures/level.png");
		Level spawn2 = new SpawnLevel("/textures/level2.png");
		
		
		
		audio = new Audio();
		menuu = new Menu();
		falas = new Falas();
		frame = new JFrame();
		digni = new Dignidade();
		key = new Keyboard();
		Dimension size = new Dimension(width*scale , height*scale);
		setPreferredSize(size);
		player = new Player(playerSpawn.x() , playerSpawn.y(), key);
		ea = new EstadoAtual();
		projectile = new WizardProjectile(17, 40 , -0.17);
		screen = new Screen(width, height);
		if(ea.fase == ea.fase.UM) level = spawn;
		if(ea.fase == ea.fase.DOIS) level = spawn2;
		level.add(player);
		addKeyListener(key);
		Mouse mouse = new Mouse();
		if(ea.State == ea.State.MENU) Dignidade.dign = 245;
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		
		//cursor do mouse
		Cursor hourglassCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
		setCursor(hourglassCursor);
		
	}
	
	
	//slow
	public static int getWindowWidth(){
		return width * scale;
	}
	
	public static int getWindowHeight(){
		return height * scale;	
	}
	
	// Inicia o jogo declarando a thread
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Janela");
		thread.start();
	}
	
	// Fecha o jogo; M�todo join() espera a thread morrer.
	public synchronized void stop(){
		running = false;
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void run(){	
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
//		setFocusable(true);
		requestFocus();

		
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns ;
			lastTime = now ;
			while(delta >= 1){
				update();
				updates++;
				delta--;
			}
			// Renderiza tudo na tela
			render();
			// Calcula FPS
			frames++;
			
			if((System.currentTimeMillis() - timer) > 1000){
				timer += 1000;
				//T�tulo do jogo
				frame.setTitle(title + "  |  " + updates + " ups / " + frames + " fps ");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
public void pintar(Graphics g){
		fundo = new Fundo();
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage( fundo.getFundo(), 0 , 0 , this);

	}
		
public void update(){
	
	ea.update();
	key.update();

	level.update();

	
	// O level.update() ja da update ne todo resto (player, particulas, mobs, projeteis.. etc)

}
	
	public void render(){
	BufferStrategy bs = getBufferStrategy();

	if (bs == null){
		createBufferStrategy(3);
		return;
	}
	

	screen.clear();
	
	int xScroll = player.getX() - screen.width / 2;
	int yScroll = player.getY() - screen.height / 2;
	level.render(xScroll, yScroll, screen);
	
	for (int i = 0; i < pixels.length; i++){
		
		pixels[i] = screen.pixels[i];
	}
	
	Graphics g = bs.getDrawGraphics();
	
	if(ea.State == ea.State.MENU){	
		menuu.renderMenu(g);
		}else if(ea.State == ea.State.CONVERSAINICIAL){
			falas.renderFala(g);
			}else if(ea.State == ea.State.CREDITS){
				menuu.renderCredits(g);
				}else if(ea.State == ea.State.GAME){
					g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
					digni.render(g);
					}else if (ea.State == ea.State.CONVERSAORC){
						falas.renderFala(g);
							}
		
	g.dispose();
	bs.show();
	
}	
	

	
public static void main(final String[] args) {

	game = new Game();
	game.frame.add(game);
	game.frame.setResizable(false);
	game.frame.setTitle(Game.title);
	game.frame.pack();
	game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	game.frame.setLocationRelativeTo(null);
	game.frame.setVisible(true);
	game.start();
	}
	

}

