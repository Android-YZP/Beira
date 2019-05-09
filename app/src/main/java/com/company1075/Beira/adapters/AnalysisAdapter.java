package com.company1075.Beira.adapters;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.com1075.library.base.ListBaseAdapter;
import com.com1075.library.base.SuperViewHolder;
import com.company1075.Beira.R;
import com.company1075.Beira.activitys.GoodsInfoActivity;
import com.company1075.Beira.utils.UIUtils;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnalysisAdapter extends ListBaseAdapter<Integer> {
    private HashMap<Integer, Boolean> mHmData;
    List<Integer> images = new ArrayList<>();
    private LRecyclerViewAdapter mLuRecyclerViewAdapter;
    private CureAdapter mMyradioAdapter;


    public AnalysisAdapter(Context context) {
        super(context);
    }

    public void setmHmData(HashMap<Integer, Boolean> mHmData) {
        this.mHmData = mHmData;
        notifyDataSetChanged();
    }

    @Override
    public int getLayoutId() {
        return R.layout.analysis_item;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, final int position) {
        Button btZhiliao = holder.getView(R.id.bt_zhiliao);
        LinearLayout rlGoods = holder.getView(R.id.rl_goods);
        if (!mHmData.get(position)) {
            rlGoods.setVisibility(View.GONE);
        } else {
            rlGoods.setVisibility(View.VISIBLE);
            ObjectAnimator animator5 = ObjectAnimator.ofFloat(rlGoods, "scaleX", 0.4f, 1f);
            ObjectAnimator animator6 = ObjectAnimator.ofFloat(rlGoods, "scaleY", 0.4f, 1f);
            AnimatorSet  set2 = new AnimatorSet();
            set2.setDuration(500);
            set2.playTogether(animator5, animator6);
            set2.start();
        }
        btZhiliao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mHmData.get(position)) {
                    mHmData.put(position, false);
                } else {
                    mHmData.put(position, true);
                }
                notifyDataSetChanged();
            }
        });
        LRecyclerView mLuRecyclerView = holder.getView(R.id.lu_radio_adapter);
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


        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 20);
        mLuRecyclerView.setLayoutManager(gridLayoutManager);
        mMyradioAdapter = new CureAdapter(mContext);
        mLuRecyclerViewAdapter = new LRecyclerViewAdapter(mMyradioAdapter);
        mLuRecyclerView.setAdapter(mLuRecyclerViewAdapter);
        mLuRecyclerView.setLoadMoreEnabled(true);
        mMyradioAdapter.setDataList(images);
        mLuRecyclerView.setNestedScrollingEnabled(false);//禁止滑动
//        tvGoodsTitle.setText("光采洗面膏(湿润型)"+position);
//        Glide.with(mContext).load(mDataList.get(position)).into(textView);
    }


}
