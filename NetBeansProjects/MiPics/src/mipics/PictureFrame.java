/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mipics;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
/**
 *
 * @author Andrew
 */
public class PictureFrame extends JFrame {
    
    Image img;
    JButton getPictureButton;
    JButton getTag;
    private JLabel showName;

    private JTextField textTag; 
    private JTree tree;
    private DefaultTreeModel model;
    private DefaultMutableTreeNode rootNode;
    
    private File file;
    private HashMap tagList; 
    private DefaultMutableTreeNode tag1, pic;
    
    public static void main (String [] args){

        new PictureFrame();
       
    }
    
    public PictureFrame(){
        this.setSize(600,600);
        this.setTitle("Picture Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DefaultMutableTreeNode tagNode = getTagTree();
        model = new DefaultTreeModel(tagNode);
        tree = new JTree(model);
        JPanel panel2 = new JPanel ();
        JScrollPane scroll = new JScrollPane(tree);
        scroll.setPreferredSize(new Dimension(150, 200));
        panel2.add(scroll);
       
        this.add(panel2, BorderLayout.WEST);
        //this.validate();
          // this.repaint();
        
        JPanel picPanel = new PicturePanel();
        this.add(picPanel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        getPictureButton = new JButton ("Open Picture");
        getPictureButton.addActionListener(e -> getPictureButtonClick() );
        buttonPanel.add(getPictureButton);
              
        textTag = new JTextField(10);
        buttonPanel.add(textTag);
        getTag = new JButton ("Add picture tags");
        getTag.addActionListener(e -> addTag());
        buttonPanel.add(getTag);
        
        JButton ChangeTag = new JButton("Change Tag");
        ChangeTag.addActionListener(e -> changeTag());
        buttonPanel.add(ChangeTag);
        
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
        
    }
    
    public final void getPictureButtonClick(){
        String file = getImageFile();
        if (file != null){
            Toolkit kit = Toolkit.getDefaultToolkit();
            img = kit.getImage(file);
            img = img.getScaledInstance(300, -1, Image.SCALE_SMOOTH);
            this.repaint();
        }
    }
    
    public String getImageFile(){
        

        String userhome = System.getProperty("user.home");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image file only","JPEG file", "jpg", "jpeg","gif", "png");    
        JFileChooser fc = new JFileChooser(userhome+"\\Pictures");
        ImagePreview preview = new ImagePreview(fc);
        fc.addPropertyChangeListener(preview);
        fc.setAccessory(preview);
        fc.setFileFilter(filter);
        fc.setAcceptAllFileFilterUsed(false);
        int result = fc.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION){
            this.file = fc.getSelectedFile();
            return file.getPath();
        }
        else
            return null;
        
    }


     private class PicturePanel extends JPanel{
         public void paint(Graphics g){
             g.drawImage(img, 0, 0, this);
         }
         
     }

         public String getDescription(){
             return "Image files (*.jpg, *.gif, *.png)";
         }
     
public DefaultMutableTreeNode makeShow(String title, DefaultMutableTreeNode parent)
    {
        DefaultMutableTreeNode show;
        show = new DefaultMutableTreeNode(title);
        parent.add(show);
        return show;
    }
 
private DefaultMutableTreeNode getTagTree (){
  /*  while ((st = reader.readLine()) != null) {
                StringTokenizer stoke = new StringTokenizer(st);
                String sno = stoke.nextToken();
                String grandChild_name = stoke.nextToken();
                String child_id = stoke.nextToken();
                child = new DefaultMutableTreeNode(grandChild_name);
                if (child_id.equals(tempNode.toString())) {
                    tempNode.add(child);
                    NodeArr[i] = child;
                    i++;
                }
                else
                {
                    for(int k=0; k<NodeArr.length; k++){
                        if (NodeArr[k]!=null) 
                        {
                            String Nodename = NodeArr[k].toString();
                            if (Nodename.equals(child_id)){
                                tempnode1= new DefaultMutableTreeNode(grandChild_name);
                                NodeArr[k].add(tempnode1);
                            }
                        }
                    }
                    NodeArr[i] = tempnode1;
                    i++;
                }
            }
    */
    
    
    
    this.rootNode = new DefaultMutableTreeNode("Photo Albums");
    return rootNode;
}
    public void tree1Changed()
    {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
        
        if (node == null) return;
        
        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()){
            
        }
    }
   
	

