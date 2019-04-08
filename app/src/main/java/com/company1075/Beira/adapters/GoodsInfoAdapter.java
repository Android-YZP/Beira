package com.company1075.Beira.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.com1075.library.base.ListBaseAdapter;
import com.com1075.library.base.SuperViewHolder;
import com.company1075.Beira.R;

public class GoodsInfoAdapter extends ListBaseAdapter<Integer> {
    public GoodsInfoAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.goods_info_item;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {
        TextView tvGoodsTitle = holder.getView(R.id.tv_goods_title);
        ImageView textView = holder.getView(R.id.item_iv);
        tvGoodsTitle.setText("光采洗面膏(湿润型)"+position);
        Glide.with(mContext).load(mDataList.get(position)).into(textView);
    }


}
