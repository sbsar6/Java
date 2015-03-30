/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package normal;

import java.io.*;
import java.util.HashMap;


/**
 *
 * @author Andrew


     */
 public class Normal {
 public static void main(String[] args) {

    double seScore = 0;
    double accounScore = 0;
    double quantScore = 0;
    double archScore = 0;
   HashMap seNorm = new HashMap();  
   seNorm.put("software engineer", 0.9);
   seNorm.put("software", 0.45);
   seNorm.put("engineer", 0.45);
 
   HashMap accNorm = new HashMap();
   accNorm.put("accountant", 0.9);
   accNorm.put("finance", 0.5);
   
   HashMap quantNorm = new HashMap();
   quantNorm.put("quantity surveyor", 0.9);
   quantNorm.put("quantity", 0.45);
   quantNorm.put("surveyor", 0.45);
   
   HashMap archiNorm = new HashMap();
   archiNorm.put("architect", 0.9);
   
   
   System.out.println("Please enter title to check for normalisation");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(isr);
        String normal = "";
        
        try
        { 
            normal = buffer.readLine().toLowerCase();
            buffer.close();          
        }
        catch(IOException e) 
        {
        
            System.out.println("An input error has occured");
                }
    if (seNorm.containsKey(normal)){
        seScore = (double) seNorm.get(normal);
       
    }
    else if (quantNorm.containsKey(normal)){
        quantScore = (double) quantNorm.get(normal);
    }
    
     else if (accNorm.containsKey(normal)){
        accounScore = (double) accNorm.get(normal);
    }
     else if (archiNorm.containsKey(normal)){
        archScore = (double) archiNorm.get(normal);
    }
    else {
        System.out.println("No match found");
        return;
    }
    
    
    /*if (normal.contains("architect")){
        archScore =archScore +1;
    }
    if (normal.contains("accountant")){
        accounScore =accounScore +1;
    }if (normal.contains("Engineer")&& normal.contains("software")){
        seScore = seScore +1;
    }
    
    else if (normal.contains("engineer")|| normal.contains("software")){
        seScore =seScore +0.5;}
    
    if (normal.contains("quantity")&& normal.contains("surveyor")){
        quantScore =quantScore +1;
    }
    
    else if (normal.contains("quantity")|| normal.contains("surveyor")){
        quantScore =quantScore +0.5;}
    

    else {
        System.out.println("No match found");
        return;
    }
    */
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



