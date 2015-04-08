/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mipics;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.tree.*;
import javax.swing.event.*;
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
    
    public DefaultMutableTreeNode makeShow(String title, DefaultMutableTreeNode parent)
    {
        DefaultMutableTreeNode show;
        show = new DefaultMutableTreeNode(title);
        parent.add(show);
        return show;
    }
 
    public void tree1Changed()
    {
        Object o =tree2.getLastSelectedPathComponent();
        DefaultMutableTreeNode show;
        show = (DefaultMutableTreeNode) o;
        String title = (String) show.getUserObject();
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
            System.out.println(tag); 
            DefaultMutableTreeNode root1, tag1, pic;
            root1 = new DefaultMutableTreeNode("Tags");
           tag1 = makeShow(tag, root1);   
            System.out.println(tag1);
           pic = makeShow("New Pic", tag1); 
           tree2 = new JTree(root1);
           tree2.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
           tree2.setVisibleRowCount(12);
           tree2.addTreeSelectionListener(e -> tree1Changed());
         
           JPanel panel2 = new JPanel ();
           JScrollPane scroll = new JScrollPane(tree2);
           panel2.add(scroll);
       
           this.add(panel2);
           this.validate();
           this.repaint();
        
        
    }
}
}
    
    