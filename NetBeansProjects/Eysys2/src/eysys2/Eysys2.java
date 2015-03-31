/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eysys2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.IntStream;
/**
 *
 * @author Andrew
 */
public class Eysys2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     if (args!= null){
         int[] a = new int[args.length];
         for (int i = 0; i < args.length; i++){
    a[i] = Integer.parseInt(args[i]);
             System.out.println(Arrays.toString(a));
    getStats(a);
     } 

     }
     
        
          
} 
    //Calculating mean from array
      public static int getStats(int[]a){
   HashMap stats = new HashMap();  
   stats.put("Mean value is ", mean(a));
   stats.put("Median value is ", median(a));
   stats.put("Modal value is ", mode(a));
   stats.put("Range value is " , range(a));
   
   System.out.println(stats); 
        return 0;
      }
      
      public static int mean(int[] a) {
 
     int meanSum = 0;
    for (int i = 0; i < a.length; i++) {
        meanSum += a[i];
    }
    return meanSum / a.length;
}
    
    //Calculating median from array
    public static int median(int[] a) {
    int midSum = a.length/2;
    if (a.length%2 == 1) {
        return a[midSum];
    } else {
        return (int) ((a[midSum-1] + a[midSum]) / 2.0);
    }
}
    
    //Calculating mode from array
    public static int mode(int a[]) {
    int maxValue = 0;
    int maxCount = 0;

    for (int i = 0; i < a.length; ++i) {
        int count = 0;
        for (int j = 0; j < a.length; ++j) {
            if (a[j] == a[i]) ++count;
        }
        if (count > maxCount) {
            maxCount = count;
            maxValue = a[i];
        }
    }
    return maxValue;

}
    
    public static int range(int a[]){
       int max = a[0];
        int min = a[0];
        for (final int i : a) {
            if (i > max) {
                max = i;
            } else if (i < min) {
                min = i;
            }
        }
        //return min;
        //return max;
        return (max - min) + 1;
          // TODO code application logic here
    }
    
}
