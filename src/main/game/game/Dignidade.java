package game;

import entity.mob.Player;
import graphics.Screen;
import level.Level;

import java.awt.*;

public class Dignidade {
	
	public static int dign = 245;
	private int dignTotal = 735;
	
	public void render(Graphics g){
		//Dignidade.render
		
		Level level = Game.level;
		if(dign >= 147 )g.setColor(Color.GREEN);
			else if(dign < 147 && dign > 50 )g.setColor(Color.YELLOW);
				else if(dign <= 50 && dign > 0) g.setColor(Color.RED);
					if(dign < 0) dign = 0;
						
					
		dignTotal = dign * 3 ;
		
		//Barra de Dignidade
		
		g.fillRect(290, 715, dignTotal, 32);
		
		//Dignidade//
		
			g.setFont(new Font("Arial",0,30));
			g.drawString("Dignidade :", 130, 738);
			Screen screen = Game.screen;

		//Porcentagem Dignidade//
			
			Player player = level.getClientPlayer();
		
			
		//Coordenadas do player
			
			g.setColor(Color.WHITE);
			if(dign > 0) g.drawString( (int)(dign/2.45)+1 + "%", 942, 741);
			else g.drawString("Violado", 900, 738);
			g.setFont(new Font("Verdana",0,10));
			g.drawString("X :" + player.getX() +", Y:" + player.getY(), 1, 750);
			
			
		// Out of toinços = /
			
			if(Player.outoincos){	
				g.setColor(Color.RED);
				g.setFont(new Font("Verdana",0,30));
				g.drawString("Out of Toinços = /", screen.width + 30 , screen.height - 30 );
				
		}
	}
}
