import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Joueur {
	private Image image;
	private float x ,y;
	
	public Joueur(int x, int y) throws SlickException{
		image = new Image("Images/vaisse.png");
		this.x = x;
		this.y = y; 
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float setX(float x) {
		return this.x =x;
	}
	
	public float setY(float y) {
		return this.y = y;
	}
	public void dessiner(Graphics g) {
		g.drawImage(image, x, y);
	}
	
	public void deplacement(GameContainer gc, int delta) {
		
		
		Input inp = gc.getInput();
		if(inp.isKeyPressed(Input.KEY_UP)) {
			if(y >= 50)
				y-=50;
		}
		//Pression continu sur le boutton droit
		if(inp.isKeyPressed(Input.KEY_DOWN)) {
			if(y+50 < gc.getHeight()-100)
				y+=50;
		}
		
		if(inp.isKeyPressed(Input.KEY_RIGHT)) {
			if(x+50 < gc.getWidth()-50)
				x+=50;
		}
		
		if(inp.isKeyPressed(Input.KEY_LEFT)) {
			if(x-50 < gc.getWidth()-50)
				x-=50;
		}
		
		if(inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			System.out.print(inp.getMouseX() + ' ' + inp.getMouseY());
		}
	}
	
	public void tirer(GameContainer gc) {
		Input inp = gc.getInput();
		if(inp.isKeyPressed(Input.KEY_SPACE)) {
			
		}
	}
	
}
