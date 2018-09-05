package com.alguojian.tangramdemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tmall.wireless.tangram.TangramBuilder;
import com.tmall.wireless.tangram.TangramEngine;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    private TangramBuilder.InnerBuilder mInnerBuilder;
    private TangramEngine engine;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //第二部，注册build
        mInnerBuilder = TangramBuilder.newInnerBuilder(this);
        engine = mInnerBuilder.build();
        recyclerView = findViewById(R.id.recyclerView);

        engine.bindView(recyclerView);

        //卡片预加载的偏移量，默认为5个
        engine.setPreLoadNumber(5);

        initData();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                engine.onScrolled();
            }
        });
    }

    /**
     * 加载数据
     */
    private void initData() {

        engine.setData(new JSONArray());

    }
}
