package com.zgf.likemeituandianpupage.gridlayoutmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zgf.likemeituandianpupage.R;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<GridItem> list;

    public GridAdapter(Context context, List<GridItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_small_layout, parent, false);
        return new ItemSmallHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemSmallHolder)holder).textView.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    static class ItemSmallHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ItemSmallHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv);
        }
    }

    static class ItemNormalHolder extends RecyclerView.ViewHolder {

        public ItemNormalHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    static class ItemBigHolder extends RecyclerView.ViewHolder {

        public ItemBigHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
