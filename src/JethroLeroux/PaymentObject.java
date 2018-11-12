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
public class PaymentObject {
    
    private int payID;
    private int repairID;
    private int fee;
    private boolean paid;
    
    public PaymentObject(int iPayID, int iRepairID, int iFee, boolean iPaid)
    {
        payID = iPayID;
        repairID = iRepairID;
        fee = iFee;
        paid = iPaid;
    }

    /**
     * @return the payID
     */
    public int getPayID() {
        return payID;
    }

    /**
     * @return the repairID
     */
    public int getRepairID() {
        return repairID;
    }

    /**
     * @return the fee
     */
    public int getFee() {
        return fee;
    }

    /**
     * @return the paid
     */
    public boolean isPaid() {
        return paid;
    }
    
    public String toString()
    {
        return payID + "\t" + repairID + "\t" + fee + "\t" + paid;
    }
}
