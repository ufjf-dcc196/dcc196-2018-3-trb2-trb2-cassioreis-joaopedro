package a20183.dcc192.trab1joaopcassio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int CADS_EVENTO = 0, DET_EVENTO = 1, INSC_EVENTO = 2, CADS_PARTICIPANTE = 3, DET_PARTICIPANTE = 4;
    private Button btnCadsParticipante, btnCadsEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadsParticipante = (Button) findViewById(R.id.btn_cadsParticipante);
        btnCadsEvento = (Button) findViewById(R.id.btn_cadsEvento);

        btnCadsParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnCadsEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
