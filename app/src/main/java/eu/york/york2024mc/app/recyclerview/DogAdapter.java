package eu.york.york2024mc.app.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import eu.york.york2024mc.app.database.DogEntity;
import eu.york.york2024mc.databinding.HolderDogBinding;

public class DogAdapter extends ListAdapter<DogEntity, DogViewHolder> {
    public DogAdapter() {
        super(new DogDiffUtil());
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HolderDogBinding binding = HolderDogBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DogViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        holder.binding.text.setText(getItem(position).getImage());
    }
}
