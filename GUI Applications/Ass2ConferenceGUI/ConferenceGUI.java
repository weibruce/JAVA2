import java.awt.*;
import javax.swing.*;

/**
 * Create a class called ConferenceGUI that inherits from a JPanel
 */
public class ConferenceGUI extends JPanel
{
    protected RegPanel          regPanel;
    protected WorkshopPanel     workshopPanel;
    protected JPanel            titlePanel;
    protected JPanel            buttonPanel;
    protected JButton           calculateButton,
                                clearButton;
    protected JTextArea         informationTextArea;
    protected JScrollPane       informationScrollPane;
    protected ConferenceHandler ch;

    /**
     * Constructor for objects of class ConferenceGUI
     */
    public ConferenceGUI()
    {
        setLayout(new BorderLayout());
        
        Font titleFont = new Font("SansSerif", Font.BOLD, 18);
        JLabel titleLabel = new JLabel("Select Registration Options");
        titleLabel.setFont(titleFont);
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        regPanel = new RegPanel();
        workshopPanel = new WorkshopPanel();
        buildButtonPanel();
        
        add(titlePanel,     BorderLayout.NORTH);
        add(regPanel,       BorderLayout.WEST);
        add(workshopPanel,  BorderLayout.EAST);
        add(buttonPanel,    BorderLayout.SOUTH);
        
        //add event listener
        ch = new ConferenceHandler(this);
        regPanel.typeCombo.addItemListener(ch);
        regPanel.nameField.addFocusListener(ch);
        calculateButton.addActionListener(ch);
        clearButton.addActionListener(ch);
    }
    
    public void buildButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        calculateButton = new JButton("Calculate Charges");
        clearButton = new JButton("Clear");
        informationTextArea = new JTextArea(5, 30);
        informationTextArea.setEditable(false);
        informationScrollPane = new JScrollPane(informationTextArea);
        
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(informationScrollPane);
    }
}
