/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mipics;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
import javax.swing.event.*;
 import java.awt.image.*;
 import javax.swing.filechooser.*;
 import java.io.*;
/**
 *
 * @author Andrew
 */
class ImageBox extends Canvas implements ImageObserver{
    
  private Image img;
  public void paint(Graphics g){
  
            int iw=img.getWidth(null);
            int ih=img.getHeight(null);
            if (iw>800) iw=500;
            if (ih>800) ih=500;
            g.drawImage(img,0,0,iw,ih,this);
           
   }

 public Image selImage(String filename, Component c){
           
            return(c.getToolkit().getImage(filename));
           
            }
 public void readImage(String filename){
              img=selImage(filename, this);    
            }
}

 class  MainInter extends JFrame implements ActionListener,ListSelectionListener{
            JFrame frame;
            JList imglist;
            JButton addbt;
            DefaultListModel listmodel;
            JLabel lbl;
            JScrollPane scr;
            JPanel panel;
            ImageBox imgb;
           
       MainInter(){
    frame=new JFrame("Image Viwer");
        imgb=new ImageBox();
        listmodel=new DefaultListModel();
        addbt=new JButton("Add image...");
      addbt.addActionListener(this);
        addbt.setBounds(10,350, 100, 30);
        lbl=new JLabel("<html><font color='blue'>Image List</font></html>");
        lbl.setBounds(10,3,100,30);
        addToList(listmodel);
        imglist=new JList(listmodel);  
        imglist.setVisibleRowCount(20);
        imglist.addListSelectionListener(this);
        frame.setLayout(null);
        panel=new JPanel();
        panel.setBounds(10,33,270,300);
        scr=new JScrollPane(imglist);
        panel.add(scr);        
        frame.add(panel); //show the drawing
        imgb.setBounds(300,33,500,300);
        frame.add(imgb); //show the drawing
        frame.add(addbt);
        frame.add(lbl);
        frame.setSize(850,450);
        frame.setResizable(false);
        //frame.setExtendedState(frame.getExtendedState() | frame.MAXIMIZED_BOTH);
        frame.addWindowListener(new Listener());
        frame.setVisible(true);
        imglist.setSelectedIndex(0);          
            }
public void actionPerformed(ActionEvent e){
            if(e.getSource()==addbt) showFileDialog(frame);
           
                       
}

 public void valueChanged(ListSelectionEvent e){
            loadImage(imglist.getSelectedValue().toString());
           
}

public void loadImage(String filename){
            imgb.readImage(filename);           
            imgb.repaint();
            }
 static class Listener extends WindowAdapter{


 public void windowClosing(WindowEvent event){

            System.exit(0);

                  }

       }
 public void addToList(DefaultListModel listmodel){
         
  try{ //catch errors if any
            String text;
            FileReader fr=new FileReader("imagefiles.txt");
            BufferedReader br=new BufferedReader(fr);
            while ((text=br.readLine())!=null){
                        //Read  lines of string from the file using readLine() method
                        listmodel.addElement(text);
           
             }
            br.close();//close file using close() method
            fr.close();    
     } catch(Exception ie){System.out.println("IO problem!");ie.printStackTrace();}

  }


 public static void saveToFile(String filename,String text){
   try{ //catch errors if any
    FileWriter fw=new FileWriter(filename,true); 
     BufferedWriter bw=new BufferedWriter(fw);
     bw.write(text);//write text to the file using write method
     bw.newLine();//new line writing
     bw.flush();//write any buffered text to the file
     bw.close();//close file using close() method  
    }catch(IOException ie){System.out.println("Error in writing to file...");}      
}


 public void showFileDialog(Frame frame){
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(frame);
    if(returnVal == JFileChooser.APPROVE_OPTION) {     
            saveToFile("imagefiles.txt",chooser.getSelectedFile().toString());
                         listmodel.addElement(chooser.getSelectedFile().toString());
           
         }
 }

}

 public class ImageViewer{
 
public static void main(String args[]){
     new MainInter();
  
}


}