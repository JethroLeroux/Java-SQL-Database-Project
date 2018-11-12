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

public class EmployeeDBM {

    DatabaseManager dbm = new DatabaseManager();

    public EmployeeObject[] getEmployees()
    {
        EmployeeObject[] employees = new EmployeeObject[1000];
        int numEmployees = 0;
        try
        {
            ResultSet rs = dbm.queryDatabase("SELECT * FROM Employees");
            while(rs.next())
            {
                employees[numEmployees] = new EmployeeObject(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                numEmployees++;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to get employees"+e);
            e.printStackTrace();
        }
        return employees;
    }

    public void addEmployee(EmployeeObject newEmployee)
    {
        try
        {
            dbm.updateDatabase("INSERT INTO Employees (EmployeeName, TradeUnion, Qualification) VALUES ('"+newEmployee.getEmployeeName()+"', '"+newEmployee.getTradeUnion()+"', '"+newEmployee.getQualification()+"')");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to add employee: "+e);
        }
    }

    public void deleteEmployee(EmployeeObject oldEmployee)
    {
        try
        {
            dbm.updateDatabase("DELETE FROM Employees WHERE EmployeeID = "+oldEmployee.getEmployeeID());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to delete employee: "+e);
        }
    }
    
    public void updateEmployee(EmployeeObject updatedEmployee)
    {
        try
        {
            dbm.updateDatabase("UPDATE Employees SET EmployeeName = '"+updatedEmployee.getEmployeeName()+"', TradeUnion = '"+updatedEmployee.getTradeUnion()+"', Qualification = '"+updatedEmployee.getQualification()+" WHERE EmployeeID = "+updatedEmployee.getEmployeeID());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to update employee: "+e);
        }
    }
    
    public void editEmployee(int primaryKey, String changedField, String newValue)
    {
        try
        {
            dbm.updateDatabase("UPDATE Employees SET "+changedField+" = '"+newValue+  "' WHERE EmployeeID = "+ primaryKey);//uses the DatabaseManager method to update a row from the database table
        }
        catch (Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to update employee: "+e);
        }
    }
    
    
    
    public EmployeeObject[] searchEmployees(String searchFor)//gets all the values out the database table as a result set and inserts it into the Object class array
    {
        EmployeeObject[] foundEmployees = new EmployeeObject[1000];
        int numFoundEmployees = 0;
        try
        {
            ResultSet rs = dbm.queryDatabase("SELECT * FROM Employees WHERE EmployeeName like '*" + searchFor + "*' OR TradeUnion like '*" + searchFor + "*' OR Qualification like '*" + searchFor + "*'");//query the database.All the data is received by the result set. Searches for the parameterised string in all the columns
            while(rs.next())
            {
                foundEmployees[numFoundEmployees] = new EmployeeObject(//make a new object of the Object class
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                numFoundEmployees++;
            }
        }
        catch(Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to get employees"+e);
            e.printStackTrace();
        }
        return foundEmployees;//returns the array of objects made
    }
}

