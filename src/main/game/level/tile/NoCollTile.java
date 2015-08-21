package level.tile;

import game.Game;
import  entity.mob.Player;
import  graphics.Screen;
import  graphics.Sprite;

public class NoCollTile extends Tile {
	
	
	public NoCollTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen){	
			//renderize aqui !
		screen.renderTile(x << 4, y << 4, this, 6);		
		
	}

	
	
}
