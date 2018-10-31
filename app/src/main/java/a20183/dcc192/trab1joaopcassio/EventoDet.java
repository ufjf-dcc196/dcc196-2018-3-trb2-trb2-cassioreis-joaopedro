package a20183.dcc192.trab1joaopcassio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import a20183.dcc192.trab1joaopcassio.Listas.ListaEventos;
import a20183.dcc192.trab1joaopcassio.Model.Participante;

public class EventoDet extends AppCompatActivity {
    private TextView txtDetTitulo, txtDetData, txtDetHora, txtDetFacilitador, txtDetDesc;
    private RecyclerView rclDetParticipantes;
    private Participante PAdapter;
    private List<Participante> participantes = new ArrayList<Participante>();
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
                    break;
                }

            }
            txtDetTitulo.setText(titulo);
            txtDetData.setText(ListaEventos.getInstance().get(i).getData()) ;
            txtDetHora.setText(ListaEventos.getInstance().get(i).getHora()) ;
            txtDetFacilitador.setText(ListaEventos.getInstance().get(i).getFacilitador());
            txtDetDesc.setText(ListaEventos.getInstance().get(i).getDescricao());
        }
    }
}