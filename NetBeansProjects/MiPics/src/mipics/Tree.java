/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mipics;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Andrew
 */
public class Tree extends JFrame {
    
    public static void main (String [] args)
    {
        new Tree();
    }
  
    private JTree tree;
    private DefaultTreeModel model;
    private JLabel showName;
    private JButton getTag;
    private JTextField textTag; 
    private JTree tree2; 
    private DefaultTreeModel innerModel;
    
    public Tree()
    {
        this.setSize(350,400);
        this.setTitle("Famous Spinoffs");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final File saveF = new File("tree2.ser");
        
        if (saveF.exists()){
         try{
        ObjectInputStream ois= new ObjectInputStream(new FileInputStream(saveF));
        model = (DefaultTreeModel)ois.readObject();
        ois.close();
        
        }
        catch(IOException  | ClassNotFoundException err)
        {
        }
        }
         if(model ==null){
             model = new DefaultTreeModel(new DefaultMutableTreeNode("Album"));    
         }
          final DefaultTreeModel innerModel = model;
          final JTree tree = new JTree(model);
          tree.setEditable(true);
          
        JPanel panel3 = new JPanel ();
           panel3.setSize(250,200);
           JScrollPane scroll = new JScrollPane(tree);
           scroll.setPreferredSize(new Dimension(200, 200));
         
           panel3.add(scroll);
           
       
           this.add(panel3);
        JPanel buttonPanel = new JPanel();
        showName = new JLabel();
        //panel1.add(showName);
       // this.add(panel1);
        
        textTag = new JTextField(10);
        buttonPanel.add(textTag);
        getTag = new JButton ("Add picture tags");
        getTag.addActionListener(e -> addTag());
        buttonPanel.add(getTag);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    
    this.addWindowListener(new WindowAdapter(){
            public void windowClosed(WindowEvent event){
                try{
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveF));
                    oos.writeObject(innerModel);
                    oos.close();
                }
                catch(IOException err){
                    err.printStackTrace();
                }
                System.exit(0);
            }
        });
    }

    public DefaultMutableTreeNode addPhoto(String title, DefaultMutableTreeNode parent)
    {
        DefaultMutableTreeNode addT;
        addT = new DefaultMutableTreeNode(title);
        parent.add(addT);
        return addT;
    }
 
    public void tree1Changed()
    {
        Object o =tree2.getLastSelectedPathComponent();
        DefaultMutableTreeNode addT;
        addT = (DefaultMutableTreeNode) o;
        String title = (String) addT.getUserObject();
        showName.setText(title);
    }
    
    private void addTag() {
        
        String tag = textTag.getText();
        
        if (tag.length() ==0)
        {
            JOptionPane.showMessageDialog(Tree.this, "Please enter a Tag","Error", JOptionPane.INFORMATION_MESSAGE);
            
        }
    else
        {
        
  
            
            ArrayList<String> keyList = new ArrayList<String>();
        ArrayList<String> arrayList1 = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        ArrayList<String> tempVals = new ArrayList<String>();
        arrayList1.add("holiday.jpg");
        arrayList1.add("holiday2.jpg");
        String name1 = "Holidays";
        String name2 = "Trees";
        
        keyList.add(name1);
        keyList.add(name2);
        HashMap namesToNodes= new HashMap();
        namesToNodes.put(name1, arrayList1);
        arrayList2.add("Tree1.jpg");
        namesToNodes.put(name2, arrayList2);
        
        System.out.println(keyList);
            
            System.out.println(tag); 
            
                Object last = path.getLastPathComponent();
                if( !(last instanceof DefaultMutableTreeNode) ){
                    return;
                }
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)tag;
            
               
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(tag);
                innerModel.insertNodeInto(newNode,node,node.getChildCount());
                TreePath newPath = path.pathByAddingChild(newNode);
                tree.makeVisible(newPath);
                tree.startEditingAtPath(newPath);
             //   SwingUtilities.invokeLater(activateEditor); 
            
           
           
           
           tree.setVisibleRowCount(18);
           tree.addTreeSelectionListener(e -> tree1Changed());
       
       
        
           this.validate();
           this.repaint();
           
        
    }
}
}
    
    