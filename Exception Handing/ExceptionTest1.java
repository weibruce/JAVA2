
/**
 * program causes a divide by zero exception.
 */
public class ExceptionTest1
{
    public static void main(String args[]) 
    {
        int i=1, j=1;
        try
        {
            i++; j--;
            System.out.println("i="+i+" "+"j="+j);
            // division by 0 !! No computer can do this. The answer is ∞
            if(i/j > 1)
            {
                System.out.println("i/j="+i/j);
                i++;
            }
        }
        
        catch(ArrayIndexOutOfBoundsException e) 
        {
            System.out.println("ArrayIndexOutOfBoundsException");
            System.out.println(e.toString());
        }
        
        catch(NullPointerException e) 
        {
            System.out.println("NullPointerException");
            System.out.println(e);
        }
        
        catch(ArithmeticException e) 
        {
            System.out.println("ArithmeticException");
            System.out.println(e);
        }
        
        catch(Exception e) 
        {
            System.out.println("Exception");
            System.out.println(e);
        }
        
        finally
        {
            System.out.println("Inside the ‘finally’ block."); 
        }
        
        System.out.println("Outside of try/catch/finally blocks.\n"); 
    }
}
