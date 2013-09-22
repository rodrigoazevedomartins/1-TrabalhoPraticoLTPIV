/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;


/**
 *
 * @author Rodrigo
 */

public enum StatusRecurso {
    
    Emprestado(1),
    Devolvido(2), 
    Reservado(3);

    private final int valor;
    
    StatusRecurso(int valor) {
        this.valor = valor;
    }
    
    public static String consultaStatusRecurso(int val){
        switch(val){
            case 1: return "Emprestado";
            case 2: return "Devolvido";
            case 3: return "Reservado";
            default: return "";
        }
    }
    
    public int getValor(){
        return valor;
    }
}
    
    
   
