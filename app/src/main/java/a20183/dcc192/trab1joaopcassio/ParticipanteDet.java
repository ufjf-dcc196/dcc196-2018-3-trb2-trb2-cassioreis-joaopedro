package a20183.dcc192.trab1joaopcassio;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import a20183.dcc192.trab1joaopcassio.Listas.ListaEventos;
import a20183.dcc192.trab1joaopcassio.Listas.ListaParticipantes;
import a20183.dcc192.trab1joaopcassio.Model.Evento;
import a20183.dcc192.trab1joaopcassio.Model.Participante;

public class ParticipanteDet extends AppCompatActivity {
    private EditText txtDetNome, txtDetEmail, txtDetCpf;
    private RecyclerView rclDetEventos;
    private Button btnDetEvInsc, btnDetEdit;

    private EventoAdapter evDetAdapter;
    private List<Evento> eventosParticipando = new ArrayList<Evento>();
    public static Participante participanteAtual;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.det_participante);

        btnDetEvInsc = (Button) findViewById(R.id.btn_DetEvInsc);
        btnDetEdit = (Button) findViewById(R.id.btn_DetEdit);

        txtDetNome = (EditText) findViewById(R.id.txt_detNome);
        txtDetEmail = (EditText) findViewById(R.id.txt_detEmail);
        txtDetCpf = (EditText) findViewById(R.id.txt_detCpf);

        rclDetEventos = (RecyclerView) findViewById(R.id.rcl_detEventos);
        rclDetEventos.setLayoutManager(new LinearLayoutManager(this));

        //Linha com erro, foi inserido o cursor, verificaar
        evDetAdapter = new EventoAdapter(getEventos());
        rclDetEventos.setAdapter(evDetAdapter);

        Bundle bundleExtras = getIntent().getExtras();
        if(bundleExtras!=null)
        {
            nome = bundleExtras.getString("nome");
            int i;
            for(i=0 ; i < ListaParticipantes.getInstance().size();i++){
                if(nome.equals(ListaParticipantes.getInstance().get(i).getNome())){
                    participanteAtual = ListaParticipantes.getInstance().get(i);
                    break;
                }

            }
            txtDetNome.setText(participanteAtual.getNome());
            txtDetEmail.setText(participanteAtual.getEmail()) ;
            txtDetCpf.setText(participanteAtual.getCPF()) ;


            for(int j = 0; j < ListaEventos.getInstance().size(); j++){
                if(ListaEventos.getInstance().get(j).findParticipante(participanteAtual)){
                    eventosParticipando.add(ListaEventos.getInstance().get(j));
                }

            }
            evDetAdapter.notifyDataSetChanged();
        }
        evDetAdapter.setOnEventLongClickListener(new EventoAdapter.OnEventLongClickListener() {
            @Override
            public void onEventLongClick(View EventView, int position) {

                TextView txtTitulo = (TextView) EventView.findViewById(R.id.txt_nomeTitulos);
                String titulo = txtTitulo.getText().toString();
                for(int i=0; i<eventosParticipando.size(); i++)
                {
                    if(titulo.equals(eventosParticipando.get(i).getTítulo()))
                    {
                        eventosParticipando.get(i).getParticipantes().remove(participanteAtual);
                        eventosParticipando.remove(eventosParticipando.get(i));
                    }
                }
                evDetAdapter.notifyItemRemoved(position);

            }
        });
        btnDetEvInsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParticipanteDet.this, EventoInsc.class);
                startActivityForResult(intent, MainActivity.INSC_EVENTO);
            }
        });
        btnDetEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                participanteAtual.setNome(txtDetNome.getText().toString());
                participanteAtual.setEmail(txtDetEmail.getText().toString());
                participanteAtual.setCPF(txtDetCpf.getText().toString());
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == MainActivity.INSC_EVENTO) {
            for(int j = 0; j < ListaEventos.getInstance().size(); j++){
                if(ListaEventos.getInstance().get(j).findParticipante(participanteAtual) && !eventosParticipando.contains(ListaEventos.getInstance().get(j))){
                    eventosParticipando.add(ListaEventos.getInstance().get(j));
                }

            }
            evDetAdapter.notifyDataSetChanged();
        }
    }

    private Cursor getEventos()
    {
        SQLiteDatabase db = MainActivity.dbHelper.getReadableDatabase();
        String []visao = {
                ParticipacaoContract.Participacao.COLUMN_NAME_EVENTO
        };
        String sort = ParticipacaoContract.Participacao.COLUMN_NAME_EVENTO+ " ASC";
        String restricoes = ParticipacaoContract.Participacao.COLUMN_NAME_PARTICIPANTE + " = " + "NOME DO PARTICIPANTE ATUAL";
        return db.query(EventoContract.Evento.TABLE_NAME, visao,restricoes,null,null,null, sort);
    }
}