/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;
import javax.swing.*;
        
/**
 *
 * @author Andrew
 */
public class Window extends JFrame {

   JPanel pnl = new JPanel();
   public Window(){
   super("Swing Window");
   setSize(500,200);
   setDefaultCloseOperation(EXIT_ON_CLOSE);
   add(pnl);
   setVisible(true);
   }

    public static void main(String[] args) {
    Window gui = new Window();    
    }
    
}
