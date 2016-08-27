package br.com.apesoftware.jumper.elementos;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.apesoftware.jumper.engine.Tela;

/**
 * Created by gabrielllbsb on 22/08/16.
 */
public class Canos {

    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 250;

    private final Pontuacao pontuacao;
    private final Context contexto;

    private List<Cano> canos = new ArrayList<Cano>();
    private Tela tela;

    public  Canos(Context contexto, Tela tela, Pontuacao pontuacao) {
        this.contexto  = contexto;
        int posicao    = 200;
        this.tela      = tela;
        this.pontuacao = pontuacao;

        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicao += DISTANCIA_ENTRE_CANOS;
            this.canos.add(new Cano(this.contexto, this.tela, posicao));
        }
    }

    public void desenharNo(Canvas canvas) {
        for (Cano cano : this.canos) {
            cano.desenharNo(canvas);
        }
    }

    public  void mover() {
        ListIterator<Cano> iterator = this.canos.listIterator();

        while (iterator.hasNext()) {
            Cano cano = iterator.next();
            cano.mover();

            if(cano.saiuDaTela()) {
                this.pontuacao.contabilizar();

                iterator.remove();

                Cano novoCano = new Cano(this.contexto, this.tela, this.getMaiorPosicao() + DISTANCIA_ENTRE_CANOS);
                iterator.add(novoCano);
            }
        }
    }

    private int getMaiorPosicao() {
        int maximo = 0;

        for (Cano cano: this.canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }

        return maximo;
    }

    public boolean temColisaoCom(Passaro passaro) {
        for (Cano cano : this.canos) {
            // aqui vamos ver se tem colissao
            if(cano.cruzouHorizontalmenteComPassaro() && cano.cruzouVerticalmenteCom(passaro)) {
                return true;
            }
        }

        return  false;
    }
}


