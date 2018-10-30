package a20183.dcc192.trab1joaopcassio;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import a20183.dcc192.trab1joaopcassio.Model.Evento;

public class EventoAdapter  extends RecyclerView.Adapter<EventoAdapter.ViewHolder> {

    private List<Evento> Eventos;

    public EventoAdapter(List<Evento> Eventos)
    {
        this.Eventos = Eventos;
    }

    @NonNull
    @Override
    public EventoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View EventoView =inflater.inflate(R.layout.rcl_layout_evento, viewGroup, false);
        EventoAdapter.ViewHolder viewHolder = new EventoAdapter.ViewHolder(EventoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventoAdapter.ViewHolder viewHolder, int position) {
        viewHolder.nome.setText(Eventos.get(position).getTítulo());

    }

    @Override
    public int getItemCount() {
        return Eventos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nome;
        public ViewHolder(final View itemView) {
            super(itemView);
            nome = (TextView)itemView.findViewById(R.id.txt_nomeTitulos);
        }
    }

}

