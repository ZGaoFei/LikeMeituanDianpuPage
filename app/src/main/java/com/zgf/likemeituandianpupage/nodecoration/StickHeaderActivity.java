package com.zgf.likemeituandianpupage.nodecoration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.zgf.likemeituandianpupage.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StickHeaderActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView textView;

    private List<DataModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stick_header);

        initData();
        initView();
        initRecycle();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        textView = findViewById(R.id.tv_title);
    }

    private void initData() {
        if (list == null) {
            list = new ArrayList<>();
        }

        int a = 4;
        for (int i = 0; i < 50; i++) {
            DataModel model = new DataModel();

            if (i % a == 0) {
                DataModel.Title title = new DataModel.Title();
                title.setTitle("title: " + i);
                model.setType(DataModel.TYPE_TITLE);
                model.setTitle(title);
                a = new Random().nextInt(6) + 6;
            } else {
                DataModel.Item item = new DataModel.Item();
                item.setContent("item: " + i);
                model.setType(DataModel.TYPE_ITEM);
                model.setItem(item);
            }

            list.add(model);
        }
    }

    private void initRecycle() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(this, list));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int position = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                if (list.get(position).getType() == 0) {
                    textView.setText(list.get(position).getTitle().getTitle());
                }
            }
        });
    }
}
