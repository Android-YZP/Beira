package com.company1075.Beira.adapters;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.com1075.library.base.ListBaseAdapter;
import com.com1075.library.base.SuperViewHolder;
import com.company1075.Beira.R;

public class TestAdapter extends ListBaseAdapter<Integer> {
    public TestAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.test_item;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {
        ImageView textView = holder.getView(R.id.item_iv);
        Glide.with(mContext).load(mDataList.get(position)).into(textView);
    }


}
