import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args)throws SlickException {
		Memories jeu = new Memories("mon jeu");
		AppGameContainer app = new AppGameContainer(jeu, 900, 1000, false);
		app.start();

	}

}
