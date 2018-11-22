package a20183.dcc192.trab1joaopcassio;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

        Bundle bundleExtras = getIntent().getExtras();
        if(bundleExtras!=null)
        {
            nome = bundleExtras.getString("nome");

            Cursor cursor = getParticipante();

            int  intDetCPF, intDetEmail;

            intDetCPF = cursor.getColumnIndex(ParticipanteContract.Participante.COLUMN_NAME_CPF);
            intDetEmail = cursor.getColumnIndex(ParticipanteContract.Participante.COLUMN_NAME_EMAIL);


            cursor.moveToFirst();

            txtDetNome.setText(nome);
            txtDetCpf.setText(cursor.getString(intDetCPF));
            txtDetEmail.setText(cursor.getString(intDetEmail));
        }



        evDetAdapter = new EventoAdapter(getEventos());
        rclDetEventos.setAdapter(evDetAdapter);



        evDetAdapter.setOnEventLongClickListener(new EventoAdapter.OnEventLongClickListener() {
            @Override
            public void onEventLongClick(View EventView, int position) {

                TextView txtTitulo = (TextView) EventView.findViewById(R.id.txt_nomeTitulos);
                String titulo = txtTitulo.getText().toString();

                SQLiteDatabase db = MainActivity.dbHelper.getReadableDatabase();
                String restricoes = ParticipanteContract.Participante.COLUMN_NAME_NOME + " = ? AND " + ParticipacaoContract.Participacao.COLUMN_NAME_EVENTO + " = ?";
                String params[] = {nome, titulo};
                db.delete(ParticipacaoContract.Participacao.TABLE_NAME,restricoes,params);

                evDetAdapter.notifyItemRemoved(position);
                evDetAdapter.setCursor(getEventos());

            }
        });
        btnDetEvInsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParticipanteDet.this, EventoInsc.class);
                intent.putExtra(String.valueOf(MainActivity.PARTICIPANTE_NOME), txtDetNome.getText().toString());
                startActivityForResult(intent, MainActivity.INSC_EVENTO);

            }
        });
        btnDetEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = MainActivity.dbHelper.getWritableDatabase();
                ContentValues valoresParticipante = new ContentValues();
                ContentValues valoresParticipacao = new ContentValues();
                valoresParticipante.put(ParticipanteContract.Participante.COLUMN_NAME_NOME, txtDetNome.getText().toString());
                valoresParticipante.put(ParticipanteContract.Participante.COLUMN_NAME_CPF, txtDetCpf.getText().toString());
                valoresParticipante.put(ParticipanteContract.Participante.COLUMN_NAME_EMAIL, txtDetEmail.getText().toString());

                valoresParticipacao.put(ParticipacaoContract.Participacao.COLUMN_NAME_PARTICIPANTE, txtDetNome.getText().toString());

                String restricoes = ParticipanteContract.Participante.COLUMN_NAME_NOME + " = ?";
                String params[] = {nome};

                long id = db.update(ParticipanteContract.Participante.TABLE_NAME, valoresParticipante,restricoes,params);
                long id2 = db.update(ParticipacaoContract.Participacao.TABLE_NAME, valoresParticipacao,restricoes,params);

                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == MainActivity.INSC_EVENTO) {

            evDetAdapter.setCursor(getEventos());
        }
    }



    private Cursor getParticipante()
    {
        SQLiteDatabase db = MainActivity.dbHelper.getReadableDatabase();
        String []visao = {
                ParticipanteContract.Participante.COLUMN_NAME_NOME,
                ParticipanteContract.Participante.COLUMN_NAME_EMAIL,
                ParticipanteContract.Participante.COLUMN_NAME_CPF,


        };
        String sort = ParticipanteContract.Participante.COLUMN_NAME_NOME+ " ASC";
        String restricoes = ParticipanteContract.Participante.COLUMN_NAME_NOME + " = ?";
        String params[] = {nome};
        return db.query(ParticipanteContract.Participante.TABLE_NAME, visao,restricoes,params,null,null,null );
    }


    private Cursor getEventos()
    {
        SQLiteDatabase db = MainActivity.dbHelper.getReadableDatabase();
        String []visao = {
                ParticipacaoContract.Participacao.COLUMN_NAME_EVENTO
        };
        String sort = ParticipacaoContract.Participacao.COLUMN_NAME_EVENTO+ " ASC";
        String restricoes = ParticipacaoContract.Participacao.COLUMN_NAME_PARTICIPANTE + " = ?";
        String params[] = {nome};
        return db.query(ParticipacaoContract.Participacao.TABLE_NAME, visao,restricoes,params,null,null, sort);
    }
}