package a20183.dcc192.trab1joaopcassio;

import android.provider.BaseColumns;

public final class ParticipanteContract {
    public final class Participante implements BaseColumns {
        public final static String TABLE_NAME = "Participante";
        public static final String COLUMN_NAME_ID = "_ID";
        public final static String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_CPF = "cpf";
        public final static String CREATE_PARTICIPANTE  = "CREATE TABLE "+Participante.TABLE_NAME+" ("
                + Participante._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Participante.COLUMN_NAME_NOME+ " TEXT, "
                + Participante.COLUMN_NAME_EMAIL+ " TEXT,"
                + Participante.COLUMN_NAME_CPF+ " TEXT"
                +")";
        public final static String DROP_PARTICIPANTE = "DROP TABLE IF EXISTS "+Participante.TABLE_NAME;
    }
}