import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Graphics;

public class Menu {
    public Menu(){
        Stuff();
    }
    public void Stuff(){
        JFrame frame = new JFrame();
        frame.setResizable(false);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
        frame.setBackground(Color.Green);
        
        
        /* 

        JPanel p2 = new JPanel();
		p2.setBounds(0,0,1000,1000);
        p2.setBackground(Color.Black);
		p2.setFocusable(false);
        p2.setVisible(true);
        frame.add(p2);

        
        JPanel p1 = new JPanel();
        frame.add(p1);
        JButton b1a = new JButton("Play");
        b1a.setBounds(100,100,100,100);
        b1a.setFocusable(false);
        b1a.setVisible(true);

        b1a.addActionListener(new ActionListener(){ // play
			public void actionPerformed(ActionEvent evt){
				// generate gameState (handler)
				game.currState = 2;
			}
		});
        */
    }
}
