package br.com.apesoftware.jumper.elementos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.apesoftware.jumper.R;
import br.com.apesoftware.jumper.engine.Cores;
import br.com.apesoftware.jumper.engine.Tela;

/**
 * Created by gabrielllbsb on 22/08/16.
 */
public class Cano {

    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;
    private static final Paint VERDE = Cores.getCorDoCano();

    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private Tela tela;
    private int posicao;
    private Bitmap canoInferior;
    private Bitmap canoSuperior;


    public Cano(Context contexto, Tela tela, int posicao) {
        this.tela                 = tela;
        this.posicao              = posicao;
        this.alturaDoCanoInferior = this.tela.getAltura() - TAMANHO_DO_CANO - this.getValorAleatorio();
        this.alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + this.getValorAleatorio();

        Bitmap bitmap             = BitmapFactory.decodeResource(contexto.getResources(), R.drawable.cano);
        this.canoInferior         = Bitmap.createScaledBitmap(bitmap, LARGURA_DO_CANO, this.alturaDoCanoInferior,false);
        this.canoSuperior         = Bitmap.createScaledBitmap(bitmap,LARGURA_DO_CANO,this.alturaDoCanoSuperior,false);
    }



    public void desenharNo(Canvas canvas) {
        this.desenharCanoInferiorNo(canvas);
        this.desenharCanoSuperiorNo(canvas);
    }

    private int getValorAleatorio() {
        return (int) (Math.random() * 70);
    }

    private void desenharCanoInferiorNo(Canvas canvas) {
        canvas.drawBitmap(this.canoInferior, this.posicao, this.alturaDoCanoInferior, null);
    }

    private void desenharCanoSuperiorNo(Canvas canvas) {
        canvas.drawBitmap(this.canoSuperior, this.posicao, 0,null);
    }

    public void mover() {
        this.posicao -= 5;
    }

    public  int getPosicao() {
        return this.posicao;
    }

    public boolean saiuDaTela() {
        return  this.posicao + LARGURA_DO_CANO < 0;
    }

    public boolean cruzouVerticalmenteCom(Passaro passaro) {
        return passaro.getAltura() + Passaro.RAIO < this.alturaDoCanoSuperior
                || passaro.getAltura() + Passaro.RAIO > this.alturaDoCanoInferior;
    }

    public boolean cruzouHorizontalmenteComPassaro() {
        return this.posicao - Passaro.X  < Passaro.RAIO;
    }
}
