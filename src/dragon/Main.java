/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

   public static void main(String[] a) {
       
    //   Map map = new Map();
       
      JFrame f = new JFrame();
      f.setSize(400, 400);
      f.add(new Map());
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
      
   //   map.paint(null);
    //  map.drawMap(null);
   }

//   public void paint(Graphics g) {
//      g.fillRect (5, 15, 50, 75);
//   }
}