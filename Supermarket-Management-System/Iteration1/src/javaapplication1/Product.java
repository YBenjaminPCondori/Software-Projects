/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author 2231349
 */
public class Product {
    
	private String product_ID;
	private float price;
	private Integer with_VAT;
	private Integer weight;
	private String product_name;
        private Integer quantity;
        private ProductList productlist;
        private LocalDate estimatedOrderDate;
        private Manufacturer manufacturer;
        private LocalDate expiryDate;
        private float pricewithoutVAT;

	public Product() {
	
	product_ID = "";
        price = 0; // or 0.0f, depending on your use case
        with_VAT = 0;
        weight = 0;
        product_name = "";
        quantity = 0;
        productlist = null;
        estimatedOrderDate = null;
        manufacturer = null;
        expiryDate = null;
        pricewithoutVAT = 0;
}

	public Product(String strproductID, float newprice, Integer intwithVAT, Integer intweight,
                   String strproductName, Integer intquantity, ProductList newproductlist,
                   LocalDate newestimatedOrderDate, Manufacturer newmanufacturer,
                   LocalDate newexpiryDate, float newpricewithoutVAT, Integer intWeight)  {
	
	product_ID = strproductID;
	price = newprice;
	with_VAT = intwithVAT;
        pricewithoutVAT = newpricewithoutVAT ;
	weight = intWeight;
	product_name = strproductName;

}
        
        public void Edit(String strproductID, float newprice, Integer intwithVAT, Integer intweight,
                   String strproductName, Integer intquantity, ProductList newproductlist,
                   LocalDate newestimatedOrderDate, Manufacturer newmanufacturer,
                   LocalDate newexpiryDate, float newpricewithoutVAT, Integer intWeight)  {
	
	product_ID = strproductID;
	price = newprice;
	with_VAT = intwithVAT;
        pricewithoutVAT = newpricewithoutVAT ;
	weight = intWeight;
	product_name = strproductName;

}

       
        
        public void DisplaytoDairy(JTextArea jDairyTextArea) {
        jDairyTextArea.setLineWrap(true);
        jDairyTextArea.append(ToString());
    }
        
        public void DisplaytoBread(JTextArea jBreadTextArea) {
        jBreadTextArea.setLineWrap(true);
        jBreadTextArea.append(ToString());
    }
        
        public void DisplaytoVeg(JTextArea jVegTextArea) {
        jVegTextArea.setLineWrap(true);
        jVegTextArea.append(ToString());
    }
        
        public void DisplaytoPasta(JTextArea jPastaTextArea) {
        jPastaTextArea.setLineWrap(true);
        jPastaTextArea.append(ToString());
    }
        
        public void DisplaytoBeverages(JTextArea jBeveragesTextArea) {
        jBeveragesTextArea.setLineWrap(true);
        jBeveragesTextArea.append(ToString());
    }
        
        public void DisplaytoMeat(JTextArea jMeatTextArea) {
        jMeatTextArea.setLineWrap(true);
        jMeatTextArea.append(ToString());
    }
        
        
        
        public String ToString() {
        return (product_name + "               " + product_ID);
    
    }
        
        public void SaveToFile(FileWriter aWriter) {
    try {
        try (aWriter) {
            aWriter.write(ToString());
            // Close the FileWriter when you're done
        }
    } catch (IOException e) {
        System.out.println("Failed to save");
    }
}

    void Edit(String valueOf, String valueOf0, String valueOf1, String valueOf2, String valueOf3, String valueOf4, String valueOf5) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}