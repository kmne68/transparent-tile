/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author Keith
 */
public class Game extends JComponent {
    
    private Ellipse2D.Double dragon = new Ellipse2D.Double(100, 100, 15, 15);
    private RoundRectangle2D.Double character = new RoundRectangle2D.Double(200, 200, 100, 10, 20, 20);
    
    private Map map = new Map();
    
    private double speed = 10.0;
    private int xDirectionDragon = 1;
    private int yDirectionDragon = 1;
    private double characterSpeed = 10;
    private BufferedImage buffer;
    private boolean checkIntersection = true;
    
    public Game() {
        
        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent me) {

            }

            @Override
            public void mouseMoved(MouseEvent me) {
                character.x = me.getX() - character.getWidth() / 2;
                character.y = me.getY() - character.getHeight() / 2;
            }            
        });
        
        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent me) {
                
                dragon.x = me.getX();
                dragon.y = me.getY();
            }
        });
        
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                
                int key = ke.getKeyCode();
                
                switch(key) {
                    case KeyEvent.VK_UP:
                        character.y -= characterSpeed;
                        break;
                    case KeyEvent.VK_DOWN:
                        character.y += characterSpeed;
                        break;
                    case KeyEvent.VK_LEFT:
                        character.x -= characterSpeed;
                        break;
                    case KeyEvent.VK_RIGHT:
                        character.x += characterSpeed;
                        break;
                }
                return false;
            } // end dispatchKeyEvent
        });
        
        addComponentListener(new ComponentAdapter() {
            
            public void componentResized(ComponentEvent ce) {
                
                buffer = null;
            }
        });
        
        Cursor hiddenCursor = getToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "");
        setCursor(hiddenCursor);
    } // end Game constructor
    
    @Override
    protected void paintComponent(Graphics g) {
        
        if(buffer == null) {
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        
  //      map.paint(g);
        
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        
        g2.setRenderingHint
                (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.BLACK);
        
        // fill background
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        g2.setColor(Color.RED);
        g2.fill(dragon);
        
        g2.setColor(Color.BLUE);
        g2.fill(character);
        
        g.drawImage(buffer, 0, 0, null);
    }
    
    
    public void update() {
        
        dragon.x += xDirectionDragon * speed;
        dragon.y += yDirectionDragon * speed;
        
        if(dragon.x < 0) {
            xDirectionDragon = 1;
            dragon.x = 0;
        }
        else if(dragon.x + dragon.getBounds().width > getWidth()) {
            xDirectionDragon = -1;
            dragon.x = getWidth() - dragon.getBounds().width;
        }
        
        if(dragon.y < 0) {
            
            yDirectionDragon = 1;
            dragon.y = 0;
        }
        else if (dragon.y + dragon.getBounds().height > getHeight()) {
            yDirectionDragon = -1;
            dragon.y = getHeight() - dragon.getBounds().height;
        }
        
        if(dragon.intersects(dragon.getBounds())) {
            if(checkIntersection) {
                xDirectionDragon = -xDirectionDragon;
                yDirectionDragon = -yDirectionDragon;
                checkIntersection = false;
            }
            else {
                checkIntersection = true;
            }
        }
        
        repaint(); // saves time vs calling paintComponent
    } // end update
    
    
    @Override
    public void update(Graphics g) {
        paint(g);
    }
    
}
