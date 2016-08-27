package br.com.apesoftware.jumper.engine;

import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by gabrielllbsb on 22/08/16.
 */
public class Cores {

    public  static Paint getCorPassaro() {
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        return vermelho;
    }

    public static Paint getCorDoCano() {
        Paint verde = new Paint();
        verde.setColor(0xFF00FF00);
        return  verde;
    }

    public static Paint getCorDaPontuacao() {
        Paint branco = new Paint();
        branco.setColor(0xFFFFFFFF);
        branco.setTextSize(80);
        branco.setTypeface(Typeface.DEFAULT_BOLD);
        branco.setShadowLayer(3, 5, 5, 0xFF000000);
        return  branco;
    }

    public static Paint getCorGameOver() {
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        vermelho.setTextSize(50);
        vermelho.setTypeface(Typeface.DEFAULT_BOLD);
        vermelho.setShadowLayer(2, 3,3, 0xFF000000);
        return  vermelho;
    }
}
