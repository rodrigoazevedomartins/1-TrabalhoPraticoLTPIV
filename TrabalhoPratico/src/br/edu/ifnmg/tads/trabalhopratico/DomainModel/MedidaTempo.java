/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;

/**
 *
 * @author Rodrigo
 */

public enum MedidaTempo{
    
    Minutos(1),
    Horas(2),
    Dias(3), 
    Semanas(4);
   
    private final int valor;
    
    MedidaTempo(int valor){
        this.valor = valor;
    }
    
    public static String consultaMedidaTempo(int val){
        switch(val){
            case 1: return "Minutos";
            case 2: return "Horas";
            case 3: return "Dias";
            case 4: return "Semanas";
            default: return "";
        }                
    }
    
    public int getValor(){
        return valor;
    }

}
