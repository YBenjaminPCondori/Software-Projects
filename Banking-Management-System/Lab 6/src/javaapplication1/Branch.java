package javaapplication1;

import java.io.BufferedReader;
import javax.swing.JTextArea;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Branch {

    private String working_hours;
    private String sort_code;
    private String Manager;
    private String branchAddressFile;
    private IAddress theAddress;

    public Branch() {
        working_hours = "09:00-17:00";
        sort_code = "00-00-00";
        Manager = "TBA";
        branchAddressFile = "BranchAddress.txt";
        theAddress = new IAddress();
        this.SaveToFile(true);
        
        
}
    public Branch(String strWorkingHours, String strSortCode, String newManager, IAddress theAddress) {
        working_hours = strWorkingHours;
        sort_code = strSortCode;
        Manager = newManager;
        this.theAddress = theAddress;
       
        
    }

    public void Edit(String strWorkingHours, String strSortCode, String strManager) {
        working_hours = strWorkingHours;
        sort_code = strSortCode;
        Manager = strManager;
    }

    public void Display(JTextArea jBranchesTextArea) {
        jBranchesTextArea.setLineWrap(true);
        jBranchesTextArea.append(toString());
    }
    
    public void display(JTextArea jBranchesTextArea) {
        jBranchesTextArea.setLineWrap(true);
        jBranchesTextArea.append(getAddress());
    }

    public String toString() {
        return "\nBRANCH\nWorkingHours: " + working_hours + "\nSort Code: " + sort_code + "\nManager: " + Manager + "\n";
    }

    public String getWorkingHours() {
        return working_hours;
    }
    
    public String getSortCode() {
        return sort_code;
    }
    
    public String getManager() {
        return Manager;
    }
    
    public String getAddress() {
        return theAddress.toString();
    }
    
    public void SaveToFile(boolean append) {
        try {
            FileWriter awriter = new FileWriter(new File(branchAddressFile), append);
            awriter.write(toString());
            theAddress.SaveToFile(awriter);
            awriter.close();  // Don't forget to close the FileWriter
        } catch (IOException e) {
            System.out.println("Failed to write");
        }
    }
    
    public void LoadFromFile(FileReader areader) {
        try (BufferedReader bin = new BufferedReader(areader)) {
            sort_code = bin.readLine();
            working_hours = bin.readLine();
            Manager = bin.readLine();
            theAddress.LoadFromFile(areader);
            bin.close();
        } catch (IOException e) {
            System.out.println("Failed to read");
        }
    }
	
}
	
    




