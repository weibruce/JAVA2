import java.io.*;

/**
 * Implement the Serializable interface to allow the Object writer to write 
 * this object to file (as an object)
 */
public class PhoneNumber implements Serializable
{
    // Declare the data attributes of the class
    private String  firstName,
                    lastName,
                    phoneNumber;

    /**
     * Constructor for objects of class PhoneNumber
     */
    public PhoneNumber()
    {
        this("", "", "");
    }
    /**
     * Create a constructor that accepts all data attributes
     */
    public PhoneNumber(String firstName, String lastName, String phoneNumber)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    } 

    // Accessor and Mutator Methods
    public String getFirstName()
    {
        return this.firstName;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
