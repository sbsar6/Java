/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Andrew
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String header = "\n\tCARDIFF 3-DAY FORECAST:\n";
        header += "\n\tDay\t\tHigh\tLow\tConditions\n";
        header += "\t---\t\t----\t---\t----------\n";
        String forecast = "\tSunday\t\t68F\t48F\tSunny\n";
        forecast += "\tMonday\t\t69F\t57F\tSunmny\n";
        forecast += "\tTuesday\t\t71F\t50F\tCloudy\n";
        System.out.print(header + forecast);
    }
    
}
