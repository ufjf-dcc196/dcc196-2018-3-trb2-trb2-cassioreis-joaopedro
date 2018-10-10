package a20183.dcc192.trab1joaopcassio;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteDAO {

    private static List<Participante> participantes;

    public static List<Participante> getInstance() {
        if (participantes == null) {
            participantes = new ArrayList<>();
        }
        return participantes;
    }
}
