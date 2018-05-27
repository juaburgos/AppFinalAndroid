package isa.appfinalandroid.models5;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import isa.appfinalandroid.DialogoFragment;
import isa.appfinalandroid.MapsActivity;
import isa.appfinalandroid.R;

/**
 * Created by ASPIRE VX15 on 27/05/2018.
 */

public class LugaresAdapter extends RecyclerView.Adapter<LugaresAdapter.ViewHolder>{

    FragmentActivity mycontex;
    List<Lugares> luga;
    private Context context;

    public LugaresAdapter(List<Lugares> luga, Context context) {
        this.luga = luga;
        this.context = context;
    }

    @Override
    public LugaresAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlugares, parent, false);
        return new LugaresAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LugaresAdapter.ViewHolder holder, int i) {
        Lugares ed = luga.get(i);

        holder.tit.setText(ed.getNombre());
        holder.des.setText(ed.getDescri());

        Glide.with(context)
                .load(ed.getIma())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return luga.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tit;
        TextView des;
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);

            tit = (TextView)itemView.findViewById(R.id.titul);
            des = (TextView)itemView.findViewById(R.id.descr);
            img = (ImageView)itemView.findViewById(R.id.imageView9);




        }

        @Override
        public void onClick(View view) {

        }
    }
}
