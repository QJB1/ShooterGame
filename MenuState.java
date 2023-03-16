import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class MenuState {
    
private Handler handler;

    public MenuState(Handler handler) {
        this.handler = handler;
    }

    static int bx = 300;
    static int by = 500;
    static int bw = 200;
    static int bh = 100;

    public void render(Graphics g) {
        g.setColor(new Color(179, 179, 179));
        g.fillRect(0, 0, 4000, 4000);

        g.setColor(Color.black);
        g.fillRect(bx, by, bw, bh);

        g.setColor(Color.white);
        g.setFont(new Font("Arial", 15, 20));
        g.drawString("Start", bx+bw/2-25, by+bh/2);

        g.setColor(Color.black);
        g.setFont(new Font("Arial", 65, 65));
        g.drawString("3rd Person Shooter Game", 400, 400);

       
    }

}
