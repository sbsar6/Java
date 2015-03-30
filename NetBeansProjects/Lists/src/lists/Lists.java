/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;
import java.io.*;

/**
 *
 * @author Andrew
 */
public class Lists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    double seScore = 0;
    double accounScore = 0;
    double quantScore = 0;
    double archScore = 0;
    
        System.out.println("Please enter title to check for normalisation");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(isr);
        String normal = "";
        
        try
        { 
            normal = buffer.readLine();
            buffer.close();          
        }
        catch(IOException e) 
        {
        
            System.out.println("An input error has occured");
                }
        
    if (normal.contains("Engineer")||normal.contains("engineer")&& normal.contains("Software")||normal.contains("software")){
        seScore =seScore +1;
    }
    
    else if (normal.contains("Engineer")||normal.contains("engineer")|| normal.contains("Software")||normal.contains("software")){
        quantScore =quantScore +0.5;}
    
    else if (normal.contains("Quantity")||normal.contains("quantity")&& normal.contains("Surveyor")||normal.contains("surveyor")){
        quantScore =quantScore +1;
    }
    
    else if (normal.contains("Quantity")||normal.contains("quantity")|| normal.contains("Surveyor")||normal.contains("surveyor")){
        quantScore =quantScore +0.5;}
    
    if (normal.contains("Architect")||normal.contains("architect")){
        archScore =archScore +1;
    }
    if (normal.contains("Accountant")||normal.contains("accountant")){
        accounScore =accounScore +1;
    }
    else {
        System.out.println("No match found");
        return;
    }
    
    if (seScore > quantScore && seScore > archScore && seScore > accounScore){
        System.out.println("Normalisation is Software Engineer");
    }
    else if (quantScore > seScore && quantScore> archScore && quantScore > accounScore){
        System.out.println("Normalisation is Quantity Surveyor");
    }
    else if (archScore > seScore && archScore> quantScore && archScore> accounScore){
        System.out.println("Normalisation is Architect");
    
    }
    else if (accounScore > seScore && accounScore> quantScore && accounScore> archScore){
        System.out.println("Normalisation is Accountant");
    
    }
    else {
        System.out.println("No normalisation found, has similarities with more than one type");
    }
}
}