package br.com.apesoftware.jumper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuPrincipalActivity extends Activity implements View.OnClickListener {

    private TextView jogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_menu_principal);

        jogar   = (TextView) this.findViewById(R.id.menu_principal_jogar);
        jogar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intencao = new Intent(this, MainActivity.class);
        this.startActivity(intencao);
    }
}
