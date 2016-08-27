package br.com.apesoftware.jumper.engine;

/**
 * Created by gabrielllbsb on 25/08/16.
 */
public class Tempo {

    private double atual;

    public double getAtual() {
        return this.atual;
    }

    public void passar() {
        this.atual += 0.1;
    }

    public void reiniciar() {
        this.atual = 0;
    }
}
