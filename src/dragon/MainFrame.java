/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 *
 * @author Keith
 */

/*
public class MainFrame extends JFrame implements ActionListener {
    
    private Timer timer;
    long startTime;
    long relativeTime;
    private Game game;
    private StartPanel startPanel;
    private CardLayout cards;
    private Map map;
    
    MainFrame() {
        super("Dragon");
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MotifLookAndFeel");
        } catch (Exception e) {
            System.out.println("Cannot set look and feel");
        }
        
        cards = new CardLayout();
        startPanel = new StartPanel();
        game = new Game();
        map = new Map();
        
        startPanel.setListener(new StartPanelListener() {
            
            @Override
            public void startGame() {
                
                cards.show(MainFrame.this.getContentPane(), "game");
            }
        });
        
   /*     timer = new Timer(20, this);
        timer.setInitialDelay(100);
        
        setSize(600, 500);
        setLayout(cards);
        
        add(startPanel, "start");
        add(map, "map");
 //       add(game, "game");
        
        timer.start();
        
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    } 

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        game.update();
    }
    
    
}*/