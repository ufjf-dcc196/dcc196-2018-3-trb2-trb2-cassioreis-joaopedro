package a20183.dcc192.trab1joaopcassio;

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
    private Evento eventoAtual;
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
            int i;
            for(i=0 ; i <= ListaEventos.getInstance().size(); i++){
                if(titulo.equals(ListaEventos.getInstance().get(i).getTítulo())){
                    eventoAtual = ListaEventos.getInstance().get(i);
                    break;
                }

            }
            txtDetTitulo.setText(titulo);
            txtDetData.setText(eventoAtual.getData()) ;
            txtDetHora.setText(eventoAtual.getHora()) ;
            txtDetFacilitador.setText(eventoAtual.getFacilitador());
            txtDetDesc.setText(eventoAtual.getDescricao());
        }

        rclDetParticipantes = (RecyclerView) findViewById(R.id.rcl_detParticipantes);
        rclDetParticipantes.setLayoutManager(new LinearLayoutManager(this));

        PDetAdapter = new ParticipanteAdapter(eventoAtual.getParticipantes());

        rclDetParticipantes.setAdapter(PDetAdapter);
    }
}