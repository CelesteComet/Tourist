package com.example.mapdisplay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    private TextView mTextMessage;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
