package isa.appfinalandroid.models2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import isa.appfinalandroid.R;

/**
 * Created by ASPIRE VX15 on 26/05/2018.
 */

public class EscenariosAdapter extends RecyclerView.Adapter<EscenariosAdapter.ViewHolder>{

    //Atributos
    private ArrayList<EscenariosDeportivos> dataset;
    private Context context;

    public EscenariosAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.
                cardescenarios, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EscenariosAdapter.ViewHolder holder, int position) {
        EscenariosDeportivos a=dataset.get(position);
        holder.nombre.setText(a.getNombre().toString());
        holder.admini.setText(a.getAdminstracion().toString());
        holder.comuna.setText(a.getComuna().toString());
        holder.loca.setText(a.getLocalizacion().toString());
    }
    public void agregar(ArrayList<EscenariosDeportivos> list)
    {
        dataset.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre;
        private TextView admini,comuna,loca,matr;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.ed_nombre);
            admini=(TextView)itemView.findViewById(R.id.ed_adminis);
            comuna=(TextView)itemView.findViewById(R.id.ed_comuna);
            loca=(TextView)itemView.findViewById(R.id.ed_loca);
        }
    }
}
