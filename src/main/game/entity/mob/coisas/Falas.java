package entity.mob.coisas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.Thread.State;
import java.util.concurrent.CountDownLatch;

import javax.imageio.ImageIO;

import game.Dignidade;
import game.Game;
import  entity.mob.BabaRanieri;
import  entity.mob.Ranieri;
import  graphics.SpriteSheet;
import  imput.Keyboard;
import  level.EstadoAtual;

public class Falas  {
	
	private int currentChoice = 1;
	EstadoAtual ea ;
	public static boolean liberaCoco = false;
	private String[] options0 = {
			"Lhe Amar",
			"Quero abrir aquela porta",
			
		};
	
	private String[] options1 = {
			"OK",
			"VSF"	
		};
	
	private String[] options2 = {
			"Passa pra ca",
			"Engole com o reto"
				
		};
	
	private String[] falasOrc = {
			
			
	};

	
	private String[] options = options0;
	private String fala = "Olar Coco. O que  desejas de mim?";
	private int contaup = 100;
	private int contado = 100;
	public static int falas = 1;
	private Keyboard key;
	private int enterPress = 0;
	private int liberaKey = 0;
	private String fala2 = "Parabens Coco, aqui esta a chave";
	
	public static boolean soltaRanieri = false;
	public static boolean chaveSpawn = false;
	
		
	public void renderFala(Graphics g){

		//Fala com o Orc
		g.setColor(Color.LIGHT_GRAY);
		g.fill3DRect(0, 500, Game.getWindowWidth(), Game.getWindowHeight()/3, true);
		
		g.setColor(Color.black);
		g.setFont(new Font("Arial", 0,20 ));
		g.drawString("Vai apertando", 1050, 650);
		g.setColor(Color.red);
		g.drawString("Enter", 1080, 680);
		g.setColor(Color.black);
		g.drawString("pra passar", 1060, 710);

		

		if(ea.State == ea.State.CONVERSAINICIAL ) ConversaInicial(g);
		if(ea.State == ea.State.CONVERSAORC ) ConversaOrc(g);

		}

	
	private void ConversaOrc(Graphics g) {

		Orc(g);

		EstadoAtual ea = Game.ea;
		g.setColor(Color.BLACK);
		g.setFont(new Font("Century",0,40));
		if(BabaRanieri.pisoBaba){ 
			fala = fala2 ;
			options = options2;
		}
	g.drawString(fala, 300, 605);
	keyPressed();
	g.setFont(new Font("Arial", 0, 35));
	for(int i = 0; i < options.length; i++) {
		if(i == currentChoice) {
			g.setColor(Color.RED);
		}
		else {
			g.setColor(Color.BLACK);
		}
		g.drawString(options[i], 500, 650 + i * 32);
	}
		}
	
