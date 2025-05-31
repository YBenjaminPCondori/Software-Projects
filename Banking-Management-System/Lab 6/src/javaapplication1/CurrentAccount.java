/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author 2231349
 */
public class CurrentAccount extends Account {
    private double Overdraft;
    private String Conditions;
    private double AvailableBalance;


    public CurrentAccount()
    {
        super();
        Overdraft = 100;
        Conditions = "";
        
    }
    
    public CurrentAccount(String aSortCode, int aAccountNo, double aBalance, String aNameOfBank, double aRate)
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
        jAccountsTextArea.append("TYPE: \nCURRENT Account");
        jAccountsTextArea.append("\nDETAILS:\nSortCode: " + getAccountNo() + "\n" + getBalance() + 
                "\n" + getNameOfBank() + "\n" + getRate() + "\n" + getLastReportedDate() + 
                "\n" + getJoint());
    }
    
    
    public void depositMonthlyIneterest() {
        super.depositMonthlyInterest();
    }
    
    @Override
    public void depositYearlyInterest() {
        super.depositYearlyInterest();
    }
    
    @Override
    public void calculateCharges() {
        super.calculateCharges();
    }
    
    public void withdrawal(double Amount) {
    
    }
    
    public void SaveToFile() {
        super.SaveToFile(true);
    }
    
    @Override
    public void deposit(double Amount) {
    
    }
}
