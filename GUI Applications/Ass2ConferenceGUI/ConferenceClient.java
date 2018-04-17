import java.awt.*;
import javax.swing.*;

/**
 * ConferenceClient that inherits from a JApplet
 */
public class ConferenceClient extends JFrame
{
    final int               WINDOW_WIDTH = 700,
                            WINDOW_HEIGHT = 250;
    private Container       c;
    private ConferenceGUI   gui;

    /**
     * init method
     */
    public ConferenceClient()
    {
        c = getContentPane();
        setLayout(new BorderLayout());
        
        gui = new ConferenceGUI();
        c.add(gui,  BorderLayout.CENTER);
        
        //set the frame size, title and make it show up
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); 
        setTitle("FocusListener Example");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args)
    {
        ConferenceClient app = new ConferenceClient();
    }
}
