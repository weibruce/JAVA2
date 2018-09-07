import javax.swing.*;
import java.awt.*;

/**
 * This class is an applet that demonstrates how a polygon can be drawn.
 */
public class JAppletPolygon extends JApplet 
{
    Container c;
    JTextField nameHolder;
    
    public void init()
    {
        // Set the background color to white.
        getContentPane().setBackground(Color.white);
    }
    
    /**
     * paint method
     * @param g The applet's Graphics object.
     */
    public void paint(Graphics g)
    {
        int[] xCoords = {60, 100, 140, 140, 100, 60, 20, 20 };
        int[] yCoords = {20, 20, 60, 100, 140, 140, 100, 60 };
        // Call the superclass paint method. super.paint(g);
        super.paint(g);
        
        // Set the drawing color.
        g.setColor(Color.red);
        
        // Draw the polygon.
        g.fillPolygon(xCoords, yCoords, 8);
        g.setColor(Color.black);
        g.drawString("Stop",70,80);
    }
    
}