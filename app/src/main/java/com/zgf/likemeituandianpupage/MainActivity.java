package com.zgf.likemeituandianpupage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zgf.likemeituandianpupage.recycler.DataModel;
import com.zgf.likemeituandianpupage.recycler.RecyclerAdapter;
import com.zgf.likemeituandianpupage.recycler.TitleDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<DataModel> list;
    private int length;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        initView();
    }

    private void initData() {
        if (list == null) {
            list = new ArrayList<>();
        }

        for (int i = 0; i < 10; i++) {
            DataModel model = new DataModel();
            model.setTitle("title: " + i);

            List<DataModel.Item> items = new ArrayList<>();
            int a = new Random().nextInt(6) + 6;
            for (int j = 0; j < a; j++) {
                DataModel.Item item = new DataModel.Item();
                item.setContent("item: " + i);
                items.add(item);
                length ++;
            }
            model.setItem(items);

            list.add(model);
        }
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(this, list));

        initDecoration();
    }

    private void initDecoration() {
        TitleDecoration decoration = TitleDecoration.Builder.init(new TitleDecoration.PowerGroupListener() {

            @Override
            public View getGroupView(int position, ViewGroup parent) {
                if (list != null && length > position) {
                    View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.title_layout, parent, false);
                    TextView textView = view.findViewById(R.id.tv_title);

//                    textView.setText(list.get(position).getTitle());
                    String title = "";
                    if (position == 0) {
                        title = list.get(0).getTitle();
                    } else {
                        int index = 0;
                        for (int i = 0; i < list.size(); i++) {
                            List<DataModel.Item> item = list.get(i).getItem();
                            index += item.size();
                            if (position < index) {
                                title = list.get(i).getTitle();
                                break;
                            }
                        }
                    }
                    textView.setText(title);
                    return view;
                } else {
                    return null;
                }
            }

            @Override
            public int getGroupType(int position) {
                if (list != null && length > position) {
                    if (position == 0) {
                        return 0;
                    }
                    int result = -1;
                    int index = 0;
                    for (int i = 0; i < list.size(); i++) {
                        List<DataModel.Item> item = list.get(i).getItem();
                        index += item.size();
                        if (position == index) {
                            result = 0;
                            break;
                        }
                    }
                    return result;
                } else {
                    return 1;
                }
            }
        }, this).setGroupHeight(dip2px(this, 60)).build();

        recyclerView.addItemDecoration(decoration);
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
