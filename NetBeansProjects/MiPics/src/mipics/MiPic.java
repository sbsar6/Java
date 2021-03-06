/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mipics;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import mipics.ImagePreview;


 /*** @author Andrew
 */
public class MiPic extends javax.swing.JFrame {
    
    private JFileChooser jfc;
    private Image img;
    /**
     * Creates new form MiPic
     */
    public MiPic() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSP = new javax.swing.JScrollPane();
        frame = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        textTag = new javax.swing.JTextField();
        getTag = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tree2 = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMI_Open = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Open Photo");

        textTag.setText("jTextField1");

        getTag.setText("Tag Photo");
        getTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getTagActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textTag, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getTag)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(textTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getTag))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout frameLayout = new javax.swing.GroupLayout(frame);
        frame.setLayout(frameLayout);
        frameLayout.setHorizontalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frameLayout.setVerticalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameLayout.createSequentialGroup()
                .addGap(0, 241, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSP.setViewportView(frame);

        jScrollPane1.setViewportView(tree2);

        jMenu1.setText("File");

        jMI_Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, 0));
        jMI_Open.setText("Open");
        jMI_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_OpenActionPerformed(evt);
            }
        });
        jMenu1.add(jMI_Open);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSP, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
JLabel jlab = new JLabel();
    private void jMI_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_OpenActionPerformed
    
       
        try{
            String userhome = System.getProperty("user.home");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image file only","JPEG file", "jpg", "jpeg","gif", "png");
            JFileChooser fileChooser = new JFileChooser(userhome+"\\Pictures");
            ImagePreview preview = new ImagePreview(fileChooser);
            fileChooser.addPropertyChangeListener(preview);
            fileChooser.setAccessory(preview);
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int returnValue = fileChooser.showOpenDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION){
                
                File file = fileChooser.getSelectedFile();
                updateImage(file);
                BufferedImage image = ImageIO.read(file);
                Dimension sz = new Dimension(300,300);
                setPreferredSize(sz);
                
          try {
            System.out.println("updating");
                     updateImage(file);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } 
            if(file == null) {
            return;
        }
        JFrame frame1 = new JFrame();
        frame1.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon(image));
        frame1.add(label);
        frame1.setVisible(true);
        frame.add(frame1);
        img = ImageIO.read(file);
        img = img.getScaledInstance(300, -1, Image.SCALE_SMOOTH);
        repaint();
        
               
        }
        }
        catch (HeadlessException | IOException e) {System.out.println(e);}
    } 
   public DefaultMutableTreeNode makeShow(String title, DefaultMutableTreeNode parent)
    {
        DefaultMutableTreeNode show;
        show = new DefaultMutableTreeNode(title);
        parent.add(show);
        return show;
    }  
        
public void propertyChange(PropertyChangeEvent evt) {
        
    }
    
    public void updateImage(File file) throws IOException {
        
    }
    
    public void paintComponent(Graphics g) {
        // fill the background
        g.setColor(Color.gray);
        g.fillRect(0,0,getWidth(),getHeight());
        
        if(img != null) {
            // calculate the scaling factor
            int w = img.getWidth(null);
            int h = img.getHeight(null);
            int side = Math.max(w,h);
            double scale = 200.0/(double)side;
            w = (int)(scale * (double)w);
            h = (int)(scale * (double)h);
            
            // draw the image
            g.drawImage(img,0,0,w,h,null);
            
            // draw the image dimensions
            String dim = w + " x " + h;
            g.setColor(Color.black);
            g.drawString(dim,31,196);
            g.setColor(Color.white);
            g.drawString(dim,30,195);
            
        } else {
            
            // print a message
            g.setColor(Color.black);
            g.drawString("Not an image",30,100);
        }
    
   /*     BufferedImage image;
        try{
            String userhome = System.getProperty("user.home");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image file only","JPEG file", "jpg", "jpeg");
            JFileChooser fileChooser = new JFileChooser(userhome+"\\Pictures");
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int returnValue = fileChooser.showOpenDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION){
                
                File file = fileChooser.getSelectedFile();
                
                image = ImageIO.read(file);
                ImageIcon icon;
                icon = new ImageIcon(image);
                jLabel1.setIcon(icon);
               
        }
        }
        catch (HeadlessException | IOException e) {System.out.println(e);}
    }
  
            /*jlab.setIcon(new Icon (gf.toString()) {});
            jlab.setHorizontalAlignment(JLabel.CENTER);
            
            jSP.getViewport().add(jlab);*/

 
        
    }//GEN-LAST:event_jMI_OpenActionPerformed

    private void getTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getTagActionPerformed
        addTag();
    }//GEN-LAST:event_getTagActionPerformed
/*
    /**
     * @param args the command line arguments
     */
    private void addTag() {
        
        String tag = textTag.getText();
        
        if (tag.length() ==0)
        {
            JOptionPane.showMessageDialog(MiPic.this, "Please enter a Tag","Error", JOptionPane.INFORMATION_MESSAGE);
            
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
          // tree2.addTreeSelectionListener(e -> tree1Changed());
         
           JPanel panel2 = new JPanel ();
           JScrollPane scroll = new JScrollPane(tree2);
           panel2.add(scroll);
       
           this.add(panel2);
           this.validate();
           this.repaint();
        
        
    }
    
    
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MiPic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiPic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiPic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiPic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /*JFileChooser jfc = new JFileChooser();
        ImagePreview preview = new ImagePreview(jfc);
        jfc.addPropertyChangeListener(preview);
        jfc.setAccessory(preview);
        jfc.showOpenDialog(null);
        jfc.paintComponents(null);
        /* Create and display the form */
               new MiPic().setVisible(true);
            
        
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel frame;
    private javax.swing.JButton getTag;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenuItem jMI_Open;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jSP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textTag;
    private javax.swing.JTree tree2;
    // End of variables declaration//GEN-END:variables

}