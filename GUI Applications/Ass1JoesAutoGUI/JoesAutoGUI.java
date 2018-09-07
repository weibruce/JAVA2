import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class JoesAutoGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JoesAutoGUI extends JPanel
{
    protected ImageIcon             carIcon;
    protected JButton               calculateButton,
                                    exitButton;
    protected JLabel                iconLabel,
                                    titleLabel;
    protected JPanel                chargesPanel,
                                    titlePanel,
                                    buttonPanel;
    protected RoutineServices       routinePanel;
    protected NonRoutineServices    nonRoutinePanel;
    protected SummaryPanel          summaryPanel;
    protected JTabbedPane           tabbedPane;
    
    /**
     * Constructor for objects of class JoesAutoGUI
     */
    public JoesAutoGUI()
    {
        // create JTabbedPane
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        // set up charges panel
        chargesPanel = new JPanel();
        buildTitlePanel();
        buildButtonPanel();
        routinePanel = new RoutineServices();
        nonRoutinePanel = new NonRoutineServices();
        
        chargesPanel.setLayout(new BorderLayout());
        chargesPanel.add(titlePanel,        BorderLayout.NORTH);
        chargesPanel.add(routinePanel,      BorderLayout.WEST);
        //chargesPanel.add(buttonPanel,       BorderLayout.EAST);
        chargesPanel.add(buttonPanel);
        chargesPanel.add(nonRoutinePanel,   BorderLayout.SOUTH);
        // add label to panel
        tabbedPane.addTab("Charges", null, chargesPanel, "Charges Panel");
        
        // set up summaryPanel and add it to JTabbedPane
        summaryPanel = new SummaryPanel();
        // create first panel
        //summaryPanel.add();
        // add label to panel
        tabbedPane.addTab("Summary", null, summaryPanel, "Summary Panel");
        
        add(tabbedPane);
    }

    /**
     * Build the title and image panel and add it to the north part of the 
     * charges JPanel
     */
    private void buildTitlePanel()
    {
        titlePanel = new JPanel();
        
        carIcon = new ImageIcon("images/car.png");
        iconLabel = new JLabel("", JLabel.RIGHT);
        iconLabel.setText(null);
        iconLabel.setIcon(carIcon);
        
        titleLabel = new JLabel("Joe's Automotive");
        
        titlePanel.add(iconLabel);
        titlePanel.add(titleLabel);
        
    }
    
    /**
     * Build the button panel and add it to the east part of the charges 
     * JPanel
     */
    private void buildButtonPanel()
    {
        JLabel  emptyLabel1,
                emptyLabel2;
        emptyLabel1 = new JLabel("");
        emptyLabel2 = new JLabel("");
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,1));
        
        calculateButton = new JButton("Calculate Charges");
        exitButton = new JButton("Exit");
        
        calculateButton.addActionListener(new JoesAutoHandler(this));
        exitButton.addActionListener(new JoesAutoHandler(this));
        buttonPanel.add(emptyLabel1);
        buttonPanel.add(emptyLabel2);
        buttonPanel.add(calculateButton);
        buttonPanel.add(exitButton);
    }
}
