import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class HUD {
    private Handler handler;
    //int lvl = handler.game.levelManager.level;
    public HUD(Handler handler){
        this.handler = handler;
    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("arial", 15, 30));
        g.drawString("Level: " + handler.game.levelManager.level, (int)(Window.w - 130), 50);
        g.setColor(Color.PINK);
        g.fillOval(20, 20, 30, 30);
        g.fillOval(60, 20, 30, 30);
        g.fillOval(100, 20, 30, 30);
        g.fillOval(140, 20, 30, 30);
        g.fillOval(180, 20, 30, 30);
        g.setColor(Color.darkGray);
        GameObject p = handler.obj.get(0);
        if (p.health <= 400) g.fillOval(180, 20, 30, 30);
        if (p.health <= 300) g.fillOval(140, 20, 30, 30);
        if (p.health <= 200) g.fillOval(100, 20, 30, 30);
        if (p.health <= 100) g.fillOval(60, 20, 30, 30);
        if (p.health <= 0) g.fillOval(20, 20, 30, 30);
    }

}
