package br.com.apesoftware.jumper.engine;

import android.content.Context;

import br.com.apesoftware.jumper.R;

/**
 * Created by gabrielllbsb on 27/08/16.
 */

public class SomColisao extends Som {

    public SomColisao(Context contexto) {
        super(contexto);
    }

    @Override
    protected void configurarSom() {
       this.soundId = this.soundPool.load(contexto, R.raw.colisao, 1);
    }
}
