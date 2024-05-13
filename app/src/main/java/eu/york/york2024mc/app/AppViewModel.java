package eu.york.york2024mc.app;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
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
import eu.york.york2024mc.json.JsonResponse;

public class AppViewModel extends AndroidViewModel {
    private final DogDatabase database;
    public final String URL = "https://dog.ceo/api/breeds/image/random";

    public MutableLiveData<List<DogEntity>> dataStream = new MutableLiveData<List<DogEntity>>();

    public AppViewModel(@NonNull Application application) {
        super(application);
        database = Room.databaseBuilder(application.getApplicationContext(), DogDatabase.class, "DogDatabase").allowMainThreadQueries().build();
    }

    public List<DogEntity> saveData(JsonResponse jsonResponse) {
        DogEntity entity = new DogEntity();
        entity.setName(jsonResponse.getStatus());
        entity.setImage(jsonResponse.getMessage());

        database.getDogDao().save(entity);

        return database.getDogDao().getAll();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
