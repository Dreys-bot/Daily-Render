import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Shoot extends BasicGame {
	private double[][] coord = new double[5][5];
	private Image image;
	private int x,y = 0;
	private Joueur joueur;
	private Ennemi[] ennemi1 = new Ennemi[10];
	private Projectile[] feu = new Projectile[5];
	private ArrayList<Projectile> p = new ArrayList<Projectile>();
	private ArrayList<Projectile> p1 = new ArrayList<Projectile>();
	
	public Shoot(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	@Override 
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		
		joueur = new Joueur(450,450);
		image = new Image("Images/universe-gb602131c6_1920.jpg");
		
		//Generation des ennemis
				for(int i=0; i<7; i++) {
					ennemi1[i] = new Ennemi(100+Math.random()*800, 100-Math.random()*-100);
				}
		
				
		
	}
	
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
			g.drawImage(image, x, y);
			joueur.dessiner(g);
		
		for(int i=0; i<p.size(); i++) {
			p.get(i).dessiner(g);
		}
		
		//Dessiner les projectiles un per un
		for(int i=0; i< p1.size(); i++) {
				p1.get(i).dessiner(g);
		}
	  //Dessiner les ennemis un par un	
	   for(int i=0; i<7; i++) {
		 ennemi1[i].dessiner(g);
	   }
	
			
 }
	

	

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
			   //Deplacement du vaisseau du joueur
				joueur.deplacement(gc, delta);
				
				Input input = gc.getInput();
			
				//Deplacement des projectiles du vaisseau du joueur
				for(int i=0; i<p.size(); i++) {
					p.get(i).deplacer(delta);
				}
		
				float coordX = joueur.getX()+70;
				float coord = joueur.getY() + 25; 
				if(input.isKeyPressed(Input.KEY_SPACE)) {
					p.add(new Projectile(coordX,coord,250));
					
				}
				
				//Deplacement des vaisseaux ennemis
						for(int i=0; i<7; i++) {
							ennemi1[i].deplacement(delta);
							if(ennemi1[i].getY() > 500) {
								ennemi1[i].setY(50+Math.random()*-200);
								ennemi1[i].setX(15+Math.random()*800);
							}
						}
					
				//Deplacement des projectiles des vaiseaux ennemis
				for(int i=0; i< p1.size(); i++) {
					p1.get(i).deplacer(delta+0);
				}
				
				//Deplacement des feus des projectile 
				for(int i=0; i<7; i++) {
					p1.add(new Projectile(ennemi1[i].getX()+70,ennemi1[i].getY()+30,-120*(i+10)));
				}			
	}

}