	public void EnterPress(){
		if(enterPress > 0) enterPress++;
		if(enterPress > 30) enterPress = 0;
		
	}
	
	
	public void ConversaInicial(Graphics g){

		key = Game.key;
		EstadoAtual ea = Game.ea;
		g.setColor(Color.BLACK);
		g.setFont(new Font("Century",0,40));
		

		if(key.enter && Keyboard.soltouTecla && enterPress == 0) {
			Keyboard.soltouTecla = false;
			falas++;
			enterPress++;
		}
		EnterPress();
		
		switch(falas){
		
		case 1:
			Coco(g);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Century",0,40));
			g.drawString("Ohh monamour, que belo dia", 300, 600);
			break;
		case 2:
			Monamour(g);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Century",0,40));
			g.drawString("Cim, és ono belo dia", 300, 600);
			break;
		case 3:
			Coco(g);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Century",0,40));
			g.drawString("Comprei uma paneleta de torresma ", 300, 600);
			g.drawString("frita na banha de toinço", 300, 660);

			break;
		case 4:
			Monamour(g);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Century",0,40));
			g.drawString("QUE DELIÉCIA POARRRRR", 300, 600);
			break;
		case 5:
			Monamour(g);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Century",0,40));
			g.drawString("Me leve pra casa preu degustar", 300, 600);
			break;	
		case 6:
	
			ea.State = ea.State.GAME;
			break;	
		case 7:
			Lander(g);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Century",0,40));
			g.drawString("Claro gata", 300,605);
			break;
		case 8:
			Coco(g);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Century",0,40));
			g.drawString("Tira a mão da minha muié fidumaégua", 300, 600);
			liberaCoco = true;
			break;
		case 9:
			ea.State = ea.State.GAME;
			break;
		case 10:
			Coco(g);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Century",0,40));
			g.drawString("Carcarei esse Lander", 300, 600);
			liberaCoco = false;
			break;
			
			default:
				ea.State = ea.State.GAME;
	
		}
		
		
	}

	
	private void Orc(Graphics g){
		
		BufferedImage menuimg2 = null;

		try {
			menuimg2 = ImageIO.read(SpriteSheet.class.getResource("/textures/OrcPortrait.png"));

		
		} catch (IOException e) {
			 e.printStackTrace(); 
		}
		g.setFont(new Font("Aharoni",0,40));
		g.drawImage(menuimg2,  0, 500,  null);
		g.setColor(Color.RED);
		g.drawString("Orc :", 260, 540);
		
		
	}
	
private void Coco(Graphics g){
		
		BufferedImage menuimg2 = null;

		try {
			menuimg2 = ImageIO.read(SpriteSheet.class.getResource("/textures/CocoPortrait.png"));

		
		} catch (IOException e) {
			 e.printStackTrace(); 
		}
		g.setFont(new Font("Aharoni",0,40));
		g.drawImage(menuimg2,  0, 500,  null);
		g.setColor(Color.RED);
		g.drawString("Coco :", 260, 540);
		
		
	}
private void Lander(Graphics g){
	
	BufferedImage menuimg2 = null;

	try {
		menuimg2 = ImageIO.read(SpriteSheet.class.getResource("/textures/LanderPortrait.png"));

	
	} catch (IOException e) {
		 e.printStackTrace(); 
	}
	g.setFont(new Font("Aharoni",0,40));
	g.drawImage(menuimg2,  0, 500,  null);
	g.setColor(Color.RED);
	g.drawString("Lander :", 260, 540);
	
	
}
private void Monamour(Graphics g){
	
	BufferedImage menuimg2 = null;

	try {
		menuimg2 = ImageIO.read(SpriteSheet.class.getResource("/textures/MonamourPortrait.png"));

	
	} catch (IOException e) {
		 e.printStackTrace(); 
	}
	g.setFont(new Font("Aharoni",0,40));
	g.drawImage(menuimg2,  0, 500,  null);
	g.setColor(Color.RED);
	g.drawString("Monamour :", 260, 540);
	
	
}
	
	
	
	
	private void select() {
		
		if(currentChoice == 0) {
				
		}
		
		
		
		if(currentChoice == 1 && options == options0) {
				if(ea.State == ea.State.CONVERSAORC){
				fala = "Voce deve encontar a rara baba de Ranieri.";
				options = options1;	
				soltaRanieri = true;
			}
		}
				if(currentChoice == 0 && options == options1){
					ea.State = ea.State.GAME;
					}
				if(currentChoice == 0 && options == options2){
					ea.State = ea.State.GAME;
					chaveSpawn  = true;
				}
				
				
				
		if(currentChoice == 2) {
			ea.State = ea.State.GAME;
			

								}
							}

	public void keyPressed() {
		key = Game.key;

	if(key.enter && Keyboard.soltouTecla && enterPress == 0){
		select();
		enterPress++;
	}
	EnterPress();
		
	if(key.up) {
		if (contaup % 100 == 0){
		currentChoice--;
		}
		contaup++;
		
		if(currentChoice == -1) {
			currentChoice = options.length - 1;
		}
	}else{contaup = 100;}
	
	if(key.down) {
		if (contado % 100 == 0){
			currentChoice++;
			}
			contado++;
		if(currentChoice == options.length) {
			currentChoice = 0;
		}
	}else{contado = 100;}
}




}
