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
        Carro.farol(true);
        Carro.acelerar(10);
        Carro.diminuir(10);
        Carro.qtdRodas = 4;
        Carro.pintar("Azul");
        
        Moto.ligar();
        Moto.farol(true);
        Moto.acelerar(20);
        Moto.diminuir(20);
        Moto.qtdRodas = 2;
        Moto.pintar("Branca");
        
        Caminhao.ligar();
        Caminhao.farol(true);
        Caminhao.acelerar(5);
        Caminhao.diminuir(5);
        Caminhao.qtdRodas = 6;
        Moto.pintar("Verde");
        
        
        //Aviso excesso de velocidade
        if(Carro.velocidade > 110){
            System.out.println("Velocidade acima do permitido para carros");
        }
        if(Moto.velocidade > 110){
            System.out.println("Velocidade acima do permitido para motos");
        }
        if(Caminhao.velocidade > 80){
            System.out.println("Velocidade acima do permitido para caminhoes");
        }
        
        
    }
}
