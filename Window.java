import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Window {

	static JFrame frame = new JFrame();
	JPanel p1 = new JPanel();
	
	private Game game;

	// Dimensions
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double height = screenSize.getHeight();
	double width = screenSize.getWidth();
	static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	static double h = size.getHeight();
	static double w = size.getWidth();

	public Window(String title, Game game) {
		
		this.game = game;
		System.out.println(height + ", " + width);

		frame.setTitle(title);
		frame.add(game);
		

		frame.setResizable(false);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setSize(1500,1000);
		//frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		//p1.setBounds(100,100,100,100);
		//p1.setBackground(Color.PINK);
		//p1.setFocusable(false);
		//p1.setVisible(true);
		//frame.add(p1);
		
		
	}
}










//Window.p1.setVisible(true);
		// JLabel label = new JLabel();
		//label.setText();
		//label