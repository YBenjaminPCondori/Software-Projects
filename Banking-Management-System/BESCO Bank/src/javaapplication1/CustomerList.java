/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
public class CustomerList {
    
    //Declaration of array of objects
    ArrayList <Customer> Clients;
    MainJFrame HeadOfficeFrame;
    String filename;
    
    public CustomerList() {
        //Addition of objects in the array object
        Clients = new ArrayList<>();
        filename = "Customers.txt";
        
    }
    
    
    
     public void add(Customer src){
        Clients.add(src);
    }
    
    public Customer remove(Customer src) {
    for (int i = 0; i < Clients.size(); i++) {
        if (Clients.get(i).getFirstname().equals(src.getFirstname()) ||
            Clients.get(i).getSurname().equals(src.getSurname()) ||
            Clients.get(i).getDOB().equals(src.getDOB()) ||
            Clients.get(i).getCustomerSince().equals(src.getCustomerSince())) {
            Clients.remove(i);
        }
    }

    return null;
}
   
    
    public void remove(String Surname, String Firstname) {
	for (int i =0; i < Clients.size(); i++){
		if (Clients.get(i).getSurname().equals(Surname) && (Clients.get(i).getFirstname().equals(Firstname))){
	            Clients.remove(i);
	}
    }
}

   
    
    public Customer find(Customer src) {
    for (int i = 0; i < Clients.size(); i++) {
        if (Clients.get(i).getFirstname().equals(src.getFirstname()) ||
            Clients.get(i).getSurname().equals(src.getSurname()) ||
            Clients.get(i).getDOB().equals(src.getDOB()) ||
            Clients.get(i).getCustomerSince().equals(src.getCustomerSince())) {
            return Clients.get(i);
        }
    }

    return null;
}

        
    public void AddCustomer(Customer newCustomer) {
    //Used to add new customers in JFrame
    }
            
    public void DeleteCustomer(Customer newCustomer) {
    //Used to delete customers in JFrame
    }
    
    public void Create() {
    
    }
    
   //Deletion of objects given index from the array
    public void Display(JTextArea jBankClientsTextArea) {
	for (int i =0; i < Clients.size(); i++){
		Clients.get(i).Display(jBankClientsTextArea);
                Clients.get(i).display(jBankClientsTextArea);
                
	}
                
    }
    
    public void SaveToFile(String filename) {
        try (FileWriter awriter = new FileWriter(filename)) {
            for (Customer src : Clients) {
                awriter.write(src.toString() + "\n");
                awriter.write(src.getAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   

}
