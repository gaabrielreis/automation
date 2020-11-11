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
        
        //Define cor do Automovel
        Carro.pintar("Azul");
        Moto.pintar("Branca");
        Caminhao.pintar("Verde");
        
        //Definie quantidade de rodas
        Carro.qtdRodas = 4;
        Moto.qtdRodas = 2;
        Caminhao.qtdRodas = 6;
        
        
        Carro.ligar();
        Carro.farol(true);
        Carro.acelerar(10);
        Carro.acelerar(10);
        
        Moto.ligar();
        Moto.farol(true);
        Moto.acelerar(20);
        Moto.acelerar(20);
        
        Caminhao.acelerar(5);
        Caminhao.acelerar(5);
        Caminhao.trocarPneus();
        
        Carro.exibirEstado("Carro");
        Moto.exibirEstado("Moto");
        Caminhao.exibirEstado("Caminhao");
        
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
