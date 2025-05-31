/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author 2231349
 */
public class Customer {
    
    private String Firstname;
    private String Surname;
    private String DOB;
    private String CustomerSince;
    private IAddress HomeAddress;
    private String filename;
    private CurrentAccount theCurrentAccount;
    private Account OwnedAccount;
    private Customer AccountCoHolder;
    
    public Customer() {
    
        Firstname = "";
        Surname = "";
        HomeAddress = new IAddress();
        DOB = "";
        CustomerSince = ""; 
        filename = "Customer.txt";
    }
    
    public Customer(String Firstname, String Surname, String DOB, String CustomerSince, IAddress HomeAddress) {
        this.Firstname = Firstname;
        this.Surname = Surname;
        this.DOB = DOB;
        this.CustomerSince = CustomerSince;
	this.HomeAddress = HomeAddress; //edits here
    }

    
    
    
    public void Display(JTextArea jBankClientTextArea) {
        jBankClientTextArea.setLineWrap(true);
        jBankClientTextArea.append(this.toString());
    }
    
   
    
    public void display(JTextArea jBankClientTextArea) {
        jBankClientTextArea.setLineWrap(true);
        jBankClientTextArea.append(getAddress());
    }
    
    
    //public void DisplayIAddress(JTextArea jBankClientTextArea) {
       
     // jBankClientTextArea.setLineWrap(true);
     //  jBankClientTextArea.append(getIAddress());
    //}

    
    @Override
    public String toString() {
        return ("\n\nDETAILS:\nFirst Name: " + Firstname + "\n" + "Surname: " + Surname + "\n" + 
                "Customer Since: " + CustomerSince + "\n" + "Date of Birth: " + DOB + "\n"
		);
        }
    
    
    public void Edit(String Firstname, String Surname, String DOB, String CustomerSince) {
        this.Firstname = Firstname;
        this.Surname = Surname;
        this.DOB = DOB;
        this.CustomerSince = CustomerSince;
        }
    
    //public boolean checkDOB(LocalDate givenDOB) {
        //return DOB.equals(givenDOB);
    //}
    
    public boolean checkDOB(String givenDOB) {
        return DOB.equals(givenDOB);
        }
    
    public String getAddress() {
        return HomeAddress.toString();
        }

    public String getSurname() {
        return Surname;
        }
    
    public String getFirstname() {
        return Firstname;
        }

    public String getDOB() {
	return DOB;
	}

    public String getCustomerSince() {
	return CustomerSince;
        }

     public void SaveToFile(boolean append) {
        try {
            FileWriter awriter = new FileWriter(new File(filename), append);
            awriter.write(toString());
            HomeAddress.SaveToFile(awriter);
            awriter.close();  // Don't forget to close the FileWriter
        } catch (IOException e) {
            System.out.println("Failed to write");
        }
    }
    
    }

    
    
 


