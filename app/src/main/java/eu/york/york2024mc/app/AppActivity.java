package eu.york.york2024mc.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import eu.york.york2024mc.NetworkViewModel;
import eu.york.york2024mc.app.database.DogEntity;
import eu.york.york2024mc.app.recyclerview.DogAdapter;
import eu.york.york2024mc.databinding.ActivityAppBinding;
import eu.york.york2024mc.json.JsonResponse;

public class AppActivity extends AppCompatActivity {

    private ActivityAppBinding binding;
    private DogAdapter adapter;
    private AppViewModel viewModel;
    private NetworkViewModel networkViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(AppViewModel.class);
        networkViewModel = new ViewModelProvider(this).get(NetworkViewModel.class);

        adapter = new DogAdapter();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        binding.refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //viewModel.refreshAction();
            }
        });
        binding.recyclerView.setAdapter(adapter);

        //viewModel.refreshAction();

        networkViewModel.performGetRequest(viewModel.URL, JsonResponse.class, new OnResponse<JsonResponse>() {
            @Override
            public void onSuccess(JsonResponse data) {
                List<DogEntity> dataList = viewModel.saveData(data);
                adapter.submitList(dataList);
            }

            @Override
            public void onError(String error) {
                Log.d("ACTIVITY", error);
            }
        });

        viewModel.dataStream.observe(this, new Observer<List<DogEntity>>() {
            @Override
            public void onChanged(List<DogEntity> dataList) {
                adapter.submitList(dataList);
            }
        });
    }
}