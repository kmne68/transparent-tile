/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 *
 * @author Keith
 */
public class Entity {
    
    private int height;
    private int width;
    private int radius;
    
    public Entity(int width, int height, int radius) {
        
        this.width = width;
        this.height = height;
        this.radius = radius;
    }
    
    public Shape drawShape(int width, int height) {
        
        Rectangle entity = new Rectangle(width, height);
        
        return entity;
    }
    
    public void drawCenteredCircle(Graphics2D g, int width, int height, int radius) {
        width = width-(radius/2);
        height = height-(radius/2);
        g.fillOval(width,height,radius,radius);
    }
    
}
