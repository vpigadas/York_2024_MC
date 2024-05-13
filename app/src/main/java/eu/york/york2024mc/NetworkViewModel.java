package eu.york.york2024mc;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import eu.york.york2024mc.app.OnResponse;

public class NetworkViewModel extends AndroidViewModel {

    private final RequestQueue queue;

    public NetworkViewModel(@NonNull Application application) {
        super(application);
        queue = Volley.newRequestQueue(getApplication().getApplicationContext());
    }

    public <T extends Object> void performGetRequest(String url, Class<T> className, OnResponse<T> onResponse) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null) {

                            Log.d("LOGS", response);
                            T jsonResponse = new Gson().fromJson(response, className);
                            Log.d("LOGS", jsonResponse.toString());
                            onResponse.onSuccess(jsonResponse);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error != null) {
                    onResponse.onError(error.getMessage());
                    Log.d("LOGS", error.getMessage());
                }
            }
        });

        queue.add(stringRequest);
    }
}
