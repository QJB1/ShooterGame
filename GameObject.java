import java.awt.Graphics;

import org.ietf.jgss.GSSContext;

public abstract class GameObject {

    int x, y;
    int velX, velY;
    int id;
    boolean isHit;
    int width, height;
    int health;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
    
    public int getX(){
        return x;
    }
    public int getY(){
        return x;
    }


}
