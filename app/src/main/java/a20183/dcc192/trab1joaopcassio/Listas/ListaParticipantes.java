package a20183.dcc192.trab1joaopcassio.Listas;

import java.util.ArrayList;
import java.util.List;

import a20183.dcc192.trab1joaopcassio.Model.Participante;

public class ListaParticipantes {

    private static List<Participante> participantes;

    public static List<Participante> getInstance() {
        if (participantes == null) {
            participantes = new ArrayList<>();
        }
        return participantes;
    }
}
