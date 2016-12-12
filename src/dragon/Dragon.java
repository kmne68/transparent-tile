/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon;

import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Keith
 */
public class Dragon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Graphics g;
        
        
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(30, 30, 300, 300);
        mainFrame.getContentPane().add(new Map());
        mainFrame.setVisible(true);
        
    }
}