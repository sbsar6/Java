/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eysys2;



/**
 *
 * @author Andrew
 */
public class main {
  
         
     public static void main(String[] args) {
         
        
         Eysys2 arrayManipulator = new Eysys2();
         int[] myBigArray = new int[20];
         myBigArray[0] = 22;
         myBigArray[1] = 27;
         myBigArray[2] = 29;
         myBigArray[3] =52;
         myBigArray[4] = 552;
         Eysys2.getStats(myBigArray);
         }
}
