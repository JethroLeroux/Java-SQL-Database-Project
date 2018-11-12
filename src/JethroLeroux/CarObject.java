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
//these comments apply to ALL "...Object()" classes

public class CarObject {
    
    private int carID;      //initiialize the private fields of the object
    private String registration;
    private String model;
    private String colour;
    private int customerID;
    
    public CarObject(int iCarID, String iRegistration, String iModel, String iColour, int iCustomerID)//receives the objects values as parameters
    {//give the object its first attributes/fields
        carID = iCarID;
        registration = iRegistration;
        model = iModel;
        colour = iColour;
        customerID = iCustomerID;
    }

    /**
     * @return the carID
     */
    public int getCarID() {
        return carID;
    }

    /**
     * @return the registration
     */
    public String getRegistration() {
        return registration;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }
    
    public String toString()//return the objects fields values as a formatted String
    {
       return carID +"\t" + registration + "\t" + model + "\t" + colour + "\t" + customerID;
    }

    /**
     * @param carID the carID to set
     */
    public void setCarID(int carID) {
        this.carID = carID;
    }
    
}//end of class
