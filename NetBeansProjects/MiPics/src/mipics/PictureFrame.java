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
/**
 *
 * @author Andrew
 */
public class PictureFrame extends JFrame {
    
    Image img;
    JButton getPictureButton;
    JButton getTag;
              

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
    
    private String getImageFile(){
        

        String userhome = System.getProperty("user.home");
        JFileChooser fc = new JFileChooser(userhome+"\\Pictures");
        ImagePreview preview = new ImagePreview(fc);
        fc.addPropertyChangeListener(preview);
        fc.setAccessory(preview);
        fc.setFileFilter(new ImageFilter());
        int result = fc.showOpenDialog(null);
        File file = null;
        if (result == JFileChooser.APPROVE_OPTION){
            file = fc.getSelectedFile();
            return file.getPath();
        }
        else
            return null;
        
    }

    private void addTag() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     private class PicturePanel extends JPanel{
         public void paint(Graphics g){
             g.drawImage(img, 0, 0, this);
         }
         
     }

     private class ImageFilter extends javax.swing.filechooser.FileFilter{
         public boolean accept (File f){
             if (f.isDirectory())
                 return true;
             String name = f.getName();
             if (name.matches(".*((.jpg)|(.gif)|(.png))"))
                     return true;
             else
             return false;
             
         }
         public String getDescription(){
             return "Image files (*.jpg, *.gif, *.png)";
         }
     }
}
