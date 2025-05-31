/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author 2231349
 */

/* Declaration and Implementation of Getter and Setter Methods start here */
public class IAddress {
    //Here are the attributes which are also known as the variables on the class, they are declared here*//
    private String name;
    private String street;
    private int house_no;
    private String house_name;
    private String area;
    private String post_code;
    private String town;
    private String country;
 
    //* Here the IAddress constructor is declared *//
public IAddress(){
    
    name ="";
    house_name="";
    house_no=0;
    street="";
    area="";
    post_code="";
    town="";
    country="";
}
 
//* Here IAddress default constuctor is being implemented using parameters *//
public IAddress(String strName, String strStreet, Integer intHouseNo, String strHouseName, String strArea, String strPostCode,
        String strTown, String strCountry) {
    
    name = strName;
    street = strStreet;
    house_no = intHouseNo;
    house_name = strHouseName;
    area = strArea;
    post_code = strPostCode; 
    town = strTown;     
    country = strCountry;
    
}

//Implementation of Edit Method
public void Edit(String strName, String strStreet, Integer intHouseNo, String strHouseName, String strArea, 
        String strPostCode, String strTown, String strCountry) {
    
    name = strName;
    street = strStreet;
    house_no = intHouseNo;
    house_name = strHouseName;
    area = strArea;
    post_code = strPostCode; 
    town = strTown;     
    country = strCountry;
    
}



//Getter and Setter methods for FirstName and Surname
public String getName(){
    return name;
}

public String getStreet() {
    return street;
}

public int getHouseNo() {
    return house_no;
}

public String getHouseName() {
    return house_name;
}

public String getArea() {
    return area;
}

public String getPostCode() {
    return post_code;
}

public String getTown() {
    return town;
}

public String getCountry() {
    return country;
}

   //Set House No if method

public void setHouse_no(Integer intHouse_no) {
    if(intHouse_no<0)
    {
        JOptionPane.showMessageDialog(null, "Incorrect value of house number");
    }
    else
    {
        house_no=intHouse_no;
    }
}
//Implementation of ToString Method
public String toString() {
    return "\n\nADDRESS" + "\nStreet: " + street + "\nHouse Number: " + house_no + "\nHouse Name: " + 
            house_name + "\nArea: " + area + "\nPost Code: " + post_code + "\nTown: " + town + "\nCountry: " + country;
    
}
       
    
//Implementation of Display method 
public void Display(JTextArea jHeadOfficeTextArea) {
        jHeadOfficeTextArea.setLineWrap(true);
        jHeadOfficeTextArea.append(toString());
}

public void SaveToFile(FileWriter awriter) {
        try {
            awriter.write(toString());
            awriter.flush();
           
    } catch (IOException e) {
        System.out.println("Failed to save");
    }
}

 public void LoadFromFile(FileReader areader) {   
    try (BufferedReader bin = new BufferedReader(areader)){
        {
            name = bin.readLine();
            street = bin.readLine();
            house_no = Integer.parseInt(bin.readLine()); // Parsing Integer value from House Number to String
            house_name = bin.readLine();
            area = bin.readLine();
            post_code = bin.readLine();
            town = bin.readLine();
            country = bin.readLine();
        }
    } catch (IOException e) {
        System.out.println("Failed to read");
    }
    }

}

  


    





