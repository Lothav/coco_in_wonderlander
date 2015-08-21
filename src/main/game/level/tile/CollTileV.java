package level.tile;

import  graphics.Screen;
import  graphics.Sprite;

public class CollTileV extends Tile {
	

	public CollTileV(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen){	
			//renderize aqui !
		screen.renderTile(x << 4, y << 4, this, 2);		
		
	}

	public boolean solid() {
	
		return true;
	}


}