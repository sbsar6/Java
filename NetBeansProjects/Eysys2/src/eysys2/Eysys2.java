
package eysys2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.IntStream;
/**
 * @author Andrew
 */
public class Eysys2 {

 
    public static void main(String[] args) {
    //convert to int array if run from argument line
        
        if (args!= null){
         int[] a = new int[args.length];
         for (int i = 0; i < args.length; i++){
            a[i] = Integer.parseInt(args[i]); 
            } 
        getStats(a); 
     }    
          
} 
   //creating getStats method to run on input arrays
    public static int getStats(int[]a){
    HashMap stats = new HashMap();  
    stats.put("Mean value is ", mean(a));
    stats.put("Median value is ", median(a));
    stats.put("Modal value is ", mode(a));
    stats.put("Range value is " , range(a));
    System.out.println(stats.toString()); 
    return 0;
      }
      
     //Calculating mean from array  
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
    } 
    else {
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
        } 
        else if (i < min) {
                min = i;
        }
    }
    //Get full range
    return (max - min) + 1;   
    }
    
}
