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
    int qtdRodas;
    int portas;
    int velocidade = 0;
    String cor;
    boolean farol;
    
    
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
                velocidade = velocidade - variacao;
            }
        }
    public void trocarPneus(){
            int gastos = qtdRodas * 150;
            System.out.println("Valor gasto para trocar pneus é: R$"+gastos+",00");
        }
    public void farol(boolean estado){
            farol = estado;
        }
    
    public void pintar(String corDaTinta){
            cor = corDaTinta;
        }
}
    


