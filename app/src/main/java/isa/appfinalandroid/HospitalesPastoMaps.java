package isa.appfinalandroid;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HospitalesPastoMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitales_pasto_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(1.2050154, -77.270413);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Hospital Universitario Departamental de Nariño ESE HUDN."));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));

        LatLng sydney1 = new LatLng(1.2172209, -77.2787676);
        mMap.addMarker(new MarkerOptions().position(sydney1).title("Clínica Nuestra Señora de Fátima"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney1, 15));

        LatLng sydney2 = new LatLng(1.2242719, -77.2937512);
        mMap.addMarker(new MarkerOptions().position(sydney2).title("Fundación Hospital San Pedro"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney2, 15));

        LatLng sydney3 = new LatLng(1.2229886, -77.2823612);
        mMap.addMarker(new MarkerOptions().position(sydney3).title("Hospital Infantil Los Ángeles"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney3, 15));

        LatLng sydney4 = new LatLng(1.2097654,-77.2969856);
        mMap.addMarker(new MarkerOptions().position(sydney4).title("Hospital Mental Nuestra Señora del Perpetuo Socorro (Salud mental femenina)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney4, 15));

        LatLng sydney5 = new LatLng(1.2216595, -77.2850138);
        mMap.addMarker(new MarkerOptions().position(sydney5).title("Hospital Civil"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney5, 15));
    }
}
