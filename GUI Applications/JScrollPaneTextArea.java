import java.awt.*;
import javax.swing.*;

/**
 * Sample Frame with a TextArea in a Scroll Object
 */
public class JScrollPaneTextArea extends JFrame
{
    //declares the text area and the scroll area
    JTextArea       outputTextArea;
    JScrollPane     scrollArea;
    JLabel          label;
    String          lyric = " Supercalifragilisticexpialidocious!\n" +
                        " Even though the sound of it is something quite atrocious.\n" + 
                        " If you say it loud enough, You'll always sound precocious\n" + 
                        " Supercalifragilisticexpialidocious!";
    //Declare a font for displaying the lyrics and label
    Font            titleFont,
                    lyricFont;
    //instantiates and places a container on the frame 
    Container       c;
    
    /**
     * Constructor for objects of class FrameTextArea
     */
    public JScrollPaneTextArea()
    {
        c = getContentPane();
        titleFont = new Font("Serif", Font.ITALIC, 14);
        lyricFont = new Font("Helvetica", Font.BOLD, 20);
        //creates the text area and scroll pane
        outputTextArea = new JTextArea(12,10);
        
        //sets on line-wrap and turn on word-wrap
        //Set the song lyrics into the text area
        outputTextArea.setLineWrap(true);
        outputTextArea.setFont(lyricFont);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setText(lyric);
        scrollArea = new JScrollPane(outputTextArea);
        
        //adds a label and the scroll pane to the container
        label = new JLabel("Sound of Music",JLabel.CENTER);
        label.setFont(titleFont);
        c.add(label,        BorderLayout.NORTH);
        c.add(scrollArea,   BorderLayout.CENTER);
        
        //JFrame parms.
        //setSize(400,100);
        setTitle("Text Area Example");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    /**
     * create the instance of the frame
     */
    public static void main(String[] args)
    {
        JScrollPaneTextArea app = new JScrollPaneTextArea();
    }
}
