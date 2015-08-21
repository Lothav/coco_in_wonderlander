package level.tile;
import  graphics.Screen;
import  graphics.Sprite;


public class GarraPe extends Tile {
	

	

		public GarraPe(Sprite sprite) {
			super(sprite);
		}

		public void render(int x, int y, Screen screen){	
				//renderize aqui !
			screen.renderTile(x << 4, y << 4, this, 6);		
			
		}

		public boolean garrou() {
		
			return true;
		}
	
//collision
}