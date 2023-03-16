
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

	private Handler handler;
	int mx, my;

	public MouseInput(Handler handler) {
		this.handler = handler;
	}
	
	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
	}
	
	public void mousePressed(MouseEvent e) {
		mx = e.getX();
		my = e.getY();

		if (handler.game.currState == 0) {
			if (mouseOver(mx, my, MenuState.bx, MenuState.by, MenuState.bw, MenuState.bh)){
				handler.game.currState = 1;
				handler.obj.add(new User(500, 500, handler));
			}
		}
		if (handler.game.currState == 1) {
			GameObject temp = handler.obj.get(0);
			handler.obj.add(new Bullet(temp.x + 20, temp.y + 20, handler, mx, my));
		}
		if (handler.game.currState == 2) {
			if (mouseOver(mx, my, MenuState.bx, MenuState.by, MenuState.bw, MenuState.bh)){
				new Game();
			}
		}
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width && my > y && my < y + height) {
			return true;
		}
		return false;
	}
	
}
