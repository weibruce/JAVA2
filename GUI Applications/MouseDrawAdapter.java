import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This applet demonstrates how the mouse adapter classes can be used.
 */
public class MouseDrawAdapter extends JFrame
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
     * Constructor for objects of class DrawBoxes2
     */
    public MouseDrawAdapter()
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
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
        
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
    private class MyMouseListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            // Get the coordinates of the mouse cursor.
            currentX = e.getX(); 
            currentY = e.getY();
            xField.setText("X: " + currentX);
            yField.setText("Y: " + currentY);
        }
    }
    
    /**
     * Mouse Motion listener class
     */
    private class MyMouseMotionListener extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e)
        {
            // Calculate the size of the rectangle.
            width = e.getX() - currentX; 
            height = e.getY() - currentY;
            widthField.setText("Width: " + width);
            heightField.setText("Height: " + height);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args)
    {
        MouseDrawAdapter app = new MouseDrawAdapter();
    }
}
