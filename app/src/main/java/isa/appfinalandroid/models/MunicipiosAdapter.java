package isa.appfinalandroid.models;

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

public class MunicipiosAdapter extends RecyclerView.Adapter<MunicipiosAdapter.ViewHolder>
{
    //Atributos
    private ArrayList<Municipios> dataset;
    private Context context;

    public MunicipiosAdapter(Context context)
    {
        this.context = context;
        dataset = new ArrayList<>();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.
                cardmunicipios, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Municipios a=dataset.get(position);
        holder.clas.setText(a.getCodigodanemunicipio().toString());
        holder.extrang.setText(a.getCorreocontactenos().toString());
        holder.oficia.setText(a.getDireccion().toString());
        holder.partic.setText(a.getNit().toString());
        holder.publi.setText(a.getNombrealcalde().toString());
        holder.ttal.setText(a.getNombremunicipio().toString());
        holder.por.setText(a.getPortalweb().toString());
        holder.te.setText(a.getTelefonocontacto().toString());
    }

    @Override
    public int getItemCount()
    {
        return dataset.size();
    }

    public void agregar(ArrayList<Municipios> list)
    {
        dataset.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        //Cajas de texto
        private TextView clas;
        private TextView extrang;
        private TextView oficia;
        private TextView partic;
        private TextView publi;
        private TextView ttal;
        private TextView  por,te;


        public ViewHolder(View itemView)
        {
            super(itemView);
            clas=(TextView)itemView.findViewById(R.id.ed_dane);
            extrang=(TextView)itemView.findViewById(R.id.ed_correo);
            oficia=(TextView)itemView.findViewById(R.id.ed_direccion);
            partic=(TextView)itemView.findViewById(R.id.ed_nit);
            publi=(TextView)itemView.findViewById(R.id.ed_alcalde);
            ttal=(TextView)itemView.findViewById(R.id.ed_Municipio);
            por=(TextView)itemView.findViewById(R.id.ed_portal);
            te=(TextView)itemView.findViewById(R.id.ed_telefono);
        }

    }

}
