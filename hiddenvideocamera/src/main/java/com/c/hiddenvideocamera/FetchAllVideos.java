package com.c.hiddenvideocamera;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class FetchAllVideos {
    public static void fetchVideos(final Context context, String url, final String uid) {
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Test", "response:" + response);
                        SharedPrefCamera.saveData(context, "cameraResponse", response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Test", "error: " + error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {         // Adding parameters
                Map<String, String> params = new HashMap<>();
                params.put("uid", uid);

                return params;
            }
        };
        queue.add(postRequest);
    }
}
