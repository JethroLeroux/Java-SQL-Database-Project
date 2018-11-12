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
public class RepairObject {
    private int repairID;
    private int carID;
    private int employeeID;
    private String dateArrived;
    private String problem;
    private boolean fixed;
    
    public RepairObject(int iRepairID, int iCarID, int iEmployeeID,String iDateArrived, String iProblem, boolean iFixed)
    {
        repairID = iRepairID;
        carID = iCarID;
        employeeID = iEmployeeID;
        dateArrived = iDateArrived;
        problem = iProblem;
        fixed = iFixed;
    }

    /**
     * @return the repairID
     */
    public int getRepairID() {
        return repairID;
    }

    /**
     * @return the carID
     */
    public int getCarID() {
        return carID;
    }

    /**
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @return the dateArrived
     */
    public String getDateArrived() {
        return dateArrived;
    }

    /**
     * @return the problem
     */
    public String getProblem() {
        return problem;
    }

    /**
     * @return the fixed
     */
    public boolean isFixed() {
        return fixed;
    }
    
    public String toString()
    {
        return repairID + "\t" + carID + "\t" + employeeID + "\t" + dateArrived + "\t" + problem + "\t" + fixed;
    }
}
