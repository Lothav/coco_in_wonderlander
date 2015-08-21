package game;

import entity.mob.Player;
import entity.projectile.WizardProjectile;
import graphics.SpriteSheet;
import imput.Mouse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Menu {
	
	private int tV = 40;
	private int tS = 40;
	private int tC = 40;
	private int tQ = 40;	
	private Color ColorS;
	private Color ColorC;
	private Color ColorQ;
	private Color ColorV;
	public static int contaACre = 0;
	//private SpawnLevel sp;
	
	
	

	public void renderMenu(Graphics g){
		
		Font fnt0 = new Font("Jokerman", Font.BOLD,tS);
		Font fnt1 = new Font("Jokerman", Font.BOLD,tC);
		Font fnt2 = new Font("Jokerman", Font.BOLD,tQ);
		
		WizardProjectile.countpor = 3;
		Player.contaSMacacoOnCoco = 0;
		
	//Start	
	if( (Mouse.getX() > 950 && Mouse.getX() < 1100) &&
		(Mouse.getY() > 150 && Mouse.getY() < 200) ){
		ColorS = Color.RED;
		tS = 60;
		}
		else {tS = 40;
		ColorS = Color.BLACK;
		}
	
	//Credits
	if( (Mouse.getX() > 950 && Mouse.getX() < 1100) &&
			(Mouse.getY() > 250 && Mouse.getY() < 300) ){
			tC = 60;
			ColorC = Color.RED;
			}
			else {tC = 40;
			ColorC = Color.black;
			}
	
	//Quit
	if( (Mouse.getX() > 950 && Mouse.getX() < 1100) &&
			(Mouse.getY() > 350 && Mouse.getY() < 400) ){
			tQ = 60;
			ColorQ = Color.RED;
			}
			else {tQ = 40;
			ColorQ = Color.black;
			}
	
	
	
		BufferedImage menuimg2 = null;
		BufferedImage menuimg = null;

		try {
			menuimg2 = ImageIO.read(SpriteSheet.class.getResource("/textures/LOGO.png"));

		
		} catch (IOException e) {
			 e.printStackTrace(); 
		}
		try {
			menuimg = ImageIO.read(SpriteSheet.class.getResource("/textures/grassbg1.gif"));

		
		} catch (IOException e) {
			 e.printStackTrace(); 
		}

		int getwi = Game.getWindowWidth();
		int gethe = Game.getWindowHeight();
	//	Graphics2D graficos = (Graphics2D) g;
/*
		ImageIcon referencia = new ImageIcon("res\\grassbg1.gif");
		getClass().getResource("res\\grassbg1.gif");
		fundo = referencia.getImage();
*/
		
		g.drawImage(menuimg,  0, 0, getwi, gethe, null);
		g.drawImage(menuimg2,  0, 0, getwi, gethe, null);

		//Botão Start
		g.setFont(fnt0);
		g.setColor(ColorS);
		g.drawString("Start", 940, 190);
		
		//Botão Credits
		g.setFont(fnt1);
		g.setColor(ColorC);
		g.drawString("Credits", 920, 290);
		
		//Botão Quit
		g.setFont(fnt2);
		g.setColor(ColorQ);
		g.drawString("Quit", 950, 390);

	}
	
	
	
	/// CREDITOS
	
	public void renderCredits(Graphics g){
		
		int getwi = Game.getWindowWidth();
		int gethe = Game.getWindowHeight();
		
		BufferedImage credits = null;
		try {
		 credits = ImageIO.read(SpriteSheet.class.getResource("/textures/backcredits.png"));

		
		} catch (IOException e) {
			 e.printStackTrace(); 
		}
		
		g.drawImage(credits,  0, 0, getwi, gethe, null);

		//if(contaACre  == 0 ) {Game.audio.playClip(Game.audio.credits , +1.0f );	
		//contaACre++;
		//}
		
		
		if( (Mouse.getX() > 950 && Mouse.getX() < 1100) &&
				(Mouse.getY() > 650 && Mouse.getY() < 700) ){
				tV = 60;
				ColorV = Color.RED;
				}
				else {tV = 40;
				ColorV = Color.yellow;
				}
		
		//Botão Volta
			Font fnt0 = new Font("Jokerman", Font.BOLD,tV);
			Font fnt1 = new Font("Jokerman", Font.BOLD,60);
			Font fnt3 = new Font("Arial", Font.BOLD,40);


				g.setFont(fnt0);
				g.setColor(ColorV);
				g.drawString("Back", 950, 700);
		
			//	sp.add(new Rocha(10, 20));
		
				
		// 		TESTE
				g.setColor(Color.yellow);
				g.setFont(fnt1);
				g.drawString("Luiz Otávio", 400, 200);
				g.drawString("Edu 'bro' Rocha", 350, 500);

				g.setFont(fnt3);
				g.drawString("Java programer", 420, 240);		
				g.drawString("Designer", 470, 540);
	}
}