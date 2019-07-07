/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Particular
 */
public class Musicas {
    
   /* public static void playMusica(String diret){ 
        InputStream music;
        try{
            music = new FileInputStream(new File(diret));
            AudioStream audios;
            audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Erro na musica");
        }
        
        
    }*/
    
    public void music2(){
        URL url = getClass().getResource("/br/com/Main/Musicas/MenuMusic.wav");
        AudioClip audio = Applet.newAudioClip(url);
        audio.play();
    }
    
    public static void playMusicMenu (){
        try{
            File musicPath = new File("/br/com/Main/Musicas/MenuMusic.wav");
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
               //==
                                                 
            new Thread(){
                 public void run(){
                     for (int hpv = 0; hpv <= 100; hpv++){
                         try {
                             sleep(300); 
                             if (hpv == 99){
                                 hpv = 1;
                             }
                            if (Variaveis.getMusic() == false || Variaveis.getMusicMenu() == false){
                                clip.stop();
                                return;
                              }
                             
                         } catch (InterruptedException ex) {
                             Logger.getLogger(TelaBatalha.class.getName()).log(Level.SEVERE, null, ex);
                         }                      
                     }
                 }
              
            }.start();             
    
               
               //==
            }else{
                System.out.println("Arquivo nao encontrado!");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
    }

       public static void playMusicBattle (){
        try{
            File musicPath = new File("/br/com/Main/Musicas/BattleMusic.wav");
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
               //==
                                                 
            new Thread(){
                 public void run(){
                     for (int hpv = 0; hpv <= 100; hpv++){
                         try {
                             sleep(300); 
                             if (hpv == 99){
                                 hpv = 1;
                             }
                            if (Variaveis.getMusic() == false || Variaveis.getMusicBattle() == false){
                                clip.stop();
                                return;
                              }
                             
                         } catch (InterruptedException ex) {
                             Logger.getLogger(TelaBatalha.class.getName()).log(Level.SEVERE, null, ex);
                         }                      
                     }
                 }
              
            }.start();             
    
               
               //==
            }else{
                System.out.println("Arquivo nao encontrado!");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
    }
    
    
}
