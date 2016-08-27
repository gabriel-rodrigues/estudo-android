package br.com.apesoftware.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.apesoftware.jumper.R;
import br.com.apesoftware.jumper.elementos.Canos;
import br.com.apesoftware.jumper.elementos.GameOver;
import br.com.apesoftware.jumper.elementos.Passaro;
import br.com.apesoftware.jumper.elementos.Pontuacao;


/**
 * Created by gabrielllbsb on 22/08/16.
 */
public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean estaRodando = true;
    private Passaro passaro;
    private Bitmap background;
    private Tela tela;
    private Canos canos;
    private Pontuacao pontuacao;
    private VerificadorDeColisao verificadorDeColisao;

    private final Context contexto;
    private final Tempo tempo;


    // constantes
    private final SurfaceHolder holder = this.getHolder();

    public Game(Context context) {
        super(context);
        this.contexto = context;
        this.tela     = new Tela(context);
        this.tempo    = new Tempo();
        this.inicializarElementos();


        this.setOnTouchListener(this);
    }

    private void inicializarElementos() {
        Bitmap backgroundAuxiliar = BitmapFactory.decodeResource(this.getResources(), R.drawable.background);

        this.background = Bitmap.createScaledBitmap(backgroundAuxiliar, backgroundAuxiliar.getWidth(), tela.getAltura(),false);


        this.passaro   = new Passaro(this.contexto, this.tela, this.tempo);

        this.pontuacao = new Pontuacao(new SomPontuacao(this.contexto));
        this.canos     = new Canos(this.contexto, this.tela, this.pontuacao);

        this.verificadorDeColisao = new VerificadorDeColisao(this.passaro, this.canos);
    }

    @Override
    public void run() {
        while (this.estaRodando) {
            if(!this.holder.getSurface().isValid()) continue;
            Canvas canvas = this.holder.lockCanvas();

            this.tempo.passar();

            canvas.drawBitmap(this.background,0,0, null);

            this.passaro.desenharNo(canvas);
            this.passaro.voar();

            this.canos.desenharNo(canvas);
            this.canos.mover();

            this.pontuacao.desenharNo(canvas);

            if(this.verificadorDeColisao.temColisao()) {
                Som som = new SomColisao(this.contexto);
                som.tocar();

                new GameOver(this.tela).desenharNo(canvas);
                this.cancelar();
            }

            this.holder.unlockCanvasAndPost(canvas);
        }
    }

    public void cancelar() {
        this.estaRodando = false;
    }

    public void iniciar() {
        this.estaRodando = true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        this.passaro.pular();

        return false;
    }
}
