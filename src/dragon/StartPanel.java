/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Keith
 */
public class StartPanel extends JPanel {
    
    private JButton btnStart;
    private JLabel lblTitle;
    
    private StartPanelListener listener;
    
    public StartPanel() {
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        
        lblTitle = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        
        lblTitle.setFont(new java.awt.Font("Lucida Grande", 0, 24));
        lblTitle.setText("Dragon");
        
        btnStart.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });  
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup())
                .addContainerGap(151, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnStart)
                .addGap(141, 141, 141))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblTitle)
                .addGap(108, 108, 108)))
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(btnStart)
                .addContainerGap(121, Short.MAX_VALUE))
                );
    }
    
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {
        
        System.out.println("Hello");
        fireStartGame();
    }
    
    
    public void setLisener(StartPanelListener listener) {
        
        this.listener = listener;
    }
    
    
    private void fireStartGame() {
        
        if(listener != null) listener.startGame();
    }
   
}
