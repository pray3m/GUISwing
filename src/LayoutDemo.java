/*
Layout Managers : 
1. Border Layout
2. Grid Layout
3. Flow Layout
4. Box Layout
 */

/* Uncomment each line for experimenting the different types of layouts */

import javax.swing.*;
import java.awt.*;

public class LayoutDemo {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(400,600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());
        
        JPanel p1 = new JPanel();
        
        JPanel  redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        JLabel redLabel = new JLabel("Red panel");
        redPanel.add(redLabel);
        p1.add(redPanel);

        JPanel  bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        JLabel blueLabel = new JLabel("Blue panel");
        bluePanel.add(blueLabel);
        p1.add(bluePanel);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        JLabel greenLabel = new JLabel("Green panel");
        greenPanel.add(greenLabel);
        p1.add(greenPanel);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);
        JLabel yellowLabel = new JLabel("Yellow panel");
        yellowPanel.add(yellowLabel);
        p1.add(yellowPanel);

        JPanel orangePanel = new JPanel();
        orangePanel.setBackground(Color.ORANGE);
        JLabel orangeLabel = new JLabel("Orange panel");
        orangePanel.add(orangeLabel);
        p1.add(orangePanel);

        JPanel pinkPanel = new JPanel();
        pinkPanel.setBackground(Color.PINK);
        JLabel pinkLabel = new JLabel("Pink panel");
        pinkPanel.add(pinkLabel);
        p1.add(pinkPanel);

        JPanel purplePanel = new JPanel();
        purplePanel.setBackground(Color.MAGENTA);  // Magenta is used for "purple" in Java
        JLabel purpleLabel = new JLabel("Purple panel");
        purplePanel.add(purpleLabel);
        p1.add(purplePanel);

        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);
        JLabel cyanLabel = new JLabel("Cyan panel");
        cyanPanel.add(cyanLabel);
        p1.add(cyanPanel);
        
        /* Flow Layout */
//        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
//        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
//        p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        /* Box Layout */
//        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS))
//        p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
        
        /* Grid Layout */
//        p1.setLayout(new GridLayout(2,4));
        p1.setLayout(new GridLayout(8,1, 20,12));
        
        /*Border Layout */
        jf.add(p1, BorderLayout.CENTER);
//        jf.add(p1,BorderLayout.NORTH);
//        jf.add(p1, BorderLayout.EAST);
//        jf.add(p1, BorderLayout.WEST);
//        jf.add(p1, BorderLayout.SOUTH);

        jf.setVisible(true);
    }
}
