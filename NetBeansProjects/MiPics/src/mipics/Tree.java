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
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class Tree extends JFrame {
    
    public static void main (String [] args)
    {
        new Tree();
    }
  
    private JTree tree1;
    private DefaultTreeModel model;
    private JLabel showName;
    private JButton getTag;
    private JTextField textTag; 
    private JTree tree2; 
    public Tree()
    {
        this.setSize(350,400);
        this.setTitle("Famous Spinoffs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       /* JPanel panel1 = new JPanel ();
        
        DefaultMutableTreeNode root, andy, archie, happy, george, maude;
        
        root = new DefaultMutableTreeNode("Famous Spin-Offs");
        
        andy = makeShow("The Andy Griffith Show", root);
        makeShow("Gomer Pyle, U.S.M.C.", andy);
        makeShow("Mayberry R.F.D", andy);
        
        archie = makeShow("All in the Family", root);
        george = makeShow("The Jeffersons", archie);
        makeShow("Checking In", george);
        maude = makeShow("Maude", archie);
        makeShow("Good Times", maude);
        makeShow("Gloria", archie);
        makeShow("Archie Bunker's Place", archie);
        
        happy = makeShow("Happy Days", root);
        makeShow("Mork and Mindy", happy);
        makeShow("Laverne and Shirley", happy);
        makeShow("Joanie Loves Chachi", happy);
        
        tree1= new JTree(root);
        tree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree1.setVisibleRowCount(12);
        tree1.addTreeSelectionListener(e -> tree1Changed());
        
        JScrollPane scroll = new JScrollPane(tree1);
        panel1.add(scroll);
       */
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
            DefaultMutableTreeNode root1, tag1, tempTag, pic;
            root1 = new DefaultMutableTreeNode("Tags");
            System.out.println(namesToNodes.size());
            System.out.println(namesToNodes.values());
           
          //  System.out.println(namesToNodes.keySet(0));
            for(int i = 0; i< namesToNodes.size();i++){
                System.out.println(keyList.get(i));
                DefaultMutableTreeNode getTagTree = new DefaultMutableTreeNode(keyList.get(i));
                System.out.println(getTagTree);
                tempTag = addPhoto(keyList.get(i), root1);   
                String tempString = namesToNodes.get(keyList.get(i)).toString();
                System.out.println(tempString);
                String[] tempString2 = tempString.split("");
                System.out.println(tempString2.length);
                System.out.println(tempString2.toString());
                tempVals.add(namesToNodes.get(keyList.get(i)).toString());
                System.out.println(tempVals);
                tempVals.spliterator();
                tempVals.spliterator();
                System.out.println(tempVals);
                System.out.println(tempVals.size());
//this.model.insertNodeInto(getTagTree, root1, root1.getChildCount());   
             //need to insert inner loop to add values under parent nodes
             //  ArrayList<String> tempList = new ArrayList<String>();
              // tempList = (ArrayList<String>) namesToNodes.values();
        //   for(int j = 0 ; j< namesToNodes.get(i).;i++){
            }
           //this.model.insertNodeInto(new DefaultMutableTreeNode(tag.getValue()), getTagTree, getTagTree.getChildCount());
           
           
            
            tag1 = addPhoto(tag, root1);   
            System.out.println(tag1);
           pic = addPhoto("New Pic", tag1); 
           
           tree2 = new JTree(root1);
           tree2.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
           tree2.setVisibleRowCount(18);
           tree2.addTreeSelectionListener(e -> tree1Changed());
         
           JPanel panel2 = new JPanel ();
           panel2.setSize(250,200);
           JScrollPane scroll = new JScrollPane(tree2);
           scroll.setPreferredSize(new Dimension(200, 200));
         
           panel2.add(scroll);
           
       
           this.add(panel2);
           this.validate();
           this.repaint();
        
        
    }
}
}
    
    