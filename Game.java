import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

import java.awt.Color;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -7803629994015778818L;

	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private KeyInput keyInput;
	private MouseInput mouseInput;

	// menu = 0, game = 1, end = 2
	public int currState;
	private MenuState menuState;
	private EndState endState;
	
	private HUD hud;
	public LevelManager levelManager;

	public Game() {
		new Window("Game", this);
		start();
		
		handler = new Handler(this);

		keyInput = new KeyInput(handler);
		mouseInput = new MouseInput(handler);
		this.addKeyListener(keyInput);
		this.addMouseListener(mouseInput);
		levelManager = new LevelManager(handler);
		menuState = new MenuState(handler);
		endState = new EndState(handler);

		hud = new HUD(handler);
	} 
	
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running) {
			return;
		}
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		// Time between each update
		double ns = 1000000000.0 / 60;
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			render();
		}
		stop();
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//g.setColor(Color.GRAY);
		//g.fillRect(0,0,5000, 5000);
		if (currState == 0) {
			menuState.render(g);
		}
		else if (currState == 1){
			handler.render(g);
			hud.render(g);
		}
		else if(currState == 2){
			endState.render(g);
		}

		g.dispose();
		bs.show();
		
	}
	
	private void tick() {
		if (currState == 1){
			handler.tick();
			levelManager.tick();
		}
	}
	static boolean game = true;
	public static void main(String[] args) {
		new Game();
		//Graphics g = new Graphics;
		//render2(g);
		/*JPanel p2 = new JPanel();
		p2.setBounds(0,0,1000,1000);
        p2.setBackground(Color.darkGray);
		p2.setFocusable(false);
        p2.setVisible(true);*/
	}
	/* 
	public static void render2(Graphics g) {

        g.setColor(Color.BLUE);
        g.fillOval(20, 20, 30, 30);

    }
	*/
	

}
