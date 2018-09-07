import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class demonstrates how panels may be added to the cells created by a 
 * GridLayout manager.

 */
public class GridPanelWindow extends JFrame
{
    private final int   WINDOW_WIDTH = 300,
                        WINDOW_HEIGHT = 100;
    private Container   c;

    /**
     * Constructor for objects of class GridPanelWindow
     */
    public GridPanelWindow()
    {
        c=getContentPane();
        // Add a GridLayout manager to the content pane.
        c.setLayout(new GridLayout(1, 3));
        
        // Create three labels.
        JLabel  label1 = new JLabel("Cell 1.", JLabel.CENTER),
                label2 = new JLabel("Cell 2.", JLabel.CENTER),
                label3 = new JLabel("Cell 3.", JLabel.CENTER);
        // Create three buttons.
        JButton button1 = new JButton("Button 1"),
                button2 = new JButton("Button 2"),
                button3 = new JButton("Button 3");
        
        // Create 3 panels with default FlowLayout.
        JPanel  panel1 = new JPanel(),
                panel2 = new JPanel(),
                panel3 = new JPanel();
        // Add a label and button to each panel.
        panel1.add(label1);
        panel1.add(button1);
        panel2.add(label2);
        panel2.add(button2);
        panel3.add(label3);
        panel3.add(button3);
        // Add the panels to the content pane.
        // The panels go into row 1, columns 1, 2, 3 
        c.add(panel1);
        c.add(panel2);
        c.add(panel3);
        
        // Set JFrame parms:
        // Set the title bar text. visibility, window size & action for the close button
        setTitle("Grid Layout");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * The main method creates an instance of the GridPanelWindow class, 
     * displaying its window.
     */
    public static void main(String[] args)
    {
        GridPanelWindow gpw = new GridPanelWindow();
    }
}
