package a20183.dcc192.trab1joaopcassio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import a20183.dcc192.trab1joaopcassio.Listas.ListaEventos;
import a20183.dcc192.trab1joaopcassio.Listas.ListaParticipantes;
import a20183.dcc192.trab1joaopcassio.Model.Participante;

public class MainActivity extends AppCompatActivity {

    private static final int  CADS_PARTICIPANTE = 1,CADS_EVENTO=2, DET_PARTICIPANTE = 3, DET_EVENTO = 4;
    private static final String PARTICIPANTE_NOME = "nome", EVENTO_TITULO = "titulo";
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

        btnCadsEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventoCads.class);
                startActivityForResult(intent, MainActivity.CADS_EVENTO);
            }
        });
        PAdapter.setOnPartClickListener(new ParticipanteAdapter.OnPartClickListener() {
            @Override
            public void onPartClick(View PartView, int position) {

                TextView txtPartNome = (TextView) PartView.findViewById(R.id.txt_nomeTitulo);
                Intent intent = new Intent(MainActivity.this, ParticipanteDet.class);
                intent.putExtra(String.valueOf(MainActivity.PARTICIPANTE_NOME), txtPartNome.getText().toString());
                startActivityForResult(intent, MainActivity.DET_PARTICIPANTE);
            }
        } );

        evAdapter.setOnEventClickListener(new EventoAdapter.OnEventClickListener() {
            @Override
            public void onEventClick(View EvView, int position) {

                TextView txtEvTitulo = (TextView) EvView.findViewById(R.id.txt_nomeTitulos);
                Intent intent = new Intent(MainActivity.this, EventoDet.class);
                intent.putExtra(String.valueOf(MainActivity.EVENTO_TITULO), txtEvTitulo.getText().toString());
                startActivityForResult(intent, MainActivity.DET_EVENTO);

            }
        } );

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
