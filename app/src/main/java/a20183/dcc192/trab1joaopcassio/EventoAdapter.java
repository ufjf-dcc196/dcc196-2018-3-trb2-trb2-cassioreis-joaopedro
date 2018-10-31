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
    private OnEventClickListener listener;
    private OnEventLongClickListener longListener;

    public EventoAdapter(List<Evento> Eventos)
    {
        this.Eventos = Eventos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View EventoView =inflater.inflate(R.layout.rcl_layout_evento, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(EventoView);
        return viewHolder;
    }

    public interface OnEventClickListener {
        void onEventClick(View EventView, int position);
    }
    public void setOnEventClickListener(OnEventClickListener listener){
        this.listener = listener;
    }
    public interface OnEventLongClickListener {
        void onEventLongClick(View EventView, int position);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
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

            /***joao verifica se eu fiz alguma coisa de errado ak pq ta dando crash e ele sai*/

            nome = (TextView)itemView.findViewById(R.id.txt_nomeTitulos);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onEventClick(itemView, position);
                        }
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v) {
                    if(longListener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            longListener.onEventLongClick(itemView, position);
                            return true;
                        }
                    }
                    return false;
                }
            });
        }

        public void onClick(View v) {
            if(listener!=null){
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    listener.onEventClick(v, position);
                }
            }
        }

        public boolean onLongClick(View v) {
            if(longListener!=null){
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    longListener.onEventLongClick(v, position);
                    return true;
                }
            }
            return false;
        }
    }
}


