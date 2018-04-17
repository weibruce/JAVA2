import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * Program: "IntField.java"
 *
 * PROCESSING:
 * This class creates a custom JTextField class. This textfield will be used 
 * when the textfield value must fall into a specific range.
 */
public class IntField extends JTextField
{
    // Declare an upperBound attribute, initialized to the largest number an integer can be
    private int     upperBound = Integer.MAX_VALUE;
    private int     max;

    /**
     * Constructor for objects of class IntField
     */
    public IntField(int size, int max)
    {
        super(size);
        this.upperBound = max;
    }
    
    public int getInt() throws NumberFormatException, IntOutOfRangeException
    {
        int num = Integer.parseInt(getText());
        if(num > upperBound)
        {
            throw new IntOutOfRangeException(upperBound);
        }
        return num;
    }
}
