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


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

            // Instantiate the RequestQueue.
            final RequestQueue queue = Volley.newRequestQueue(this);

        //GET to search

            String userQuery = "pizza";
            //searches user query, limit 1
            String searchUrl = "https://api.tomtom.com/search/2/search/" + userQuery + ".json?key=Ja9sedGJlJJHgfWROHBWF4Qev7QYVeeV&limit=1";

        // Request a string response from the provided URL.
            StringRequest searchRequest = new StringRequest(Request.Method.GET, searchUrl,

                    // Create a json obj out of request data
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String searchRes) {
                            // Display the first 500 characters of the response string.
                            try {
                                JSONObject searchResJson = new JSONObject(searchRes);

                                Log.d("My App", searchResJson.toString());

                                //POST to searchAlongRoute



                                String alongRouteUrl = "https://api.tomtom.com/search/2/searchAlongRoute/pizza.json?key=Ja9sedGJlJJHgfWROHBWF4Qev7QYVeeV&maxDetourTime=1000";

                                // grab textView
                                mTextView = (TextView) findViewById(R.id.message);


                                String myString = "{'route':{'points':[{'lat': 37.7524152343544,'lon':-122.43576049804686},{'lat': 37.70660472542312,'lon':-122.43301391601562},{'lat': 37.712059855877314,'lon':-122.36434936523438},{'lat':37.75350561243041,'lon':-122.37396240234374}]}}";


                                JSONObject userInputtedPOIs;
                                String whatever = "";

                                try {
                                    userInputtedPOIs = new JSONObject(myString);
                                    whatever = userInputtedPOIs.toString();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                final String requestBody = whatever;



                                // Request a string response from the provided URL.
                                StringRequest stringRequest = new StringRequest(Request.Method.POST, alongRouteUrl,

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
                                } ) {

                                    @Override
                                    public byte[] getBody() throws AuthFailureError {
                                        try {
                                            return requestBody == null ? null : requestBody.getBytes("utf-8");
                                        } catch (UnsupportedEncodingException uee) {
                                            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                                            return null;
                                        }
                                    }
                                };



                                // Add the request to the RequestQueue.
                                queue.add(stringRequest);




                            } catch (Throwable t) {
                                Log.e("My App", "Could not parse malformed JSON: \"" + searchRes + "\"");
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("My App", "Error encountered ");
                }
            } );

            queue.add(searchRequest);


//        //POST to searchAlongRoute
//
//            String alongRouteUrl = "https://api.tomtom.com/search/2/searchAlongRoute/pizza.json?key=Ja9sedGJlJJHgfWROHBWF4Qev7QYVeeV&maxDetourTime=1000";
//
//            // grab textView
//            mTextView = (TextView) findViewById(R.id.message);
//
//
////            Map<String, ArrayList> routeObject = new HashMap<String, ArrayList>();
////            routeObject.put("points", new ArrayList());
//
//
//
//            String myString = "{'route':{'points':[{'lat': 37.7524152343544,'lon':-122.43576049804686},{'lat': 37.70660472542312,'lon':-122.43301391601562},{'lat': 37.712059855877314,'lon':-122.36434936523438},{'lat':37.75350561243041,'lon':-122.37396240234374}]}}";
//
//
//            JSONObject userInputtedPOIs;
//            String whatever = "";
//
//            try {
//                userInputtedPOIs = new JSONObject(myString);
//                whatever = userInputtedPOIs.toString();
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            final String requestBody = whatever;
//
//
//
//            // Request a string response from the provided URL.
//            StringRequest stringRequest = new StringRequest(Request.Method.POST, alongRouteUrl,
//
//                    // Create a json obj out of request data
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String json) {
//                            // Display the first 500 characters of the response string.
//                            try {
//                                JSONObject obj = new JSONObject(json);
//
//                                Log.d("My App", obj.toString());
//
//                            } catch (Throwable t) {
//                                Log.e("My App", "Could not parse malformed JSON: \"" + json + "\"");
//                            }
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.e("My App", "Error encountered ");
//                        }
//            } ) {
//
//                @Override
//                public byte[] getBody() throws AuthFailureError {
//                    try {
//                        return requestBody == null ? null : requestBody.getBytes("utf-8");
//                    } catch (UnsupportedEncodingException uee) {
//                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
//                        return null;
//                    }
//                }
//            };
//
//
//
//            // Add the request to the RequestQueue.
//            queue.add(stringRequest);

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
