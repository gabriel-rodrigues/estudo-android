package br.com.apesoftware.jumper.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.apesoftware.jumper.engine.Cores;
import br.com.apesoftware.jumper.engine.Som;

/**
 * Created by gabrielllbsb on 25/08/16.
 */
public class Pontuacao {

    private  static  final Paint BRANCO = Cores.getCorDaPontuacao();

    private int pontos;

    private final Som som;

    public Pontuacao(Som som) {
        this.som = som;
    }

    public void contabilizar() {
        this.som.tocar(Som.PONTUACAO);
        ++this.pontos;
    }

    public  void desenharNo(Canvas canvas) {
        canvas.drawText(String.valueOf(this.pontos), 100, 100,BRANCO);
    }
}
