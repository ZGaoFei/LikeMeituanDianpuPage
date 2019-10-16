package com.zgf.likemeituandianpupage.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zgf.likemeituandianpupage.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DataModel> list;
    private List<DataModel.Item> items;
    private Context context;

    public RecyclerAdapter(Context context, List<DataModel> list) {
        this.context = context;
        this.list = list;

        items = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            items.addAll(list.get(i).getItem());
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new RecyclerItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((RecyclerItemHolder)holder).textView.setText(items.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class RecyclerItemHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public RecyclerItemHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_content);
        }
    }
}
