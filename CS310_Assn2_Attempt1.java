/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310_assn2_attempt1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ragan E. Lake
 */
public class CS310_Assn2_Attempt1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Create objects of the classes that contain the methods for totaling donations.
        
        CashImplementation cashImpl = new CashImplementation();
        PropertyImplementation propImpl = new PropertyImplementation();
        DonorImplementation donorImpl = new DonorImplementation();
        PrintImplementation printImpl = new PrintImplementation();

        //Read in input file.
        Scanner fileScanner = null;
        File inFile = new File("donations.csv");

        try {
            fileScanner = new Scanner(inFile);
        } catch (FileNotFoundException fnfe) {
            System.err.println("Failed to open file " + inFile);
        }

        int sizeOfList = 100;
        String[] inputArray = new String[sizeOfList];

        while (fileScanner.hasNextLine()) {
            
            //Read file in to a String array.
            
            String inputLine = fileScanner.nextLine();     
            inputArray = inputLine.split(",");
            String type = (inputArray[0]);
            
            //Read in file entries of "DONOR" type then create new donor object.
            if (type.equalsIgnoreCase("DONOR")) {
                int donorId = Integer.parseInt(inputArray[1]);
                String firstName = inputArray[2];
                String lastName = inputArray[3];
                String email = inputArray[4];
                String phone = inputArray[5];
                Donor oneDonor = new Donor(donorId, firstName, lastName, email, phone);
                
                //Validate donor's email address.
                if (oneDonor.getDonorId() == (donorId)) {
                    if (!(oneDonor.checkEmail(email))) {
                        System.out.println("The email is invalid " + oneDonor.toString());
                    }
                    donorImpl.add(oneDonor);
                } else {
                    System.out.println("That donor already exists.");
                }
                //Read in file entries of "CASH" type then create new cash donation object.
            } else if (type.equalsIgnoreCase("CASH")) {
                String action = inputArray[1];
                int donationId = Integer.parseInt(inputArray[2]);
                int donorId = Integer.parseInt(inputArray[3]);
                String donationDescription = inputArray[4];
                double donationAmount = Double.parseDouble(inputArray[5]);
                String donationDate = inputArray[6];
                char isDeductible = inputArray[7].charAt(0);
                int checkNumber = Integer.parseInt(inputArray[8]);
                CashDonation cashDonation = new CashDonation(donationId, donorId, donationDescription, donationAmount, donationDate, isDeductible, checkNumber);
                cashImpl.add(cashDonation);
                
                //Validate donation check number.
                if (!(cashDonation.validateCheckNumber(checkNumber))) {
                    System.out.println("Check number " + checkNumber + " is not valid for " + cashDonation.toString());
                    System.out.println();
                }
                //Validate that donation is unique by its ID number.
                if (!(cashDonation.getDonationId() == (donationId))) {
                    System.out.println("This donation, donation id #" + donationId + ", already exists.");
                    System.out.println();
                }
                //Read in file entries of "CASH" type then create new property donation object.
            } else if (type.equalsIgnoreCase("PROPERTY")) {
                String action = inputArray[1];
                int donationId = Integer.parseInt(inputArray[2]);
                int donorId = Integer.parseInt(inputArray[3]);
                String donationDescription = inputArray[4];
                double donationAmount = Double.parseDouble(inputArray[5]);
                String donationDate = inputArray[6];
                char isDeductible = inputArray[7].charAt(0);
                char appraisalPerformed = inputArray[8].charAt(0);
                PropertyDonation propertyDonation = new PropertyDonation(donationId, donorId, donationDescription, donationAmount, donationDate, isDeductible, appraisalPerformed);
                if (!(propertyDonation.getDonationId() == (donationId))) {
                    System.out.println("This donation, donation id #" + donationId + ", already exists.");
                    System.out.println();
                }
                propImpl.add(propertyDonation);
            }

        }
        //Call method to print totals.
        printImpl.printReport(donorImpl, cashImpl, propImpl);
        fileScanner.close();
    }
}
