/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;

/**
 *
 * @author Rodrigo
 */

public enum Operacao {
    Empréstimo(1),
    Reserva(2);
    
    private final int valor;
    
    Operacao(int valor){
        this.valor = valor;
    }
    
    public static String consultaOperacao(int val){
        switch(val){
            case 1: return "Empréstimo";
            case 2: return "Reserva";
            default: return "";
        }
    }
    
    public int getValor(){
        return valor;
    }
    
    
    
    
}
