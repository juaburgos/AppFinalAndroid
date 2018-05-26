package isa.appfinalandroid.api;

import java.util.ArrayList;

import isa.appfinalandroid.models.Municipios;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 26/05/2018.
 */

public interface DatosApi
{
    @GET("v2gq-kc7t.json")
    Call<ArrayList<Municipios>> obtenerListaMunicipios();
}
