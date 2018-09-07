import java.io.*;

/**
 * This object will contain four instance variables: a String ISBN number, 
 * String Book title, integer Quantity-on-hand and double Book price.
 */
public class BookInventory implements Serializable, Comparable<BookInventory>
{
    private String  ISBNNumber,
                    bookTitle;
    private int     qoh;
    private double  bookPrice;

    /**
     * Constructor for objects of class BookInventory
     */
    public BookInventory()
    {
        this("", "", 0, 0);
    }
    
    public BookInventory(String ISBNNumber, String bookTitle, int qoh, double bookPrice)
    {
        setISBNNumber(ISBNNumber);
        setBookTitle(bookTitle);
        setQoh(qoh);
        setBookPrice(bookPrice);
    }

    /**
     * Accessor and Mutator Methods
     */
    public String getISBNNumber()
    {
        return this.ISBNNumber;
    }
    public String getBookTitle()
    {
        return this.bookTitle;
    }
    public int getQoh()
    {
        return this.qoh;
    }
    public double getBookPrice()
    {
        return this.bookPrice;
    }
    
    public void setISBNNumber(String ISBNNumber)
    {
        this.ISBNNumber = ISBNNumber;
    }
    public void setBookTitle(String bookTitle)
    {
        this.bookTitle = bookTitle;
    }
    public void setQoh(int qoh)
    {
        this.qoh = qoh;
    }
    public void setBookPrice(double bookPrice)
    {
        this.bookPrice = bookPrice;
    }
    
    public double getInvCost()
    {
        return bookPrice * qoh;
    }
    
    public String toString()
    {
        String result = "";
        result += "Isbn: " + ISBNNumber + " Title: " + bookTitle;
        result += "\nQoh: " + qoh + " Price: " + bookPrice + " Cost: " + getInvCost();
        return result;
    }
    
    public int compareTo(BookInventory bi)
    {
        int value;
        if(parseNumber(ISBNNumber) > parseNumber(bi.getISBNNumber()))
        {
            value = 1;
        }
        else if(parseNumber(ISBNNumber) == parseNumber(bi.getISBNNumber()))
        {
            value = 0;
        }
        else
        {
            value = -1;
        }
        return value;
    }
    
    private int parseNumber(String number)
    {
        String cleanNumber = number.replace("-", "");
        return Integer.parseInt(cleanNumber);
    }
}
