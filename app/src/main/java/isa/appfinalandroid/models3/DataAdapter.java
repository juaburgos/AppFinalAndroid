package isa.appfinalandroid.models3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import isa.appfinalandroid.DialogoFragment;
import isa.appfinalandroid.MapsActivity;
import isa.appfinalandroid.R;
import isa.appfinalandroid.models.Municipios;

/**
 * Created by ASPIRE VX15 on 26/05/2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>
{
    //Atributos
    private ArrayList<Taxis> dataset;
    private Context context;

    public DataAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.
                cardtaxis, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {

        Taxis a=dataset.get(position);
        holder.direccion.setText(a.getDireccion().toString());
        if(holder.direccion.equals("CARRERA 19 N° 13-56 PISO 2  AV. LAS AMÉRICAS "))
        {
            holder.nombre.setText("AUTOPASTO");
        }

        else if(holder.direccion.equals("CALLE 2 No 33-10 AV/ PANAMERICANA "))
        {
            holder.nombre.setText("COONARTAX");
        }
        else if(holder.direccion.equals("CALLE 20A NO.2-48 B. LAS MERCEDES"))
        {
            holder.nombre.setText("COOTAXLUJO");
        }
        else if(holder.direccion.equals("CARRERA 13 N°. 17 –21 B/ FATIMA "))
        {
            holder.nombre.setText("EMPRESA GALENA");
        }

        else if(holder.direccion.equals("CALLE 22 No 20 BIS-24 2do PISO AV/ SANTANDER"))
        {
            holder.nombre.setText("EXPRESO JUANAMBU");
        }
        else if(holder.direccion.equals("CARRERA 41 N° 20-50 B/MORASURCO"))
        {
            holder.nombre.setText("FLOTA GALERAS");
        }
        else if(holder.direccion.equals("CARRERA 14 N° 20-34 B/FATIMA"))
        {
            holder.nombre.setText("FLOTA GUAITARA");
        }
        else if(holder.direccion.equals("CARRERA 17 N° 19-37"))
        {
            holder.nombre.setText("TAXI EXPRESS");
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void agregar(ArrayList<Taxis> list)
    {
        dataset.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nombre,direccion;
        private CardView car;
        private ImageButton imageButton;

        public ViewHolder(View itemView) {
            super(itemView);
            direccion=(TextView)itemView.findViewById(R.id.ed_dir);
            nombre=(TextView)itemView.findViewById(R.id.ed_nom);
            car=(CardView) itemView.findViewById(R.id.carv);

            imageButton=(ImageButton)itemView.findViewById(R.id.imageButton);
            imageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    final String edi1 = direccion.getText().toString();

                        Intent myIntent = new Intent(context, MapsActivity.class);
                        myIntent.putExtra("param", edi1);
                        context.startActivity(myIntent);


                }
            });

        }

        @Override
        public void onClick(View view) {

        }
    }
}
