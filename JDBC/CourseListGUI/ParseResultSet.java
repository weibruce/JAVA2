import java.sql.*;
import java.util.Vector;

/**
 * StereoType: 'Control' stereotype class. It does some business logic.
 * Purpose: This class is a generic class that parses any ResultSet object.
 *      It will pull the metadata from the ResultSet object and create a columns
 *      Vector and rows Vector containing all the information in the ResultSet object 
 * Input: DB Table
 * Output: Returns the result set's column headers, and rows, as Vectors
 */
public class ParseResultSet
{
    // ResultSet object that is passed into the constructor
    private ResultSet           resultSet;
    // ResultSetMetaData object derived from ResultSet
    private ResultSetMetaData   rsMetaData;
    private Vector              heading = new Vector(),
                                rows = new Vector();

    /**
     * Constructor for objects of class ParseResultSet
     */
    public ParseResultSet(ResultSet rs)
    {
        // Set the ResultSet object
        resultSet = rs;
        
        try
        {
            rsMetaData = resultSet.getMetaData();
            parseHeading();
            parseRows();
        }
        catch(SQLException e)
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    private void parseHeading() throws SQLException
    {
        // Find all the column headings from the ResultSetMetaDataObject
        for(int i = 1; i <= rsMetaData.getColumnCount(); i++)
        {
            heading.addElement(rsMetaData.getColumnName(i));
        }
    }
    
    private void parseRows() throws SQLException
    {
        //If there is a result set row, parse and attach its field (column) values
        while(resultSet.next())
        {
            rows.addElement(getRow());
        }
    }
    
    /**
     * This method will create and return a Vector containing all the fields 
     * of one row in the Result Set
     */
    private Vector getRow() throws SQLException
    {
        Vector currentRow = new Vector();
        
        for(int i = 1; i <= rsMetaData.getColumnCount(); i++)
        {
            switch(rsMetaData.getColumnType(i))
            {
                case Types.BIT:
                    currentRow.addElement(new Boolean(resultSet.getBoolean(i)));
                    break;
                case Types.CHAR:
                    currentRow.addElement(resultSet.getString(i));
                    break;
                case Types.VARCHAR:
                    currentRow.addElement(resultSet.getString(i));
                    break;
                case Types.INTEGER:
                    currentRow.addElement(new Long(resultSet.getString(i)));
                    break;
                case Types.BIGINT:
                    currentRow.addElement(new Long(resultSet.getString(i)));
                    break;
                case Types.REAL:
                    currentRow.addElement(new Float(resultSet.getString(i)));
                    break;
                case Types.FLOAT:
                    currentRow.addElement(new Double(resultSet.getString(i)));
                    break;
                case Types.DOUBLE:
                    currentRow.addElement(new Double(resultSet.getString(i)));
                    break;
                case Types.TIMESTAMP:
                    currentRow.addElement(resultSet.getString(i));
                    break;
                default:
                    System.out.println( "Type was: " + rsMetaData.getColumnTypeName(i));
            }
        }
        
        return currentRow;
    }

    /**
     * Accessors (Getters)
     * Returns a Vector containing the Column Headings
     */
    public Vector getColHeadings()
    {
        return heading;
    }
    public Vector getRows()
    {
        return rows;
    }
}
