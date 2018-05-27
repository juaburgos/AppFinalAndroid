package isa.appfinalandroid.models3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

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

        public ViewHolder(View itemView) {
            super(itemView);
            direccion=(TextView)itemView.findViewById(R.id.ed_dir);
            car=(CardView) itemView.findViewById(R.id.carv);

            car.setOnClickListener(new View.OnClickListener() {
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
