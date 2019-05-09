package com.company1075.Beira.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.com1075.library.base.ListBaseAdapter;
import com.com1075.library.base.SuperViewHolder;
import com.company1075.Beira.R;

public class DDetailsAdapter extends ListBaseAdapter<Integer> {
    public DDetailsAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.d_details_item;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {
        ProgressBar pb = holder.getView(R.id.pb);
        TextView tvTitle = holder.getView(R.id.tv_title);
        if (position == 0) {
            tvTitle.setText("痤疮");
            pb.setProgress(8);
        } else if (position == 1) {
            tvTitle.setText("雀斑");
            pb.setProgress(5);
        } else if (position == 2) {
            tvTitle.setText("色素");
            pb.setProgress(3);
        }else {
            tvTitle.setText("痤疮");
            pb.setProgress(6);
        }
//        ImageView textView = holder.getView(R.id.item_iv);
//        tvGoodsTitle.setText("光采洗面膏(湿润型)"+position);
//        Glide.with(mContext).load(mDataList.get(position)).into(textView);
    }


}
