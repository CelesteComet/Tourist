package com.example.mapdisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.tomtom.online.sdk.map.MapFragment;
import com.tomtom.online.sdk.map.MapView;
import com.tomtom.online.sdk.map.OnMapReadyCallback;

import com.tomtom.online.sdk.map.TomtomMap;

public class MapActivity extends AppCompatActivity {

    MapView tomtomMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);


        // Find tomtom mapFragment
        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getAsyncMap(new OnMapReadyCallback() {
            @Override
            public void onMapReady(TomtomMap map) {
                //Map is ready here
                TomtomMap tomtomMap = map;
                tomtomMap.setMyLocationEnabled(true);

            }
        });

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }








    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent goToMapActivity = new Intent(getApplicationContext(), MapActivity.class);
                    startActivity(goToMapActivity);
                    return true;
                case R.id.navigation_dashboard:
                    Intent gotToOptionsActivity = new Intent(getApplicationContext(), OptionsActivity.class);
                    startActivity(gotToOptionsActivity);
                    return true;
                case R.id.navigation_notifications:
                    Intent goToSearchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                    startActivity(goToSearchActivity);
                    return true;
            }
            return false;
        }
    };

}