    /**
     *
     * @param tag
     */
    public void addTag() {
      
        String getTagName = textTag.getText();
        Tag tag = new Tag(getTagName, file.toString());
        DefaultMutableTreeNode parent = getSelectedNode();
        //This will get selected node may need to change it to find if You can create a method that will return you all the matching nodes. You can do it by iterating over all the nodes in the tree and check if there names matches the one in the set.
/*
   public java.util.List<TreePath> find(DefaultMutableTreeNode root, Set<String> s) {
        java.util.List<TreePath> paths = new ArrayList<>();
        @SuppressWarnings("unchecked")
        Enumeration<DefaultMutableTreeNode> e = root.depthFirstEnumeration();
        while (e.hasMoreElements()) {
            DefaultMutableTreeNode node = e.nextElement();
            if (s.contains(node.toString())) {
                paths.add(new TreePath(node.getPath()));
            }
        }
        return paths;
    }
You can then call this method passing the tree node and Set of strings. Please note that you will need to cast the root to DefaultMutableTreeNode because getRoot returns Object.

java.util.List<TreePath> treePaths=   find((DefaultMutableTreeNode)tree.getModel().getRoot(), someSet);
Then iterate over treePaths and invoke removeSelectionPath to deselect the nodes

    for (TreePath treePath : treePaths) {
        tree.getSelectionModel().removeSelectionPath(treePath);
    }*/
       
        //if (parent.toString() == getTagName){
        //    model.insertNodeInto(new DefaultMutableTreeNode(getTagName),parent, parent.getChildCount());
       // }
        
        
        
        //tagList.put(tag.getType(), tag.getValue());
        System.out.println(tag.getType());
        System.out.println(file);       
//String fileName = getImageFile(file); 
     //  tag = tag.setValue(gettag);
        if (getTagName.length() ==0)
        {
            JOptionPane.showMessageDialog(PictureFrame.this, "Please enter a Tag","Error", JOptionPane.INFORMATION_MESSAGE);
            
        }
    else
        {
            System.out.println(getTagName); 
           this.model.insertNodeInto(new DefaultMutableTreeNode(getTagName), this.rootNode, this.rootNode.getChildCount());    

          // tag1 = makeShow(tag.getType(), rootNode);   
         //  pic = makeShow(tag.getValue(), tag1); 
           //tree2 = new JTree(root1);
           //tree2.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
           //tree2.setVisibleRowCount(12);
           //tree2.addTreeSelectionListener(e -> tree1Changed());
         
           //JPanel panel2 = new JPanel ();
          // JScrollPane scroll = new JScrollPane(tree2);
         //  scroll.setPreferredSize(new Dimension(150, 200));
          // panel2.add(scroll);
       
         //  this.add(panel2, BorderLayout.WEST);
          // this.validate();
          // this.repaint();
        
        
    }
    }
   private DefaultMutableTreeNode getSelectedNode(){
       return (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
       
   }
   
   private void changeTag(){
       DefaultMutableTreeNode selectedNode = getSelectedNode();
       if (selectedNode == null){
           JOptionPane.showMessageDialog(PictureFrame.this, "Select a Tag to Change", "Error", JOptionPane.ERROR_MESSAGE);
       }
       else { String newName = JOptionPane.showInputDialog(PictureFrame.this, "Enter a new tag name");
       // Insert code to replace selectedNode with newName
       }
   }
}

