package br.com.apesoftware.jumper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import br.com.apesoftware.jumper.engine.Game;

public class MainActivity extends Activity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = (FrameLayout)findViewById(R.id.container);

        this.games  = new Game(this);
        container.addView(this.game);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.game.iniciar();
        new Thread(this.game).start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        this.game.cancelar();
    }
}
