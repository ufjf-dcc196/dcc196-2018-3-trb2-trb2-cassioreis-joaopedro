package a20183.dcc192.trab1joaopcassio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import a20183.dcc192.trab1joaopcassio.Listas.ListaEventos;
import a20183.dcc192.trab1joaopcassio.Listas.ListaParticipantes;
import a20183.dcc192.trab1joaopcassio.Model.Participante;

public class MainActivity extends AppCompatActivity {

    private static final int  CADS_PARTICIPANTE = 1,CADS_EVENTO=2;
    private Button btnCadsParticipante, btnCadsEvento;
    private RecyclerView rclParticipantes, rclEventos;
    private ParticipanteAdapter PAdapter;
    private EventoAdapter evAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadsParticipante = (Button) findViewById(R.id.btn_cadsParticipanteMain);
        btnCadsEvento = (Button) findViewById(R.id.btn_cadsEventoMain);

        rclParticipantes = (RecyclerView) findViewById(R.id.rlc_participantesMain);
        rclParticipantes.setLayoutManager(new LinearLayoutManager(this));
        PAdapter = new ParticipanteAdapter(ListaParticipantes.getInstance());
        rclParticipantes.setAdapter(PAdapter);

        rclEventos = (RecyclerView) findViewById(R.id.rlc_eventoMain);
        rclEventos.setLayoutManager(new LinearLayoutManager(this));
        evAdapter = new EventoAdapter(ListaEventos.getInstance());
        rclEventos.setAdapter(evAdapter);

        btnCadsParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ParticipanteCads.class);
                startActivityForResult(intent, MainActivity.CADS_PARTICIPANTE);
            }
        });

        rclParticipantes.setAdapter(PAdapter);

        btnCadsEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventoCads.class);
                startActivityForResult(intent, MainActivity.CADS_EVENTO);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == MainActivity.CADS_PARTICIPANTE && resultCode == Activity.RESULT_OK) {
            PAdapter.notifyDataSetChanged();
        }
        if(requestCode == MainActivity.CADS_EVENTO && resultCode == Activity.RESULT_OK) {
            evAdapter.notifyDataSetChanged();
        }
    }
}
