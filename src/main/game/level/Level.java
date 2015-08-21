package level;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import game.Game;
import  entity.Entity;
import  entity.mob.Player;
import  entity.mob.coisas.Falas;
import  entity.particle.Particle;
import  entity.projectile.Projectile;
import  entity.projectile.WizardProjectile;
import  graphics.Screen;
import  level.tile.Node;
import  level.tile.Tile;
import  util.Vector2i;

public class Level {
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	protected int tile_size;
	private EstadoAtual ea;
	
	public static int olar = 0;
	private List<Entity> entities = new ArrayList<Entity>();
	public static List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Particle> particles = new ArrayList<Particle>();
	private List<Player> players = new ArrayList<Player>();
	
	public static Object getLevel;
	
	private Comparator<Node> nodeSorter = new Comparator<Node>(){

		public int compare(Node n0, Node n1) {
			if(n1.fCost < n0.fCost) return +1;
			if(n1.fCost > n0.fCost) return -1;
			return 0;
		}
		
		
	};

	
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
		
		
	}

	

	public Level(String path){
		loadLevel(path);
		generateLevel();
		

	}
	protected void generateLevel() {
		for (int y = 0; y < 64; y++){
			for (int x = 0; x < 64; x++){
				getTile(x,y);
			}
		}
		tile_size = 48 ;
	}
	protected void loadLevel(String path) {
		
	}
	
	public void update(){
		
		EstadoAtual ea = Game.ea;

		if(ea.State == ea.State.GAME){
		{
		for (int i = 0; i < entities.size(); i++){
			entities.get(i).update();		
			}
		}
		
		for (int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).update();		
		}
		
		for (int i = 0; i < particles.size(); i++){
			particles.get(i).update();		
		}
		
	{	for (int i = 0; i < players.size(); i++){
			players.get(i).update();		
			}
		
	}
		remove();
	}
		}
	
	private void remove(){
		
		for (int i = 0; i < entities.size(); i++){
			if (entities.get(i).isRemoved()) entities.remove(i);	
		}
		for (int i = 0; i < projectiles.size() ; i++){
			if (projectiles.get(i).isRemoved()) projectiles.remove(i);	
		}
	
		for (int i = 0; i < particles.size() ; i++){
			if (particles.get(i).isRemoved()) particles.remove(i);	
		}
			
		for (int i = 0; i < players.size(); i++){
			if (players.get(i).isRemoved()) players.remove(i);		
		}
		
		
	}
	
	public List<Projectile> getProjectiles(){
		return projectiles;
	}
	
	private void time(){
		
	}
	
	
	public boolean tileCollision(double x , double y, double xa , double ya, int size){
		boolean solid =false;
		for(int c = 0; c< 4 ; c++){
			int xt = (((int)x+(int)xa) + c % 2 * size/8 + 10 ) / 16;
			int yt = (((int)y+(int)ya) + c / 2 * size/8 + 10) / 16;
			if (getTile(xt,yt).solid()) solid = true;
		}
		
			return solid;
	}
	
	
	
	public void render(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4 ; 
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		
		for (int y = y0; y < y1; y++){
			for(int x = x0; x < x1 ; x++){
			getTile(x , y).render(x, y, screen);
				
			}
		}
		for (int i = 0; i < entities.size(); i++){
			entities.get(i).render(screen);		
		}
		for (int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).render(screen);		
		}
		for (int i = 0; i < particles.size(); i++){
			particles.get(i).render(screen);		
		}
	
		for (int i = 0; i < players.size(); i++){
			players.get(i).render(screen);		
		}	
	}
	
	
	
	public void add(Entity e){
				e.init(this);
		if(e instanceof Particle){
		particles.add((Particle) e);
		}else if(e instanceof Projectile){
			projectiles.add((Projectile)e);
		}else if(e instanceof Player){	
		players.add((Player) e);
		}else{entities.add(e);
		}
	}
	
	public List<Player> getPlayers(){
		
		return players;
		
	}
	
	
	public Player getPlayerAt(int index){
		return players.get(index);
	}
	
	public Player getClientPlayer(){
		return players.get(0);
	}
	

	public Entity getClientEntity(){
		return entities.get(0);
	}
	
	public Particle getClientParticles(){
		return particles.get(0);
	}
	
	public Projectile getClientProjectile(){
		return projectiles.get(0);
	}
	
	
	
	//////////// A * SEARCHING ALGORITHM ////////////////
	
	public List<Node> findPath(Vector2i start, Vector2i goal){
		List<Node> openList = new ArrayList<Node>();
		List<Node> closedList = new ArrayList<Node>();
		Node current = new Node(start, null, 0, getDistance(start, goal));
		Tile goala = getTile(goal.getX(), goal.getY());
		if(!goala.solid())openList.add(current);
		
		while(openList.size() > 0){
			Collections.sort(openList, nodeSorter);
			current = openList.get(0);
			if(current.tile.equals(goal)){
				 List<Node> path = new ArrayList<Node>();
				 while(current.parent != null){
					 path.add(current);
					 current = current.parent;
				 }
				 openList.clear();
				 closedList.clear();
				 return path;
			}
			
			closedList.add(current);
			if(!goala.solid())openList.remove(current);

			
				
			for(int i=0; i < 9; i++){
				if(i == 4)continue;
				int x = current.tile.getX();
				int y = current.tile.getY();
				int xi = (i % 3) - 1;
				int yi = (i / 3) - 1;
				Tile at = getTile(x + xi, y + yi);
				if (at == null) continue;
				if(at.solid()) continue;
				Vector2i a = new Vector2i(x+ xi, y + yi);
				double gCost = current.gCost + getDistance(current.tile, a);
				double hCost = getDistance(a, goal);
				Node node = new Node(a, current, gCost, hCost);
				if(vecInList(closedList, a) && gCost >= node.gCost) continue;
				if(!vecInList(openList, a) || gCost < node.gCost) openList.add(node);	
				
				}
			}
		closedList.clear();
		return null;
		}
	
	////////////////////////////////////////////////////////
	
	
	
	private boolean vecInList (List<Node> list, Vector2i vector){
		for(Node n : list){
			if(n.tile.equals(vector)) return true;
		}
		return false;
	}
	
	private double getDistance(Vector2i tile, Vector2i goal){
		double dx = tile.getX() - goal.getX();
		double dy = tile.getY() - goal.getY();
		return Math.sqrt(dx *dx + dy * dy);
		
	}
	
	
		
	public Tile getTile(int x, int y){
		
		//fase 1
		if(ea.fase == ea.fase.UM){
		
			if(x < 0 || y < 0 || x >= width || y >= height) return Tile.pedrachao;
		if(tiles[x+y * width] == 0xFFFF1420) return Tile.madeira;
		if(tiles[x+y * width] == 0xFFF2FF00) return Tile.madeira2tomb;
		if(tiles[x+y * width] == 0xFF2014FF) return Tile.chaocasa;


		if(tiles[x+y * width] == 0xFFFFBA26) return Tile.madeirachao;
			if(tiles[x+y * width] == 0xFF00FFE5) return Tile.lava;
			
			
			if(!Player.aberta2){
				
				if(tiles[x+y * width] == 0xFF24FF07) return Tile.pedrachaoC;
				}else {
					if(tiles[x+y * width] == 0xFF24FF07) return Tile.madeirachao;
					}
				
			if(!Player.aberta){
		
				if(tiles[x+y * width] == 0xFFFF19BD) return Tile.pedrachaoC;
				}else {
					if(tiles[x+y * width] == 0xFFFF19BD) return Tile.chaocasa;
					}
		}
		
		if(ea.fase == ea.fase.DOIS){
			
			if(x < 0 || y < 0 || x >= width || y >= height) return Tile.agua;
			if(tiles[x+y * width] == 0xFFFF3F46) return Tile.Tarvere;
			if(tiles[x+y * width] == 0xFFFF8EDD) return Tile.Tarvere0;
			if(tiles[x+y * width] == 0xFF97FF19) return Tile.Tarvere1;
			if(tiles[x+y * width] == 0xFF03999B) return Tile.Tarvere2;
			if(tiles[x+y * width] == 0xFF26AFFF) return Tile.Tarvere3;
			if(tiles[x+y * width] == 0xFFFCFF7C) return Tile.Tarvere4;
			
			
			if(tiles[x+y * width] == 0xFF6BFFF0) return Tile.rock;


			if(tiles[x+y * width] == 0xFF2419FF) return Tile.agua;

			if(tiles[x+y * width] == 0xFFFFF544) return Tile.areia;
				
			if(tiles[x+y * width] == 0xFF73FF4C) return Tile.grass;
			
			
			//Fogo
			if(tiles[x+y * width] == 0xFFFFBD54) return Tile.pedraFogo;
			if(tiles[x+y * width] == 0xFFFF4130) return Tile.fireChao;
			if(tiles[x+y * width] == 0xFF8975FF) return Tile.fogo;
			if(tiles[x+y * width] == 0xFF51FFFC) return Tile.fireText;
			if(tiles[x+y * width] == 0xFF00FF00) return Tile.tnt;
			
			//Gelo
			if(tiles[x+y * width] == 0xFFFF7F07) return Tile.geloMuro;
			if(tiles[x+y * width] == 0xFFFDFFC6) return Tile.geloChao;
			if(tiles[x+y * width] == 0xFF1CBAFF) return Tile.pedraComGelo;
			if(tiles[x+y * width] == 0xFF5E99FF) return Tile.chaoEscorrega;

			if(tiles[x+y * width] == 0xFFB7FFF3) return Tile.pcdFogo;
			
			if(tiles[x+y * width] == 0xFFFF75C5) return Tile.garraPe;


			
		}

		 return Tile.pedrachao;
	}
}
