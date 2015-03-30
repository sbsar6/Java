/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eysys2;
import java.util.Arrays;
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
            int[] numbers = new int[500];
          for(int i = 1; i<numbers.length; i++){ numbers[i] = randomFill();}
          System.out.println("My Big Array contains" + Arrays.toString(numbers));
          System.out.println("The total amount of numbers in My Big Array is: " + numbers.length);
          System.out.println("Total sum of My Big Array is: " + IntStream.of(numbers).sum());
          System.out.println("Mean value is: " + mean(numbers));
          System.out.println("Median value is: " + median(numbers));
          System.out.println("Modal value is: " + mode(numbers));
          System.out.println("Range value is: " + range(numbers));
} 
    //Calculating mean from array
      public static int randomFill(){

    Random rand = new Random();
    int randomNum = rand.nextInt(1001);
    return randomNum;
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