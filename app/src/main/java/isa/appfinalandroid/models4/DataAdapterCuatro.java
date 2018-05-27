package isa.appfinalandroid.models4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import isa.appfinalandroid.R;
import isa.appfinalandroid.models3.DataAdapter;

/**
 * Created by ASPIRE VX15 on 27/05/2018.
 */

public class DataAdapterCuatro extends RecyclerView.Adapter<DataAdapterCuatro.ViewHolder>
{

    private ArrayList<ParquesNacionales> dataset;
    private Context context;

    public DataAdapterCuatro(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.
                cardparques, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ParquesNacionales a=dataset.get(position);
        holder.barrio.setText(a.getBarrio().toString());
        holder.depa.setText(a.getDepartamento().toString());
        holder.mun.setText(a.getMunicipio().toString());
        //holder.dane.setText(a.getidString());
        //holder.telefo.setText(a.getTelFonosDeContacto().toString());
        //holder.tipo.setText(a.getTipoDeBiblioteca().toString());
        //holder.centro.setText(a.getCentroPoblado().toString());
       // holder.direcc.setText(a.getDirecciNDeLaBiblioteca().toString());
        //holder.estado.setText(a.getEstadoDeLaBiblioteca().toString());

        //holder.dane.setText(a.getCDigoDane().toString());

/*       */
        //holder.geo.setText(a.getGeoreferencia().toString());
/*
holder.natu.setText(a.getNaturalezaDeLaBiblioteca().toString());
 holder.nombre.setText(a.getNombreDeLaBiblioteca().toString());
      */

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void agregar(ArrayList<ParquesNacionales> list)
    {
        dataset.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView barrio,dane,centro,depa,direcc,estado,geo,mun,natu,nombre,telefo,tipo;

        public ViewHolder(View itemView) {
            super(itemView);
            barrio=(TextView)itemView.findViewById(R.id.ed_ba);
            dane=(TextView)itemView.findViewById(R.id.ed_dan);
            centro=(TextView)itemView.findViewById(R.id.ed_cent);
            depa=(TextView)itemView.findViewById(R.id.ed_depa);
            direcc=(TextView)itemView.findViewById(R.id.ed_direc);
            estado=(TextView)itemView.findViewById(R.id.ed_esta);
            geo=(TextView)itemView.findViewById(R.id.ed_geo);
            mun=(TextView)itemView.findViewById(R.id.ed_muni);
            natu=(TextView)itemView.findViewById(R.id.ed_natu);
            nombre=(TextView)itemView.findViewById(R.id.ed_no);
            telefo=(TextView)itemView.findViewById(R.id.ed_telefono);
            tipo=(TextView)itemView.findViewById(R.id.ed_tip);
        }
    }
}
