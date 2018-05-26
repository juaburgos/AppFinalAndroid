package isa.appfinalandroid.api3;

import java.util.ArrayList;

import isa.appfinalandroid.models3.Taxis;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 26/05/2018.
 */

public interface DatossApii
{
    @GET("4p32-twbt.json")
    Call<ArrayList<Taxis>> obtenerListaEscenarios();
}
