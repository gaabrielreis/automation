import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class Senha {
    
    private boolean BCaixa1;
    private boolean BCaixa2;
    private boolean BCaixa3;
    private boolean BCaixa4;
    private boolean BComum;
    private boolean BRapido;
    private boolean BPrioritario;
    private String TSenhaGerada;
    private String TCaixaParaAtendimento;
    private String TSenhaParaAtendimento;
    
    public ArrayList<String> ArrayFila = new ArrayList();
  
    //Atributos
    public String tipo;
    public int numero;

    public boolean isBCaixa1() {
        return BCaixa1;
    }

    public void setBCaixa1(boolean BCaixa1) {
        this.BCaixa1 = BCaixa1;
    }

    public boolean isBCaixa2() {
        return BCaixa2;
    }

    public void setBCaixa2(boolean BCaixa2) {
        this.BCaixa2 = BCaixa2;
    }

    public boolean isBCaixa3() {
        return BCaixa3;
    }

    public void setBCaixa3(boolean BCaixa3) {
        this.BCaixa3 = BCaixa3;
    }

    public boolean isBCaixa4() {
        return BCaixa4;
    }

    public void setBCaixa4(boolean BCaixa4) {
        this.BCaixa4 = BCaixa4;
    }

    public boolean isBComum() {
        return BComum;
    }

    public void setBComum(boolean BComum) {
        this.BComum = BComum;
    }

    public boolean isBRapido() {
        return BRapido;
    }

    public void setBRapido(boolean BRapido) {
        this.BRapido = BRapido;
    }

    public boolean isBPrioritario() {
        return BPrioritario;
    }

    public void setBPrioritario(boolean BPrioritario) {
        this.BPrioritario = BPrioritario;
    }

    public String getTSenhaGerada() {
        return TSenhaGerada;
    }

    public void setTSenhaGerada(String TSenhaGerada) {
        this.TSenhaGerada = TSenhaGerada;
    }

    public String getTCaixaParaAtendimento() {
        return TCaixaParaAtendimento;
    }

    public void setTCaixaParaAtendimento(String TCaixaParaAtendimento) {
        this.TCaixaParaAtendimento = TCaixaParaAtendimento;
    }

    public String getTSenhaParaAtendimento() {
        return TSenhaParaAtendimento;
    }

    public void setTSenhaParaAtendimento(String TSenhaParaAtendimento) {
        this.TSenhaParaAtendimento = TSenhaParaAtendimento;
    }

    public ArrayList<String> getArrayFila() {
        return ArrayFila;
    }

    public void setArrayFila(ArrayList<String> ArrayFila) {
        this.ArrayFila = ArrayFila;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}