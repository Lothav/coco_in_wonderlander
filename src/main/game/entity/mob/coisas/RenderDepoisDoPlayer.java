package entity.mob.coisas;


import game.Dignidade;
import game.Game;
import  entity.mob.Player;
import  entity.projectile.WizardProjectile;
import  graphics.Screen;
import  graphics.SpriteSheet;
import  level.tile.Tile;
import  level.EstadoAtual;
import  level.Level;

public class RenderDepoisDoPlayer {
	
	private Screen screen = Game.screen;
	private EstadoAtual ea;
	public void render(){
		
	if(ea.fase == ea.fase.UM){	
		
		//Muraiada da fase 1
		screen.renderCoisas(0, 805, Tile.tijoloteto);
		screen.renderCoisas(176, 805, Tile.tijoloteto);
		screen.renderCoisas(176+176, 805, Tile.tijoloteto);
		screen.renderCoisas(176+176+116, 805, Tile.tijoloteto);
		screen.renderCoisas(16, 688, Tile.tijoloteto);

		screen.renderCoisas(64, 0, Tile.tijoloteto);
		screen.renderCoisas(176, 0, Tile.tijoloteto);
		screen.renderCoisas(176+176, 0, Tile.tijoloteto);
		screen.renderCoisas(176+176+116, 0, Tile.tijoloteto);
		screen.renderCoisas(464, 385, Tile.tijoloteto);
		screen.renderCoisas(416, 528, Tile.tijoloteto);
		screen.renderCoisas(48, 130, Tile.tijoloteto);
		screen.renderCoisas(320, 130, Tile.tijoloteto);
		
		
		Level level = Game.level;
		Player p = level.getClientPlayer();
		
		
		//Telhado e muros da casa fase 1
		if(!(p.getX() > 223 && p.getX() < 400 && p.getY() > 240 && p.getY() < 390)){
			
			screen.renderCoisas(192, 246, Tile.telhado);

			}else{
		
				

				
				
		screen.renderCoisas(224, 242, Tile.tijoloteto);
		screen.renderCoisas(224, 368, Tile.tijoloteto);
		
			}
		
		
		if(!(p.getX() > 35 && p.getX() < 170 && p.getY() > 730 && p.getY() < 790))
				screen.renderCoisas(-10, 674, Tile.telhado);

		
	}
	if(ea.fase == ea.fase.DOIS){
	
	screen.renderCoisas(144, 1550 ,Tile.arvereCimeMuro);
	screen.renderCoisas(144, 1570 ,Tile.arvereCimeMuro);
	screen.renderCoisas(144, 1590 ,Tile.arvereCimeMuro);
	screen.renderCoisas(144, 1610 ,Tile.arvereCimeMuro);
	screen.renderCoisas(144, 1630, Tile.arvereCimeMuro);
	screen.renderCoisas(144, 1650, Tile.arvereCimeMuro);
	screen.renderCoisas(144, 1670, Tile.arvereCimeMuro);
	screen.renderCoisas(144, 1690, Tile.arvereCimeMuro);
	screen.renderCoisas(144, 1710 ,Tile.arvereCimeMuro);
	
	screen.renderCoisas(1120, 1555 ,Tile.arvereCimeMuro);
	screen.renderCoisas(1120, 1575 ,Tile.arvereCimeMuro);
	screen.renderCoisas(1120, 1595 ,Tile.arvereCimeMuro);
	screen.renderCoisas(1120, 1615 ,Tile.arvereCimeMuro);


	


	screen.renderCoisas(144, 1729, Tile.arvereCime);
	screen.renderCoisas(368, 1729, Tile.arvereCime);
	screen.renderCoisas(704, 1729, Tile.arvereCime);
	screen.renderCoisas(1040, 1776, Tile.arvereCime);
	screen.renderCoisas(1376, 1728, Tile.arvereCime);
	screen.renderCoisas(1600, 1728, Tile.arvereCime);
	screen.renderCoisas(928, 1634, Tile.arvereCime);
	
	screen.renderCoisas(1488, 1520, Tile.arvereCime);
	screen.renderCoisas(1680, 1520, Tile.arvereCime);
	screen.renderCoisas(1680, 1264 ,Tile.arvereCime);
	screen.renderCoisas(1488, 1264 ,Tile.arvereCime);




	
/*	screen.renderCoisas(352, 320, Tile.arvereCime);
	screen.renderCoisas(64, 420, Tile.arvereCime);
	screen.renderCoisas(368, 464, Tile.arvereCime);
	screen.renderCoisas(144, 560, Tile.arvereCime);
	screen.renderCoisas(368, 560, Tile.arvereCime);
	screen.renderCoisas(32, 688, Tile.arvereCime);
	screen.renderCoisas(32, 790, Tile.arvereCime);
	screen.renderCoisas(224, 790, Tile.arvereCime);
	screen.renderCoisas(416, 790, Tile.arvereCime);*/

	


	
	
	}
		//INTERFACE
		
		
		if(WizardProjectile.countpor > 3) WizardProjectile.countpor = 3;
		if( WizardProjectile.countpor == 3 ) screen.renderSheet(1, 195, SpriteSheet.porc0, false);
		if( WizardProjectile.countpor == 2 ) screen.renderSheet(1, 195, SpriteSheet.porc1, false);
		if( WizardProjectile.countpor == 1 ) screen.renderSheet(1, 195, SpriteSheet.porc2, false);
		if( WizardProjectile.countpor <= 0 ) screen.renderSheet(1, 195, SpriteSheet.porc3, false);
		
		if(Dignidade.dign <= 0 ){ 
			screen.renderSheet(50, 10, SpriteSheet.cocomorto, false);
			

		}
		
	}
}
