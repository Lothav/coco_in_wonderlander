package level;

import game.Game;
import game.Menu;
import  entity.mob.BabaRanieri;
import  entity.mob.Player;
import  imput.Mouse;

public class EstadoAtual {

	public enum STATE {
		GAME,
		MENU,
		CONVERSAORC,
		CREDITS,
		CONVERSAINICIAL
	};
	
	public enum FASE {
		UM,
		DOIS
	};
	
	public static STATE State = STATE.MENU;
	public static FASE fase = FASE.UM;

	private int contaorc = 0;
	private int outoCont = 0;
	public STATE EstadoAtual(){
		Level level = Game.level;
		Player p = level.getClientPlayer();
	
	if(Mouse.getX() > 950 && Mouse.getX() < 1100 &&
		Mouse.getY() > 150 && Mouse.getY() < 200 &&
			Mouse.getButton() == 1 && State == STATE.MENU)	{
				State = STATE.GAME;	
				return State;

				}
	//porta
	if(Mouse.getX() > 950 && Mouse.getX() < 1100 &&
			Mouse.getY() > 250 && Mouse.getY() < 300 &&
				Mouse.getButton() == 1 && State == STATE.MENU)	{
					State = STATE.CREDITS;	
					return State;

					}
	
	if(Mouse.getX() > 950 && Mouse.getX() < 1100 &&
		Mouse.getY() > 350 && Mouse.getY() < 400 &&
			Mouse.getButton() == 1 && State == STATE.MENU)	{
				// Fecha o jogo
				System.exit(0);
				}
	
	
	if(Mouse.getX() > 950 && Mouse.getX() < 1100 &&
			Mouse.getY() > 650 && Mouse.getY() < 700 &&
				Mouse.getButton() == 1 && State == STATE.CREDITS)	{
					State = STATE.MENU;
					Game.audio.stop();
					Menu.contaACre = 0;
					return State;
					}
	if(BabaRanieri.pisoBaba && outoCont == 0) {
		outoCont  ++;
		contaorc = 0;
	}
	if(p.getX() < 130 && p.getY() < 92 &&
			p.getX() > 90 && fase == fase.UM && contaorc == 0 ){
		State = STATE.CONVERSAORC;
		contaorc ++;
		return State;
				}

	return STATE.GAME;	
	}
	
	
	public void update(){
		
		EstadoAtual();
		
	}
}
