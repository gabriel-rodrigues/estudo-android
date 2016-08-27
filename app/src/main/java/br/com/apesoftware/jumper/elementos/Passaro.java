package br.com.apesoftware.jumper.elementos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;


import br.com.apesoftware.jumper.R;
import br.com.apesoftware.jumper.engine.Som;
import br.com.apesoftware.jumper.engine.Tela;
import br.com.apesoftware.jumper.engine.Tempo;

/**
 * Created by gabrielllbsb on 22/08/16.
 */
public class Passaro {

    public static final int X    = 100;
    public static final int RAIO = 50;


    private static final int DESLOCAMENTO_DO_PULO = 5;

    private int altura;
    private Tela tela;
    private final Bitmap passaro;
    private Tempo tempo;

    private Som som;

    public Passaro(Context contexto, Tela tela, Som som, Tempo tempo) {
        this.altura = 100;
        this.tela   = tela;
        this.som    = som;
        this.tempo  = tempo;

        Bitmap bp    = BitmapFactory.decodeResource(contexto.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2, false);
    }

    public  void desenharNo(Canvas canvas) {
        canvas.drawBitmap(this.passaro, X - RAIO, this.altura - RAIO, null);
    }

    public void voar() {
        double tempo         = this.tempo.getAtual();
        double novaAltura    = -DESLOCAMENTO_DO_PULO + ((10 * (tempo * tempo))/ 2.0);
        boolean chegouNoChao = this.altura + RAIO > this.tela.getAltura();

        if(!chegouNoChao) {
            this.altura += novaAltura;
        }
    }

    public void pular() {

        if(this.altura > RAIO) {
            this.som.tocar(Som.PULO);
            this.tempo.reiniciar();
        }
    }

    public int getAltura() {
        return  this.altura;
    }
}
