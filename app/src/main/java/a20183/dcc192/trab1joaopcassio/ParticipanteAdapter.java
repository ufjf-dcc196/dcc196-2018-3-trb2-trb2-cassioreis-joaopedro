package a20183.dcc192.trab1joaopcassio;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import a20183.dcc192.trab1joaopcassio.Model.Participante;

class ParticipanteAdapter extends RecyclerView.Adapter<ParticipanteAdapter.ViewHolder> {

    private List<Participante> participantes;
    private OnPartClickListener listener;
    private OnPartLongClickListener longListener;

    public ParticipanteAdapter(List<Participante> participantes)
    {
        this.participantes = participantes;
    }

    public interface OnPartClickListener {
        void onPartClick(View PartView, int position);
    }
    public void setOnPartClickListener(OnPartClickListener listener){
        this.listener = listener;
    }

    public interface OnPartLongClickListener {
        void onPartLongClick(View PartView, int position);
    }
    public void setOnPartLongClickListener(OnPartLongClickListener listener){
        this.longListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View participanteView =inflater.inflate(R.layout.rcl_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(participanteView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.txtNome.setText(participantes.get(position).getNome());

    }

    @Override
    public int getItemCount() {
        return participantes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        public TextView txtNome;

        public ViewHolder(final View itemView) {
            super(itemView);
            txtNome = (TextView) itemView.findViewById(R.id.txt_nomeTitulo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onPartClick(itemView, position);
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
                            longListener.onPartLongClick(itemView, position);
                            return true;
                        }
                    }
                    return false;
                }
            });
        }

        @Override
        public void onClick(View v) {
            if(listener!=null){
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    listener.onPartClick(v, position);
                }
            }
        }
        @Override
        public boolean onLongClick(View v) {
            if(longListener!=null){
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    longListener.onPartLongClick(v, position);
                    return true;
                }
            }
            return false;
        }
    }
}
