/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menubars;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Andrew
 */
public class Menubars extends JFrame {

         private JPanel topPanel;
         private JMenuBar menuBar;
         private JMenu menuFile;
         private JMenu menuEdit;
         private JMenu menuOpen;
         private JMenu menuSave;
         
         public Menubars(){
             setTitle("Mi Pics");
             setSize(800,800);
             
             topPanel = new JPanel();
             topPanel.setLayout (new BorderLayout());
             add(topPanel);
             
             menuBar = new JMenuBar();
             
             setJMenuBar(menuBar);
             
             setJMenuBar (menuBar);
             
             
             //add file menu
             menuFile = new JMenu ("File");
             menuBar.add(menuFile);
             //add open subitem
             menuOpen = new JMenu ("Open");
             menuFile.addSeparator();
             menuFile.add (menuOpen);
             menuFile.addSeparator();
             
             //add save subitem
             menuSave = new JMenu ("Save");
             menuFile.add (menuSave);
             menuFile.addSeparator();
             
             
             //add Edit Menu
             menuEdit = new JMenu ("Edit");
             menuBar.add(menuEdit);
         }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Menubars mainFrame = new Menubars();
    mainFrame.setVisible(true);
    
    }
    
}
