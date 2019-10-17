package com.zgf.likemeituandianpupage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.zgf.likemeituandianpupage.gridlayoutmanager.GridLayoutManagerActivity;
import com.zgf.likemeituandianpupage.nodecoration.StickHeaderActivity;

public class StarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        initView();
    }

    private void initView() {
        findViewById(R.id.tv_stick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.start(StarActivity.this);
            }
        });

        findViewById(R.id.tv_stick_no_decoration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StickHeaderActivity.start(StarActivity.this);
            }
        });

        findViewById(R.id.tv_grid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GridLayoutManagerActivity.start(StarActivity.this);
            }
        });
    }
}
