package com.zgf.likemeituandianpupage.gridlayoutmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.zgf.likemeituandianpupage.R;
import com.zgf.likemeituandianpupage.nodecoration.StickHeaderActivity;

import java.util.ArrayList;
import java.util.List;

public class GridLayoutManagerActivity extends AppCompatActivity {

    private RecyclerView gridLayout;

    private List<GridItem> list;

    public static void start(Context context) {
        context.startActivity(new Intent(context, GridLayoutManagerActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout_manager);

        gridLayout = findViewById(R.id.grid_layout);

        initData();
        initView();
    }

    private void initData() {
        list = new ArrayList<>();

        list.add(new GridItem(24, "item；1"));
        list.add(new GridItem(24, "item；1"));
        list.add(new GridItem(24, "item；1"));
        list.add(new GridItem(24, "item；1"));
        list.add(new GridItem(24, "item；1"));
        list.add(new GridItem(30, "item；2"));
        list.add(new GridItem(30, "item；2"));
        list.add(new GridItem(30, "item；2"));
        list.add(new GridItem(30, "item；2"));
        list.add(new GridItem(40, "item；3"));
        list.add(new GridItem(40, "item；3"));
        list.add(new GridItem(40, "item；3"));
        list.add(new GridItem(60, "item；4"));
        list.add(new GridItem(60, "item；4"));
        list.add(new GridItem(120, "item；5"));
    }

    private void initView() {
        GridLayoutManager manager = new GridLayoutManager(this, 120);
        manager.setSpanSizeLookup(new ItemSpanSizeLookup(list));
        gridLayout.setLayoutManager(manager);
        gridLayout.setAdapter(new GridAdapter(this, list));
    }

    static class ItemSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

        private List<GridItem> list;

        public ItemSpanSizeLookup(List<GridItem> list) {
            this.list = list;
        }

        @Override
        public int getSpanSize(int position) {
            return list.get(position).getSpanSize();
        }
    }
}
