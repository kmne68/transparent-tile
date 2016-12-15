/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon;

import javax.swing.JPanel;

/**
 *
 * @author Keith
 */
public class StartPanel extends JPanel {
    
    private StartPanelListener listener;
    
    public StartPanel() {
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        
        jLabelTitle = new javax.swing.JLabel();
        jButtonStart = new javax.swing.JButton();
        
        jLabelTitle.setFont(new java.awt.Font("Lucida Grande", 0, 24));
        jLabelTitle.setText("Dragon");
        
        jButtonStart.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jButtonStart.setText("Start");
        JButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });  
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup())
                .addContainerGap(151, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButtonStart)
                .addGap(141, 141, 141))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabelTitle)
                .addGap(108, 108, 108)))
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabelTitle)
                .addGap(18, 18, 18)
                .addComponent(jButtonStart)
                .addContainerGap(121, Short.MAX_VALUE))
                );
    }
    
    private void jButtonActionPerformed(java.awt.event.ActionEvent evt)
            System.out.println("Hello");
    fireStartGame();
    
   
}
