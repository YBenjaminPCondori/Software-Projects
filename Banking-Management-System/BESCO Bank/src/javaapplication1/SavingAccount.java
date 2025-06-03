/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import javax.swing.JTextArea;

/**
 *
 * @author 2231349
 */
public class SavingAccount extends Account{
    private double WithdrawLimit;
    
    public SavingAccount() {
        WithdrawLimit = 200;
    }
    
    public SavingAccount(String aSortCode, int aAccountNo, double aBalance, String aNameOfBank, double aRate)
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
        jAccountsTextArea.append("TYPE: \nSAVING Account");
        jAccountsTextArea.append("\nDETAILS:\nSortCode: " + getAccountNo() + "\n" + getBalance() + 
                "\n" + getNameOfBank() + "\n" + getRate() + "\n" + getLastReportedDate() + 
                "\n" + getJoint());
    }
    
    @Override
    public void calculateCharges() {
        super.calculateCharges();
    }
    
    public void withdraw(){
    
    }
    
    public void SaveToFile() {
        super.SaveToFile(true);
    }
    
    @Override
    public void depositMonthlyInterest() {
        super.depositMonthlyInterest();
    }
    
    @Override
    public void depositYearlyInterest() {
        super.depositYearlyInterest();
    }
    
}
