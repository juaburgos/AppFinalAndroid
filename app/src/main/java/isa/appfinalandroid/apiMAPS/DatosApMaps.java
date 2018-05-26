package isa.appfinalandroid.apiMAPS;

import java.util.List;

import isa.appfinalandroid.modelsMapa.WifiGratis;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 26/05/2018.
 */

public interface DatosApMaps
{
    @GET("f4kx-n3nn.json")
    Call<List<WifiGratis>> obtenerPuntosMapa();
}
