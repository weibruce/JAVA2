import java.awt.*;
import javax.swing.*; // Needed for Swing classes

/**
 * This class extends the JFrame class. Its constructor displays a simple window with a title. The application exits when the user clicks the close button.
 */
public class JFrameSimpleWindow extends JFrame
{
  Container c;
  JLabel label1;
  JLabel label2;
  JLabel label3;
  JTextField tf1;
  JTextField tf2;

  /** Constructor */
  public JFrameSimpleWindow()
  {
    final int WINDOW_WIDTH = 550,
              WINDOW_HEIGHT = 350;
    // Set this window's title.
    setTitle("A Simple Window");
    
    // Set the size of this window.
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    
    // Specify what happens when the close button is clicked.
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // the default operation is to only hide the frame.
    //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    
    // Centre the JFrame on the centre of the desktop
    setLocationRelativeTo(null);
    
    // Causes this frame’s window to be sized to fit the preferred size and layouts of its subcomponents.
    //pack();
    
    setResizable(true);
    setLayout(new FlowLayout(FlowLayout.LEFT));

    //Create labels
    label1 = new JLabel("Label Centered");
    label1.setForeground(Color.RED);
    
    label2 = new JLabel("Image and Text");
    label2.setVerticalTextPosition(JLabel.BOTTOM);
    label2.setHorizontalTextPosition(JLabel.RIGHT);
    
    label3 = new JLabel("Label Centered", JLabel.CENTER);
    
    //Create textfileds
    tf1 = new JTextField("Jim Sutton", 20);
    tf1.setText("Peter Miller");
    tf1.setHorizontalAlignment(JTextField.LEFT);
    tf1.setEditable(true);
    //tf1.requestFocus();
    //tf1.selectAll();
    
    tf2 = new JTextField("aaa2", 10);
    tf2.selectAll();
    tf2.requestFocus();

    c = getContentPane();
    c.add(label1);
    c.add(label2);
    c.add(label3);
    c.add(tf1);
    c.add(tf2);
    // Display the window.
    setVisible(true);
  }
  /**
   * Creates an instance of the SimpleWindow class. 
   */
  public static void main(String[] args)
  {
    JFrameSimpleWindow app = new JFrameSimpleWindow();
  }
}//end class SimpleWindow