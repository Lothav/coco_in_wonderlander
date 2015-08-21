package level.tile;
import  graphics.Screen;
import  graphics.Sprite;


public class CollTile extends Tile {
	

	

		public CollTile(Sprite sprite) {
			super(sprite);
		}

		public void render(int x, int y, Screen screen){	
				//renderize aqui !
			screen.renderTile(x << 4, y << 4, this, 6);		
			
		}

		public boolean solid() {
		
			return true;
		}
	
//collision
}
