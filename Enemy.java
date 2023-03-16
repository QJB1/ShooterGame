import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Enemy extends GameObject{
    
    private Handler handler;
    private int spd = 10;
    private int userX, userY;
    private int count;
    
    public Enemy(int x, int y, Handler handler) {
        super(x, y);
        this.handler = handler;
        id = 2;
        health = 10;
        width = 40;
        height = 40;
    }

    private void findPath() {
        userX = handler.obj.get(0).x;
        userY = handler.obj.get(0).y;
        if(userX > x){
            x++;
        }
        else if(userX < x){
            x--;
        }
        if(userY > y){
            y++;
        }
        else if(userY < y){
            y--;
        }
    }

    public void tick() {
        for (int i = 0; i < 4; i++) findPath();
        if(isHit){
            health--;
            isHit = false;
        }
        hasHit();
        if (health == 0) { // removes obj after death
            handler.obj.remove(this);
        }
        /* 
        if(handler.enemy_hit){
            health--;
            System.out.println(health);
            handler.enemy_hit = false;
        }
        if has hit = 10
        */
        count++; // slow it down by 4x. runs every 4 ticks.
        if(count == 30){
            hasHit();
            count = 0;
        }
    }

    public void hasHit(){
        GameObject user = handler.obj.get(0);
        userX = user.x;
        userY = user.y;
        if (x <= userX+user.width && x+width >= userX && y <= userY+user.height && x+height >= userY){
            user.isHit = true;
            //System.out.println(1);
        }
    }
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
        g.setColor(Color.black);
        g.setFont(new Font("Arial",15, 15));
        g.drawString(Integer.toString(health),x+20,y+20);
    }
}
