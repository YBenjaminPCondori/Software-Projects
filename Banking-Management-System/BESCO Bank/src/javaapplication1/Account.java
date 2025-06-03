/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JTextArea;

/**
 *
 * @author 2231349
 */
public class Account {
    
    protected String SortCode;
    protected int AccountNo;
    protected double Balance;
    protected String NameOfBank;
    protected double Rate;
    private String LastReportedDate;
    private boolean Joint;
    private CurrentAccount theCurrentAccount;
    
    public Account(){
        SortCode = "";
        AccountNo = 0;
        Balance = 0;
        NameOfBank = "";
        Rate = 1.2;
        LastReportedDate = "01/01/1900";
    }
    
    public Account(String aSortCode, int aAccountNo, double aBalance, String aNameOfBank, double aRate)
    {
            SortCode = aSortCode;
            AccountNo = aAccountNo;
            Balance = aBalance;
            NameOfBank = aNameOfBank;
            Rate = aRate;       
    }
    
    public void create(String aSortCode, int aAccountNo, double aBalance, String aNameOfBank, double aRate)
    {
            SortCode = aSortCode;
            AccountNo = aAccountNo;
            Balance = aBalance;
            NameOfBank = aNameOfBank;
            Rate = aRate; 
    }
    
    public String getSortCode() {
    return SortCode;
}
    
    public int getAccountNo() {
    return AccountNo;
}
    public double getBalance() {
        return Balance;
    }
    
    public String getNameOfBank() {
        return NameOfBank;
    }
    
    public double getRate() {
        return Rate;
    }
    
    public String getLastReportedDate() {
        return LastReportedDate;
    }
    
    public boolean getJoint() {
        return Joint;
    }
            
    
    public void display(JTextArea jAccountsTextArea) {
        jAccountsTextArea.setLineWrap(true);
    }
    
    
    
    public void depositMonthlyInterest() {
    
    }
    
    public void depositYearlyInterest() {
    
    }
    
    public void deposit(double Amount) {
    
    
    }
    
    public void withdraw(double Amount) {
    
    }
    
    public void transfer(Account toAccount) {
    
    }
    
    
    public void SaveToFile(boolean append) {
        try {
            try (FileWriter awriter = new FileWriter(new File("Accounts.txt"), append)) {
                awriter.write(getAccountNo() + System.getProperty("line.separator"));
                awriter.write(Double.toString(getBalance()) + System.getProperty("line.separator"));
                awriter.write(getNameOfBank() + System.getProperty("line.separator"));
                awriter.write(Double.toString(getRate()) + System.getProperty("line.separator"));
                awriter.write(getLastReportedDate() + System.getProperty("line.separator"));
                awriter.write(Boolean.toString(getJoint()) + System.getProperty("line.separator"));
                awriter.close();
            }
        } catch (IOException e) {
            System.out.println("Failed to write: " + e.getMessage());
        }
    }
    
    public void calculateCharges() {
        
    }
    
    
    /*public String toString() {
        return ("DETAILS:\nSortCode: " + getAccountNo() + "\n" + getBalance() + 
                "\n" + getNameOfBank()) + "\n" + getRate() + "\n" + getLastReportedDate() + 
                "\n" + getJoint() + "\n";
    }*/
    
    public void printStatement() {
    
    }
    
    public void LastReportedDate(Date aLastReportedDate) {
    
    }
    
    
}
