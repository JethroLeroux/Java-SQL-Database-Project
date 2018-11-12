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
public class CustomerObject {
  
    private int customerID;
    private String customerName;
    private String cellNum;
    private String email;

    public CustomerObject(int iId, String iCustomerName, String iCellNum, String iEmail)
    {
        customerID = iId;
        customerName = iCustomerName;
        cellNum = iCellNum;
        email = iEmail;
    }

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }


    /**
     * @return the cellNum
     */
    public String getCellNum() {
        return cellNum;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    
    public String toString()
    {
        return customerID +"\t" + customerName + "\t" + cellNum + "\t" + email;
    }

}
    

