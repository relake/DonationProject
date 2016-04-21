package cs310_assn2_attempt1;


import cs310_assn2_attempt1.CashDonation;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ragan E. Lake
 */
public class CashImplementation implements TotalsIdInterfaceI {
 
    //Create array list of cash donation objects.
    List <CashDonation> cashDonationList = new ArrayList<>(); 
     
    public int getNumberOfDonations () { 
        int numberOfDonations = 0; 
        for (int i=0; i < cashDonationList.size(); i++) {
             numberOfDonations ++;
         }
         return numberOfDonations;
     }
     
     //Returns count of donations with donorID.
   
     public int getNumberOfDonations (int donorId) {
         int numberOfDonations = 0;
         for (CashDonation oneCashDonation:cashDonationList) {
             if (donorId == oneCashDonation.getDonorId()) {
                numberOfDonations++;
            } 
         }
        return numberOfDonations;
     }
     
     //Returns sum of donations in list.
     
     public double getAmountOfDonations (){
         double totalDonationAmount = 0;
         for (CashDonation oneDonation:cashDonationList) {
             totalDonationAmount += oneDonation.getDonationAmount();
         }
         return totalDonationAmount;
     }
      
     //Returns sum of donations with donorID.
     
     public double getAmountOfDonations(int donorId) {
         float totalDonationAmount = 0;    
         for (CashDonation oneCashDonation:cashDonationList) {
             if (donorId==oneCashDonation.getDonorId()) { 
                 totalDonationAmount += oneCashDonation.getDonationAmount();
                   
             }
         } return totalDonationAmount;    
     }
     
     //Adds donation to list.
     
     public boolean add (Object obj) {
         CashDonation cashDonation = (CashDonation)obj;
         cashDonationList.add(cashDonation);
         return true;
     }
    
     
     //Removes donation from list.
     
     public boolean remove (Object obj){
         CashDonation cashDonation = (CashDonation)obj;
         return (cashDonationList.remove(cashDonation));
     }
     
     //Removes donation with a specified donorID from list.
     
     public boolean remove (int donorId) {
         for (CashDonation oneCashDonation:cashDonationList) {
             donorId=oneCashDonation.getDonorId();
         }
        return false;
     }
     
     //Tests if donation with ID exists in list.
     
     public boolean isIDUnique (int donationID) {
         for (CashDonation oneCashDonation:cashDonationList) {
             donationID = oneCashDonation.getDonationId();
             if (donationID != oneCashDonation.getDonationId()) {
                 return true;
             }
         } return false;
     }

    public List<CashDonation> getCashDonationList() {
        return cashDonationList;
    }

//    public void setCashDonationList(ArrayList<CashDonation> cashDonationList) {
//        this.cashDonationList = cashDonationList;
//    }

    
}
