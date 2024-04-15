package eu.york.york2024mc.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import eu.york.york2024mc.databinding.HolderItemBinding;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {

    private List<String> dataList;
    private Context context;
    private LayoutInflater inflate;

    public MyRecyclerViewAdapter(List<String> dataList, Context context, LayoutInflater inflate) {
        this.dataList = dataList;
        this.context = context;
        this.inflate = inflate;
    }

    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(context).inflate(R.layout.holder_item, parent, false);
        HolderItemBinding binding = HolderItemBinding.inflate(inflate, parent, false);
        return new MyRecyclerViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
