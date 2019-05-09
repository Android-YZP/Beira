package com.company1075.Beira.activitys;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.com1075.library.base.BaseActivity;
import com.company1075.Beira.R;
import com.company1075.Beira.adapters.AnalysisAdapter;
import com.company1075.Beira.adapters.GoodsInfoAdapter;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetailsAnalysisActivity extends BaseActivity {

    private LRecyclerView mLuRecyclerView;
    List<Integer> images = new ArrayList<>();
    private LRecyclerViewAdapter mLuRecyclerViewAdapter;
    private AnalysisAdapter mMyradioAdapter;
    private HashMap<Integer, Boolean> mHmData = new HashMap<>();

    @Override
    protected int getContentViewId() {
        return R.layout.activity_details_analysis;
    }

    @Override
    protected void initView() {
        mLuRecyclerView = findViewById(R.id.lu_radio_adapter);
    }

    @Override
    protected void initData() {
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);


        for (int i = 0; i < images.size(); i++) {
            mHmData.put(i, false);
        }


        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(DetailsAnalysisActivity.this);
        mLuRecyclerView.setLayoutManager(gridLayoutManager);
        mMyradioAdapter = new AnalysisAdapter(DetailsAnalysisActivity.this);
        mLuRecyclerViewAdapter = new LRecyclerViewAdapter(mMyradioAdapter);
        mLuRecyclerView.setAdapter(mLuRecyclerViewAdapter);
        mLuRecyclerView.setLoadMoreEnabled(true);
        mMyradioAdapter.setmHmData(mHmData);
        mMyradioAdapter.setDataList(images);
    }

    @Override
    protected void setListener() {


        mLuRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        images.clear();
                        mHmData.clear();
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);

                        for (int i = 0; i < images.size(); i++) {
                            mHmData.put(i, false);
                        }

                        mMyradioAdapter.setmHmData(mHmData);
                        mMyradioAdapter.setDataList(images);
                        mLuRecyclerView.refreshComplete(7);

                    }
                }, 2000);
            }
        });

        mLuRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = images.size(); i < (images.size() + 7); i++) {
                            mHmData.put(i, false);
                        }

                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);

                        mMyradioAdapter.setmHmData(mHmData);
                        mMyradioAdapter.setDataList(images);
                        mLuRecyclerView.refreshComplete(7);


                    }
                }, 2000);

            }
        });
    }
}
