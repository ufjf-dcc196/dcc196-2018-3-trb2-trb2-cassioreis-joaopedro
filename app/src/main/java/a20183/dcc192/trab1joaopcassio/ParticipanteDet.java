package a20183.dcc192.trab1joaopcassio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import a20183.dcc192.trab1joaopcassio.Listas.ListaParticipantes;
import a20183.dcc192.trab1joaopcassio.Model.Evento;
import a20183.dcc192.trab1joaopcassio.Model.Participante;

public class ParticipanteDet extends AppCompatActivity {
    private EditText txtDetNome, txtDetEmail, txtDetCpf;
    private RecyclerView rclDetEventos;
    private EventoAdapter evAdapter;
    private List<Evento> eventosParticipando = new ArrayList<Evento>();
    private String nome,email,cpf;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.det_participante);

        txtDetNome = (EditText) findViewById(R.id.txt_detNome);
        txtDetEmail = (EditText) findViewById(R.id.txt_detEmail);
        txtDetCpf = (EditText) findViewById(R.id.txt_detCpf);

        rclDetEventos = (RecyclerView) findViewById(R.id.rcl_detEventos);
        rclDetEventos.setLayoutManager(new LinearLayoutManager(this));
        evAdapter = new EventoAdapter(eventosParticipando);
        rclDetEventos.setAdapter(evAdapter);

        Bundle bundleExtras = getIntent().getExtras();
        if(bundleExtras!=null)
        {
            nome = bundleExtras.getString("nome");


            /*VERIFICAR COMO IREMOS FAZER PARA CRIAR ESSE OBJETO, JA QUE TEMOS SOMENTE O NOEM, MINHA IDEIA ERA
            * PERCORRER A LISTA E SE EU ACHASSE UM NOME IGUAL EU PARAVA, DEPOIS DISSO EU CRIAVA O PARTICIPANTE
            */
            for(i=0 ; i <= ListaParticipantes.getInstance().size();i++){
                if(nome.equals(ListaParticipantes.getInstance().get(i).getNome())){
                    break;
                }

            }
            txtDetNome.setText(ListaParticipantes.getInstance().get(i).getNome()) ;
            //   txtDetEmail.setText(ListaParticipantes.getInstance().get(i).getEmail()) ;
            //  txtDetCpf.setText(ListaParticipantes.getInstance().get(i).getCPF()) ;
        }
    }
}