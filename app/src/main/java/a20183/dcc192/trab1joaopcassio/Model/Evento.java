package a20183.dcc192.trab1joaopcassio.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {
    private String título,  facilitador , descrição;
    private String data;
    private String hora;
    private List<Participante> participantes;

    public Evento(String título, String facilitador, String descricao, String data, String hora) {
        this.título = título;
        this.facilitador = facilitador;
        this.descrição = descricao;
        this.data = data;
        this.hora = hora;
        participantes = new ArrayList<Participante>();
    }

    public void addParticipante(Participante novoParticipante){ this.participantes.add(novoParticipante);}
    public void removeParticipante(Participante novoParticipante){this.participantes.remove(novoParticipante);}
    public boolean findParticipante(Participante procuraParticipante)
    {
        if(participantes.contains(procuraParticipante))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFacilitador() {
        return facilitador;
    }

    public void setFacilitador(String facilitador) {
        this.facilitador = facilitador;
    }

    public String getDescricao() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }


}
