package eu.york.york2024mc.storage;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import eu.york.york2024mc.R;

public class StorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", "Vassilis");
        //editor.commit();
        editor.apply();

        SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        SharedPreferences.Editor sharedEditor = sharedPreferences.edit();
        sharedEditor.putString("name", "Vassilis");
        //editor.commit();
        sharedEditor.apply();


        MyDatabaseInstance databaseInstance = Room.databaseBuilder(this, MyDatabaseInstance.class, "myDatabase")
                        .allowMainThreadQueries()
                        .build();

        List<UserEntity> dataList = databaseInstance.getUser().retrieve();
    }
}