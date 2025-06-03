package javaapplication1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.JTextArea;
 
// DecIaring VariabIes in the CIass (Person)
public class Person {
    private String FirstName;
    private String SurName;
    private LocalDate DOB;
    private LocalDate CustomerSince;

    // Default constructor Person()
    public Person() {
        FirstName = "";
        SurName = "";
        DOB = LocalDate.of(1990, 01, 01);
    }

    // ImpIementation of Display method
    public void Display(JTextArea jHeadOfficeTextArea) {
        jHeadOfficeTextArea.setLineWrap(true);
        jHeadOfficeTextArea.append(ToString());
    }
    
  

    public String ToString() {
        return (FirstName + " " + SurName + "" + DOB);
    }
    
    // Check DOB method method to validate given DOB (DATE OF BIRTH)
    public boolean checkDOB(LocalDate givenDOB) {
        return DOB.equals(givenDOB);
    }

    public void LoadFromFile(FileReader fr) {
    try (BufferedReader br = new BufferedReader(fr)) {
        FirstName = br.readLine();
        SurName = br.readLine();
    } catch (IOException e) {
        System.out.println("Failed to load: " + e.getMessage());
    }
}


    public void SaveToFile(FileWriter aWriter) {
    try {
        try (aWriter) {
            aWriter.write(toString());
            // Close the FileWriter when you're done
        }
    } catch (IOException e) {
        System.out.println("Failed to save: " + e.getMessage());
    }
}
    
}


