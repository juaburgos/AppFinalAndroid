package isa.appfinalandroid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import isa.appfinalandroid.apiMAPS.DatosApMaps;
import isa.appfinalandroid.modelsMapa.WifiGratis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.InfoWindowAdapter, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;

    public static final String EXTRA_LATITUD = "";
    public static final String EXTRA_LONGITUD = "";
    public final static String TAG ="DATOS COLOMBIA";
    private Retrofit retrofit;
    private Marker markerArgentina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        retrofit=new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create()).build();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Bundle parametros = this.getIntent().getExtras();
        String datos = parametros.getString("param");

        if(datos.equalsIgnoreCase("CARRERA 19 N° 13-56 PISO 2  AV. LAS AMÉRICAS "))
        {
            LatLng sydney = new LatLng(1.3625542,-78.1810467);
            //mMap.addMarker(new MarkerOptions().position(sydney).title("El Diviso").snippet(""+"").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            markerArgentina = googleMap.addMarker(
                    new MarkerOptions()
                            .position(sydney)
                            .title("Argentina")
            );
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 5));
        }

        else if(datos.equalsIgnoreCase("CALLE 2 No 33-10 AV/ PANAMERICANA "))
        {
            LatLng sydney = new LatLng(1.3625542,-78.0467);
            //mMap.addMarker(new MarkerOptions().position(sydney).title("El Diviso").snippet(""+"").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            markerArgentina = googleMap.addMarker(
                    new MarkerOptions()
                            .position(sydney)
                            .title("Pasto")
            );
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 5));
        }




        mMap.setInfoWindowAdapter(this);
        mMap.setOnInfoWindowClickListener(this);


    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return prepareInfoView(marker);
    }

    private View prepareInfoView(Marker marker) {

        LinearLayout infoView = new LinearLayout(MapsActivity.this);
        LinearLayout.LayoutParams infoViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        infoView.setOrientation(LinearLayout.HORIZONTAL);
        infoView.setLayoutParams(infoViewParams);

        ImageView infoImageView = new ImageView(MapsActivity.this);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_wifi_black_24dp,null);
        infoImageView.setImageDrawable(drawable);
        infoView.addView(infoImageView);

        LinearLayout subInfoView = new LinearLayout(MapsActivity.this);
        LinearLayout.LayoutParams subInfoViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        subInfoView.setOrientation(LinearLayout.VERTICAL);
        subInfoView.setLayoutParams(subInfoViewParams);

        TextView subInfoLad = new TextView(MapsActivity.this);
        subInfoLad.setText(" La: " + marker.getPosition().latitude);
        TextView subInfoLad1 =  new TextView(MapsActivity.this);
        subInfoLad1.setText(" La: " + marker.getPosition().longitude);
        subInfoView.addView(subInfoLad);
        subInfoView.addView(subInfoLad1);

        infoView.addView(subInfoView);
        return  infoView;
    }


    @Override
    public void onInfoWindowClick(Marker marker) {
        if (marker.equals(markerArgentina)) {

            DialogoFragment.newInstance(marker.getTitle(),
                    getString(R.string.argentina_full_snippet)).show(getFragmentManager(),null);
        }
    }
}
