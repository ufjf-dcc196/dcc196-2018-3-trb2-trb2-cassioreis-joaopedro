package a20183.dcc192.trab1joaopcassio;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EventoCads extends AppCompatActivity {

    private Button btnCadastrar;
    private EditText txtTitulo,txtDia,txtHora,txtFacilitador,txtDesc;

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

                Intent resultado = new Intent();
                setResult(Activity.RESULT_OK, resultado);
                finish();

            }
        });
    }
}