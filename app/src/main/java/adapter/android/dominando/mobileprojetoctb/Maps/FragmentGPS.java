package adapter.android.dominando.mobileprojetoctb.Maps;


import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
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

public class FragmentGPS extends SupportMapFragment implements OnMapReadyCallback,GoogleMap.OnMapClickListener,LocationListener { //essa interfacer  OnMapReadyCallback //GoogleMap.OnMapClickListener ação

    private static  final  String TAG = "FragmentMapsGPS";
    private GoogleMap mMap;
    private LocationManager locationManager;  //objeto responsavel pro localizar o provaider para estar buscando nossa localização


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        // ATIVA O GPS
        locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
    }

    @Override
    public void onPause() {
        super.onPause();
        locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationManager.removeUpdates(this);
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

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(getActivity(),"Posição alterada",Toast.LENGTH_LONG).show();

        //Cordenadas de Sidney
        LatLng novaLocalizacao = new LatLng(location.getLatitude(),location.getAltitude());
        MarkerOptions marker = new MarkerOptions();
        marker.position(novaLocalizacao);
        marker.title("Nova Localização");

        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(novaLocalizacao));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Toast.makeText(getActivity(),"Status do GPS foi alterado",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(getActivity(),"Provider Habilitado",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(getActivity(),"Provider desabilitado",Toast.LENGTH_LONG).show();
    }
}
