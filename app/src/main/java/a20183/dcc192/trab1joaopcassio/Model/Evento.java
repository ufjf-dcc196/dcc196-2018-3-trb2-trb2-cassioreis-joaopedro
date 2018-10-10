package a20183.dcc192.trab1joaopcassio.Model;

import java.util.Date;

public class Evento {
     String título,  facilitador , descrição;
     Date data;
     Date hora;

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getFacilitador() {
        return facilitador;
    }

    public void setFacilitador(String facilitador) {
        this.facilitador = facilitador;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public Evento(String título, String facilitador, String descrição, Date data, Date hora) {
        this.título = título;
        this.facilitador = facilitador;
        this.descrição = descrição;
        this.data = data;
        this.hora = hora;
    }
}
