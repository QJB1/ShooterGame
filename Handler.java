
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Color;


public class Handler {

	ArrayList<GameObject> obj = new ArrayList<>();
	public Game game;

	boolean up, down, left, right;
	// boolean enemy_hit = false;
	// int userX, userY;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public void tick() {
		for (int i = 0; i < obj.size(); i++) {
			obj.get(i).tick();
		}
		/*
		loop i from 0 to OBJ.size()
			OBJ.get(i).tick();
		end loop 
		*/
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0,0,5000, 5000);
		//health bar
		/*
		
		*/
		for (int i = 0; i < obj.size(); i++) {
			obj.get(i).render(g);
		}
		//System.out.println("1");
	}
	
}
