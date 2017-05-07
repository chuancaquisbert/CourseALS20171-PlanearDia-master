package tech.alvarez.planeardia;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

import tech.alvarez.planeardia.db.Database;
import tech.alvarez.planeardia.model.Lugar;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        ArrayList<Lugar> lugares = Database.obtenerUbicaciones(this);

        // TODO: Paso 3
        PolylineOptions polylineOptions = new PolylineOptions()
                .color(ContextCompat.getColor(this, R.color.colorPrimary))
                .width(8);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        for (int i = 0; i < lugares.size(); i++) {
            Lugar l = lugares.get(i);

            LatLng punto = new LatLng(l.getLatitud(), l.getLongitud());
            MarkerOptions markerOptions;
            if (i == 0 || i == lugares.size() - 1)
            {
                markerOptions = new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto))
                    .position(punto)
                    .title(l.getNombre())
                    .snippet(l.getDireccion());
            }
            else {
                 markerOptions = new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto2))
                        .position(punto)
                        .title(l.getNombre())
                        .snippet(l.getDireccion());
            }

            mMap.addMarker(markerOptions);

            polylineOptions.add(punto);

            builder.include(punto);
        }
        mMap.addPolyline(polylineOptions);


        // TODO: Paso 4


        LatLngBounds bounds = builder.build();
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20));

    }
}
