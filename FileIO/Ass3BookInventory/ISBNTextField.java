import java.awt.*;
import javax.swing.*;
import java.util.regex.*;

/**
 * Write a description of class ISBNText here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ISBNTextField extends JTextField
{
    protected String    ISBN;
    protected String    correctISBN = "";

    /**
     * Constructor for objects of class ISBNText
     */
    public ISBNTextField()
    {
        super(20);
    }

    /**
     * This method first retrieves the ISBN entered in the textfield and 
     * stores it as a class variable . The method then will call the method 
     * validateISBN() and return the results of that method.
     */
    public String getISBN() throws ISBNException
    {
        ISBN = getText();
        return validateISBN(ISBN);
    }
    
    /**
     * This method accepts an ISBN string and returns a valid String ISBN number.
     * 
     * Error Message:
     * ISBN number must be 10 characters.
     * ISBN number must contain all digits and a digit or ‘X’ in the last position.
     * ISBN number is invalid. ISBN number should be valid number.
     */
    private String validateISBN(String isbn) throws ISBNException
    {
        String cleanNum = isbn.replace("-","");
        String leftNum = "";
        String lastNum = "";
        if(cleanNum.length() == 10)
        {
            leftNum = cleanNum.substring(0,9);
            lastNum = cleanNum.substring(9);
        }
        
        if(cleanNum.length() != 10)
        {
            throw new ISBNException("ISBN # " + isbn + " must be 10 characters.");
        }
        // all number matches("^[0-9]{9}$"); 0-9 X matches("^[0-9xX]$");
        else if(!(leftNum.matches("^[0-9]{9}$") && lastNum.matches("^[0-9xX]$")))
        {
            throw new ISBNException("ISBN # " + isbn + " must contain all digits and a digit or ‘X’ in the last position.");
        }
        else if(!checkDigit(isbn))
        {
            throw new ISBNException("ISBN # " + isbn + " has an invalid check digit.\nValid ISBN # should be " + correctISBN + ".");
        }
        
        return correctISBN;
    }
    
    /**
     * Additional information regarding ISBN-10 Modulus-11 check digit 
     * validation. ISBN is the abbreviation for the International Standard 
     * Book Number. ISBN-10 numbers are 10 digits in length. An ISBN is in 
     * the form X-XXX-XXXXX-X:
     */
    private boolean checkDigit(String number)
    {
        boolean result = false;
        String cleanNum = number.replace("-","");
        String leftNum = cleanNum.substring(0,9);
        String lastNum = number.substring(number.length()-1,number.length());
        int weightedValues = 0;
        int modValue = 0;
        
        for(int i = 0; i < leftNum.length(); i++)
        {
            weightedValues += (i + 1) * Integer.parseInt(String.valueOf(leftNum.charAt(i)));
        }
        modValue = weightedValues%11;
        
        if(modValue == 10)
        {
            if(lastNum.equalsIgnoreCase("X"))
            {
                result = true;
                correctISBN = number;
            }
            else
            {
                result = false;
                correctISBN = number.substring(0, number.length()-1) + "X";
            }
        }
        else
        {
            if(lastNum.equals(String.valueOf(modValue)))
            {
                result = true;
                correctISBN = number;
            }
            else
            {
                result = false;
                correctISBN = number.substring(0, number.length()-1) + modValue;
            }
        }
        
        return result;
    }
}
