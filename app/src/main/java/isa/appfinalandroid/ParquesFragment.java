package isa.appfinalandroid;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import isa.appfinalandroid.api4.DatosApiCuatro;
import isa.appfinalandroid.models4.DataAdapterCuatro;
import isa.appfinalandroid.models4.ParquesNacionales;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParquesFragment extends Fragment {

    public static final String TAG="DATOS COLOMBIA";
    private Retrofit retrofit;
    private DataAdapterCuatro listamunicipios;
    private RecyclerView recyclerView;
    private int ofset;
    private boolean cargar;
    private FragmentActivity myContext;

    public ParquesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_parques, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        listamunicipios = new DataAdapterCuatro(getContext());
        recyclerView.setAdapter(listamunicipios);

        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        Log.i(TAG, "ka");
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0)
                {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();


                    if (cargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, ".");
                            cargar = false;
                            ofset += 1;
                            obtenerDatosReportesVehiculos();
                        }
                    }

                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cargar = true;
        ofset = 0;

        obtenerDatosReportesVehiculos();
        return view;
    }

    private void obtenerDatosReportesVehiculos() {
        DatosApiCuatro service = retrofit.create(DatosApiCuatro.class);
        Call<ArrayList<ParquesNacionales>> reporteRespuestaCall = service.obtenerListaEscenarios();

        reporteRespuestaCall.enqueue(new Callback<ArrayList<ParquesNacionales>>() {
            @Override
            public void onResponse(Call<ArrayList<ParquesNacionales>> call, Response<ArrayList<ParquesNacionales>> response) {
                if(response.isSuccessful())
                {
                    ArrayList listado = response.body();
                    listamunicipios.agregar(listado);
                }
                else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ParquesNacionales>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }

    @Override
    public void onAttach(Context activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}
