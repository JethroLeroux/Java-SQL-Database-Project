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

public class RepairDBM {

    DatabaseManager dbm = new DatabaseManager();

    public RepairObject[] getRepairs()
    {
        RepairObject[] repairs = new RepairObject[1000];
        int numRepairs = 0;
        try
        {
            ResultSet rs = dbm.queryDatabase("SELECT * FROM Repairs");
            while(rs.next())
            {
                repairs[numRepairs] = new RepairObject(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6));
                numRepairs++;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to get repairs"+e);
            e.printStackTrace();
        }
        return repairs;
    }

    public void addRepair(RepairObject newRepair)
    {
        try
        {
            dbm.updateDatabase("INSERT INTO Repairs (CarID, EmployeeID, DateArrived, Problem, Fixed) VALUES ('"+newRepair.getCarID()+"', '"+newRepair.getEmployeeID()+"', '"+newRepair.getDateArrived()+" 00:00:00.000000', '"+newRepair.getProblem()+"', '"+newRepair.isFixed()+"')");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to add repair: "+e);
        }
    }

    public void deleteRepair(RepairObject oldRepair)
    {
        try
        {
            dbm.updateDatabase("DELETE FROM Repairs WHERE RepairID = "+oldRepair.getRepairID());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to delete repair: "+e);
        }
    }
    
    public void updateRepair(RepairObject updatedRepair)
    {
        try
        {
            dbm.updateDatabase("UPDATE Repairs SET CarID = '"+updatedRepair.getCarID()+"', EmployeeID = '"+updatedRepair.getEmployeeID()+"', DateArrived = '"+updatedRepair.getDateArrived()+"', Problem = '"+updatedRepair.getProblem()+"', Fixed = "+updatedRepair.isFixed()+" WHERE RepairID = "+updatedRepair.getRepairID());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to update repair: "+e);
        }
    }
    
    public void editRepair(int primaryKey, String changedField, String newValue)
    {
        try
        {
            dbm.updateDatabase("UPDATE Repairs SET "+changedField+" = '"+newValue+  "' WHERE RepairID = "+ primaryKey);//uses the DatabaseManager method to update a row from the database table
        }
        catch (Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to update repair: "+e);
        }
    }
    
    
    public RepairObject[] searchRepairs(String searchFor)//gets all the values out the database table as a result set and inserts it into the Object class array
    {
        RepairObject[] foundRepairs = new RepairObject[1000];
        int numFoundRepairs = 0;
        try
        {
            ResultSet rs = dbm.queryDatabase("SELECT * FROM Repairs WHERE DateArrived like '*" + searchFor + "*' OR Problem like '*" + searchFor + "*'");//query the database.All the data is received by the result set. Searches for the parameterised string in all the columns
            while(rs.next())
            {
                foundRepairs[numFoundRepairs] = new RepairObject(//make a new object of the Object class
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6));
                numFoundRepairs++;
            }
        }
        catch(Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to get payments"+e);
            e.printStackTrace();
        }
        return foundRepairs;//returns the array of objects made
    }
}
