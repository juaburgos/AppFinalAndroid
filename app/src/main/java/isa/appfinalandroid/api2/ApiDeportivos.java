package isa.appfinalandroid.api2;

import java.util.ArrayList;

import isa.appfinalandroid.models2.EscenariosDeportivos;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 26/05/2018.
 */

public interface ApiDeportivos
{
    @GET("eiji-v24r.json")
    Call<ArrayList<EscenariosDeportivos>> obtenerListaEscenarios();
}
