/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mipics;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class Tree1{
    public static void main(String[] args){
        DefaultTreeModel model = null;

        final File serFile = new File("TreeDemo.ser"); 

        if( serFile.exists() ){
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serFile));
                model = (DefaultTreeModel)ois.readObject();
                ois.close();
            }
            catch(IOException err){
                err.printStackTrace();
            }
            catch(ClassNotFoundException err){
                err.printStackTrace();
            }
        }

        if(model == null){
            model = new DefaultTreeModel(new DefaultMutableTreeNode("root"));
        }

        final DefaultTreeModel innerModel = model;

        JFrame frame = new JFrame("Tree Demo");
        final JTree tree = new JTree(model);
        tree.setEditable(true);
        final JTextField editor = new JTextField();
        final Runnable activateEditor = new Runnable(){
            public void run(){
                editor.requestFocus();
                editor.setSelectionStart(0);
                editor.setSelectionEnd(editor.getText().length());
            }
        };

        tree.setCellEditor(new DefaultCellEditor(editor));
        frame.getContentPane().add(new JScrollPane(tree));
        tree.registerKeyboardAction( new ActionListener(){
            public void actionPerformed(ActionEvent event){
                TreePath path = tree.getLeadSelectionPath();
                System.out.println(path);
                if( path == null ){
                    return;
                }
                Object last = path.getLastPathComponent();
                if( !(last instanceof DefaultMutableTreeNode) ){
                    return;
                }
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)last;
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New Node");
                innerModel.insertNodeInto(newNode,node,node.getChildCount());
                TreePath newPath = path.pathByAddingChild(newNode);
                tree.makeVisible(newPath);
                tree.startEditingAtPath(newPath);
                SwingUtilities.invokeLater(activateEditor);
            }
        },"Add Item",KeyStroke.getKeyStroke(KeyEvent.VK_INSERT,0),JComponent.WHEN_FOCUSED);

        tree.registerKeyboardAction( new ActionListener(){
            public void actionPerformed(ActionEvent event){
                TreePath path = tree.getLeadSelectionPath();
                if( path == null ){
                    return;
                }
                Object last = path.getLastPathComponent();
                if( !(last instanceof DefaultMutableTreeNode) ){
                    return;
                }
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)last;
                innerModel.removeNodeFromParent(node);
            }
        },"Delete Item",KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0),JComponent.WHEN_FOCUSED);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosed(WindowEvent event){
                try{
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serFile));
                    oos.writeObject(innerModel);
                    oos.close();
                }
                catch(IOException err){
                    err.printStackTrace();
                }
                System.exit(0);
            }
        });

        frame.pack();
        JButton modifyTest = new JButton("Modify Node");
        frame.getContentPane().add(modifyTest,BorderLayout.SOUTH);
        modifyTest.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent event){
                TreePath path = tree.getLeadSelectionPath();
                Object last = path.getLastPathComponent();
                if( !(last instanceof DefaultMutableTreeNode) ){
                    return;
                }
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)last;
                node.setUserObject((String)node.getUserObject()+"WWWWWWWWWW");
                innerModel.nodeChanged(node); 
            }
        });
        frame.setVisible(true);
    }
} 