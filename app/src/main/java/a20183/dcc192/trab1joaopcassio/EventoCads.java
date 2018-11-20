package a20183.dcc192.trab1joaopcassio;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import a20183.dcc192.trab1joaopcassio.Listas.ListaEventos;
import a20183.dcc192.trab1joaopcassio.Listas.ListaParticipantes;
import a20183.dcc192.trab1joaopcassio.Model.Evento;

public class EventoCads extends AppCompatActivity {

    private Button btnCadastrar;
    private EditText txtTitulo,txtDia,txtHora,txtFacilitador,txtDesc;
    private EventoParticipanteDbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cads_evento);

        btnCadastrar = (Button) findViewById(R.id.btn_cadastrarEvento);
        txtTitulo = (EditText) findViewById(R.id.txt_tituloCads);
        txtDia = (EditText) findViewById(R.id.txt_diaCads);
        txtHora = (EditText) findViewById(R.id.txt_horaCads);
        txtFacilitador = (EditText) findViewById(R.id.txt_facilitadorCads);
        txtDesc = (EditText) findViewById(R.id.txt_descCads);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues valores = new ContentValues();
                valores.put(EventoContract.Evento.COLUMN_NAME_DATA, txtDia.getText().toString());
                valores.put(EventoContract.Evento.COLUMN_NAME_DESCRICAO, txtDesc.getText().toString());
                valores.put(EventoContract.Evento.COLUMN_NAME_FACILITADOR, txtFacilitador.getText().toString());
                valores.put(EventoContract.Evento.COLUMN_NAME_HORA, txtHora.getText().toString());
                valores.put(EventoContract.Evento.COLUMN_NAME_TITULO, txtTitulo.getText().toString());
                long id = db.insert(EventoContract.Evento.COLUMN_NAME_ID,null, valores);
                Intent intent = new Intent(EventoCads.this, MainActivity.class);
                startActivity(intent);


                /*


                Intent resultado = new Intent();
                Evento evento = new Evento(txtTitulo.getText().toString(),txtFacilitador.getText().toString(),txtDesc.getText().toString(),txtDia.getText().toString(),txtHora.getText().toString());
                ListaEventos.getInstance().add(evento);
                setResult(Activity.RESULT_OK, resultado);
                finish();
                */
            }
        });
    }
}