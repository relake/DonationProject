/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310_assn2_attempt1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ragan E. Lake
 */
public class PrintImplementation {
     List<CashDonation>cashDonationList;
     List<PropertyDonation>propertyDonationList;
     List<Donor>donorList;
     
     public void printReport (DonorImplementation donorImpl,CashImplementation cashImpl, PropertyImplementation propImpl)  {  
  
        cashDonationList = cashImpl.getCashDonationList();
        propertyDonationList = propImpl.getPropertyDonationList();
        donorList = donorImpl.getDonorList();
        
        float GOLDSTAR = 10000;
        double totalCashDonationAmount = 0;
        double totalPropertyDonationAmount = 0;
        int totalNumberCashDonations = 0;
        int totalNumberPropertyDonations = 0;
        double donorCashDonationAmount= 0;
        double donorPropertyDonationAmount=0;
        int donorNumberCashDonations = 0;
        int donorNumberPropertyDonations = 0;
        double totalDonationAmount = 0;
        int totalDonationNumber = 0;
        String printDeductible = null;
      
        try {
            PrintWriter fstream = new PrintWriter ("out.txt");  
        } catch (FileNotFoundException fnfe) { 
            System.err.println("Failed to create file ");           
        }
        System.out.printf("Donor ID, Donor Last Name, Donor First Name, GOLDSTAR(display if true)");  
        for (Donor currDonor:donorList) {
            System.out.println();
            
            int idNumber=currDonor.getDonorId();
            String lastName = currDonor.getLastName();
            String firstName = currDonor.getFirstName();
            System.out.println();
            System.out.printf(idNumber + "%22s %15s\n", lastName, firstName);
            
            System.out.println("Cash Donations");
            System.out.println("Donation Id       Date            Description                        Amount        Check Number        Tax Deductible");    
            
            for (CashDonation currCashDonation:cashDonationList) {
             
                if (currCashDonation.getDonorId() == currDonor.getDonorId()) {
                    int donationId = currCashDonation.getDonationId();
                    String donationDate = currCashDonation.getDonationDate();
                    String donationDescription = currCashDonation.getDonationDescription();
                    double donationAmount = currCashDonation.getDonationAmount();
                    int donationCheckNumber = currCashDonation.getCheckNumber();
                    char taxDeductible = currCashDonation.getTaxDeductible();
                    if (currCashDonation.getTaxDeductibleTrue()){
                        printDeductible = "TAX DEDUCTIBLE";
                    } 
                                             
                System.out.printf("%1s %14s %15s %15.2f %15s %20s", donationId, donationDate, donationDescription, donationAmount, donationCheckNumber, printDeductible);               
                  
                System.out.println();
                }
            }
            System.out.println();
            System.out.println("Property Donations");
            System.out.println("Donation Id       Date            Description                        Amount        Tax Deductible    Appraisal Performed");    
            for (PropertyDonation currPropertyDonation:propertyDonationList) {
              
                if (currPropertyDonation.getDonorId() == currDonor.getDonorId()) {
                    int donationId = currPropertyDonation.getDonationId();
                    String donationDate = currPropertyDonation.getDonationDate();
                    String donationDescription = currPropertyDonation.getDonationDescription();
                    double donationAmount = currPropertyDonation.getDonationAmount();
                    char appraisalPerformed = currPropertyDonation.getAppraisalPerformed();
                    char taxDeductible = currPropertyDonation.getTaxDeductible();               
                    if (currPropertyDonation.getTaxDeductibleTrue()){
                        printDeductible = "TAX DEDUCTIBLE";
                    } 
                    System.out.printf("%1s %15s %20s %30.2f %20s %20s", donationId, donationDate, donationDescription, donationAmount, printDeductible, appraisalPerformed);
                    System.out.println();
                }         
            }    
                donorNumberCashDonations = cashImpl.getNumberOfDonations(idNumber);
                donorNumberPropertyDonations = propImpl.getNumberOfDonations(idNumber);
                int totalDonorDonations = donorNumberCashDonations + donorNumberPropertyDonations;
                donorCashDonationAmount = cashImpl.getAmountOfDonations(idNumber);
                donorPropertyDonationAmount = propImpl.getAmountOfDonations(idNumber);
                double totalDonorDonationAmount = donorCashDonationAmount + donorPropertyDonationAmount;
                totalNumberCashDonations = cashImpl.getNumberOfDonations();
                totalCashDonationAmount = cashImpl.getAmountOfDonations();
                totalNumberPropertyDonations += propImpl.getNumberOfDonations();
                totalPropertyDonationAmount = propImpl.getAmountOfDonations();
                totalDonationNumber = totalNumberCashDonations + totalNumberPropertyDonations;
                totalDonationAmount = totalCashDonationAmount + totalPropertyDonationAmount;
                              
                if (totalDonorDonationAmount > GOLDSTAR ){
                            System.out.printf("GOLDSTAR");
                            System.out.println();
            } 
               
                System.out.println("Total Number of Donations:  " + totalDonorDonations);
                System.out.printf("Total Amount of Donations:  %6.2f", totalDonorDonationAmount);                                   
                System.out.println();
         }        
                System.out.println();
                System.out.println("Total Cash Donations = " + totalNumberCashDonations);
                System.out.printf("Total Cash Donation Amount = $%10.2f", totalCashDonationAmount);
                System.out.println();
                System.out.println("Total Property Donations = " + totalNumberPropertyDonations);
                System.out.printf("Total Property Donation Amount = $%6.2f", totalPropertyDonationAmount);
                System.out.println();
                System.out.println("Total Donations = " + totalDonationNumber);
                System.out.printf("Total Donation Amount = $%15.2f", totalDonationAmount);
                System.out.println();
   
   }
}

