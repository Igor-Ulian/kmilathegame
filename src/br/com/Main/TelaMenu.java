package br.com.Main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Particular
 */
public class TelaMenu extends javax.swing.JFrame {
    public TelaMenu() {
        initComponents();
        setLocation(Variaveis.telap1, Variaveis.telap2);
        setResizable(false);
        dinheiros.setText("$" + VariaveisLoja.getDinheiro());
        dano.setText("" + Variaveis.getDamage());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
          Variaveis.musicMenu = true;
          Variaveis.musicBattle = false; 
          if(Variaveis.music == true){
              audio.play();
          }          
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
               int soun = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair? Todo o progresso será perdido!","Certeza",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                if (soun == JOptionPane.YES_OPTION){ 
                    e.getWindow().dispose();
                    System.exit(0);                   
                }
                audio.stop();
                              
            }         
});   
        Color cor = new Color(26, 27, 29);   
          getContentPane().setBackground(cor);
        ImageIcon iconicone = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/KmilaImgs/KmilaGorda30x30.png"));
        iconicone.getImage().flush();
        setIconImage(iconicone.getImage());   
        
      if(Variaveis.getMusic() == true){
        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/IcnImgs/Som.png"));
        icon.getImage().flush();
        Musica.setIcon( icon );
      }else{
        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/IcnImgs/SomOff.png"));
        icon.getImage().flush();
        Musica.setIcon( icon );
      }
    }  
    
        URL url = getClass().getResource("/br/com/Main/Musicas/MenuMusic.wav");
        AudioClip audio = Applet.newAudioClip(url);

        
    public void exit(){
        
               int soun = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair? Todo o progresso será perdido!","Certeza",JOptionPane.YES_NO_OPTION);
                if (soun == JOptionPane.NO_OPTION){
                    return;
                }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        danotxt = new javax.swing.JLabel();
        loja = new javax.swing.JButton();
        sla = new javax.swing.JButton();
        batalhar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        dinheirostxt = new javax.swing.JLabel();
        Musica = new javax.swing.JButton();
        dinheiros = new javax.swing.JLabel();
        dano = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Haettenschweiler", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Main/Imagens/TxtImgs/Menu.png"))); // NOI18N

        danotxt.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        danotxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Main/Imagens/TxtImgs/Dano.png"))); // NOI18N

        loja.setForeground(new java.awt.Color(255, 255, 255));
        loja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Main/Imagens/IcnImgs/Moeda.png"))); // NOI18N
        loja.setText("LOJA");
        loja.setBorder(null);
        loja.setBorderPainted(false);
        loja.setContentAreaFilled(false);
        loja.setFocusPainted(false);
        loja.setFocusable(false);
        loja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lojaActionPerformed(evt);
            }
        });

        sla.setForeground(new java.awt.Color(255, 255, 255));
        sla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Main/Imagens/IcnImgs/Globo.png"))); // NOI18N
        sla.setText("Rank");
        sla.setBorder(null);
        sla.setBorderPainted(false);
        sla.setContentAreaFilled(false);
        sla.setFocusPainted(false);
        sla.setFocusable(false);
        sla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slaActionPerformed(evt);
            }
        });

        batalhar.setForeground(new java.awt.Color(255, 255, 255));
        batalhar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Main/Imagens/IcnImgs/Faquinha.png"))); // NOI18N
        batalhar.setText("Batalhar");
        batalhar.setBorder(null);
        batalhar.setContentAreaFilled(false);
        batalhar.setFocusPainted(false);
        batalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalharActionPerformed(evt);
            }
        });

        dinheirostxt.setFont(new java.awt.Font("8BIT WONDER", 0, 14)); // NOI18N
        dinheirostxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Main/Imagens/TxtImgs/DinheirosMenu.png"))); // NOI18N

        Musica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Main/Imagens/IcnImgs/Som.png"))); // NOI18N
        Musica.setBorder(null);
        Musica.setContentAreaFilled(false);
        Musica.setFocusPainted(false);
        Musica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MusicaActionPerformed(evt);
            }
        });

        dinheiros.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        dinheiros.setForeground(new java.awt.Color(255, 255, 255));
        dinheiros.setText("X");

        dano.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        dano.setForeground(new java.awt.Color(255, 255, 255));
        dano.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(Musica, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loja, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(batalhar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sla, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(danotxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dano, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dinheirostxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dinheiros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(132, 132, 132)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Musica, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dinheiros)
                    .addComponent(dinheirostxt))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(danotxt)
                    .addComponent(dano))
                .addGap(34, 34, 34)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loja, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sla, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batalhar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lojaActionPerformed
        // TODO add your handling code here:
        Variaveis.telap1 = (int) getLocation().getX();
        Variaveis.telap2 = (int) getLocation().getY();
        TelaLoja loja = new TelaLoja();
        loja.setVisible(true);
        setVisible(false);
        audio.stop();
    }//GEN-LAST:event_lojaActionPerformed

    private void slaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slaActionPerformed
        TelaRanking tn = new TelaRanking();
        tn.setVisible(true);
        setVisible(false);
        audio.stop();
    }//GEN-LAST:event_slaActionPerformed

    private void batalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalharActionPerformed
        // TODO add your handling code here: 
        Variaveis.telap1 = (int) getLocation().getX();
        Variaveis.telap2 = (int) getLocation().getY();
        
        TelaBatalha telaBatalha = new TelaBatalha();
        telaBatalha.setVisible(true);
        setVisible(false);
        audio.stop();
    }//GEN-LAST:event_batalharActionPerformed

    private void MusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MusicaActionPerformed
      if(Variaveis.getMusic() == false){
        Variaveis.music = true;
        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/IcnImgs/Som.png"));
        icon.getImage().flush();
        Musica.setIcon( icon );
        audio.play();
      }else{
        Variaveis.music = false;
        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/IcnImgs/SomOff.png"));
        icon.getImage().flush();
        Musica.setIcon( icon );
        audio.stop();
      }
        
    }//GEN-LAST:event_MusicaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Musica;
    private javax.swing.JButton batalhar;
    private javax.swing.JLabel dano;
    private javax.swing.JLabel danotxt;
    private javax.swing.JLabel dinheiros;
    private javax.swing.JLabel dinheirostxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loja;
    private javax.swing.JButton sla;
    // End of variables declaration//GEN-END:variables

}
