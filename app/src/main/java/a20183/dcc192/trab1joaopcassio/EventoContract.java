package a20183.dcc192.trab1joaopcassio;

import android.provider.BaseColumns;

public class EventoContract {
    public final class Evento implements BaseColumns {
        public final static String TABLE_NAME = "Evento";
        public static final String COLUMN_NAME_ID = "_ID";
        public final static String COLUMN_NAME_TITULO = "titulo";
        public final static String COLUMN_NAME_DATA = "data";
        public final static String COLUMN_NAME_HORA = "hora";
        public static final String COLUMN_NAME_FACILITADOR = "facilitador";
        public static final String COLUMN_NAME_DESCRICAO = "descricao";
        public final static String CREATE_EVENTO  = "CREATE TABLE "+Evento.TABLE_NAME+" ("
                + Evento.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Evento.COLUMN_NAME_TITULO + " TEXT, "
                + Evento.COLUMN_NAME_DATA + " TEXT,"
                + Evento.COLUMN_NAME_HORA + " TEXT,"
                + Evento.COLUMN_NAME_FACILITADOR + " TEXT,"
                + Evento.COLUMN_NAME_DESCRICAO + " TEXT"
                +")";
        public final static String DROP_EVENTO = "DROP TABLE IF EXISTS "+Evento.TABLE_NAME;
    }
}