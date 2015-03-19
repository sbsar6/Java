
package bordercontrol;

import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;

public class BorderControl extends JFrame{


    public BorderControl(String title) {
        super(title);
        
        JLabel Etched = new JLabel("Etched",JLabel.CENTER);
        JLabel Titled = new JLabel("Titled", JLabel.CENTER);
        JLabel Line = new JLabel("Line",JLabel.CENTER);
        
        Etched.setVerticalAlignment(JLabel.CENTER);
        Titled.setVerticalAlignment(JLabel.CENTER);
        Line.setVerticalAlignment(JLabel.CENTER);
        
        Etched.setBorder(BorderFactory.createEtchedBorder(50, Color.PINK, Color.DARK_GRAY));
        Titled.setBorder(BorderFactory.createTitledBorder("MOTHERFUCKER"));
        Line.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));
        
        setLayout(new GridLayout(3,1));
        add (Etched);
        add (Titled);
        add (Line);
       
       pack();
    }
    
    public static void main(String[] args) {
        
        BorderControl myFrame = new BorderControl("Suck It");
        myFrame.setSize(200,200);
        myFrame.setVisible(true);
    }
}
