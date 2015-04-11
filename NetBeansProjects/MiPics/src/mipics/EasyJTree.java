/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mipics;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Andrew
 */
public class EasyJTree extends JTree{
    
    //create map of names to node objects
  



    public EasyJTree() {
        
   

//create root of tree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("");
        this.setModel(new DefaultTreeModel(root));
 
        //add to map
        namesToNodes.put("Picture Album", root);
    }
 
    //get node object with name
    private DefaultMutableTreeNode getNode(String name) {
        //make lowercase
        //name = name.toLowerCase();
 
        //get node from map
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)(namesToNodes.get(name));
 
        //if not defined
        if(node == null) {
            //create new node
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(name);
 
            //add to map
            namesToNodes.put(name, newNode);
 
            //return new node
            return newNode;
        } else {
            //return old node
            return node;
        }
    }
 
    public void expandRoot() {
        //expand path to root
        expandPath(new TreePath(getNode("root")));
    }
 
    //add first node to second node
    public void addNodeTo(String childNodeName, String parentNodeName) {
        //get two nodes
        DefaultMutableTreeNode parentNode = getNode(parentNodeName);
        DefaultMutableTreeNode childNode = getNode(childNodeName);
 
        //add child to parent at the end of child list
        ((DefaultTreeModel)getModel()).insertNodeInto(childNode, parentNode, parentNode.getChildCount());
    }
 
    
    public static void main(String[] args){
        new EasyJTree();
    }
}
