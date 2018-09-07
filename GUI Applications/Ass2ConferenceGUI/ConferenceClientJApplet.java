import java.awt.*;
import javax.swing.*;

/**
 * ConferenceClient that inherits from a JApplet
 */
public class ConferenceClientJApplet extends JApplet
{
    final int               WINDOW_WIDTH = 700,
                            WINDOW_HEIGHT = 250;
    private Container       c;
    private ConferenceGUI   gui;

    /**
     * init method
     */
    public void init()
    {
        c = getContentPane();
        setLayout(new BorderLayout());
        
        gui = new ConferenceGUI();
        c.add(gui,  BorderLayout.CENTER);
    }
}
