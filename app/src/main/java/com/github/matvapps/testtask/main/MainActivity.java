package com.github.matvapps.testtask.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.viewanimator.ViewAnimator;
import com.github.matvapps.testtask.R;
import com.github.matvapps.testtask.Utility;
import com.github.matvapps.testtask.model.Location;
import com.github.matvapps.testtask.setttings.SettingsActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tomtom.online.sdk.map.CameraPosition;
import com.tomtom.online.sdk.map.MarkerBuilder;
import com.tomtom.online.sdk.map.TomtomMap;
import com.tomtom.online.sdk.map.TomtomMapCallback;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback,
        com.tomtom.online.sdk.map.OnMapReadyCallback, View.OnClickListener,
        GoogleMap.OnMapClickListener, TomtomMapCallback.OnMapClickListener, MainView {

    public final String TAG = MainActivity.class.getSimpleName();

    private final double BASE_ZOOM = 12.5;

    private ImageButton settingsBtn;
    private TextView coutryTxtView;
    private TextView cityTxtView;
    private TextView streetTxtView;
    private View movingContainer;
    private View menuView;


    private SharedPreferences sharedPreferences;
    private MainPresenter mainPresenter;
    private GoogleMap googleMap;
    private TomtomMap tomtomMap;

    private double zoom;
    private int currentServiceIndex = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuView = findViewById(R.id.menu_view);
        movingContainer = findViewById(R.id.container);
        settingsBtn = findViewById(R.id.settings_btn);
        settingsBtn.setOnClickListener(this);

        initMenu();
        movingContainer.setOnClickListener(view -> hideMenu());

        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);

        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.INTERNET,
                android.Manifest.permission.ACCESS_NETWORK_STATE
        };

        if (!Utility.hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }

        setupSharedPreferences();
    }

    private void initMenu() {
        coutryTxtView = findViewById(R.id.country_text);
        cityTxtView = findViewById(R.id.city_text);
        streetTxtView = findViewById(R.id.street_text);
    }

    private void showMenu() {
        ViewAnimator
                .animate(menuView)
                .slideLeft()
                .duration(300)

//                .andAnimate(movingContainer)
//                .translationX(Utility.convertDpToPx(this, 200))
//                .duration(300)

                .onStart(() -> menuView.setVisibility(View.VISIBLE))
                .start();
    }

    private void hideMenu() {
        ViewAnimator
                .animate(menuView)
                .translationX(-Utility.convertDpToPx(this, 200))
                .duration(300)

//                .andAnimate(movingContainer)
//                .translationX(-Utility.convertDpToPx(this, 0))
//                .duration(300)

                .onStop(() -> menuView.setVisibility(View.GONE))
                .start();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setOnMapClickListener(this);
        googleMap.setOnMarkerClickListener(marker -> {
            showMenu();
            return true;
        });
        this.googleMap = googleMap;
    }

    @Override
    public void onMapReady(@NonNull TomtomMap tomtomMap) {
        tomtomMap.addOnMapClickListener(this);
        tomtomMap.addOnMarkerClickListener(marker -> showMenu());
        this.tomtomMap = tomtomMap;
    }

    @Override
    protected void onResume() {
        super.onResume();

        int mapIndex = Integer.parseInt(sharedPreferences.getString("pref_chooseMapProvider", "0"));
        currentServiceIndex = Integer.parseInt(sharedPreferences.getString("pref_chooseGeocodeService", "2"));

        switch (mapIndex) {
            case 0:
                MapFragment googleMapFragment = MapFragment.newInstance();
                googleMapFragment.getMapAsync(this);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, googleMapFragment)
                        .commit();
                break;
            case 1:
                com.tomtom.online.sdk.map.MapFragment tomTomMapFragment = com.tomtom.online.sdk.map.MapFragment.newInstance();
                tomTomMapFragment.getAsyncMap(this);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, tomTomMapFragment)
                        .commit();
                break;
        }


    }

    private void setupSharedPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public void onClick(View view) {
        SettingsActivity.start(MainActivity.this);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        if (menuView.getVisibility() == View.VISIBLE) {
            hideMenu();
            return;
        }
        getAddressByPoint(String.format("%s,%s", latLng.latitude, latLng.longitude));

        zoom = googleMap.getCameraPosition().zoom < BASE_ZOOM ? BASE_ZOOM : googleMap.getCameraPosition().zoom;

        // remove old markers
        googleMap.clear();

        // Add a marker and move the camera
        googleMap.addMarker(new MarkerOptions().position(latLng));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, (float) zoom));
    }

    @Override
    public void onMapClick(@NonNull com.tomtom.online.sdk.common.location.LatLng latLng) {
        if (menuView.getVisibility() == View.VISIBLE) {
            hideMenu();
            return;
        }
        getAddressByPoint(String.format("%s,%s", latLng.getLatitudeAsString(), latLng.getLongitudeAsString()));

        zoom = tomtomMap.getZoomLevel() < BASE_ZOOM ? BASE_ZOOM : tomtomMap.getZoomLevel();

        // remove old markers
        tomtomMap.removeMarkers();

        // Add a marker and move the camera
        tomtomMap.addMarker(new MarkerBuilder(latLng));
        tomtomMap.centerOn(CameraPosition.builder(latLng).zoom(zoom).build());
    }

    private void getAddressByPoint(String latlng) {
        String key = currentServiceIndex == 2 ? getString(R.string.bing_maps_key) : getString(R.string.tomtom_maps_key);
        mainPresenter.getAddress(latlng, key, currentServiceIndex);
    }

    @Override
    public void onGetAddress(Location location, String latlng) {
        coutryTxtView.setText(getString(R.string.country, location.getCountry()));
        cityTxtView.setText(getString(R.string.city, location.getCity()));
        streetTxtView.setText(getString(R.string.street, location.getStreet()));
        showMenu();

        Log.d(TAG, "onGetAddress: " + location);
    }

    @Override
    public void showLoading(boolean load) {

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "Some error: " + message, Toast.LENGTH_SHORT).show();
    }
}
