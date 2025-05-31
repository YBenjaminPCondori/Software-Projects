/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;

/**
 *
 * @author 2231349
 */
public class BranchList {
    
    //Declaration of array of objects
    private Branch SubDepartments;
    private ArrayList <Branch> Branches;
    private MainJFrame HeadOfficeFrame;
    private String filename;
    
    public BranchList() {
        //Addition of objects in the array object
        Branches = new ArrayList<>();
        filename = "Branches.txt";
        
        
        
    }
    
    
    
     public void add(Branch src){
        Branches.add(src);
    }
    
    //Deletion of objects from the aray
    
    public Branch remove(Branch src) {
    for (int i = 0; i < Branches.size(); i++) {
        if (Branches.get(i).getWorkingHours().equals(src.getWorkingHours()) ||
            Branches.get(i).getSortCode().equals(src.getSortCode()) ||
            Branches.get(i).getManager().equals(src.getManager())) {
            Branches.remove(i);
        }
    }

    return null;
}
   
     
    public Branch find(Branch src) {
    for (int i = 0; i < Branches.size(); i++) {
        if (Branches.get(i).getWorkingHours().equals(src.getWorkingHours()) ||
            Branches.get(i).getSortCode().equals(src.getSortCode()) ||
            Branches.get(i).getManager().equals(src.getManager())) {
            return Branches.get(i);
        }
    }
    return null;
}
    
    
    public void AddBranch(Branch newBranch) {
    //Used to add new customers in JFrame
    }
            
    public void DeleteBranch(Branch newBranch) {
    //Used to delete customers in JFrame
    }

    
    
    
    public void Create() {
    
    }
    
   //Deletion of objects given index from the array
    public void Display(JTextArea jBranchesTextArea) {
	for (int i =0; i < Branches.size(); i++){
		Branches.get(i).Display(jBranchesTextArea);
                Branches.get(i).display(jBranchesTextArea);
	}
}
  
    
  public void SaveToFile(String filename) {
        try (FileWriter awriter = new FileWriter(filename)) {
            for (Branch src : Branches) {
                awriter.write(src.toString() + "\n");
                awriter.write(src.getAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 // ...

/*public void LoadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming your Branch class has a constructor that takes a string
                Branch branch = new Branch();
                branch.LoadFromFile(new FileReader(line));
                add(branch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// ...*/

  
}
