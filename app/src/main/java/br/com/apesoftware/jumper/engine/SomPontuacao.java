package br.com.apesoftware.jumper.engine;

import android.content.Context;

import br.com.apesoftware.jumper.R;

/**
 * Created by gabrielllbsb on 27/08/16.
 */
public class SomPontuacao extends Som {

    public SomPontuacao(Context contexto) {
        super(contexto);
    }

    @Override
    protected void configurarSom() {
        this.soundId = this.soundPool.load(contexto, R.raw.pontos, 1);
    }
}
