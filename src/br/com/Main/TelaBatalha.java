/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.io.File;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author Particular
 */
public class TelaBatalha extends javax.swing.JFrame {
           URL url = getClass().getResource("/br/com/Main/Musicas/BattleMusic.wav");
           AudioClip audio = Applet.newAudioClip(url);      
    public TelaBatalha() {
        
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaBatalha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaBatalha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaBatalha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaBatalha.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        // Nivel 
        if(Variaveis.nivel != 3 && Variaveis.nivel != 5){
        barra.setMaximum(2000 * Variaveis.nivel); 
        Nivel.setText("Nivel: " + Variaveis.nivel );
       // String imageName = "C:/Users/Particular/Desktop/Pastas/Projeto KmilaTheGame/Camilalvl" + Variavies.nivel + ".png";
       ImageIcon icon;
       if(Variaveis.nivel < 6){
           icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/KmilaImgs/Camilalvl" + Variaveis.nivel + ".png")); 
       } else{
           icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/KmilaImgs/Camilalvl5E3.png")); 
       }                   
        icon.getImage().flush();
        camila.setIcon( icon );
        }else{
        if(Variaveis.nivel == 3){
          barra.setMaximum(2000 * Variaveis.nivel * Variaveis.estagio); 
          Nivel.setText("Nivel: " + Variaveis.nivel  + "  Estágio: " + Variaveis.estagio +"/2");
          ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/KmilaImgs/Camilalvl3E" + Variaveis.estagio + ".png"));
          icon.getImage().flush();
          camila.setIcon( icon );      
            }
        if(Variaveis.nivel == 5){
          barra.setMaximum(2000 * Variaveis.nivel * Variaveis.estagio); 
          Nivel.setText("Nivel: " + Variaveis.nivel  + "  Estágio: " + Variaveis.estagio +"/3");
          ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/KmilaImgs/Camilalvl5E" + Variaveis.estagio + ".png"));
          icon.getImage().flush();
          camila.setIcon( icon );    
            }
        }
         barra.setValue(barra.getMaximum());
        ImageIcon iconicone = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/KmilaImgs/KmilaGorda30x30.png"));
        iconicone.getImage().flush();
        setIconImage(iconicone.getImage());   
        setResizable(false);
        setLocation(Variaveis.telap1, Variaveis.telap2);
        hp.setValue(1000);
        startar();
        especial.setValue(0);
        batidas.setText("" + Variaveis.getBatidas());
//        dano.setText("" + Variavies.getDamage());
        Color cor = new Color(26, 27, 29);
        // VER VER AZUl
        getContentPane().setBackground(cor);
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
        
            @Override
            public void windowClosing(WindowEvent e){
                audio.stop();
                setVisible(false);
                TelaMenu telaMenu = new TelaMenu();
                telaMenu.setVisible(true);
            }
            
});   
                
          Variaveis.musicMenu = false;
          Variaveis.musicBattle = true;
          
        if(Variaveis.music == true && Variaveis.musicBattle == true){
           audio.play(); 
        }   
        
        
    }    
    TelasEstagio2 tl = new TelasEstagio2();
    
    private void startar(){                                   
            new Thread(){
                 public void run(){
                     for (int hpv = 0; hpv <= 100; hpv++){                        
                         try {                        
                             sleep(Variaveis.getDelayKmila());
                             if(hp.getValue() >= 1){
                                 if (isVisible()){
                                     if(Variaveis.paraHP == false){
                                         hp.setValue(hp.getValue() - (1 + Variaveis.nivel));  // AQUI
                                     }                                   
                                 }                               
                             }else{
                                 if (isVisible()){
                                     JOptionPane.showMessageDialog(null, "Putz, a Kmila pulou em cima de você e te esmagou..! \n Boa sorte na proxima!", "Você Morreu!!", JOptionPane.DEFAULT_OPTION);                                
                                 VariaveisLoja.setDinheiro(VariaveisLoja.getDinheiro() + (Variaveis.getBatidas() / 10));
                                 Variaveis.setBatidas(0);
                                 setVisible(false);
                                 TelaMenu menu = new TelaMenu();
                                 menu.setVisible(true); 
                                 Variaveis.estagio = 1;
                                 }                                
                                                               
                                 return;
                             }    
                                                       
                         } catch (InterruptedException ex) {
                             Logger.getLogger(TelaBatalha.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     
                     }
                 }
                 
              
            }.start();             
    }
    
    private void estagio2(){        
        new Thread(){
            public void run(){
                for(int x = 0; x <= 10; x++){                   
                    try {
                        tl.setVisible(false);
                        int delay = (int) (Math.random() * (10000 - 1000) + 1000);                     
                        if(Variaveis.estagio == 2){
                            if(Variaveis.est2 == true){
                               tl.setVisible(true); 
                               tl.setLocation((int) (Math.random() * (1000 - 500) + 500), (int) (Math.random() * (1000 - 500) + 500));
                            }                                                
                        sleep(delay);
                        }else{
                            tl.setVisible(false);
                        }                    
                    } catch (InterruptedException ex) {}
                }
            }
            
        }.start();
    }

    
    public static void tiraHPKmila(int quant){
        barra.setValue(barra.getValue() - quant);
        if(barra.getValue() <= 0){
            // Derrotou Kmila
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        especial = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        batidas = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();
        bntbater = new javax.swing.JButton();
        btnespecial = new javax.swing.JButton();
        UIManager.put("ProgressBar.foreground", Color.YELLOW);
        hp = new javax.swing.JProgressBar();
        btnsuicidio = new javax.swing.JButton();
        Nivel = new javax.swing.JLabel();
        camila = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dinheiros = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        especial.setBackground(new java.awt.Color(51, 51, 51));
        especial.setForeground(new java.awt.Color(0, 153, 204));
        especial.setBorderPainted(false);
        especial.setRequestFocusEnabled(false);
        getContentPane().add(especial, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Main/Imagens/TxtImgs/Batidas.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 93, -1));

        batidas.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        batidas.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(batidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 130, 36, 23));

        barra.setBackground(new java.awt.Color(51, 51, 51));
        UIManager.put("ProgressBar.foreground", Color.YELLOW);
        barra.setForeground(new java.awt.Color(12,40,34));
        barra.setForeground(new java.awt.Color(153, 0, 0));
        barra.setBorderPainted(false);
        barra.setFocusable(false);
        barra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraStateChanged(evt);
            }
        });
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 450, 44));

        bntbater.setFont(new java.awt.Font("Haettenschweiler", 0, 36)); // NOI18N
        bntbater.setForeground(new java.awt.Color(204, 0, 0));
        bntbater.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Main/Imagens/BtnImgs/BtnBater.png"))); // NOI18N
        bntbater.setBorder(null);
        bntbater.setBorderPainted(false);
        bntbater.setContentAreaFilled(false);
        bntbater.setDefaultCapable(false);
        bntbater.setFocusPainted(false);
        bntbater.setFocusable(false);
        bntbater.setRequestFocusEnabled(false);
        bntbater.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntbaterMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bntbaterMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bntbaterMouseReleased(evt);
            }
        });
        bntbater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntbaterActionPerformed(evt);
            }
        });
        getContentPane().add(bntbater, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 259, 108, 53));

        btnespecial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Main/Imagens/BtnImgs/BtnEspecial.png"))); // NOI18N
        btnespecial.setBorder(null);
        btnespecial.setContentAreaFilled(false);
        btnespecial.setDefaultCapable(false);
        btnespecial.setFocusable(false);
        btnespecial.setRequestFocusEnabled(false);
        btnespecial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnespecialMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnespecialMouseReleased(evt);
            }
        });
        btnespecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnespecialActionPerformed(evt);
            }
        });
        getContentPane().add(btnespecial, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        hp.setBackground(new java.awt.Color(51, 51, 51));
        hp.setForeground(new java.awt.Color(153, 153, 0));
        hp.setBorderPainted(false);
        hp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        hp.setFocusable(false);
        hp.setRequestFocusEnabled(false);
        hp.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 323, 450, 27));

        btnsuicidio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Main/Imagens/BtnImgs/BtnDesistir.png"))); // NOI18N
        btnsuicidio.setBorder(null);
        btnsuicidio.setContentAreaFilled(false);
        btnsuicidio.setFocusPainted(false);
        btnsuicidio.setRequestFocusEnabled(false);
        btnsuicidio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnsuicidioMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnsuicidioMouseReleased(evt);
            }
        });
        btnsuicidio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuicidioActionPerformed(evt);
            }
        });
        getContentPane().add(btnsuicidio, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 278, 74, -1));

        Nivel.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        Nivel.setForeground(new java.awt.Color(255, 255, 255));
        Nivel.setText("Nivel: 1");
        getContentPane().add(Nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 0, -1, -1));
        getContentPane().add(camila, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 112, -1, 141));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Main/Imagens/TxtImgs/DinheirosBattle.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 171, 118, -1));

        dinheiros.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        dinheiros.setForeground(new java.awt.Color(255, 255, 255));
        dinheiros.setText("$0");
        getContentPane().add(dinheiros, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 171, 39, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bntbaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntbaterActionPerformed

        Variaveis.somaBatidas();
        barra.setValue((barra.getValue() - (Variaveis.getDamage())));
        batidas.setText(Integer.toString(Variaveis.getBatidas()));
//        dano.setText(Float.toString(Variavies.getDamage()));
        dinheiros.setText("$" + Variaveis.getBatidas() / 10);
        
        if (barra.getValue() <= 0){
            derrotouKmila();
        }
        if(especial.getValue() < especial.getMaximum()){
            especial.setValue(especial.getValue() + 1 + VariaveisLoja.getQApontador());    
    }//GEN-LAST:event_bntbaterActionPerformed
        
    }
    private void btnespecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespecialActionPerformed
        // TODO add your handling code here:
        if(especial.getValue() >= especial.getMaximum()){
            barra.setValue(barra.getValue() - 100 * (VariaveisLoja.getQGrifa()/ 2 + 1));
            especial.setValue(0);
        }else{
           JOptionPane.showMessageDialog(null, "Você ainda não carregou seu especial!", "", JOptionPane.ERROR_MESSAGE); 
        }
        if (barra.getValue() <= 0){
            derrotouKmila();
        }
    }//GEN-LAST:event_btnespecialActionPerformed

    private void btnsuicidioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuicidioActionPerformed
         VariaveisLoja.setDinheiro(VariaveisLoja.getDinheiro() + (Variaveis.getBatidas() / 10));
        Variaveis.setBatidas(0);
        setVisible(false);
        TelaMenu telaMenu = new TelaMenu();
        telaMenu.setVisible(false);
        telaMenu.setVisible(true);
        audio.stop();
    }//GEN-LAST:event_btnsuicidioActionPerformed

    private void bntbaterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntbaterMouseClicked

    }//GEN-LAST:event_bntbaterMouseClicked

    private void barraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_barraStateChanged

    private void bntbaterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntbaterMousePressed
        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/BtnImgs/BtnBaterPressed.png"));
        icon.getImage().flush();
        bntbater.setIcon( icon );
        Point p = camila.getLocation();
        p.y = p.y - 1;
        camila.setLocation(p);
    }//GEN-LAST:event_bntbaterMousePressed

    private void bntbaterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntbaterMouseReleased
       
        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/BtnImgs/BtnBater.png"));
        icon.getImage().flush();
        bntbater.setIcon( icon );
        Point p = camila.getLocation();
        p.y = p.y + 1;
        camila.setLocation(p);
        
    }//GEN-LAST:event_bntbaterMouseReleased
    
    private void btnespecialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnespecialMousePressed
        // TODO add your handling code here:
        
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/BtnImgs/BtnEspecialPressed.png"));
        icon2.getImage().flush();
        btnespecial.setIcon( icon2 );
        ImageIcon icon;
         if(especial.getValue() >= especial.getMaximum()){
         icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/KmilaImgs/Camilalvl" + Variaveis.nivel + "Verm.png"));
        if(Variaveis.estagio > 1){
         icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/KmilaImgs/Camilalvl" + Variaveis.nivel + "E" + Variaveis.estagio + "Verm.png"));
        }
        icon.getImage().flush();
        camila.setIcon( icon );
         }
         
    }//GEN-LAST:event_btnespecialMousePressed

    private void btnespecialMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnespecialMouseReleased
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/BtnImgs/BtnEspecial.png"));
        icon2.getImage().flush();
        btnespecial.setIcon( icon2 );
        ImageIcon icon;
        try {
            sleep(100);
        icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/KmilaImgs/Camilalvl" + Variaveis.nivel + ".png"));
        if(Variaveis.estagio > 1){
        icon = new ImageIcon(getClass().getResource( "/br/com/Main/Imagens/KmilaImgs/Camilalvl" + Variaveis.nivel + "E" + Variaveis.estagio + ".png"));
        }
        icon.getImage().flush();
        camila.setIcon( icon );  
        } catch (InterruptedException ex) {
            Logger.getLogger(TelaBatalha.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnespecialMouseReleased

    private void btnsuicidioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsuicidioMousePressed
        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/BtnImgs/BtnDesistirPressed.png"));
        icon.getImage().flush();
        btnsuicidio.setIcon( icon );  
    }//GEN-LAST:event_btnsuicidioMousePressed

    private void btnsuicidioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsuicidioMouseReleased
        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/Main/Imagens/BtnImgs/BtnDesistir.png"));
        icon.getImage().flush();
        btnsuicidio.setIcon( icon );
    }//GEN-LAST:event_btnsuicidioMouseReleased

    
    
    private void derrotouKmila(){
        if((Variaveis.nivel != 3) && (Variaveis.nivel != 5)){
            Variaveis.nivel = Variaveis.nivel + 1;
            Variaveis.paraHP = true;
            Variaveis.est2 = false;
            JOptionPane.showMessageDialog(null, "Parabéns!" + Variaveis.nivel + "  A Você matou a Camila e desbloqueou o nive! " + Variaveis.nivel + " \n O mundo agradece! o/", "Parabens!", JOptionPane.DEFAULT_OPTION);
            Variaveis.est2 = true;
            Variaveis.paraHP = false;
            VariaveisLoja.setDinheiro(VariaveisLoja.getDinheiro() + (Variaveis.getBatidas() / 10));
            Variaveis.setBatidas(0);
            setVisible(false);
            TelaMenu menu = new TelaMenu();
            menu.setVisible(true);
            tl.setVisible(false);
        }else{
            if(Variaveis.nivel == 3){
            if(Variaveis.estagio == 2){
            Variaveis.nivel = Variaveis.nivel + 1;
             Variaveis.paraHP = true;
             Variaveis.est2 = false;
            JOptionPane.showMessageDialog(null, "Parabéns! Você matou a Camila e desbloqueou o nive! " + Variaveis.nivel + " \n O mundo agradece! o/", "Parabens!", JOptionPane.DEFAULT_OPTION);
             Variaveis.est2 = true;
            Variaveis.paraHP = false;
            VariaveisLoja.setDinheiro(VariaveisLoja.getDinheiro() + (Variaveis.getBatidas() / 10));
            Variaveis.setBatidas(0);
            setVisible(false);
            TelaMenu menu = new TelaMenu();
            menu.setVisible(true);
            tl.setVisible(false); 
            Variaveis.estagio = 1;
            }else{
            Variaveis.paraHP = true;
            JOptionPane.showMessageDialog(null, "Oh não! Ela conseguiu o COLETINHO e ficou ainda mais forte!");
            JOptionPane.showMessageDialog(null, "Clique nas janelas que aparecem na tela para dar mais dano!");
            Variaveis.paraHP = false;
            Variaveis.estagio++;
            TelaBatalha tela = new TelaBatalha();
            setVisible(false);
            tela.setVisible(true);
            estagio2(); 
            }  
            }
            if(Variaveis.nivel == 5){
                if(Variaveis.estagio == 1){
                    Variaveis.paraHP = true;
                    JOptionPane.showMessageDialog(null, "Oh não! ela está ficando mais forte! parece até que está evoluindo!");
                    JOptionPane.showMessageDialog(null, "Clique nas jenelas que aparece na tela para dar mais dano!");
                    Variaveis.paraHP = false;
                    Variaveis.estagio++;
                    TelaBatalha tela = new TelaBatalha();
                    setVisible(false);
                    tela.setVisible(true);
                    estagio2(); 
                    return;
                }
                if(Variaveis.estagio == 2){
                    Variaveis.paraHP = true;
                    Variaveis.est2 = false;
                    JOptionPane.showMessageDialog(null, "Ela está ainda maior! Você precisa dar mais dano!");
                    Variaveis.est2 = true;
                    Variaveis.paraHP = false;
                    Variaveis.estagio++;
                    TelaBatalha tela = new TelaBatalha();
                    setVisible(false);              
                    tela.setVisible(true);
                    return;
                }
                if(Variaveis.estagio == 3){
            Variaveis.nivel = Variaveis.nivel + 1;
             Variaveis.paraHP = true;
            JOptionPane.showMessageDialog(null, "Parabéns! Você matou a Camila e desbloqueou o nive! " + Variaveis.nivel + " \n O mundo agradece! o/", "Parabens!", JOptionPane.DEFAULT_OPTION);
            JOptionPane.showMessageDialog(null, "Você terminou o modo campanha do jogo! Mas não desanime! você ainda pode continuar jogando e melhorando suas abilidades!");
             Variaveis.paraHP = false;
            VariaveisLoja.setDinheiro(VariaveisLoja.getDinheiro() + (Variaveis.getBatidas() / 10));
            Variaveis.setBatidas(0);
            setVisible(false);
            TelaMenu menu = new TelaMenu();
            menu.setVisible(true);
            tl.setVisible(false); 
            Variaveis.estagio = 1;
            return;
                }
            }
        }
            
    }
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
            java.util.logging.Logger.getLogger(TelaBatalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBatalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBatalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBatalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBatalha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nivel;
    public static javax.swing.JProgressBar barra;
    private javax.swing.JLabel batidas;
    private javax.swing.JButton bntbater;
    private javax.swing.JButton btnespecial;
    private javax.swing.JButton btnsuicidio;
    private javax.swing.JLabel camila;
    private javax.swing.JLabel dinheiros;
    private javax.swing.JProgressBar especial;
    private javax.swing.JProgressBar hp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
