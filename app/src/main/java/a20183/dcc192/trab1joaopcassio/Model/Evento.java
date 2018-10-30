package a20183.dcc192.trab1joaopcassio.Model;

import java.util.Date;

public class Evento {
     String título,  facilitador , descrição;
     String data;
    String hora;

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

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public Evento(String título, String facilitador, String descrição, String data, String hora) {
        this.título = título;
        this.facilitador = facilitador;
        this.descrição = descrição;
        this.data = data;
        this.hora = hora;
    }
}
