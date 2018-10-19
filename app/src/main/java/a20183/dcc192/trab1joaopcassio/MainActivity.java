package a20183.dcc192.trab1joaopcassio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int CADS_EVENTO = 0, DET_EVENTO = 1, INSC_EVENTO = 2, CADS_PARTICIPANTE = 3, DET_PARTICIPANTE = 4;
    private Button btnCadsParticipante, btnCadsEvento;
    private RecyclerView rclParticipantes, rclEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadsParticipante = (Button) findViewById(R.id.btn_cadsParticipanteMain);
        btnCadsEvento = (Button) findViewById(R.id.btn_cadsEventoMain);

        rclParticipantes = (RecyclerView) findViewById(R.id.rlc_participantesMain);
        rclParticipantes.setLayoutManager(new LinearLayoutManager(this));
        rclEventos = (RecyclerView) findViewById(R.id.rlc_eventoMain);
        rclEventos.setLayoutManager(new LinearLayoutManager(this));



        btnCadsParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ParticipanteCads.class);
                startActivityForResult(intent, MainActivity.CADS_PARTICIPANTE);
            }
        });
        btnCadsEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventoCads.class);
                startActivityForResult(intent, MainActivity.CADS_EVENTO);
            }
        });
    }
}
