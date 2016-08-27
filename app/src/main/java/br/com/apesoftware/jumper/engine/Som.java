package br.com.apesoftware.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;


/**
 * Created by gabrielllbsb on 25/08/16.
 */
public abstract class Som {

    protected SoundPool soundPool;
    protected int soundId;
    protected Context contexto;


    public Som(Context contexto) {
        this.contexto  = contexto;
        this.soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);

        this.configurarSom();
    }

    public void tocar() {
        this.soundPool.play(this.soundId, 1, 1, 1, 0, 1);
    }

    protected abstract void configurarSom();



}
