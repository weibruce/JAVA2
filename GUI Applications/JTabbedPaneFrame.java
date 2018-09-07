import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * JTabbedPaneFrame.java Demonstrate how the JTabbedPane component works
 */
public class JTabbedPaneFrame extends JFrame
{
    /**
     * Constructor for objects of class JTabbedPaneFrame
     */
    public JTabbedPaneFrame()
    {
        // create JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        // set up panel1 and add it to JTabbedPane
        JPanel panel1 = new JPanel();
        // create first panel
        panel1.add(new JLabel("panel one", SwingConstants.CENTER));
        // add label to panel
        tabbedPane.addTab("Tab One", null, panel1, "First Panel");
        
        // set up panel2 and add it to JTabbedPane
        JPanel panel2 = new JPanel();
        // create second panel
        panel2.setBackground( Color.YELLOW );
        // set background to yellow
        panel2.add(new JLabel("panel two", SwingConstants.CENTER));
        tabbedPane.addTab("Tab Two", null, panel2, "Second Panel");
        
        // set up panel3 and add it to JTabbedPane
        JPanel panel3 = new JPanel();
        // create third panel
        panel3.setLayout(new BorderLayout());
        // use borderlayout
        panel3.add(new JButton("North"), BorderLayout.NORTH);
        panel3.add(new JButton("West"), BorderLayout.WEST);
        panel3.add(new JButton("East"), BorderLayout.EAST);
        panel3.add(new JButton("South"), BorderLayout.SOUTH);
        panel3.add(new JLabel("panel three"), BorderLayout.CENTER);
        tabbedPane.addTab("Tab Three", null, panel3, "Third Panel");
        // add JTabbedPane to frame
        add(tabbedPane);
        
        // Set JFrame parms:
        setTitle("JTabbedPane Demo");
        setVisible(true);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * JTabbedPaneDemo.java Demonstrating JTabbedPane.
     */
    public static void main(String[] args)
    {
        JTabbedPaneFrame app = new JTabbedPaneFrame();
    }
}
