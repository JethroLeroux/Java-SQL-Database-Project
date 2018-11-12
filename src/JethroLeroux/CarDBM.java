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

//these comments apply to ALL "...DBM()" classes
public class CarDBM {

    DatabaseManager dbm = new DatabaseManager();//creates a object of the DatabaseManager class
    private int arrLength = 0; //array length for when an array of object type Cars is created
    public CarObject[] getCars()//gets all the values out the database table as a result set and inserts it into the Object class array
    {
        CarObject[] cars = new CarObject[1000];
        int numCars = 0;
        try
        {
            ResultSet rs = dbm.queryDatabase("SELECT * FROM Cars");//query the database.All the data is received by the result set
            while(rs.next())
            {
                cars[numCars] = new CarObject(//make a new object of the Object class
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
                numCars++;
            }
        }
        catch(Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to get cars"+e);
            e.printStackTrace();
        }
        return cars;//returns the array of objects made
    }

    public void addCar(CarObject car)//to add a row to the database table
    {
        try
        {
            dbm.updateDatabase("INSERT INTO Cars (Registration, Model, Colour, CustomerID) VALUES ('"+car.getRegistration()+"', '"+car.getModel()+"', '"+car.getColour()+"', "+car.getCustomerID()+")");//uses the method in the DatabaseManager class to insert into the database table
        }
        catch (Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to add car: "+e);
        }
    }

    public void deleteCar(CarObject oldCar)//to delete a row from the database table
    {
        try
        {
            dbm.updateDatabase("DELETE FROM Cars WHERE CarID = "+oldCar.getCarID());//uses the DatabaseManager method to delete a row from the database table
        }
        catch (Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to delete car: "+e);
        }
    }
    
    public void updateCar(CarObject updatedCar)//to update a row in the database table
    {
        try
        {
            dbm.updateDatabase("UPDATE Cars SET Registration = '"+updatedCar.getRegistration()+"', Model = '"+updatedCar.getModel()+"', Colour = '"+updatedCar.getColour()+"', CustomerID = "+updatedCar.getCustomerID()+" WHERE CarID = "+updatedCar.getCarID());//uses the DatabaseManager method to update a row from the database table
        }
        catch (Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to update car: "+e);
        }
    }
    
    public void editCar(int primaryKey, String changedField, String newValue)//to edit a row in a table
    {
        try
        {
            dbm.updateDatabase("UPDATE Cars SET "+changedField+" = '"+newValue+  "' WHERE CarID = "+ primaryKey);//uses the DatabaseManager method to update a row from the database table
        }
        catch (Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to update car: "+e);
        }
    }
    
    
    
    
    
    public CarObject[] searchCars(String searchFor)//gets all the values out the database table as a result set and inserts it into the Object class array
    {
        CarObject[] foundCars = new CarObject[1000];
        int numFoundCars = 0;
        try
        {
            ResultSet rs = dbm.queryDatabase("SELECT * FROM Cars WHERE Registration like '*" + searchFor + "*' OR Model like '*" + searchFor + "*' OR Colour like '*" + searchFor + "*'");//query the database.All the data is received by the result set. Searches for the parsed string in all the columns
            while(rs.next())
            {
                foundCars[numFoundCars] = new CarObject(//make a new object of the Object class
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
                numFoundCars++;
            }
        }
        catch(Exception e)//catch exception. Error handling
        {
            JOptionPane.showMessageDialog(null, "Failed to get cars"+e);
            e.printStackTrace();
        }
        return foundCars;//returns the array of objects made
    }
    
    
    public CarObject[] getReleasableVehicles()
            {
                CarObject[] rVehicles = new CarObject[1000];//vehicles which can be released
                int numrVehicles = 0;
                try
                {
                    ResultSet rs = dbm.queryDatabase("SELECT Cars.*\n" +
                                             "FROM (Cars INNER JOIN Repairs ON Cars.CarID = Repairs.CarID) INNER JOIN Payments ON Repairs.RepairID = Payments.RepairID\n" +
                                             "WHERE Payments.Paid = true AND Repairs.Fixed = true;");// show the details of the car when the car has been both fixed and paid for
                    while(rs.next())
                    {
                        rVehicles[numrVehicles] = new CarObject(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
                        numrVehicles++;
                    }
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Failed to get cars"+e);
                e.printStackTrace();
            }
         arrLength = numrVehicles;
        return rVehicles;
    }

    /**
     * @return the arrLength
     */
    public int getArrLength() {//get the length of the array created to hold the car objetcs in this class
        return arrLength;
    }
    
    
    public CarObject[] getUnrepairedVehicles()
            {
                CarObject[] uVehicles = new CarObject[1000];//vehicles which need to be fixed
                int numuVehicles = 0;
                try
                {
                    ResultSet rs = dbm.queryDatabase("SELECT Cars.*\n" +
                                                     "FROM Cars INNER JOIN Repairs ON Cars.CarID = Repairs.CarID\n" +
                                                     "WHERE Repairs.Fixed =false;");// show the details of the car if the car has not been fixed
                    while(rs.next())
                    {
                        uVehicles[numuVehicles] = new CarObject(//put the data into an object in the array
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
                        numuVehicles++;
                    }
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Failed to get cars"+e);
                e.printStackTrace();
            }
         arrLength = numuVehicles;
        return uVehicles;
    }
}

