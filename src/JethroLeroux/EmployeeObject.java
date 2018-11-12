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
public class EmployeeObject {
    private int employeeID;
    private String employeeName;
    private String tradeUnion;
    private String qualification;
    
    public EmployeeObject(int iEmployeeID, String iEmployeeName, String iTradeUnion, String iQualification)
    {
        employeeID = iEmployeeID;
        employeeName = iEmployeeName;
        tradeUnion = iTradeUnion;
        qualification = iQualification;
    }

    /**
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @return the tradeUnion
     */
    public String getTradeUnion() {
        return tradeUnion;
    }

    /**
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }
    
    public String toString()
    {
        return employeeID + "\t" + employeeName+ "\t" + tradeUnion + "\t" + qualification;
    }
}
