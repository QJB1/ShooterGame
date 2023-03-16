import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class User extends GameObject {

    private Handler handler;
    private int spd = 10;

    public User(int x, int y, Handler handler) {
        super(x, y);
        this.handler = handler;
        id = 1;
        health = 500;
    }

    public void tick() { 
        if(isHit){
            health--;
            isHit = false;
        }  
        if (health == 0) { // removes obj after death
            handler.obj.remove(this);
            // call to Game Over page.
        }
        Move();
/*
        if ISHIT then
            health -= 1
            isHit = FALSE
        end if
        if health == 0 then
            HANDLER.OBJ.remove(this)
        end if
*/
    }

    public void removeHearts(){
        if(health == 500){
            
        }
        else if(health == 400){

        }
        else if(health == 300){
        }
        else if(health == 200){
        }
        else if(health == 100){
        }
    }

    public void Move(){
        if (x >= 0) x += velX;
        if (y >= 0) y += velY;

        if (handler.up) velY = -spd;
        else if (!handler.down) velY = 0;
        
        if (handler.down) velY = spd;
        else if (!handler.up) velY = 0;
        
        if (handler.left) velX = -spd;
        else if (!handler.right) velX = 0;
        
        if (handler.right) velX = spd;
        else if (!handler.left) velX = 0;
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 40, 40);
        g.setColor(Color.black);
        g.setFont(new Font("Arial",15, 15));
        g.drawString(Integer.toString(health),x+20,y+20);
    }
}

/* 
    public void Move(){
        X += VELX
        Y += VELY

        if (HANDLER.up) then 
            VELY = -SPD
        else if (NOT HANDLER.down) then 
            VELY = 0 
        end if
        
        if (HANDLER.down) then 
            VELY = SPD
        else if (NOT HANDLER.up) then 
            VELY = 0 
        end if
        
        if (HANDLER.left) then 
            VELX = -SPD 
        else if (NOT HANDLER.right) then 
            VELX = 0 
        end if
        
        if (HANDLER.right) then 
            VELX = SPD
        else if (NOT HANDLER.left) then 
            VELX = 0 
        end if

        if(x <= 0 || y <= 0){
            x = 0;
            y = 0;
        }

        if(x < 0) velX = 0;
        //if(x <= 0 - 40) velX = 0;
        if (x >= 1512 - 40) velX = 0;
        if (y >= 982 - 40) velY = 0;
    }
*/