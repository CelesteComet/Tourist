package com.example.mapdisplay;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class ListActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Set navigation event listeners
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // network request to get list of stuff

        String url = "https://api.tomtom.com/search/2/searchAlongRoute/pizza.json?key=Ja9sedGJlJJHgfWROHBWF4Qev7QYVeeV&maxDetourTime=1000";

        // grab textView
        mTextView = (TextView) findViewById(R.id.message);


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                // Create a json obj out of request data
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String json) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONObject obj = new JSONObject(json);

                            Log.d("My App", obj.toString());

                        } catch (Throwable t) {
                            Log.e("My App", "Could not parse malformed JSON: \"" + json + "\"");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("My App", "Error encountered ");
            }
        });


        // Add the request to the RequestQueue.
        queue.add(stringRequest);

//        try
//        {
//            String jsonInput = "[\"one\",\"two\",\"three\",\"four\",\"five\",\"six\",\"seven\",\"eight\",\"nine\",\"ten\"]";
//            JSONArray jsonArray = new JSONArray(jsonInput);
//            int length = jsonArray.length();
//            List<String> listContents = new ArrayList<String>(length);
//            for (int i = 0; i < length; i++)
//            {
//                listContents.add(jsonArray.getString(i));
//            }
//
//            ListView myListView = (ListView) findViewById(R.id.my_list);
//            myListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listContents));
//        }
//        catch (Exception e)
//        {
//            Log.e("List view error", "Error in creating a list view");
//        }





    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };



}
