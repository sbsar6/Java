/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Andrew
 */
public class Lists {
 

   
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        arrayList1.add("holiday.jpg");
        arrayList1.add("holiday2.jpg");
        HashMap namesToNodes= new HashMap();
        namesToNodes.put("Holidays", arrayList1);
        arrayList2.add("Tree1.jpg");
        namesToNodes.put("Trees", arrayList2);
        
        System.out.println(namesToNodes.size());
        
        ArrayList<String> list = new ArrayList<String>();
        
        
        
    list.add("Alpha");
    list.add("Delta");
    list.add("Charlie");
        System.out.println("List: " + list);
    
        System.out.println("Replacing " + list.get(1) + "\n");
        list.set(1, "Bravo");
    list.forEach((x) -> System.out.println("Item: " + x));
    }
    
}
