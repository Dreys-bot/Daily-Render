import java.awt.Font;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class Memories extends BasicGame {
	private int x, y;
	private Image image, image1,image3;
	private int compt = 0;
	private int compteur = 0;
	Carte[] carte1 = new Carte[2];
	int[] categorie = new int[2];
	Carte[] carte = new Carte[2];
	int[][] indice = new int[2][2];
	int point = 0;
	int k = 0;
	int tentatives = 0;
	String tentative = "0";
	String score="0";
	int[] tab = new int[16];
	int l = 0;

	// Creation de la matrice d'images

	// Creation de la matrice de carré
	private Carte[][] c = new Carte[4][4];
	private Carte[][] c1 = new Carte[4][4];

	public Memories(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		x = y = 0;

		// Image de chaque carte
		image = new Image("icon/def.JPG");
		image1 = new Image("icon/menu_bg.png");
		image3 = new Image("icon/logo.png");
		// Initialiser la grille de cartes
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				float x = 120 * i + 190;
				float y = 90 * j + 50;
				c[i][j] = new Carte(y, x, image, 0);
			}
		}

		// Tableau d'images
		Image[] images = { new Image("icon/1.JPG"), new Image

				("icon/2.JPG"), new Image("icon/3.JPG"), new Image("icon/4.JPG"), new Image

				("icon/5.JPG"), new Image("icon/6.JPG"), new Image("icon/7.JPG"), new Image

				("icon/8.JPG"), new Image("icon/9.JPG"), new Image("icon/10.JPG"), new Image

				("icon/11.JPG"), new Image("icon/12.JPG"), new Image("icon/13.JPG"), new Image

				("icon/14.JPG"), new Image("icon/15.JPG"), new Image("icon/16.JPG") };

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				float x = 120 * i + 190;
				float y = 90 * j + 50;
				k = (int) (Math.random() * 16 + 1);
				tab[l] = k;

				if (l == 1) {
					for (int m = 0; m < 16; m++) {
						if (tab[m] == k) {
							k = (int) (Math.random

							() * 16 + 1);
						}
					}
				}

				if (k == 0 || k == 3)
					c1[i][j] = new Carte(y, x, images[k], 0);
				else if (k == 1 || k == 6) {
					c1[i][j] = new Carte(y, x, images[k], 1);
				} else if (k == 2 || k == 14) {
					c1[i][j] = new Carte(y, x, images[k], 2);
				} else if (k == 4 || k == 9) {
					c1[i][j] = new Carte(y, x, images[k], 3);
				} else if (k == 5 || k == 11) {
					c1[i][j] = new Carte(y, x, images[k], 4);
				} else if (k == 7 || k == 12) {
					c1[i][j] = new Carte(y, x, images[k], 5);
				} else if (k == 8 || k == 15) {
					c1[i][j] = new Carte(y, x, images[k], 6);
				} else if (k == 10 || k == 13) {
					c1[i][j] = new Carte(y, x, images[k], 7);
				}
				l += 1;
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException

	{
		// TODO Auto-generated method stub

		// Dessin du background de couleur rose
		g.drawImage(image1, x, y);
		g.fillRect(460,190, 150, 100);
		g.drawImage(image3, 50,50);
		
		  java.awt.Font font = (java.awt.Font) new Font("Verdana",Font.BOLD, 15); 
		  TrueTypeFont ttf = new TrueTypeFont(font, true);
		  ttf.drawString(y+470, x+210, "TENTATIVES :", Color.black);
		  ttf.drawString(y+590, x+210, tentative, Color.black);
		  ttf.drawString(y+470, x+250, "SCORE :", Color.black);
		  ttf.drawString(y+590, x+250, score, Color.black);

		// Representons chaque element de la matrice par un carré
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (c[i][j] != null)
					c[i][j].dessiner(g);
			}
		}

	}
	
	
	
	@Override
	public void update(GameContainer gc, int delat) throws SlickException {
		// TODO Auto-generated method stub
		// Initialisons une variable pour commencer le jeu
		boolean game = true;
		boolean cacher = true;
		// Mettons le jeu dans une boucle pour permettre de jouer dans qu'on a pas eu 8
		// points

		// Recuperation des coordonnées de la souris
		Input inp = gc.getInput();
		double x_mouse = inp.getMouseX();
		double y_mouse = inp.getMouseY();

		if (game == true)
			// Lorsqu'on fait un clic, je verifie que le clic se fait sur la carte si c'est
			// le cas je retourne la carte en remplacant par son verso
			if (inp.isMousePressed

			(Input.MOUSE_LEFT_BUTTON)) {

				for (int i = 0; i < 4; i++)

				{
					for (int j = 0;

							j < 4; j++) {
						if (x_mouse

								>= c[i][j].getX() && x_mouse <= c[i][j].getX() + 80 && y_mouse >= c[i][j].getY()

								&& y_mouse <= c[i][j].getY() + 80) {

							indice[0][compt] = i;

							indice[1][compt] = j;

							compt += 1;

							carte1[compteur] = c[i][j];
							c

							[i][j] = c1[i][j];

							carte[compteur] = c[i][j];

							categorie[compteur] = c1[i][j].getCategorie();

							compteur += 1;
						}

					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (compteur == 2) {
					tentatives += 1;
					tentative = String.valueOf(tentatives);
					if (categorie

					[0] == categorie[1]) {
						point

								+= 1;
						score = String.valueOf(score);
						System.out.print(point);

						compteur = 0;

						compt = 0;
					} else if

					(categorie[0] != categorie[1]) {
						c

						[indice[0][0]][indice[1][0]] = carte1[0];
						c

						[indice[0][1]][indice[1][1]] = carte1[1];

						compteur = 0;

						compt = 0;
					}
				}

				if (point == 8)
					game = false;

			}
	}
}
