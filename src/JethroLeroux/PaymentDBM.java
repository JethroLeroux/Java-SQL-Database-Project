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

public class PaymentDBM {

    DatabaseManager dbm = new DatabaseManager();
    private int arrLength = 0; //array length for the getPayments Method

    public PaymentObject[] getPayments()
    {
        PaymentObject[] payments = new PaymentObject[1000];
        int numPayments = 0;
        try
        {
            ResultSet rs = dbm.queryDatabase("SELECT * FROM Payments");
            while(rs.next())
            {
                payments[numPayments] = new PaymentObject(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getBoolean(4));
                numPayments++;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to get payments"+e);
            e.printStackTrace();
        }
        setArrLength(numPayments); //set private array length for this methods object array
        return payments;//return an array of objects
    }

    public void addPayment(PaymentObject newPayment)
    {
        try
        {
            dbm.updateDatabase("INSERT INTO Payments (RepairID, Fee, Paid) VALUES ('"+newPayment.getRepairID()+"', '"+newPayment.getFee()+"', '"+newPayment.isPaid()+"')");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to add payment: "+e);
        }
    }

    public void deletePayment(PaymentObject oldPayment)
    {
        try
        {
            dbm.updateDatabase("DELETE FROM Payments WHERE PayID = "+oldPayment.getPayID());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to delete payment: "+e);
        }
    }
    
    public void updatePayment(PaymentObject updatedPayment)
    {
        try
        {
            dbm.updateDatabase("UPDATE Payments SET RepairID = '"+updatedPayment.getRepairID()+"', Fee = '"+updatedPayment.getFee()+"', Paid = '"+updatedPayment.isPaid()+" WHERE PayID = "+updatedPayment.getPayID());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to update payment: "+e);
        }
    }
    
    public void editPayment(int primaryKey, String changedField, String newValue)
    {
        try
        {
            dbm.updateDatabase("UPDATE Payments SET "+changedField+" = '"+newValue+  "' WHERE PayID = "+ primaryKey);//uses the DatabaseManager method to update a row from the database table
        }
        catch (Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to update payment: "+e);
        }
    }
    
    
    public PaymentObject[] searchPayments(String searchFor)//gets all the values out the database table as a result set and inserts it into the Object class array
    {
        PaymentObject[] foundPayments = new PaymentObject[1000];
        int numFoundPayments = 0;
        
        if(!searchFor.equals(""))//only if there is a value in the search bar
        {
            if(searchFor.substring(0,1).equalsIgnoreCase("T"))//completes the search term because the Boolean field is the only text field in this table so it can be assumed the user is searching for true/false
            {                                                // "Like" for SQL commands doesnt work for boolean variables so the searchFor value is automatically set to true or false so an error is not created 
                searchFor = "'true'";
            }else 
                if(searchFor.substring(0,1).equalsIgnoreCase("F"))
                {
                    searchFor = "'false'";
                }else
                {
                    searchFor = "'true' OR Paid = 'false'";// if an unknown/abstract value is entered in the search bar it will just show ALL rows
                }
        }else searchFor = "'true' OR Paid = 'false'";// if an no value is entered in the search bar it will just show ALL rows
            
            try
        {
            ResultSet rs = dbm.queryDatabase("SELECT * FROM Payments WHERE Paid = " + searchFor);//query the database.All the data is received by the result set. Searches for the parameterised string in all the columns
            while(rs.next())
            {
                foundPayments[numFoundPayments] = new PaymentObject(//make a new object of the Object class
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getBoolean(4));
                numFoundPayments++;
            }
        }
        catch(Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to get payments. You may only search the boolean 'Paid' column in this table."+e);
            e.printStackTrace();
        }
        return foundPayments;//returns the array of objects made
    }

    /**
     * @return the arrLength
     */
    public int getArrLength() {//get method for the Array length of the get payments method
        return arrLength;   //returns an int
    }

    /**
     * @param arrLength the arrLength to set
     */
    public void setArrLength(int arrLength) {//set method for the Array length of the get payments method
        this.arrLength = arrLength;
    }
    
    public String getOverallStats()
    {
        
        String max = "";//maximum fee payed
        String min = "";//minimum fee payed
        String avg = "";//average fee payed
        try
                {
                    ResultSet rs = dbm.queryDatabase("SELECT MAX(Fee) AS Max, MIN(Fee) AS Min, AVG(Fee) AS Avg\n" +
                                                     "FROM Payments;");// shows the overall stats using SQL manipulation
                    while(rs.next())
                    {
                        max= rs.getInt(1) + "";
                        min= rs.getInt(2) + "";
                        avg= rs.getDouble(3) + "";
                    }
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Failed to get specific stats"+e);
                e.printStackTrace();
            }
        return max +"#" + min + "#" + avg;//separates each value by a # which can be split in the JFrame class
        
    }
    
    
    public String getSpecificStats()
    {
        
        String timesVisited = "";//maximum fee payed
        String totalIncome = "";//total income recieved from repairs on this car
        try
                {
                    ResultSet rs = dbm.queryDatabase("SELECT Count(*) AS TimesVisited, Sum(Payments.Fee) AS TotalIncomeFromThisCar\n" +
                                                     "FROM (Cars INNER JOIN Repairs ON Cars.CarID = Repairs.CarID) INNER JOIN Payments ON Repairs.RepairID = Payments.RepairID\n" +
                                                     "WHERE (Repairs.CarID)=4 AND Payments.Paid = 'true';");// shows the specific stats using SQL manipulation
                    while(rs.next())
                    {
                        timesVisited= rs.getInt(1) + "";
                        totalIncome= rs.getInt(2) + "";
                    }
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Failed to get overall stats"+e);
                e.printStackTrace();
            }
        return timesVisited +"#" + totalIncome;//separates each value by a # which can be split in the JFrame class
        
    }
}
