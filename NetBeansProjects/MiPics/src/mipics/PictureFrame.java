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
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
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
    private JTree tree2;
    private File file;

    public static void main (String [] args){
    
        new PictureFrame();
       
    }
    
    public PictureFrame(){
        this.setSize(600,600);
        this.setTitle("Picture Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
 
    public void tree1Changed()
    {
        Object o =tree2.getLastSelectedPathComponent();
        DefaultMutableTreeNode show;
        show = (DefaultMutableTreeNode) o;
        String title = (String) show.getUserObject();
        showName.setText(title);
    }
   
	

    /**
     *
     * @param tag
     */
    public void addTag() {
        
        String gettag = textTag.getText();
        Tag tag = new Tag(gettag, file.toString());
        System.out.println(tag.getType());
        System.out.println(file);       
//String fileName = getImageFile(file); 
     //  tag = tag.setValue(gettag);
        if (gettag.length() ==0)
        {
            JOptionPane.showMessageDialog(PictureFrame.this, "Please enter a Tag","Error", JOptionPane.INFORMATION_MESSAGE);
            
        }
    else
        {
            System.out.println(gettag); 
            DefaultMutableTreeNode root1, tag1, pic;
            root1 = new DefaultMutableTreeNode("Tags");
           tag1 = makeShow(tag.getType(), root1);   
           pic = makeShow(tag.getValue(), tag1); 
           tree2 = new JTree(root1);
           tree2.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
           tree2.setVisibleRowCount(12);
           tree2.addTreeSelectionListener(e -> tree1Changed());
         
           JPanel panel2 = new JPanel ();
           JScrollPane scroll = new JScrollPane(tree2);
           scroll.setPreferredSize(new Dimension(150, 200));
           panel2.add(scroll);
       
           this.add(panel2, BorderLayout.WEST);
           this.validate();
           this.repaint();
        
        
    }
    }
   
}

