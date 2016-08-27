package br.com.apesoftware.jumper.engine;

import br.com.apesoftware.jumper.elementos.Canos;
import br.com.apesoftware.jumper.elementos.Passaro;

/**
 * Created by gabrielllbsb on 25/08/16.
 */
public class VerificadorDeColisao {

    public final Passaro passaro;
    public final Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {
        return this.canos.temColisaoCom(this.passaro);
    }
}
