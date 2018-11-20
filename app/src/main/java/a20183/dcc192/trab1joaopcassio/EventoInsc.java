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
import android.widget.TextView;
import android.widget.Toast;

import a20183.dcc192.trab1joaopcassio.Listas.ListaEventos;

public class EventoInsc extends AppCompatActivity {
    private RecyclerView rclInsEvento;
    private EventoAdapter EvInscAdapter;
    private Button btn_detInsVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insc_evento);

        btn_detInsVoltar = (Button) findViewById(R.id.btn_detInscVoltar);
        rclInsEvento = (RecyclerView) findViewById(R.id.rcl_detInsEv);
        rclInsEvento.setLayoutManager(new LinearLayoutManager(this));
        EvInscAdapter = new EventoAdapter(ListaEventos.getInstance());
        rclInsEvento.setAdapter(EvInscAdapter);

        EvInscAdapter.setOnEventClickListener(new EventoAdapter.OnEventClickListener() {
            @Override
            public void onEventClick(View EvView, int position) {

                TextView txtEvTitulo = (TextView) EvView.findViewById(R.id.txt_nomeTitulos);
                String evInsTitulo = txtEvTitulo.getText().toString();
                for(int i=0; i <ListaEventos.getInstance().size();i++){
                    if(evInsTitulo.equals(ListaEventos.getInstance().get(i).getTítulo()) && !ListaEventos.getInstance().get(i).findParticipante(ParticipanteDet.participanteAtual))
                    {
                        ListaEventos.getInstance().get(i).addParticipante(ParticipanteDet.participanteAtual);
                        Toast.makeText(getApplicationContext(), "Inscrito",Toast.LENGTH_SHORT).show();
                        break;
                    }
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


/*
falta fazer essa funcao
    private Cursor getInsc()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String []visao = {
                EventoContract.Evento.COLUMN_NAME_DESCRICAO,
                EventoContract.Evento.COLUMN_NAME_HORA,
                EventoContract.Evento.COLUMN_NAME_TITULO
        };
        String sort = EventoContract.Evento.COLUMN_NAME_ID+ " ASC";
        return db.query(EventoContract.Evento.TABLE_NAME, visao,null,null,null,null, sort);
    }
*/
}