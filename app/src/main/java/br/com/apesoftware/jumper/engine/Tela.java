package br.com.apesoftware.jumper.engine;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by gabrielllbsb on 22/08/16.
 */
public class Tela {

    private DisplayMetrics metrics;

    public  Tela(Context contexto) {
        WindowManager windowManager = (WindowManager)contexto.getSystemService(Context.WINDOW_SERVICE);

        Display display = windowManager.getDefaultDisplay();
        this.metrics = new DisplayMetrics();
        display.getMetrics(this.metrics);
    }

    public int getAltura() {
        return this.metrics.heightPixels;
    }

    public int getLargura() {
        return this.metrics.widthPixels;
    }
}
