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

    public ParticipanteAdapter(List<Participante> participantes)
    {
        this.participantes = participantes;
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

    public interface OnPartClickListener {
        void onPartClick(View PartView, int position);
    }
    public void setOnPartClickListener(OnPartClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.nome.setText(participantes.get(position).getNome());

    }

    @Override
    public int getItemCount() {
        return participantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nome;
        public ViewHolder(final View itemView) {
            super(itemView);
            nome = (TextView)itemView.findViewById(R.id.txt_nomeTitulo);
        }
    }

}
