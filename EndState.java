import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class EndState {

    private Handler handler;

    public EndState(Handler handler) {
        this.handler = handler;
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(0, 0, 5000, 5000);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", 65, 65));

        if(handler.game.levelManager.you_win){
            g.drawString("You Win!!", 600, 400);
        }
        else{
            g.drawString("You Lose!!", 600, 400); 
        }
        
    }

}

