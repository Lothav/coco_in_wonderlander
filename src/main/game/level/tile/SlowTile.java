package level.tile;

import game.Game;
import  entity.mob.Geladeira;
import  entity.mob.Player;
import  graphics.Screen;
import  graphics.Sprite;
import  level.Level;

public class SlowTile extends Tile {

	
	public SlowTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen){	
			//renderize aqui !
		screen.renderTile(x << 4, y << 4, this, 6);	
	}

	public boolean slow(){
		return true;
	}
	
	
	
	
	
	
}