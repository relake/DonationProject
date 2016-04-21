/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310_assn2_attempt1;

/**
 *
 * @author Ragan E. Lake
 */
public class CashDonation extends Donation {
     /**The check number of the donation*/
    private int checkNumber;
    
    /**Construct a cash donation with given values
     * @param donationId - the ID number of the donation
     * @param idOfDonor - the ID number of the donor of the donation
     * @param donDescription - the description of the donation
     * @param donAmt - the amount of the donation
     * @param dateOfDonation  - the date the donation was made
     * @param deductible  - whether or not the donation is tax deductible
     * @param checkNumber  - the number of the check tendered for the donation
     */
    public CashDonation(int donationId, int idOfDonor, String donDescription, double donAmt, String dateOfDonation, char deductible,int checkNumber) {
        super(donationId, idOfDonor, donDescription, donAmt, dateOfDonation, deductible);
        this.checkNumber = checkNumber;
    }
 
    /**Validates that a check is valid by confirming that the check number is greater 
     * than 100 and less than 5000.
     * @param numberOfCheck - number of the check that was used to make the donation
     * @return true if the check number is greater than 100 and less than 5000,
     * false if it is not.
     */
    
    public boolean validateCheckNumber (int numberOfCheck) {
        if (checkNumber >= 100 && checkNumber <=5000){
            return true;     
        } else {
            return false;
    }
    }
    
    
    /**Sets the check number for a given check.
     * 
     * @param noOfCheck - the number of an individual check.
     */
    public void setCheckNumber (int noOfCheck) {
        checkNumber=noOfCheck;
    }
    
    
    /**Gets the number of an individual check.
     * 
     * @return the check number as an integer.
     */
    public int getCheckNumber () {
        return checkNumber;
    } 
    
     /**Sets the ID number for a donation.
     * 
     * @param donationId - the ID number of a donation.
     */
    public void setDonationId (int donationId) {
        this.donationId=donationId;
    }
    
    /**Gets the number of the ID number of an individual donation.
     * 
     * @return the ID number as an integer.
     */
    public int getDonationId () {
        return donationId;
    } 
    
    
    //Determines if two objects are equal based on the donation ID number.
    @Override
    public boolean equals(Object obj) {

        final CashDonation other = (CashDonation) obj;
        if (this.donationId != other.donationId) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    //    super.toString();
        return super.toString() + "CashDonation{" + "checkNumber=" + checkNumber + '}';
    }

    
}
