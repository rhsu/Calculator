package graphics;

//http://zetcode.com/gfx/java2d/basicdrawing/

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

public class LinePlotter 
{
	//TODO make a GUI for this and Integrate it with the CalclatorGUI
	public LinePlotter()
	{
		PlotComponent painter = new PlotComponent();
		JFrame frameLinePlotter = new JFrame("Line Plotter");
		frameLinePlotter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//TODO user should be able to custom set size
		frameLinePlotter.setSize(500,500);
		frameLinePlotter.setVisible(true);
		frameLinePlotter.add(painter);
	}
	
	public static void main(String[] args)
	{
		LinePlotter myproj = new LinePlotter();
	}
}

class PlotComponent extends Component
{
	public PlotComponent()
	{
		//default expression
		//TODO Make the Expression Evaluator able to interpret this.
		String expression = "2x + 4";
	}
	
	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		//0,0 is the start point
		//300, 300 is the end point
		//For best fit do (0,2x+4) and (0,2x+300)\
		//TODO: User should be able to set color
		g2.setColor(Color.BLUE);
		//g.drawLine(0,0, 500, 500);
		g2.setStroke(new BasicStroke(5));
		g2.setColor(Color.RED);
		g2.drawLine(250,250,250,250);
	}
}