package eu.york.york2024mc.app.recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import eu.york.york2024mc.app.database.DogEntity;

public class DogDiffUtil extends DiffUtil.ItemCallback<DogEntity> {
    @Override
    public boolean areItemsTheSame(@NonNull DogEntity oldItem, @NonNull DogEntity newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull DogEntity oldItem, @NonNull DogEntity newItem) {
        return oldItem.equals(newItem);
    }
}
