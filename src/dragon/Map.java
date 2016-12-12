/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author Keith
 */
public class Map extends JComponent {
    
    public int tileWidth = 30;
    public int tileHeight = 30;
    public int mapLength = 10;
    public int mapWidth = 10;
    

//   public void paint(Graphics g) {
//      g.fillRect (15, 15, 50, 50);
//   }
    

    
    public void paint(Graphics g) {
        
        Graphics2D g2d = (Graphics2D)g;
        float thickness = 3;
  //      g2d.setStroke(new BasicStroke(thickness));
        
            for(int i = 0; i <= 5; i++) {   
                for (int j = 0; j <= 5; j++) {
                    g2d.setColor(Color.black);
                    g2d.drawRect(i * tileWidth, j * tileHeight, tileWidth, tileHeight);
                    g2d.setStroke(new BasicStroke(thickness));
                    g2d.setColor(Color.yellow);
                    g2d.fillRect(i * tileWidth, j * tileHeight, tileWidth, tileHeight);  
                }
            } 
    }
}

/*Graphics2D g2;
double thickness = 2;
Stroke oldStroke = g2.getStroke();
g2.setStroke(new BasicStroke(thickness));
g2.drawRect(x, y, width, height);
g2.setStroke(oldStroke); */