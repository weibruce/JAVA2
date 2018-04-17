import java.util.*;

/**
 * ExceptionTest2
 */
public class ExceptionTest2
{
    public static void main(String args[]) 
    {
        int[]   numbers = new int[5]; 
        String  car = "honda";
        
        try
        {
            // throws an ArrayIndexOutOfBounds exception
            int j = numbers[9]; 
            // throw a StringIndexOutOfBounds exception
            char letter = car.charAt(5);
        }
         
        catch(ArithmeticException e)
        {
            System.out.println("ArithmeticException");
            System.out.println(e);
        } 
        
        catch(ArrayIndexOutOfBoundsException e) 
        {
            System.out.println("ArrayIndexOutOfBoundsException");
            System.out.println(e);
        }
        
        catch(NullPointerException e)
        {
            System.out.println("NullPointerException");
            System.out.println(e);
        }
        
        catch(StringIndexOutOfBoundsException e)
        {
            System.out.println("StringIndexOutOfBoundsException");
            System.out.println(e);
        }
        
        catch(Exception e)
        {
            System.out.println("Exception");
            System.out.println(e); 
        }
        
        finally
        {
            System.out.println("Inside the ‘finally’ block\n");
        }
        
        System.out.println( "After and Outside of the try/catch/finally blocks\n" ); 
    }
    
    public static void customeThrowException(String[] args)
    {
        int     n = -20;
        int  sum = 0;
        double  average = 0;
        try
        {
            //n = Integer.parseInt("0");
            
            if(n < 0)
            {
                //throw new Exception("ERROR: Can't average negative elements");
                throw new IntOutOfRangeException(100);
            }
            
            for(int i = 1; i <= n; i++)
            {
                sum += i;
            }
            average = sum/n;
            System.out.println(average);
        }
        catch(ArithmeticException e)
        {
            System.out.println("ArithmeticException");
            System.out.println(e);
            System.out.println("n=0 is an valid denomiattor");
        } 
        catch(Exception e)
        {
            System.out.println("Exception");
            System.out.println(e);
        }
    }
    
    public static void inputIntException(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean done = false;
        
        do
        {
            try
            {
                System.out.println("Please enter an integer number: ");
                int a = input.nextInt();
                System.out.println("Please enter an integer number: ");
                int b = input.nextInt();
                double c = a/b;
                System.out.println("a="+a+" b="+b+" a/b="+c);
                done = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println("InputMismatchException" + e);
                System.out.println("Please try again: ");
            }
            catch(ArithmeticException e)
            {
                System.out.println("ArithmeticException" + e);
                System.out.println("Zero is an valid denomiattor");
            }
        }
        while(!done);
    }
}
