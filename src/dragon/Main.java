/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

    public static void main(String[] a, Object Graphics) {
       
        //   Map map = new Map();
        Graphics2D g2d = null;
        Entity dragon = new Entity(6, 6, 3);

        JFrame f = new JFrame();
        f.setSize(400, 400);
        f.add(new Map());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);      

        
        

        
    }

//   public void paint(Graphics g) {
//      g.fillRect (5, 15, 50, 75);
//   }
}