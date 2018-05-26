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

import isa.appfinalandroid.api2.ApiDeportivos;
import isa.appfinalandroid.models2.EscenariosAdapter;
import isa.appfinalandroid.models2.EscenariosDeportivos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class EscenariosDeportivosFragment extends Fragment {

    public static final String TAG="DATOS COLOMBIA";
    private Retrofit retrofit;
    private EscenariosAdapter listaEscenarios;
    private RecyclerView recyclerView;
    private int ofset;
    private boolean cargar;
    private FragmentActivity myContext;

    public EscenariosDeportivosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_escenarios_deportivos, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        listaEscenarios = new EscenariosAdapter(getContext());
        recyclerView.setAdapter(listaEscenarios);

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
        ApiDeportivos service = retrofit.create(ApiDeportivos.class);
        Call<ArrayList<EscenariosDeportivos>> reporteRespuestaCall = service.obtenerListaEscenarios();

        reporteRespuestaCall.enqueue(new Callback<ArrayList<EscenariosDeportivos>>() {
            @Override
            public void onResponse(Call<ArrayList<EscenariosDeportivos>> call, Response<ArrayList<EscenariosDeportivos>> response) {
                if(response.isSuccessful())
                {
                    ArrayList listado = response.body();
                    listaEscenarios.agregar(listado);
                }
                else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EscenariosDeportivos>> call, Throwable t) {
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
