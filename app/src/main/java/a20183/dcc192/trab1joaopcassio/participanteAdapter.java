package a20183.dcc192.trab1joaopcassio;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(final View itemView) {
            super(itemView);
        }
    }

}
