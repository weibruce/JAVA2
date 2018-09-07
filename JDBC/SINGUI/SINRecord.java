
/**
 * This entity class represents ONE SIN Record from the SIN2000.mdb 
 * ACCESS Database
 */
public class SINRecord
{
    // SIN Record attributes
    private long    sin;
    private String  firstName,
                    lastName,
                    address,
                    city,
                    province,
                    pCode;
    private int     age;
    private String  sex,            // M or F
                    bDay;           // birthday in mm/dd/yyyy forma
    private int     dependants;     // Number of dependants

    /**
     * Constructor for objects of class SINRecord
     */
    //one-arg constructor
    public SINRecord(long sin)
    {
        setSin(sin);
        setFirstName("");
        setLastName("");
        setAddress("");
        setCity("");
        setProvince("");
        setPCode("");
        setAge(0);
        setSex("");
        setBDay("");
        setDependants(0);
    }
    // Constructor that accepts all data attributes
    public SINRecord(long sin, String firstName, String lastName,
                    String address, String city, String province,
                    String pCode, int age, String sex, String bDay,
                    int dependants)
    {
        setSin(sin);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCity(city);
        setProvince(province);
        setPCode(pCode);
        setAge(age);
        setSex(sex);
        setBDay(bDay);
        setDependants(dependants);
    }

    /**
     * Accessor methods (Getters)
     */
    public long getSin()
    {
        return sin;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getAddress()
    {
        return address;
    }
    public String getCity()
    {
        return city;
    }
    public String getProvince()
    {
        return province;
    }
    public String getPCode()
    {
        return pCode;
    }
    public int getAge()
    {
        return age;
    }
    public String getSex()
    {
        return sex;
    }
    public String getBDay()
    {
        return bDay;
    }
    public int getDependants()
    {
        return dependants;
    }
    
    /**
     * Mutator methods (setters)
     */
    public void setSin(long sin)
    {
        this.sin = sin;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public void setProvince(String province)
    {
        this.province = province;
    }
    public void setPCode(String pCode)
    {
        this.pCode = pCode;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    public void setBDay(String bDay)
    {
        this.bDay = bDay;
    }
    public void setDependants(int dependants)
    {
        this.dependants = dependants;
    }
}
