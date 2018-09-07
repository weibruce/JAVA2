import java.sql.*;

/**
 * STEREOTYPE: ‘Boundary' class. 
 *      It I/Fs the appl'n to a database (an external agent)
 * INPUT: None
 * PROCESSING: class SINDatabase
 *      This class is the Database component of the SINApp Application.
 *      It contains the code required to connect to and update the database.
 * OUTPUT: None
 */
public class SINDatabase
{
    // Declare all database objects required to utilize the database
    // Since these objects AND the methods are declared as STATIC,
    // this class does not need to be instantiated to be used.
    
    // ODBC Driver and URL (to connect to the database by the Connection object)
    private final static String DRIVER = "com.mysql.jdbc.Driver",
                                URL = "jdbc:mysql://localhost:3306/JDBC?useSSL=true";
    // Connection object that will connect to the database
    private static Connection   connect;
    // Prepare the Statement object to be be used to run database queries
    private static Statement    statement;
    
    /**
     * The initialize method will setup the initial connection to the database.
     * This method must be called before any others
     */
    public static void initialize()
    {
        try
        {
            // Load the ODBC driver
            Class.forName(DRIVER);
            // Get the Connection object by connecting to the database
            connect = DriverManager.getConnection(URL,"root","J5z8e5r5");
            // Prepare the Statement object for queries
            statement = connect.createStatement();
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("SINDatabase.initialize() - Did not load JDBC/ODBC driver.");
            e.printStackTrace();
            System.exit(1);
        }
        catch(SQLException e)
        {
            System.err.println("SINDatabase.initialize() - Unable to connect");
            e.printStackTrace();
        }
    }

    /**
     * This method will insert a record into the database based on the 
     * information contained in the passed in SINRecord object.
     */
    public static int addRecord(SINRecord sinRec)
    {
        int result = 0;
        try
        {
            //Builds SQL insert by getting data from GUI fields
            String ins = "";
            ins = "INSERT INTO INFO " + 
                    "(FIRST, LAST, ADDRESS, CITY, PROVINCE, POSTAL, AGE, SEX, BDAY, DEPENDENTS ,SIN ) " + 
                    "VALUES ('" + sinRec.getFirstName() + "', '" + 
                    sinRec.getLastName() + "', '" + sinRec.getAddress() + "', '" +
                    sinRec.getCity() + "', '" + sinRec.getProvince() + "', '" + 
                    sinRec.getPCode() + "', '" + sinRec.getAge() + "', '" + 
                    sinRec.getSex() + "', '" + sinRec.getBDay() + "', '" + 
                    sinRec.getDependants() + "', '" + sinRec.getSin() + "')";
            
            // Execute the SQL insert statement. When running the executeUpdate method, 
            // the number of rows affected is returned (contained in the result variable)
            // Since this is an insert of 1 record, the result variable should always be 1
            System.out.println(ins);
            result = statement.executeUpdate(ins);
        }
        catch(SQLException e)
        {
            System.err.println("SINDatabase.addRecord() - insert record in DB error\n" +
                                e.getMessage());
            e.printStackTrace();
            result = -1;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return result;
    }
    
    /**statement.close
     * Close the connection to the database
     */
    public static void close()
    {
        try
        {
            connect.close();
        }
        catch(SQLException e)
        {
            System.err.println("SINDatabase.close() - Could not disconnect");
            e.printStackTrace();
        }
    }
}
