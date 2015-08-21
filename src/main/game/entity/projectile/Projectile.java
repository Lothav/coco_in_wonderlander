package entity.projectile;

import java.util.Random;

import game.Game;
import  entity.Entity;
import  graphics.Sprite;
import  imput.Mouse;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin;
	protected double angle;
	public Sprite sprite;
	public static int type = 0;
	protected double x, y;
	protected double nx, ny;
	protected double distance;
	protected double speed, range, damage;
	public static boolean atirandoBaixo = false;
	public static boolean atirandoCima = false;

	protected final Random random = new Random();
	public static boolean atirandoCimaD = false;

	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		
		double dx = Mouse.getX();
		double dy = Mouse.getY();

		double ax = Game.getWindowWidth() / 2;
		double ay = Game.getWindowHeight() / 2;

		if (dy > ay + 100 && ((dx > ax - 20) || (dx < ax + 20))
				&& Mouse.getButton() == 1) {

			this.x = x - 15;
			this.y = y + 25;

			atirandoBaixo = true;

		} else {

			atirandoBaixo = false;

			if (dy < ay - 100 && ((dx > ax - 20) || (dx < ax + 20))
					&& Mouse.getButton() == 1) {

				this.x = x - 15;
				this.y = y - 25;
				atirandoCima = true;

				if (dx > ax)
					atirandoCimaD = true;
				else
					atirandoCimaD = false;

			} else {

				atirandoCima = false;

				if (dx > ax) {
					if (Mouse.getButton() == 1) {
						this.x = x + 20;
						this.y = y - 15;
					} else

					if (Mouse.getButton() == 3) {
						this.x = x + 20;
						this.y = y - 30;
					}
				} else if (Mouse.getButton() == 1) {
					this.x = x - 40;
					this.y = y - 15;
				} else

				if (Mouse.getButton() == 3) {

					this.x = x - 40;
					this.y = y - 30;

				}
			}
		}
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getSpriteSize() {
		return sprite.SIZE;

	}

	protected void move() {

	}
}