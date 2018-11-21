package a20183.dcc192.trab1joaopcassio;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import a20183.dcc192.trab1joaopcassio.Listas.ListaParticipantes;
import a20183.dcc192.trab1joaopcassio.Model.Participante;

public class ParticipanteCads extends AppCompatActivity {

    private Button btnCadastrar;
    private EditText txtNome, txtCpf, txtEmail;

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
                SQLiteDatabase db = MainActivity.dbHelper.getWritableDatabase();
                ContentValues valores = new ContentValues();
                valores.put(ParticipanteContract.Participante.COLUMN_NAME_NOME, txtNome.getText().toString());
                valores.put(ParticipanteContract.Participante.COLUMN_NAME_CPF, txtCpf.getText().toString());
                valores.put(ParticipanteContract.Participante.COLUMN_NAME_EMAIL, txtEmail.getText().toString());
                long id = db.insert(ParticipanteContract.Participante.TABLE_NAME,null, valores);
                Log.i("DBINFO", "registro criado com id: "+id);
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }
}