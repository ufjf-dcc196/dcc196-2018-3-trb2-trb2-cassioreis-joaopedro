package a20183.dcc192.trab1joaopcassio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EventoParticipanteDbHelper extends SQLiteOpenHelper {
    public final static int DATABASE_VERSION = 1;
    public final static String DATABASE_NAME = "ParticipantesEvento.db";

    public EventoParticipanteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EventoContract.Evento.CREATE_EVENTO);
        db.execSQL(ParticipanteContract.Participante.CREATE_PARTICIPANTE);
        db.execSQL(ParticipacaoContract.Participacao.CREATE_PARTICIPACAO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ParticipacaoContract.Participacao.DROP_PARTICIPACAO);
        db.execSQL(ParticipanteContract.Participante.DROP_PARTICIPANTE);
        db.execSQL(EventoContract.Evento.DROP_EVENTO);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
