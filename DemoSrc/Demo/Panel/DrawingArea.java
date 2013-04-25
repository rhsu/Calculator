package Demo.Panel;

import java.awt.*;
import javax.swing.*;

///////////////////////////////////////////////////////// DrawingArea
public class DrawingArea extends JPanel {

    //======================================================== fields
    private Color _ovalColor;      // Color of oval.

    //=================================================== constructor
    public DrawingArea() {
        _ovalColor = Color.GREEN;  // Initial color.
        setPreferredSize(new Dimension(100,100));
    }

    //================================================ paintComponent
    @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);  // Ask parent to paint background.

        g.setColor(_ovalColor);
        int w = getWidth();       // Size might have changed if
        int h = getHeight();      // user resized window.
        g.fillOval(0, 0, w, h);
    }

    //==================================================== setMyColor
    public void setMyColor(Color col) {
        _ovalColor = col;  // Remember color.
        repaint();         // Color changed, must repaint
    }
}
