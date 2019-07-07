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
public class VariaveisLoja {
    
    public static float Dinheiro = 0; // DB
    
    public static float getDinheiro(){
        return Dinheiro;
    }
    public static void setDinheiro(float num){
        Dinheiro = num;
    }
    
    public static int QBorracha = 0; // DB
    public static int QLapis = 0; // DB
    public static int QCaneta = 0; // DB
    public static int QGrifa = 0; // DB
    public static int QApontador = 0; // DB
    public static int QVic = 0; // DB
    
    public static int PBorracha = 10;
    public static int PLapis = 10;
    public static int PCaneta = 15;
    public static int PGrifa = 20;
    public static int PApontador = 30;
    public static int PVic = 50;
    
    public static int getQBorracha(){
        return QBorracha;
    }
    public static int getQLapis(){
        return QLapis;
    }
    public static int getQCaneta(){
        return QCaneta;
    }
    public static int getQGrifa(){
        return QGrifa;
    }
    public static int getQApontador(){
        return QApontador;
    }
    public static int getQVic(){
        return QVic;
    }
    
    public static void setQBorracha(int v){
         QBorracha = v;
    }
    public static void setQLapis(int v){
         QLapis = v;
    }
    public static void setQCaneta(int v){
         QCaneta = v;
    }
    public static void setQGrifa(int v){
         QGrifa = v;
    }
    public static void setQApontador(int v){
         QApontador = v;
    }
    public static void setQVic(int v){
         QVic = v;
    }
    
    //preco
    
        public static int getPBorracha(){
        return PBorracha;
    }
    public static int getPLapis(){
        return PLapis;
    }
    public static int getPCaneta(){
        return PCaneta;
    }
    public static int getPGrifa(){
        return PGrifa;
    }
    public static int getPApontador(){
        return PApontador;
    }
    public static int getPVic(){
        return PVic;
    }
    
    public static void setPBorracha(int v){
         PBorracha = v;
    }
    public static void setPLapis(int v){
         PLapis = v;
    }
    public static void setPCaneta(int v){
         PCaneta = v;
    }
    public static void setPGrifa(int v){
         PGrifa = v;
    }
    public static void setPApontador(int v){
         PApontador = v;
    }
    public static void setPVic(int v){
         PVic = v;
    }
    
    
}
