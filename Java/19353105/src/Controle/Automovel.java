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
public class Automovel {
    
    boolean motor = false; //True motor ligado e false motor desligado
    int rodas;
    int portas;
    int velocidade = 0;
    
    public void ligar(){
            motor = true;
        }
    public void desligar(){
            motor = false;
        }
    public void acelerar(int variacao){
            if (motor == true) {
                velocidade = velocidade + variacao;
            }
        }
    public void diminuir(int variacao){
            if (motor == true) {
                velocidade = velocidade + variacao;
            }
        }
    public void trocarPneus(){
            rodas = 0;
        }
    
}
    


