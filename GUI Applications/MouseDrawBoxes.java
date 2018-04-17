import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This applet demonstrates how mouse events and mouse motion events can be 
 * handled. It lets the user draw boxes by dragging the mouse.
 */
public class MouseDrawBoxes extends JFrame
{
    private int         currentX = 0,
                        currentY = 0,
                        width = 0,
                        height = 0;
    private JTextField  xField,
                        yField,
                        widthField,
                        heightField;
    private Container   c;
    
    /**
     * Constructor for objects of class DrawBoxes
     */
    public MouseDrawBoxes()
    {
        c = getContentPane();
        setLayout(new FlowLayout());
        
        xField = new JTextField(10);
        yField = new JTextField(10);
        widthField = new JTextField(10);
        heightField = new JTextField(10);
        c.add(xField);
        c.add(yField);
        c.add(widthField);
        c.add(heightField);
        
        // Add a mouse listener and a mouse motion listener.
        c.addMouseListener(new MyMouseListener());
        c.addMouseMotionListener(new MyMouseMotionListener());
        
        //set the frame size, title and make it show up
        setSize(400, 500); 
        setTitle("Draw Boxes");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
    }
    
    /**
     * Mouse listener class
     */
    private class MyMouseListener implements MouseListener
    {
        public void mousePressed(MouseEvent e) 
        {
            // Get the mouse cursor coordinates.
            currentX = e.getX(); 
            currentY = e.getY();
            xField.setText("X: " + currentX);
            yField.setText("Y: " + currentY);
        }
        
        // The following methods are unused, but still required by the MouseListener interface.
        public void mouseClicked(MouseEvent e) { }
        public void mouseReleased(MouseEvent e) { }
        public void mouseEntered(MouseEvent e) { }
        public void mouseExited(MouseEvent e) { }
    }
    
    /**
     * 
     */
    private class MyMouseMotionListener implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent e) 
        {
            // Calculate the size of the rectangle.
            width = e.getX() - currentX;
            height = e.getY() - currentY;
            widthField.setText("Width: " + width);
            heightField.setText("Height: " + height);
        }
        
        //The mouseMoved method is unused, but still required by the MouseMotionListener interface.
        public void mouseMoved(MouseEvent e) { }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args)
    {
        MouseDrawBoxes app = new MouseDrawBoxes();
    }
}
