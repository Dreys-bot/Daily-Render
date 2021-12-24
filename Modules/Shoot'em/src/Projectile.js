

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Projectile {
	private double x,y;
	private float vy;
	private Image image;
	
	public Projectile(double x, double y, float vy) throws SlickException{
		if (x >= 0 && y >= 0 && x < 1000 && y < 600) {
			this.x = x;
			this.y = y;
			this.vy = vy;
		}
		else
		{
			this.x = 0;
			this.y = 0;
			this.vy = 0;
		}
		
		image = new Image("images/feu.png");
	}
	
	public double getX() {
		return x; 
	}
	
	public double getY() {
		return y;
	}
	
	public void dessiner(Graphics g) {
		g.drawImage(image, (float)x-4, (float)y-4);
	}
	
	public void deplacer(int delta) {
		float distance = vy * delta/1000f;
		y = y - distance;
	}
}
