package com.company1075.Beira.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.com1075.library.base.ListBaseAdapter;
import com.com1075.library.base.SuperViewHolder;
import com.company1075.Beira.R;

public class HistoryAdapter extends ListBaseAdapter<Integer> {
    public HistoryAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.history_item;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {

    }


}
