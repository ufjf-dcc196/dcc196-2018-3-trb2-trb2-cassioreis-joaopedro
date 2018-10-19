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

class participanteAdapter extends RecyclerView.Adapter<participanteAdapter.ViewHolder> {

    private List<Participante> participantes;

    public participanteAdapter(List<Participante> participantes)
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

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Participante participante = participantes.get(position);
        viewHolder.nome.setText(participante.getNome());
    }

    @Override
    public int getItemCount() {
        return participantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nome;
        public ViewHolder(final View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txt_nomeTitulo);
        }
    }

}
