package a20183.dcc192.trab1joaopcassio;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import a20183.dcc192.trab1joaopcassio.Listas.ListaEventos;

public class EventoInsc extends AppCompatActivity {
    private RecyclerView rclInsEvento;
    private EventoAdapter EvInscAdapter;
    private Button btn_detInsVoltar;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insc_evento);

        btn_detInsVoltar = (Button) findViewById(R.id.btn_detInscVoltar);
        rclInsEvento = (RecyclerView) findViewById(R.id.rcl_detInsEv);
        rclInsEvento.setLayoutManager(new LinearLayoutManager(this));
        EvInscAdapter = new EventoAdapter(getEventos());
        rclInsEvento.setAdapter(EvInscAdapter);


        Bundle bundleExtras = getIntent().getExtras();
        if(bundleExtras!=null) {
            nome = bundleExtras.getString("nome");
        }


            EvInscAdapter.setOnEventClickListener(new EventoAdapter.OnEventClickListener() {
            @Override
            public void onEventClick(View EvView, int position) {
                try {
                TextView txtEvTitulo = (TextView) EvView.findViewById(R.id.txt_nomeTitulos);
                String evInsTitulo = txtEvTitulo.getText().toString();

                SQLiteDatabase db = MainActivity.dbHelper.getWritableDatabase();
                ContentValues valores = new ContentValues();
                valores.put(ParticipacaoContract.Participacao.COLUMN_NAME_EVENTO, evInsTitulo);
                valores.put(ParticipacaoContract.Participacao.COLUMN_NAME_PARTICIPANTE,nome);


                    long id = db.insert(ParticipacaoContract.Participacao.TABLE_NAME, null, valores);
                    Log.i("DBINFO", "registro criado com id: " + id);
                    Toast.makeText(getApplicationContext(), "Inscrito em evento", Toast.LENGTH_SHORT).show();
                }
                catch (SQLiteConstraintException e)
                {
                    Toast.makeText(getApplicationContext(), "Já está incrito neste evento", Toast.LENGTH_SHORT).show();
                }
            }
        } );
        btn_detInsVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultado = new Intent();
                setResult(Activity.RESULT_OK, resultado);
                finish();
            }
        });
    }

    private Cursor getEventos()
    {
        SQLiteDatabase db = MainActivity.dbHelper.getReadableDatabase();
        String []visao = {
                EventoContract.Evento.COLUMN_NAME_TITULO
        };
        String sort = EventoContract.Evento.COLUMN_NAME_TITULO+ " ASC";
        return db.query(EventoContract.Evento.TABLE_NAME, visao,null,null,null,null, sort);
    }
}