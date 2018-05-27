package isa.appfinalandroid.api4;

import java.util.ArrayList;

import isa.appfinalandroid.models4.ParquesNacionales;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 27/05/2018.
 */

public interface DatosApiCuatro {
    @GET("in3j-awgi.json")
    Call<ArrayList<ParquesNacionales>> obtenerListaEscenarios();
}
