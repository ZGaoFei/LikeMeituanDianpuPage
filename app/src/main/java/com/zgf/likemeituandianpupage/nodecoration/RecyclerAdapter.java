package com.zgf.likemeituandianpupage.nodecoration;

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
    private Context context;

    public RecyclerAdapter(Context context, List<DataModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == DataModel.TYPE_TITLE) {
            View view = LayoutInflater.from(context).inflate(R.layout.title_layout, parent, false);
            return new RecyclerTitleHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
            return new RecyclerItemHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == DataModel.TYPE_TITLE) {
            ((RecyclerTitleHolder) holder).textView.setText(list.get(position).getTitle().getTitle());
        } else {
            ((RecyclerItemHolder) holder).textView.setText(list.get(position).getItem().getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    static class RecyclerTitleHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public RecyclerTitleHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    static class RecyclerItemHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public RecyclerItemHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_content);
        }
    }
}
