package eu.york.york2024mc.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

import eu.york.york2024mc.app.database.DogDatabase;
import eu.york.york2024mc.app.database.DogEntity;
import eu.york.york2024mc.app.recyclerview.DogAdapter;
import eu.york.york2024mc.databinding.ActivityAppBinding;
import eu.york.york2024mc.json.JsonResponse;

public class appActivity extends AppCompatActivity {

    private ActivityAppBinding binding;
    private DogDatabase database;
    private DogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = Room.databaseBuilder(this, DogDatabase.class, "DogDatabase").allowMainThreadQueries().build();
        adapter = new DogAdapter();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        binding.refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshAction();
            }
        });
        binding.recyclerView.setAdapter(adapter);

        refreshAction();
    }

    private void refreshAction() {
        RequestQueue queue = Volley.newRequestQueue(appActivity.this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                "https://dog.ceo/api/breeds/image/random",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null) {

                            Log.d("LOGS", response);
                            JsonResponse jsonResponse = new Gson().fromJson(response, JsonResponse.class);
                            Log.d("LOGS", jsonResponse.toString());

                            DogEntity entity = new DogEntity();
                            entity.setName(jsonResponse.getStatus());
                            entity.setImage(jsonResponse.getMessage());

                            database.getDogDao().save(entity);

                            List<DogEntity> dataList = database.getDogDao().getAll();
                            adapter.submitList(dataList);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error != null) {
                    Log.d("LOGS", error.getMessage());
                }
            }
        });

        queue.add(stringRequest);
    }
}