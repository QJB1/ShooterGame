import java.awt.Graphics;
import java.awt.Color;

public class Bullet extends GameObject{

    private Handler handler;
    private float velX, velY;
    int enemyX, enemyY;
    private boolean not_done;
    
    public Bullet(int x, int y, Handler handler, int mx, int my) {
        super(x, y);
        this.handler = handler;
        not_done = true;
        calculateVelocity(x, y, mx, my);
    }

    public void tick() {
        //if(not_done){
            hasHit();
        //}
        /* 
        count++; // slow it down by 4x. runs every 4 ticks.
        if(count == 4){
            hasHit();
            count = 0;
        }
        */
        
        if (x < 0 || y < 0) {
            handler.obj.remove(this);
        }
        x += velX;
        y += velY;
    }

    public void hasHit(){
        for (int i = 1; i < handler.obj.size(); i++) {
            GameObject enemy = handler.obj.get(i);
			if(enemy.id == 2){
                enemyX = enemy.x;
                enemyY = enemy.y;
                if (x <= enemyX+enemy.width && x+width >= enemyX && y <= enemyY+enemy.height && x+height >= enemyY){
                    enemy.isHit = true;
                    not_done = false;
                }
            }
		}     
        /* 
        loop COUNT from 1 to HANDLER.OBJ.size()
            ENEMY = HANDLER.OBJ.get(COUNT)
			if ENEMY.ID == 2 then
                ENEMYX = ENEMY.X
                ENEMYY = ENEMY.y
                if X <= ENEMYX+ENEMY.WIDTH AND X+WIDTH >= ENEMYX AND Y <= ENEMYY+ENEMY.HEIGHT AND X+HEIGHT >= ENEMYY then
                    ENEMY.ISHIT = TRUE
                    NOT_DONE = FALSE
                }
            }
		}   
        */  
    }

    public void calculateVelocity(int fromX, int fromY, int toX, int toY) {
		double distance = Math.sqrt(Math.pow((toX - fromX), 2) + Math.pow((toY - fromY), 2));
		float speed = 10f;
		velX = (float)((toX - fromX) * speed / distance);
		velY = (float)((toY - fromY) * speed / distance);

        /* 
        DISTANCE = Math.sqrt(Math.pow((TOX - FROMX), 2) + Math.pow((TOY - FROMY), 2));
		SPEED = 10f;
		VELX = (float)((TOX - FROMX) * speed / distance)
		VELY = (float)((TOY - FROMY) * speed / distance)
        */
	}

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y, 10, 10);
    }
    
}



/*
    public void hasHit(){
        for (int i = 1; i < handler.obj.size(); i++) {
            GameObject enemy = handler.obj.get(i);
			if(enemy.id == 2){
                enemyX = enemy.x;
                enemyY = enemy.y;
                /*
                if(enemyX+enemy.width <= x+width && enemyX+enemy.width >= x){ // needs some more work
                    if(enemyY+enemy.height <= y+height && enemyY+enemy.height >= y){       
                        enemy.isHit = true;
                    }
                }
                if ((x > enemyX && x - 10 < enemyX + 40) && (y + 10 == enemyY)
                || (y > enemyY && y - 10 < enemyY + 40) && (x == enemyX + 40)
                || (x > enemyX && x - 10 < enemyX + 40) && (y == enemyY + 40)
                || (y > enemyY && y - 10 < enemyY + 40) && (x + 10 == enemyX)) enemy.isHit = true;
                
                if (x <= enemyX+enemy.width && x+width >= enemyX && y <= enemyY+enemy.height && x+height >= enemyY){
                    enemy.isHit = true;
                }
            }
		}
        // x <= enemyX+enemy.width && x+width >= enemyX
        // y <= enemyY+enemy.height && x+height >= enemyY
        // above enemy
        // (x > enemyX && x - 10 < enemyX + 40) && (y + 10 == enemyY)
        // right of enemy
        // (y > enemyY && y - 10 < enemyY + 40) && (x == enemyX + 40)
        // below enemy
        // (x > enemyX && x - 10 < enemyX + 40) && (y == enemyY + 40)
        // left of enemy
        // (y > enemyY && y - 10 < enemyY + 40) && (x + 10 == enemyX)
    }
*/