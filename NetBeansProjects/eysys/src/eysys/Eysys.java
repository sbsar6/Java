/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eysys;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;
import java.util.regex.Pattern;
/**
 *
 * @author Andrew
 */
public class Eysys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        
        String condition;
       ArrayList lista = new ArrayList() {};  
       
      lista.add("Software Engineer");
       lista.add("Accountant");
        System.out.println("Array contains" + lista);
        if (lista.contains("Engineer")){
            System.out.println("Here");
        }
                
                
         
        
      /*   Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
      
        while (true) {
        Pattern pattern = Pattern.compile(console.readLine("Enter Job Title to test: "));
      // condition = (lista.contains("Engineer"))? "isIn": "notIn";
   // if (lista.contains("Engineer")){
   //     System.out.println("Is in");
   // }
   // else{
    //  System.out.println("Not In");
//} */
  
    Matcher matcher = pattern.matcher("Software Engineer");
         boolean found = false;
            while (matcher.find()) {
                console.format("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                found = true;
            }
            if(!found){
                console.format("No match found.%n");}
    
    
        
    }
    }
    

