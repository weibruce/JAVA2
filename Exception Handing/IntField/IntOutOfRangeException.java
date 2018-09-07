/**
 * All custom Exception classes must inherit from Exception
 * 
 * INPUT: 
 * upper bound that was exceeded
 * 
 * PROCESSING: 
 * This class declares a custom Exception class used when an integer is out 
 * of range.
 * 
 * OUTPUT:
 */
public class IntOutOfRangeException extends Exception
{
    /**
     * Constructor for objects of class IntOutOfRangeException
     */
    public IntOutOfRangeException(int bound)
    {
        super("The input value exceeds the bound " + bound);
    }
}
