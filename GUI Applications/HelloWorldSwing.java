import javax.swing.*;

/**
 * Write a description of class HelloWorldSwing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HelloWorldSwing
{
    /**
     * Create and display the GUI. For thread-safety reasons, this method is 
     * called in the event call thread.
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private static void createAndShowGUI()
    {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        //g.drawString("Red River College Computer Education",25,25);
    }

    /**
     * Constructor for objects of class HelloWorldSwing
     */
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
