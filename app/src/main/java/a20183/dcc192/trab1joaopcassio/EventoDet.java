package a20183.dcc192.trab1joaopcassio;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import a20183.dcc192.trab1joaopcassio.Listas.ListaEventos;
import a20183.dcc192.trab1joaopcassio.Model.Evento;
import a20183.dcc192.trab1joaopcassio.Model.Participante;

public class EventoDet extends AppCompatActivity {
    private TextView txtDetTitulo, txtDetData, txtDetHora, txtDetFacilitador, txtDetDesc;
    private RecyclerView rclDetParticipantes;
    private ParticipanteAdapter PDetAdapter;
    private String titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.det_evento);
        txtDetTitulo = (TextView) findViewById(R.id.txt_detTitulo);
        txtDetData = (TextView) findViewById(R.id.txt_detData);
        txtDetHora = (TextView) findViewById(R.id.txt_detHora);
        txtDetFacilitador = (TextView) findViewById(R.id.txt_detFacilitador);
        txtDetDesc = (TextView) findViewById(R.id.txt_detDesc);

        Bundle bundleExtras = getIntent().getExtras();
        if(bundleExtras!=null)
        {
            titulo = bundleExtras.getString("titulo");
            Cursor cursor = getEvento();
            int intDetData, intDetHora, intDetFacilitador, intDetDesc;
            intDetData = cursor.getColumnIndex(EventoContract.Evento.COLUMN_NAME_DATA);
            intDetHora = cursor.getColumnIndex(EventoContract.Evento.COLUMN_NAME_HORA);
            intDetFacilitador = cursor.getColumnIndex(EventoContract.Evento.COLUMN_NAME_FACILITADOR);
            intDetDesc = cursor.getColumnIndex(EventoContract.Evento.COLUMN_NAME_DESCRICAO);
            txtDetTitulo.setText(titulo);
            txtDetData.setText(cursor.getString(intDetData));
            txtDetHora.setText(cursor.getString(intDetHora));
            txtDetFacilitador.setText(cursor.getString(intDetFacilitador));
            txtDetDesc.setText(cursor.getString(intDetDesc));
        }

        rclDetParticipantes = (RecyclerView) findViewById(R.id.rcl_detParticipantes);
        rclDetParticipantes.setLayoutManager(new LinearLayoutManager(this));

        PDetAdapter = new ParticipanteAdapter(getEventosParticipantes());

        rclDetParticipantes.setAdapter(PDetAdapter);
    }


    private Cursor getEventosParticipantes()
    {
        SQLiteDatabase db = MainActivity.dbHelper.getReadableDatabase();
        String []visao = {
                ParticipacaoContract.Participacao.COLUMN_NAME_PARTICIPANTE,

        };
        String sort = ParticipacaoContract.Participacao.COLUMN_NAME_PARTICIPANTE+ " ASC";
        String restricoes = ParticipacaoContract.Participacao.COLUMN_NAME_EVENTO + " = " + titulo;
        return db.query(ParticipacaoContract.Participacao.TABLE_NAME, visao,restricoes,null,null,null, sort);
    }
    private Cursor getEvento()
    {
        SQLiteDatabase db = MainActivity.dbHelper.getReadableDatabase();
        String []visao = {
                EventoContract.Evento.COLUMN_NAME_TITULO,
                EventoContract.Evento.COLUMN_NAME_HORA,
                EventoContract.Evento.COLUMN_NAME_DATA,
                EventoContract.Evento.COLUMN_NAME_FACILITADOR,
                EventoContract.Evento.COLUMN_NAME_DESCRICAO
        };
        String sort = EventoContract.Evento.COLUMN_NAME_TITULO+ " ASC";
        String restricoes = ParticipacaoContract.Participacao.COLUMN_NAME_EVENTO + " = " + titulo;
        return db.query(EventoContract.Evento.TABLE_NAME, visao,restricoes,null,null,null, sort);
    }

}