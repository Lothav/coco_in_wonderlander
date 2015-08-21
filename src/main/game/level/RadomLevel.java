package level;

import java.util.Random;

public class RadomLevel extends Level{

	private static final Random random = new Random();
	
	public RadomLevel(int width, int height) {
		super(width, height);
	}

	protected void generateLevel(){
		for (int y = 0; y < height ; y++){
			for (int x = 0; x < width ; x++){
				tilesInt[x + y * width] = random.nextInt(4);		
			}		
		}	
	}
	
}
