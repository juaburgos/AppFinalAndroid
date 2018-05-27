package isa.appfinalandroid;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import isa.appfinalandroid.models5.Lugares;
import isa.appfinalandroid.models5.LugaresAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class LugaresFragment extends Fragment {

    private FragmentActivity myContext;
    private RecyclerView listadoLugares;

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    public LugaresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_lugares, container, false);
        listadoLugares = (RecyclerView)view.findViewById(R.id.recy);
        List<Lugares> impr = new ArrayList<Lugares>();


        impr.add(new Lugares(getResources().getString(R.string.titulo), getResources().getString(R.string.descripcion),R.drawable.laslajas));
        impr.add(new Lugares(getResources().getString(R.string.titulo2),getResources().getString(R.string.descripcion2),R.drawable.laguna));
        impr.add(new Lugares(getResources().getString(R.string.titulo3), getResources().getString(R.string.descripcion3),R.drawable.lacocha));
        impr.add(new Lugares(getResources().getString(R.string.titulo4), getResources().getString(R.string.descripcion4),R.drawable.chimayoy));

        listadoLugares.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        listadoLugares.setLayoutManager(layoutManager);
        LugaresAdapter adapter = new LugaresAdapter(impr,myContext);
        listadoLugares.setAdapter(adapter);


        return view;
    }

}
