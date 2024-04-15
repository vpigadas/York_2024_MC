package eu.york.york2024mc.recyclerview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import eu.york.york2024mc.databinding.ActivityRecyclerBinding;

public class RecyclerActivity extends AppCompatActivity {

    private ActivityRecyclerBinding _binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding = ActivityRecyclerBinding.inflate(getLayoutInflater());
        setContentView(_binding.getRoot());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        _binding.recyclerView.setAdapter(
                new MyRecyclerViewAdapter(new ArrayList<String>(), this, getLayoutInflater())
        );
    }
}