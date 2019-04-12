package com.company1075.Beira.activitys;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.com1075.library.base.BaseActivity;
import com.company1075.Beira.R;
import com.company1075.Beira.adapters.AnalysisSkinAdapter;
import com.company1075.Beira.adapters.GoodsInfoAdapter;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

public class AnalysisSkinActivity extends BaseActivity {

    private LRecyclerView mLuRecyclerView;
    List<Integer> images = new ArrayList<>();
    private LRecyclerViewAdapter mLuRecyclerViewAdapter;
    private AnalysisSkinAdapter mMyradioAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_analysis_skin;
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
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(AnalysisSkinActivity.this);
        mLuRecyclerView.setLayoutManager(gridLayoutManager);
        mMyradioAdapter = new AnalysisSkinAdapter(AnalysisSkinActivity.this);
        mLuRecyclerViewAdapter = new LRecyclerViewAdapter(mMyradioAdapter);
        mLuRecyclerView.setAdapter(mLuRecyclerViewAdapter);
        mLuRecyclerView.setLoadMoreEnabled(true);
        mMyradioAdapter.setDataList(images);
    }

    @Override
    protected void setListener() {

        mLuRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(AnalysisSkinActivity.this, GoodsDetialActivity.class));
            }
        });

        mLuRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        images.clear();
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
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
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        images.add(R.mipmap.ic_launcher);
                        mMyradioAdapter.setDataList(images);
                        mLuRecyclerView.refreshComplete(7);
                    }
                }, 2000);

            }
        });
    }
}
