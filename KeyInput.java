
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	boolean paused;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) handler.up = true;
		if (code == KeyEvent.VK_A) handler.left = true;
		if (code == KeyEvent.VK_S) handler.down = true;
		if (code == KeyEvent.VK_D) handler.right = true;

		/*if (code == KeyEvent.VK_P) {
			if (!paused) handler.game.currState = 3;
			else {
				handler.game.currState = 1;
				paused = false;
			}
		}*/
		if (code == KeyEvent.VK_ESCAPE) System.exit(1);
/* 
		CODE = E.getKeyCode();
		if (CODE == KeyEvent.VK_W) HANLDER.UP = TRUE;
		if (CODE == KeyEvent.VK_A) HANDLER.LEFT = TRUE;
		if (CODE == KeyEvent.VK_S) HANDLER.DOWN = TRUE;
		if (CODE == KeyEvent.VK_D) HANDLER.RIGHT = TRUE;

		if (CODE == KeyEvent.VK_ESCAPE) System.exit(1);
		
		*/
	}
	
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) handler.up = false;
		if (code == KeyEvent.VK_A) handler.left = false;
		if (code == KeyEvent.VK_S) handler.down = false;
		if (code == KeyEvent.VK_D) handler.right = false;
		
	}
	
}
