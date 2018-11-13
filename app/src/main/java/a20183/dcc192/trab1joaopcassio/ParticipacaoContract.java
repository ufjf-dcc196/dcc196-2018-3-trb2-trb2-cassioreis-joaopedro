package a20183.dcc192.trab1joaopcassio;

import android.provider.BaseColumns;

public class ParticipacaoContract{
    public final class Participacao implements BaseColumns {
        public final static String TABLE_NAME = "Participacao";
        public final static String COLUMN_NAME_EVENTO = "titulo";
        public static final String COLUMN_NAME_PARTICIPANTE = "nome";
        public final static String CREATE_PARTICIPACAO  = "CREATE TABLE "+Participacao.TABLE_NAME+" ("
                + Participacao.COLUMN_NAME_EVENTO+ " TEXT REFERENCES Evento(titulo), "
                + Participacao.COLUMN_NAME_PARTICIPANTE+ " TEXT REFERENCES Participante(nome)"
                + "PRIMARY KEY (titulo,nome)"
                +")";
        public final static String DROP_PARTICIPACAO = "DROP TABLE IF EXISTS "+Participacao.TABLE_NAME;
    }
}