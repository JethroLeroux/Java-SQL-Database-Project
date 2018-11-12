/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JethroLeroux;

/**
 *
 * @author Jethro
 */
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class CustomerDBM {

    DatabaseManager dbm;
    public CustomerDBM()
    {
        dbm = new DatabaseManager();
    }
    public CustomerObject[] getCustomers()
    {
        CustomerObject[] customers = new CustomerObject[1000];
        int numCustomers = 0;
        try
        {
            ResultSet rs = dbm.queryDatabase("SELECT * FROM Customers");
            while(rs.next())
            {
                customers[numCustomers] = new CustomerObject(
                        numCustomers +1,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                numCustomers++;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to get customers"+e);
            e.printStackTrace();
        }
        return customers;
    }

    public void addCustomer(CustomerObject newCustomer)
    {
        try
        {
            dbm.updateDatabase("INSERT INTO Customers (CustomerName, CellNum, Email) VALUES ('"+newCustomer.getCustomerName()+"', '"+newCustomer.getCellNum()+"', '"+newCustomer.getEmail()+"')");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to add customer: "+e);
        }
    }

    public void deleteCustomer(CustomerObject oldCustomer)
    {
        try
        {
            dbm.updateDatabase("DELETE FROM Customers WHERE CustomerID = "+oldCustomer.getCustomerID());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to delete customer: "+e);
        }
    }
    
    public void updateCustomer(CustomerObject updatedCustomer)
    {
        try
        {
            dbm.updateDatabase("UPDATE Customers SET CustomerName = '"+updatedCustomer.getCustomerName()+"', CellNum = '"+updatedCustomer.getCellNum()+"', Email = '"+updatedCustomer.getEmail()+" WHERE CarID = "+updatedCustomer.getCustomerID());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to update customer: "+e);
        }
    }
    
    public void editCustomer(int primaryKey, String changedField, String newValue)
    {
        try
        {
            dbm.updateDatabase("UPDATE Customers SET "+changedField+" = '"+newValue+  "' WHERE CustomerID = "+ primaryKey);//uses the DatabaseManager method to update a row from the database table
        }
        catch (Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to update customer: "+e);
        }
    }
    
    public CustomerObject[] searchCustomers(String searchFor)//gets all the values out the database table as a result set and inserts it into the Object class array
    {
        CustomerObject[] foundCustomers = new CustomerObject[1000];
        int numFoundCustomers = 0;
        try
        {
            ResultSet rs = dbm.queryDatabase("SELECT * FROM Customers WHERE CustomerName like '*" + searchFor + "*' OR CellNum like '*" + searchFor + "*' OR Email like '*" + searchFor + "*'");//query the database.All the data is received by the result set. Searches for the parameterised string in all the columns
            while(rs.next())
            {
                foundCustomers[numFoundCustomers] = new CustomerObject(//make a new object of the Object class
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                numFoundCustomers++;
            }
        }
        catch(Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to get customers"+e);
            e.printStackTrace();
        }
        return foundCustomers;//returns the array of objects made
    }
}

