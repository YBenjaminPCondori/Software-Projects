/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class User {
    
    private String name;
    private String password;
    private String role;
    private String filename;
        
    public User() {
    
    name = "";
    password = "";
    role = "";
    filename = "login.txt";
    
    }
    
     public User(String strname, String strpassword, String strrole, String strfilename) {
    
    name = strname;
    password = strpassword;
    role = strrole;
    filename = strfilename;
    }
    
    public boolean isUser(String newName, String newPassword) {
    name = newName;
    password = newPassword;
    
    boolean isFound = false;
    String recorduser;
    String recordpass;
    FileReader reader;

 try {
        reader = new FileReader(filename);
        BufferedReader bin = new BufferedReader(reader);
    	recorduser = new String();
	recordpass = new String();
        while ((recorduser = bin.readLine()) != null && (recordpass = bin.readLine()) != null) {
            if (newName.equals(recorduser) && newPassword.equals(recordpass)) {
                isFound = true;
                role = recorduser;
		break;
            }
        }

 /*String recorduser;
    FileReader reader; */
    
   /* try {
        reader = new FileReader(filename);
        BufferedReader bin = new BufferedReader(reader);
    	record = new String();
        while ((record = bin.readLine()) != null){

            if (record.equals(name + " " + password)) {
                isFound = true;
                role = record;
		break;
            }
        }
        */
        bin.close();
    } catch (IOException ioe) {
        isFound = false;
    }
    
    return isFound;
} 

   
    /*the method returns the value of isUser to identify if the
    username and password are correct, toerhwise it returns false */
    
    
    
    public boolean isRegistered(String newName, String newPassword) {
    boolean isRegistered = false;
    // Initialize attributes of the class User: name, password, and filename aka "login.txt"
    name = newName;
    password = newPassword;
    
    // Object writer is declared here
    FileWriter writer = null;
    try {
        // Object writer is instantiated here
        writer = new FileWriter(filename, true);
        writer.write(newName + System.getProperty("line.separator"));
        writer.write(newPassword + System.getProperty("line.separator"));
        writer.write("##" + System.getProperty("line.separator"));
        // Here the variable isRegistered is set to true
        isRegistered = true;
    } catch (IOException ioe) {
        isRegistered = false;
    } finally {
        try {
            if (writer != null) {
                writer.close(); // Close the writer in a finally block
            }
        } catch (IOException e) {
            // Handle the exception if needed
        }
    }
    return isRegistered;
}

    //User implementation of role Bank Manager
public boolean isOwner() {
        return role.contains("Owner");
    }
    
    //User implementation of role Bank Employee
public boolean isEmployee() {
        return role.contains("Employee");
}

   //User implementation of role Customer
public boolean isCustomer() {
        return role.contains("Customer");
}

}
