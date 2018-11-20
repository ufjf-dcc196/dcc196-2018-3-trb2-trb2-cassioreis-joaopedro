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

import a20183.dcc192.trab1joaopcassio.Listas.ListaParticipantes;
import a20183.dcc192.trab1joaopcassio.Model.Participante;

public class ParticipanteCads extends AppCompatActivity {

    private Button btnCadastrar;
    private EditText txtNome, txtCpf, txtEmail;
    private EventoParticipanteDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cads_participante);

        btnCadastrar = (Button) findViewById(R.id.btn_cadastrarParticipante);
        txtNome = (EditText) findViewById(R.id.txt_nomeCads);
        txtCpf = (EditText) findViewById(R.id.txt_cpfCads);
        txtEmail = (EditText) findViewById(R.id.txt_emailCads);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues valores = new ContentValues();
                valores.put(ParticipanteContract.Participante.COLUMN_NAME_NOME, txtNome.getText().toString());
                valores.put(ParticipanteContract.Participante.COLUMN_NAME_CPF, txtCpf.getText().toString());
                valores.put(ParticipanteContract.Participante.COLUMN_NAME_EMAIL, txtEmail.getText().toString());
                long id = db.insert(ParticipanteContract.Participante.COLUMN_NAME_ID,null, valores);
                Intent intent = new Intent(ParticipanteCads.this, MainActivity.class);
                startActivity(intent);

            /*
                Participante participante = new Participante(txtNome.getText().toString(),txtCpf.getText().toString(),txtEmail.getText().toString());
                ListaParticipantes.getInstance().add(participante);
                setResult(Activity.RESULT_OK);
                finish();
                */
          }
        });
    }
}