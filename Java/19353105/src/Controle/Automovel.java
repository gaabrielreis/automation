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
            System.out.println("Valor gasto para trocar os pneus é: R$"+gastos+",00");
        }
    public void farol(boolean estado){
            farol = estado;
        }
    
    public void pintar(String corDaTinta){
            cor = corDaTinta;
        }
    
    public void exibirEstado(String automovel){ 
        System.out.println("Estado do "+automovel+":");
        if(motor == true){
            System.out.println(automovel+" ligado");
        }else{
            System.out.println(automovel+" desligado");
            }
        System.out.println("Velocidade: "+velocidade+"km/h");
        System.out.println();
        
        
}
}
    


