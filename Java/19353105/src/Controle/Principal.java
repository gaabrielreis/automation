/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

/**
 *
 * @author Gabriel
 */



public class Principal {
    public static void main(String[] args){
        
        
        Automovel Carro = new Automovel();       
        Automovel Moto = new Automovel();       
        Automovel Caminhao = new Automovel();
        
        //Define quantidade de portas
        Carro.portas = 4;
        Caminhao.portas = 2;
        Moto.portas = 0;
        
        Carro.ligar();
    }
}
