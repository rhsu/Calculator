package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

public class test 
{
    public static void main(String[] args)
	{
		myComponent painter = new myComponent();
		JFrame frame = new JFrame("Test Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.add(painter);
	}
}

class myComponent extends Component
{
	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		//g.fillRect(100, 100, 
		//g.
	}
}