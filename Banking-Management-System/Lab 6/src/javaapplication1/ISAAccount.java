package javaapplication1;

import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 2231349
 */
public class ISAAccount extends Account{
    
    private double MaximumLimitPerYear;
    private double DepositedThisYear;
    
    public ISAAccount() {
    
    super();
    MaximumLimitPerYear = 3250;
    DepositedThisYear = 0;
    }
    
    public ISAAccount(String aSortCode, int aAccountNo, double aBalance, String aNameOfBank, double aRate)
    {
    super(aSortCode, 
                aAccountNo, 
                aBalance, 
                aNameOfBank, 
                aRate);
    }
    
    public void create(String aSortCode, int aAccountNo, double aBalance, String aNameOfBank, double aRate, String aConditions)
     {
        super.create(SortCode, 
                AccountNo, 
                Balance, 
                NameOfBank, 
                Rate);
    }
    
    @Override
    public void display(JTextArea jAccountsTextArea) {
        super.display(jAccountsTextArea);
        jAccountsTextArea.append("TYPE: \nISA Account");
        jAccountsTextArea.append("\nDETAILS:\nSortCode: " + getAccountNo() + "\n" + getBalance() + 
                "\n" + getNameOfBank() + "\n" + getRate() + "\n" + getLastReportedDate() + 
                "\n" + getJoint());
    }
    
    public void SaveToFile() {
        super.SaveToFile(true);
    }
    
    @Override
    public void depositYearlyInterest() {
        super.depositMonthlyInterest();
    }
    
    @Override
   public void calculateCharges() {
        super.calculateCharges();
    }
}
