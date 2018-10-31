package a20183.dcc192.trab1joaopcassio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import a20183.dcc192.trab1joaopcassio.Listas.ListaEventos;
import a20183.dcc192.trab1joaopcassio.Listas.ListaParticipantes;
import a20183.dcc192.trab1joaopcassio.Model.Evento;
import a20183.dcc192.trab1joaopcassio.Model.Participante;

public class ParticipanteDet extends AppCompatActivity {
    private EditText txtDetNome, txtDetEmail, txtDetCpf;
    private RecyclerView rclDetEventos;
    private Button btnDetEvInsc;
    private EventoAdapter evAdapter;
    private List<Evento> eventosParticipando = new ArrayList<Evento>();
    private Participante participanteAtual;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.det_participante);

        btnDetEvInsc = (Button) findViewById(R.id.btn_DetEvInsc);

        txtDetNome = (EditText) findViewById(R.id.txt_detNome);
        txtDetEmail = (EditText) findViewById(R.id.txt_detEmail);
        txtDetCpf = (EditText) findViewById(R.id.txt_detCpf);

        rclDetEventos = (RecyclerView) findViewById(R.id.rcl_detEventos);
        rclDetEventos.setLayoutManager(new LinearLayoutManager(this));
        evAdapter = new EventoAdapter(eventosParticipando);
        rclDetEventos.setAdapter(evAdapter);

        Bundle bundleExtras = getIntent().getExtras();
        if(bundleExtras!=null)
        {
            nome = bundleExtras.getString("nome");
            int i;
            for(i=0 ; i <= ListaParticipantes.getInstance().size();i++){
                if(nome.equals(ListaParticipantes.getInstance().get(i).getNome())){
                    participanteAtual = ListaParticipantes.getInstance().get(i);
                    break;
                }

            }
            txtDetNome.setText(participanteAtual.getNome());
            txtDetEmail.setText(participanteAtual.getEmail()) ;
            txtDetCpf.setText(participanteAtual.getCPF()) ;

            /*
            for(int j = 0; j <= ListaEventos.getInstance().size(); j++){
                if(ListaEventos.getInstance().get(j).findParticipante(ListaParticipantes.getInstance().get(i))){
                    eventosParticipando.add(ListaEventos.getInstance().get(j));
                }

            }
            evAdapter.notifyDataSetChanged();*/
        }

        btnDetEvInsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParticipanteDet.this, EventoInsc.class);
                startActivityForResult(intent, MainActivity.INSC_EVENTO);
            }
        });
    }
}