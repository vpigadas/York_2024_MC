package eu.york.york2024mc.app.recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import eu.york.york2024mc.databinding.HolderDogBinding;

public class DogViewHolder extends RecyclerView.ViewHolder {

    public HolderDogBinding binding;

    public DogViewHolder(@NonNull HolderDogBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
