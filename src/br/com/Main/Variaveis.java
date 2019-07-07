/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Main;

/**
 *
 * @author Particular
 */
public class Variaveis {
    
    
    static int telap1 = 750;
    static int telap2 = 300;
    
    static int nivel = 1; // DB
    
    static int delayKmilaHit = 400;
    static int damage = 1; // DB
    static int batidas = 0;
    static boolean music = true;
    static boolean musicMenu = true;
    static boolean musicBattle = true;
    
    static boolean paraHP = false;
    
    static int estagio = 1;
    
    static boolean est2 = true;
    
    public static boolean getMusic(){
        return music;
    }
     public static boolean getMusicMenu(){
        return musicMenu;
    }
      public static boolean getMusicBattle(){
        return musicBattle;
    }
    
 public static int getDamage(){
     int dano = damage + VariaveisLoja.getQLapis() + VariaveisLoja.getQCaneta() * 2;
  return dano;
 }
 
 public static int getBatidas(){
   return batidas;  
   }
 public static void somaBatidas(){
     batidas++;
  }
 
 public static void setBatidas(int numero){
     batidas = numero;
 }
 
 public static int getDelayKmila(){
     return delayKmilaHit;
 }
 public static void somaDelayKmia(int num){
     delayKmilaHit = delayKmilaHit + num; 
 }
 
 
    
}
