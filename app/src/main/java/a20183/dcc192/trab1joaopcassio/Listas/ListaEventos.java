package a20183.dcc192.trab1joaopcassio.Listas;

import java.util.ArrayList;
import java.util.List;

import a20183.dcc192.trab1joaopcassio.Model.Evento;

public class ListaEventos {

    private static List<Evento> eventos;

    public static List<Evento> getInstance() {
        if (eventos == null) {
            eventos = new ArrayList<>();
        }
        return eventos;
    }
}
