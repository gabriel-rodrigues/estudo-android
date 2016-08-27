package br.com.apesoftware.jumper.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import br.com.apesoftware.jumper.engine.Cores;
import br.com.apesoftware.jumper.engine.Tela;

/**
 * Created by gabrielllbsb on 25/08/16.
 */
public class GameOver {

    private static final Paint VERMELHO = Cores.getCorGameOver();

    private final Tela tela;

    public GameOver(Tela tela) {
        this.tela = tela;
    }

    public void desenharNo(Canvas canvas) {
        String gameOver = "Game Over";
        canvas.drawText(gameOver,this.getCentroParaTexto(gameOver), this.tela.getAltura() / 2, VERMELHO);
    }

    private int getCentroParaTexto(String texto) {
        Rect limiteDoTexto = new Rect();
        VERMELHO.getTextBounds(texto,0, texto.length(), limiteDoTexto);

        int centroHorizontal = (this.tela.getLargura() / 2) - (limiteDoTexto.right - limiteDoTexto.left) / 2;

        return centroHorizontal;
    }
}
