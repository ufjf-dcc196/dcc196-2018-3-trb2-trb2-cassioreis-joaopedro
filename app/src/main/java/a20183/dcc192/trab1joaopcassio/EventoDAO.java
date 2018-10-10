package a20183.dcc192.trab1joaopcassio;

import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    private static List<Evento> eventos;

    public static List<Evento> getInstance() {
        if (eventos == null) {
            eventos = new ArrayList<>();
        }
        return eventos;
    }
}
