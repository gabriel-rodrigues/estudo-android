package br.com.apesoftware.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import br.com.apesoftware.jumper.R;

/**
 * Created by gabrielllbsb on 25/08/16.
 */
public class Som {

    private SoundPool soundPool;

    public static int PULO;
    public static int PONTUACAO;
    public static int COLISAO;

    public Som(Context contexto) {
        this.soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        PULO           = this.soundPool.load(contexto, R.raw.pulo, 1);
        PONTUACAO      = this.soundPool.load(contexto, R.raw.pontos, 1);
        COLISAO        = this.soundPool.load(contexto, R.raw.colisao, 1);
    }

    public void tocar(int som) {
        this.soundPool.play(som, 1, 1, 1, 0, 1);
    }
}
