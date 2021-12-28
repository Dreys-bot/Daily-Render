import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Carte {
   private double x,y;
   private Image image;
   private int categorie;
   
   public Carte(double x, double y, Image image, int c) {
	   this.x = x;
	   this.y = y;
	   this.image = image;
	   this.categorie=c;
   }
   
   public void dessiner(Graphics g) {
	   g.drawImage(image, (float)x, (float)y);
   }
   

	public double getX() {
		return x;
	}

	public void setX(double x) {
			this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public Image getImage() {
		return image;
	}

	public void setY(double y) {
			this.y = y;
	}
	public int getCategorie() {
		return this.categorie;
	}
}
