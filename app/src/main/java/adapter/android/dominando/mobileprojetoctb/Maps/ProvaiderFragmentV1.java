package adapter.android.dominando.mobileprojetoctb.Maps;


import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.security.SignatureException;

public class ProvaiderFragmentV1 extends SupportMapFragment implements OnMapReadyCallback,GoogleMap.OnMapClickListener { //essa interfacer  OnMapReadyCallback //GoogleMap.OnMapClickListener ação

    private static  final  String TAG = "ProvaiderFragmentV1";
    private GoogleMap mMap;
    private LocationManager locationManager;  //objeto responsavel pro localizar o provaider para estar buscando nossa localização


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
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

        try{
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria,true); ///// ajudar a buscar fazer pesquisa da localização

            Toast.makeText(getActivity(),"provider: " + provider,Toast.LENGTH_LONG).show(); //// Mensagem para exibir o nome do provider

        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMyLocationEnabled(true); ///ativando o provaider o melhor provide do gps para localização

        }catch (SecurityException ex){
            Log.e(TAG,"ERRO",ex);
        }
        //Cordenadas de Sidney
        LatLng sydney = new LatLng(-33.87365,151.20689);
        MarkerOptions marker = new MarkerOptions();
        marker.position(sydney);
        marker.title("Marker in Sidney");

        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onMapClick(LatLng latLng) {
///evento de click no mapa
        Toast.makeText(getContext(),"Cordenada:" + latLng.toString(),Toast.LENGTH_SHORT).show();
    }
}
